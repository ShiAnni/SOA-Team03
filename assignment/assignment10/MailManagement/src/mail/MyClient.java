package mail;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

public class MyClient {
	public static void main(String[] args) {  
		  
		URL url = null;
        try {  
        	url=new URL("http://localhost:8088/assignment10/MailManagement?wsdl");  
            //����WSDL Document�ĵ�ַ  
            //Qnameqname��qualified name �ļ�д  
            //2.���ɣ������ֿռ�(namespace)ǰ׺(prefix)�Լ�ð��(:),����һ��Ԫ�����ƹ���  
            //�ɷ�����wsdl��֪namespaceΪhttp://server.ws.platform.whaty.com/��  
        } catch (MalformedURLException e) {  
            e.printStackTrace();  
        } 
        QName qname=new QName("http://mail/","MailImplService");  
        Service service=Service.create(url, qname);  
        MailInterface mi=service.getPort(MailInterface.class);  
        
        try { 
        	UserType type = mi.login("141250147@smail.nju.edu.cn", "123456");  
        	System.out.println(type.toString());
        }catch (LoginFailedFault e) {
        	System.out.println(e.getFaultInfo());
		}  
        
        try { 
        	UserType type = mi.login("141250146@smail.nju.edu.cn", "Sa19951229");  
        	System.out.println(type.toString());
        }catch (LoginFailedFault e) {
        	System.out.println(e.getFaultInfo());
		}  
    }  
}
