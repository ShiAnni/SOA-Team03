package mail;

import java.security.Security;
import java.util.Properties;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.mail.AuthenticationFailedException;
import javax.mail.Authenticator;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Store;

import com.sun.net.ssl.internal.ssl.Provider;
@WebService(endpointInterface="mail.MailInterface")  
public class MailImpl implements MailInterface {

	@Override
	public UserType login(String user, String pwd) throws LoginFailedFault {
		boolean y = true;
		String pop3Server = "pop.exmail.qq.com";
		String protocol = "pop3";

		Security.addProvider(new Provider());
		final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
		Properties props = System.getProperties();
		props.setProperty("mail.store.protocol", protocol);
		props.setProperty("mail.pop3.host", pop3Server);
		props.setProperty("mail.pop3.socketFactory.class", SSL_FACTORY);
		props.setProperty("mail.pop3.socketFactory.fallback", "false");
		props.setProperty("mail.pop3.port", "995");
		props.setProperty("mail.pop3.socketFactory.port", "995");
		Session session = Session.getInstance(props, new Authenticator() {

			public PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(user, pwd);
			}
		});

		Store store = null;

		try {
			store = session.getStore();
			store.connect();
//			System.out.println(store.isConnected());
		} catch (AuthenticationFailedException e) {
			y = false;
		} catch (MessagingException e) {
			e.printStackTrace();
			y = false;
		} finally {
			try {
				store.close();
			} catch (MessagingException e) {
				e.printStackTrace();
			}
		}
		if (y) {
			int i = getIdentity(user);
			switch(i) {
			case 1:
				System.out.println("��¼�ɹ�������Ǳ�����");
				return UserType.������;
			case 2:
				System.out.println("��¼�ɹ���������о���");
				return UserType.�о���;
			case 4:
				System.out.println("��¼�ɹ����������ʦ");
				return UserType.��ʦ;
			case 3:
				System.out.println("��¼�ɹ������δ֪");
				return UserType.δ֪����;
			default:
				return UserType.δ֪����;
			}
		} else {
			System.out.println("��¼ʧ��");
		}
		throw new LoginFailedFault("��¼ʧ��","��¼ʧ��");
	}
	
	@WebMethod(exclude = true)
	public int getIdentity(String usr) {
		String first = usr.split("@")[0];
		String last = usr.split("@")[1];
		if (last.equals("smail.nju.edu.cn")) {
			if ((first.length() == 9) && isNumber(first)) {
				return 1;
			} else if (first.startsWith("mf") && isNumber(first.substring(2))) {
				return 2;
			} else {
				return 3;
			}
		} else {
			return 4;
		}
	}
	
	@WebMethod(exclude = true)
	public boolean isNumber(String str) {
		try {
			Integer.parseInt(str);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

}
