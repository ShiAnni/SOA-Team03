package cn.edu.nju.util;  
  
import javax.xml.ws.Endpoint;

import cn.edu.nju.jw.wsdl.StudentManagementImpl;  
  
public class MyServer {  
    public static void main(String[] args) {  
        String address="http://localhost:8880/assignment10/StudentManagement";  
                        
        Endpoint.publish(address, new StudentManagementImpl());  
    }  
}  