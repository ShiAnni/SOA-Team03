package servlets;

import org.w3c.dom.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.soap.*;
import javax.xml.soap.Node;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;


@WebServlet("/querySoap")
public class StudentIdGetterSoap extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接收到学生id并调用scoreGetter进行成绩的查询
        String studentId = req.getParameter("stuId");
        StringBuilder outString = new StringBuilder();//用来存放最终查询的结果，并返回给response
        System.out.println("StudentIdGetterSoap"+" 接收到参数 "+studentId);
        try {
            MessageFactory messageFactory = MessageFactory.newInstance();
            //soapMessageOut是发送给ScoreGetter的SOAPMessage，包含学生的学号
            SOAPMessage soapMessageOut = messageFactory.createMessage();
            SOAPPart soappart = soapMessageOut.getSOAPPart();
            SOAPEnvelope envelope = soappart.getEnvelope();
            SOAPBody body = envelope.getBody();//即将把学生学号存放在body对象中
            body.addBodyElement(envelope.createName("student-id", "nju", "http://www.nju.edu.cn/")).addTextNode(studentId);
            //通过SOAPMessage来调用ScoreGetter的SOAP服务，并接收到返回的SOAPMessage
            StringBuffer serverUrl = new StringBuffer();
            serverUrl.append(req.getScheme()).append("://").append(req.getServerName());
            serverUrl.append(":").append(req.getServerPort()).append(req.getContextPath());
            String baseUrl = serverUrl.toString();
            //URL对象封装了即将访问的目标服务
            URL client = new URL(baseUrl + "/scoreGetter");
            //调用ScoreGetter
            System.out.println("即将访问:"+baseUrl + "/scoreGetter");
            HttpURLConnection conn = (HttpURLConnection) client.openConnection();
            conn.setReadTimeout(10000);
            conn.setConnectTimeout(15000);
            conn.setRequestMethod("POST");
            conn.setDoInput(true);
            conn.setDoOutput(true);
            OutputStream outputStream = new BufferedOutputStream(conn.getOutputStream());
            //输出StudentIdGetterSoap发出的SOAPMessage
            System.out.println("*************StudentIdGetterSoap发出的SOAPMessage start*************");
            soapMessageOut.writeTo(System.out);
            System.out.println();
            System.out.println("*************StudentIdGetterSoap发出的SOAPMessage end*************");
            soapMessageOut.writeTo(outputStream);
            outputStream.flush();
            System.out.println("调用scoreGetter状态码:"+conn.getResponseCode());
            //回传结果
            String messageBack = conn.getResponseMessage();
            if(messageBack == null)
                System.out.println("messageBack is null!");
            SOAPMessage incomingMessage = MessageFactory.newInstance().createMessage(null,conn.getInputStream());
            if (incomingMessage != null) {
                //输出，浏览器显示
                resp.setCharacterEncoding("utf-8");
                incomingMessage.writeTo(resp.getOutputStream());
                resp.setContentType("application/soap+xml");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
