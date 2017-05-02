package util;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by WH on 2016/4/26.
 */
public class QueryParser {
    private static Document document;
    public static String path="D:\\大三（3）\\SOA\\git\\SOA-Team03\\assignment\\assignment6\\SimpleWebProject";
    public static void main(String[] args) {
        List<Score> list  = query("141250010");
        for(Score score : list)
            System.out.println(score);
//        List<Score> newScoreList = new LinkedList<>();
//        Score s = new Score();
//        s.setStudentId("131250059");
//        s.setCourseNumber("00000");
//        s.setScoreType("平时成绩");
//        s.setScore(22);
//        newScoreList.add(s);
//        System.out.println(update(newScoreList));
    }
    public static List<Score> query(String stuId){
        //D:\Course-2016Spring\CodePractice\SimpleWebProject\src\tempfiles\studentScore
        List<Score> allScores = getObjectFromFile();
        List<Score> result = new LinkedList<>();
        for(Score s : allScores){
            if(s.getStudentId().equals(stuId))
                result.add(s);
        }
        return result;

    }

    public static boolean update(List<Score> newScoreList){
        for(int i=0; i<newScoreList.size(); i++){
            Score score = newScoreList.get(i);
            System.out.println("QueryParser update():"+score);
        }
        List<Score> scores = getObjectFromFile();
        boolean result = false;
        NodeList courseUnitList = document.getElementsByTagName("课程成绩");
        for(int i=0; i<courseUnitList.getLength(); i++){
            Element course = (Element) courseUnitList.item(i);
            String courseId  = course.getAttribute("课程编号");
            String scoreType  = course.getAttribute("成绩性质");
            for(int j=0; j<newScoreList.size(); j++){
                Score newScore = newScoreList.get(j);

                if(courseId.equals(newScore.getCourseNumber()) &&
                        scoreType.equals(newScore.getScoreType())){

                    NodeList recordList = course.getElementsByTagName("成绩");
                    for(int k=0; k<recordList.getLength(); k++){
                        Element chengji = (Element) recordList.item(k);
                        String xuehao = chengji.getElementsByTagName("学号").item(0).getFirstChild().getNodeValue();
                        if(xuehao.equals(newScore.getStudentId())){
                            result = true;
                            chengji.getElementsByTagName("得分").item(0).getFirstChild().setNodeValue(Integer.toString(newScore.getScore()));
                        }
                    }
                }
            }
        }
        if(result){
            TransformerFactory tFactory =
                    TransformerFactory.newInstance();
            Transformer transformer =
                    null;
            try {
                transformer = tFactory.newTransformer();
                DOMSource source = new DOMSource(document);
                FileOutputStream outputStream = new FileOutputStream(new File(path+"/src/tempfiles/文档2.xml"));
                StreamResult streamResult = new StreamResult(outputStream);
                transformer.transform(source, streamResult);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        return result;
    }

    public static List<Score> getObjectFromFile(){
        String url = path+"/src/tempfiles/文档2.xml";
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        List<Score> result = new LinkedList<>();
        try {
            DocumentBuilder builder = builderFactory.newDocumentBuilder();
            InputStream in = new FileInputStream(url);
            //下面是解析xml文件，寻找成绩
            Document doc = builder.parse(in);
            document = doc;
            Element root = doc.getDocumentElement();
            NodeList list = root.getElementsByTagName("成绩");//获取全部的成绩节点

            for(int i=0; i<list.getLength(); i++){
                //通过item()方法找到集合中的节点，并向下转型为Element对象
                Element n = (Element) list.item(i);
                String tempId = n.getElementsByTagName("学号").item(0).getFirstChild().getNodeValue();
                Score score = new Score();
                score.setStudentId(tempId);//设置学号
                String strScore = n.getElementsByTagName("得分").item(0).getFirstChild().getNodeValue();
                score.setScore(Integer.parseInt(strScore));//设置得分
                Element parent = (Element) n.getParentNode();
                score.setCourseNumber(parent.getAttribute("课程编号"));//设置课程编号
                score.setScoreType(parent.getAttribute("成绩性质"));//设置成绩性质
                result.add(score);
            }
            in.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }
}
