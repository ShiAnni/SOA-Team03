package assignment4.sax;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import javax.xml.parsers.*;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by WH on 2016/4/15.
 */
public class XmlSAXTest {
    public static void main(String[] args) {
        SAXParserFactory parserFactory = SAXParserFactory.newInstance();
        try {
            String path = System.getProperty("user.dir");

            SAXParser parser = parserFactory.newSAXParser();
            MySAXHandler saxHandler = new MySAXHandler("课程成绩列表");
            parser.parse(path+"/src/assignment4/xml/xml3 .xml",saxHandler);
            List<List> result = saxHandler.getList();
            outputXml(result);
            //System.out.println(list.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    static DocumentBuilder builder;
    static Document document;
    public static void outputXml(List<List> domContent){
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            builder = factory.newDocumentBuilder();
            document = builder.newDocument();
            Element root = document.createElement("课程成绩列表");
            for(int i=0; i<domContent.size(); i++){
                List<Map<String,String>> course = domContent.get(i);
                Element courseEle = document.createElement("课程成绩");
                courseEle.setAttribute("课程编号",course.get(0).get("课程编号"));
                courseEle.setAttribute("成绩性质",course.get(0).get("成绩性质"));
                for(int j=1; j<course.size(); j++){
                    Element score = document.createElement("成绩");
                    Map<String,String> map = course.get(j);
                    Element xuehao = document.createElement("学号");
                    xuehao.appendChild(document.createTextNode(map.get("学号")));
                    Element defen = document.createElement("得分");
                    defen.appendChild(document.createTextNode(map.get("得分")));
                    score.appendChild(xuehao);
                    score.appendChild(defen);
                    courseEle.appendChild(score);
                }
                root.appendChild(courseEle);
            }
            //输出xml
            document.appendChild(root);
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer transformer = tf.newTransformer();
            DOMSource source = new DOMSource(document);
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");

            String path = System.getProperty("user.dir");

            PrintWriter pw = new PrintWriter(new FileOutputStream(path+"/src/assignment4/xml/xml4 .xml"));
            StreamResult result = new StreamResult(pw);
            transformer.transform(source, result);
            System.out.println("生成xml4成功!");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
