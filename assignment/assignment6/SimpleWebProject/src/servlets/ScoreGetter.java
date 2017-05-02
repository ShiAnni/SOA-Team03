package servlets;


import util.QueryParser;
import util.Score;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.soap.*;
import java.io.*;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Created by WH on 2016/4/26.
 */
@WebServlet("/scoreGetter")
public class ScoreGetter extends HttpServlet{
    private static final long serialVersionUID = 1L;
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
        System.out.println("ScoreGetter doPost();");
        try {
            SOAPMessage reqeustMessage = MessageFactory.newInstance().createMessage(null,req.getInputStream());
            SOAPEnvelope incomingEnvelope = reqeustMessage.getSOAPPart().getEnvelope();
            SOAPBody incomingBody = incomingEnvelope.getBody();
            Iterator iterator = incomingBody.getChildElements(
                    incomingEnvelope.createName("student-id","nju","http://www.nju.edu.cn/"));
            //得到存放学生学号的节点
            SOAPElement element = (SOAPElement) iterator.next();
            String studentId = element.getValue();
            System.out.println("ScoreGetter得到学生学号:"+studentId);
            //检验studentId是否合法
            boolean validInput = Pattern.matches("^141250[0-9]{3}$",studentId);
            //返回的是成绩，封装在SOAPMessage中
            SOAPMessage returnMessage = messageFactory.createMessage();
            SOAPEnvelope returnEnvelop = returnMessage.getSOAPPart().getEnvelope();
            SOAPBody responseBody = returnEnvelop.getBody();
            //异常处理
            if(!validInput) {
                responseBody.addFault(SOAPConstants.SOAP_SENDER_FAULT, "Not valid format of Student Id");
            }
            else{
                //调用QueryParser查询xml文件
                List<Score> scores = QueryParser.query(studentId);
                System.out.println("xxxxxxxxx");
                if(scores.size() == 0){
                    responseBody.addFault(SOAPConstants.SOAP_RECEIVER_FAULT, "No data for that given Id :"+studentId);
                }else{
                    for(Score score : scores){
                        SOAPBodyElement bodyElement = responseBody.addBodyElement(returnEnvelop.createName
                                ("scoreRecord", "nju", "http://www.nju.edu.cn/"));
                        bodyElement.addChildElement("studentId").setValue(score.getStudentId());
                        bodyElement.addChildElement("courseNumber").setValue(score.getCourseNumber());
                        bodyElement.addChildElement("scoreType").setValue(score.getScoreType());
                        bodyElement.addChildElement("score").setValue(Integer.toString(score.getScore()));
                    }
                }

            }
            //打印SOAPMessage到屏幕以便查看
            System.out.println("*************ScoreGetter返回的SOAPMessage begin*************");
            returnMessage.writeTo(System.out);
            System.out.println();
            System.out.println("*************ScoreGetter返回的SOAPMessage end*************");
            returnMessage.writeTo(resp.getOutputStream());
        } catch (SOAPException e) {
            e.printStackTrace();
        }

    }
}
/*
*  SOAPMessage soapMessage = null;
        //获取request body里面的SOAPMessage
        BufferedReader reader = req.getReader();
        DocumentBuilder receivedDocumentBuilder =
        //要从soapMessage中解析出学生学号
        SOAPPart received = soapMessage.getSOAPPart();

        try {
            SOAPEnvelope incomingEnvelope = received.getEnvelope();
            SOAPBody incomingBody = incomingEnvelope.getBody();
            Iterator iterator = incomingBody.getChildElements(
                    incomingEnvelope.createName("student-id","nju","http://www.nju.edu.cn/"));
            //得到存放学生学号的节点
            SOAPElement element = (SOAPElement) iterator.next();
            String studentId = element.getValue();
            System.out.println("ScoreGetter得到学生学号:"+studentId);
            //检验studentId是否合法
            boolean validInput = true;
            if(studentId.length() != 9)
                validInput = false;
            //调用QueryParser查询xml文件
            List<Score> scores = QueryParser.query(studentId);
            //返回的是成绩，封装在SOAPMessage中
            SOAPMessage returnMessage = messageFactory.createMessage();
            SOAPEnvelope returnEnvelop = returnMessage.getSOAPPart().getEnvelope();
            SOAPBody responseBody = returnEnvelop.getBody();
            for(Score score : scores){
//                .addChildElement(
//                        returnEnvelop.createName("studentId")).addTextNode(score.getStudentId())
//                        .addChildElement(returnEnvelop.createName("courseNumber")).addTextNode(score.getCourseNumber())
//                        .addChildElement(returnEnvelop.createName("scoreType")).addTextNode(score.getScoreType())
//                        .addChildElement(returnEnvelop.createName("score")).addTextNode(Integer.toString(score.getScore()))
//                ;
                SOAPBodyElement bodyElement = responseBody.addBodyElement(returnEnvelop.createName
                        ("scoreRecord", "nju", "http://www.nju.edu.cn/"));
                bodyElement.addChildElement("studentId").setValue(score.getStudentId());
                bodyElement.addChildElement("courseNumber").setValue(score.getCourseNumber());
                bodyElement.addChildElement("scoreType").setValue(score.getScoreType());
                bodyElement.addChildElement("score").setValue(Integer.toString(score.getScore()));
            }
            File outFile = new File("D:\\Course-2016Spring\\CodePractice\\SimpleWebProject\\src\\tempfiles\\out.msg");
            if(!outFile.exists())
                outFile.createNewFile();
            FileOutputStream outgoingFile = new FileOutputStream(outFile);
            returnMessage.writeTo(outgoingFile);
            outgoingFile.close();
            return returnMessage;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
*
* */
