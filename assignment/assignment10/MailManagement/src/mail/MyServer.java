package mail;  
  
import javax.xml.ws.Endpoint;  
  
public class MyServer {  
    public static void main(String[] args) {  
        String address="http://localhost:8088/assignment10/MailManagement";  
        Endpoint.publish(address, new MailImpl());  
    }  
}  