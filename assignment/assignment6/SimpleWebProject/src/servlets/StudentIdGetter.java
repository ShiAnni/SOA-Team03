package servlets;
import org.w3c.dom.*;
import org.w3c.dom.Node;
import util.Score;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.soap.*;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by WH on 2016/4/26.
 */
@WebServlet("/query")
public class StudentIdGetter extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接收到学生id并调用scoreGetter进行成绩的查询
        String studentId = req.getParameter("stuId");
        StringBuilder outString = new StringBuilder();//用来存放最终查询的结果，并返回给response
        System.out.println("StudentIdGetter"+" 接收到参数 "+studentId);
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
            //将StudentIdGetter发出的SOAPMessage打印出来
            System.out.println("*************StudentIdGetter发出的SOAPMessage start*************");
            soapMessageOut.writeTo(System.out);
            System.out.println();
            System.out.println("*************StudentIdGetter发出的SOAPMessage end*************");
            soapMessageOut.writeTo(outputStream);
            outputStream.flush();
            System.out.println("调用scoreGetter状态码:"+conn.getResponseCode());
            //将返回的SOAPMessage中的数据转为Java对象
            List<Score> resultList = new LinkedList<>();
            SOAPMessage incomingMessage = MessageFactory.newInstance().createMessage(null,conn.getInputStream());
            if (incomingMessage != null) {
                SOAPPart incomingPart = incomingMessage.getSOAPPart();
                SOAPEnvelope incomingEnvelope = incomingPart.getEnvelope();
                SOAPBody incomingBody = incomingEnvelope.getBody();
                if(incomingBody.hasFault()){
                    resp.sendRedirect(req.getContextPath() + "/QueryFail.html");
                    return;
                }
                Iterator<SOAPElement> iterator = incomingBody.getChildElements(incomingEnvelope.createName("scoreRecord","nju","http://www.nju.edu.cn/"));
                while (iterator.hasNext()){
                    Score score = new Score();
                    SOAPElement element = iterator.next();
                    Node studentIdElement = element.getElementsByTagName("studentId").item(0);
                    Node courseNumberElement = element.getElementsByTagName("courseNumber").item(0);
                    Node scoreTypeElement = element.getElementsByTagName("scoreType").item(0);
                    Node scoreElement = element.getElementsByTagName("score").item(0);
                    score.setScore(Integer.parseInt(scoreElement.getTextContent()));
                    score.setScoreType(scoreTypeElement.getTextContent());
                    score.setCourseNumber(courseNumberElement.getTextContent());
                    score.setStudentId(studentIdElement.getTextContent());
                    resultList.add(score);
                }
            }
            if(resultList.size() == 0){
                req.setAttribute("warnMessage","No data now...");
            }else{
                System.out.println("结果数量"+resultList.size());
                req.getSession().setAttribute("resultList",resultList);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        resp.sendRedirect(req.getContextPath() + "/ScoreView.jsp");
    }


}
