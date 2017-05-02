package servlets;

import org.w3c.dom.Node;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.soap.*;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;



@WebServlet("/updateClient")
public class StudentUpdateClient extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String studentId = req.getParameter("student");
        String courseNumber = req.getParameter("courseNumber");
        String scoreType = req.getParameter("scoreType");
        System.out.println("StudentUpdateClient 得到参数"+studentId+
                " "+courseNumber+" "+scoreType);
        req.getSession().setAttribute("studentId",studentId);
        req.getSession().setAttribute("courseNumber",courseNumber);
        req.getSession().setAttribute("scoreType",scoreType);
        resp.sendRedirect(req.getContextPath() + "/UpdateScore.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("StudentUpdateClient doPost()");
        //get from session
        String studentId = (String) req.getSession().getAttribute("studentId");
        String courseNumber = (String) req.getSession().getAttribute("courseNumber");
        String scoreType = (String) req.getSession().getAttribute("scoreType");
        String newScore = req.getParameter("newScore");//get from user
        System.out.println("StudentUpdateClient doPost接收到参数：");
        System.out.println(studentId+ " "+ courseNumber+" "+scoreType+" "+newScore);
        //验证分数
        boolean validScore = false;

        //构造SOAPMessage，封装要更新的数据
        MessageFactory messageFactory = null;
        try {
            messageFactory = MessageFactory.newInstance();
            //soapMessageOut是发送给ScoreGetter的SOAPMessage，包含学号/课程编号/类型/分数
            SOAPMessage soapMessageOut = messageFactory.createMessage();
            SOAPPart soappart = soapMessageOut.getSOAPPart();
            SOAPEnvelope envelope = soappart.getEnvelope();
            SOAPBody body = envelope.getBody();
            SOAPBodyElement bodyElement = body.addBodyElement(envelope.createName
                    ("newScoreRecord", "nju", "http://www.nju.edu.cn/"));
            bodyElement.addChildElement("studentId").setValue(studentId);
            bodyElement.addChildElement("courseNumber").setValue(courseNumber);
            bodyElement.addChildElement("scoreType").setValue(scoreType);
            bodyElement.addChildElement("newScore").setValue(newScore);

            //通过SOAPMessage来调用ScoreGetter的SOAP服务，并接收到返回的SOAPMessage
            StringBuffer serverUrl = new StringBuffer();
            serverUrl.append(req.getScheme()).append("://").append(req.getServerName());
            serverUrl.append(":").append(req.getServerPort()).append(req.getContextPath());
            String baseUrl = serverUrl.toString();
            //URL对象封装了即将访问的目标服务
            URL client = new URL(baseUrl + "/updateServer");
            //调用ScoreGetter
            System.out.println("即将访问:"+baseUrl + "/updateServer");
            HttpURLConnection conn = (HttpURLConnection) client.openConnection();
            conn.setReadTimeout(10000);
            conn.setConnectTimeout(15000);
            conn.setRequestMethod("POST");
            conn.setDoInput(true);
            conn.setDoOutput(true);
            OutputStream outputStream = new BufferedOutputStream(conn.getOutputStream());
            //输出Client发出的Message
            System.out.println("*************StudentUpdateClient发出的SOAPMessage start*************");
            soapMessageOut.writeTo(System.out);
            System.out.println();
            System.out.println("*************StudentUpdateClient发出的SOAPMessage end*************");
            //发出SOAPMessage
            soapMessageOut.writeTo(outputStream);
            outputStream.flush();
            System.out.println("调用updateServer状态码:"+conn.getResponseCode());
            //回传结果
            SOAPMessage incomingMessage = MessageFactory.newInstance().createMessage(null,conn.getInputStream());
            if (incomingMessage != null) {
                SOAPPart incomingPart = incomingMessage.getSOAPPart();
                SOAPEnvelope incomingEnvelope = incomingPart.getEnvelope();
                SOAPBody incomingBody = incomingEnvelope.getBody();
                SOAPFault soapFault = incomingBody.getFault();
                if(soapFault!=null){
                    //出现了错误
                    resp.sendRedirect(req.getContextPath() + "/UpdateFail.html");
                    return;
                }else {
                    Iterator<SOAPElement> iterator = incomingBody.getChildElements(incomingEnvelope.createName("updateResult","nju","http://www.nju.edu.cn/"));
                    SOAPElement element = iterator.next();
                    Node statusNode = element.getElementsByTagName("status").item(0);
                    Node infoNode = element.getElementsByTagName("info").item(0);
                    String info = infoNode.getTextContent();
                    if(statusNode.getTextContent().equals("false")){
                        System.out.println("StudentUpdateClient: 调用Server更新失败!"+info);
                    }else{
                        resp.sendRedirect(req.getContextPath() + "/queryPage.html");
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
