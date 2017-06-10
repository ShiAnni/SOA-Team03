package cn.edu.nju.jw.wsdl;  
  
import javax.xml.ws.Endpoint;  
  
public class MyServer {  
    public static void main(String[] args) {  
        String address="http://localhost:8080/assignment10/ScoreManagement";  
        Endpoint.publish(address, new ScoreInterfaceImpl());  
    }  
}  