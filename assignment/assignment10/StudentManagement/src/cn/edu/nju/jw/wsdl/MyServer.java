package cn.edu.nju.jw.wsdl;  
  
import javax.xml.ws.Endpoint;  
  
public class MyServer {  
    public static void main(String[] args) {  
        //访问方式：hhttp://localhost:8080/WS3
        String address="http://localhost:8080/assignment10/StudentManagement";  
        Endpoint.publish(address, new StudentManagementImpl());  
    }  
}  