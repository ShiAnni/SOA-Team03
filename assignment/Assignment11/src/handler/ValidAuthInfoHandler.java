package handler;

import java.io.IOException;
import java.rmi.RemoteException;
import java.util.Set;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

import org.w3c.dom.Node;

import cn.edu.nju.jw.schema.AuthControllerService;
import cn.edu.nju.jw.schema.IdNotFoundException;
import cn.edu.nju.jw.schema.MyAuth;
import cn.edu.nju.jw.schema.PswErrorException;
import cn.edu.nju.jw.schema.账号认证类型;
import cn.edu.nju.jw.schema.验证类型;


public class ValidAuthInfoHandler implements SOAPHandler<SOAPMessageContext> {

	@Override
	public boolean handleMessage(SOAPMessageContext context) {

		Boolean out = (Boolean) context.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
		try {
			if (out) {
				SOAPMessage message = context.getMessage();

				System.out.println("------ValidAuthInfoHandler In------");
				message.writeTo(System.out);
				System.out.println();

				SOAPHeader header = message.getSOAPPart().getEnvelope().getHeader();
				SOAPBody body = message.getSOAPPart().getEnvelope().getBody();

				Node node = header.getElementsByTagName("tns:email").item(0);
				String email = node.getTextContent();
				node = header.getElementsByTagName("tns:password").item(0);
				String password = node.getTextContent();

				System.out.println("email is " + email);
				System.out.println("password is " +password);

				//TODO 初始化Login服务并进行身份验证 
				AuthControllerService authControllerService = new AuthControllerService();
				MyAuth myAuth = authControllerService.getMyAuthPort();
				账号认证类型 account = new 账号认证类型();
				account.set邮箱(email);
				account.set密码(password);
				
//				System.out.println(account+"account");
//				System.out.println(account.get邮箱()+"account邮箱");
//				System.out.println(account.get密码()+"account密码");
				验证类型 type = null; 
				String result = null;
				//添加一个教师账号的桩
				if(email.equals("bj@nju.edu.cn") && password.equals("123456")){
					result = "老师";
				} else {
					try {
						 type = myAuth.verify(account);
						 result = type.get权限().toString();
						 System.out.println(result+"result");
						 
					} catch (IdNotFoundException | PswErrorException e) {
					//	e.printStackTrace();
					}
					
				}
				
				QName qName = new QName("http://jw.nju.edu.cn/","identity", "tns");

				if(result.equals("老师")){
					header.addChildElement(qName).setValue("teacher");
				}else if(result.equals("本科生") || result.equals("研究生")){
					header.addChildElement(qName).setValue("student");
					Node bd = body.getFirstChild();
					String methodName = bd.getLocalName();
					System.out.println(methodName);
					// 学生不能调用getScore以外的方法
					if (!"getScore".equals(methodName)) {
						System.out.println("权限不够，无法调用");
						return false;
					}
					
				}else{
					System.out.println("身份验证失败！");
					return false;
				}
				System.out.println("-----ValidAuthInfoHandler Out-----");
				message.writeTo(System.out);
				System.out.println();
			}

		} catch (SOAPException | RemoteException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return true;	
	}

	@Override
	public boolean handleFault(SOAPMessageContext context) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void close(MessageContext context) {
		// TODO Auto-generated method stub

	}

	@Override
	public Set<QName> getHeaders() {
		// TODO Auto-generated method stub
		return null;
	}

}
