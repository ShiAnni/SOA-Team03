package cn.edu.nju.jw.wsdl;  
  
import javax.xml.ws.Endpoint;  
  
/** 
 * @className:MyServer.java 
 * @Desc:发布服务 
 * @author:lizhuang 
 * @createTime:2012-12-21 上午01:02:39 
 */  
public class MyServer {  
    public static void main(String[] args) {  
        //访问方式：hhttp://localhost:8080/WS3
        String address="http://localhost:8080/WS3";  
        Endpoint.publish(address, new ScoreInterfaceImpl());  
    }  
}  