package servlets;

import org.w3c.dom.*;
import org.w3c.dom.Node;
import util.QueryParser;
import util.Score;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.soap.*;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Created by WH on 2016/5/2.
 */
@WebServlet("/updateServer")
public class StudentUpdateServer extends HttpServlet {
    private static MessageFactory messageFactory = null;

    @Override
    public void init() throws ServletException {
        super.init();
        try {
            messageFactory = MessageFactory.newInstance();
        } catch (SOAPException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("StudentUpdateServer doPost();");
        SOAPMessage reqeustMessage = null;
        try {
            reqeustMessage = MessageFactory.newInstance().createMessage(null, req.getInputStream());
            boolean validInput = true;
            SOAPEnvelope incomingEnvelope = reqeustMessage.getSOAPPart().getEnvelope();
            SOAPBody incomingBody = incomingEnvelope.getBody();
            //访问newScoreRecord节点
            Iterator<SOAPElement> iterator = incomingBody.getChildElements(incomingEnvelope.createName("newScoreRecord", "nju", "http://www.nju.edu.cn/"));
            List<Score> newScoreRecordList = new LinkedList<>();
            while (iterator.hasNext()) {
                Score score = new Score();
                SOAPElement element = iterator.next();
                System.out.println();
                Node studentIdElement = element.getElementsByTagName("studentId").item(0);
                Node courseNumberElement = element.getElementsByTagName("courseNumber").item(0);
                Node scoreTypeElement = element.getElementsByTagName("scoreType").item(0);
                Node scoreElement = element.getElementsByTagName("newScore").item(0);
                //检验成绩输入是否合法
                String s =  scoreElement.getTextContent().trim();
                boolean b = Pattern.matches("^[1-9]$",s);
                boolean c = Pattern.matches("^[1-9][0-9]$",s);
                boolean d = Pattern.matches("^100$",s);
                System.out.println(b || c || d);
                if (!(b || c || d)) {
                    validInput = false;
                    break;
                }
                score.setScore(Integer.parseInt(scoreElement.getTextContent()));
                score.setScoreType(scoreTypeElement.getTextContent());
                score.setCourseNumber(courseNumberElement.getTextContent());
                score.setStudentId(studentIdElement.getTextContent());
                newScoreRecordList.add(score);
            }
            System.out.println("即将更新的记录数：" + newScoreRecordList.size());
            //根据updateResult构建返回的结果,封装到SOAPMessage
            SOAPMessage returnMessage = messageFactory.createMessage();
            SOAPEnvelope returnEnvelop = returnMessage.getSOAPPart().getEnvelope();
            SOAPBody responseBody = returnEnvelop.getBody();
            if (!validInput) {
                responseBody.addFault(SOAPConstants.SOAP_SENDER_FAULT, "Not valid format of Score!");
            } else {
                boolean updateResult = QueryParser.update(newScoreRecordList);
                SOAPBodyElement bodyElement = responseBody.addBodyElement(returnEnvelop.createName
                        ("updateResult", "nju", "http://www.nju.edu.cn/"));
                bodyElement.addChildElement("status").setValue(Boolean.toString(updateResult));
                if (updateResult) {
                    bodyElement.addChildElement("info").setValue("更新成功!!");
                } else {
                    bodyElement.addChildElement("info").setValue("更新失败");
                }
            }
            //输出的SOAPMessage
            System.out.println("*************StudentUpdateServer返回的SOAPMessage start*************");
            returnMessage.writeTo(System.out);
            System.out.println();
            System.out.println("*************StudentUpdateServer返回的SOAPMessage end*************");
            returnMessage.writeTo(resp.getOutputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
