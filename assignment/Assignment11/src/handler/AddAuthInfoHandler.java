package handler;

import java.io.IOException;
import java.util.Set;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

public class AddAuthInfoHandler implements SOAPHandler<SOAPMessageContext> {

	private String email;
	private String password;

	public AddAuthInfoHandler(String email, String password) {
		// TODO Auto-generated constructor stub
		super();
		this.email = email;
		this.password = password;
	}

	@Override
	public boolean handleMessage(SOAPMessageContext context) {
		Boolean out = (Boolean)context.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
		try {
			if(out){
				SOAPMessage message = context.getMessage();
				System.out.println("-----AddAuthInfoHandler In-----");
				message.writeTo(System.out);
				System.out.println();

				SOAPEnvelope senv = message.getSOAPPart().getEnvelope();
				SOAPHeader header = senv.getHeader();
				if(header==null){
					header = senv.addHeader();
				}
				QName studentEmail = new QName("http://jw.nju.edu.cn/", "email","tns");
				QName studentPassword = new QName("http://jw.nju.edu.cn/","password", "tns");
				header.addChildElement(studentEmail).setValue(email);
				header.addChildElement(studentPassword).setValue(password);

				System.out.println("-----AddAuthInfoHandler Out-----");
				message.writeTo(System.out);
				System.out.println();
			}

		} catch (SOAPException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
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
