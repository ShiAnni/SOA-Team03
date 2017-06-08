package mail;

import javax.jws.WebService;

@WebService
public interface MailInterface {
	public UserType login(String user, String pwd) throws LoginFailedFault;
}
