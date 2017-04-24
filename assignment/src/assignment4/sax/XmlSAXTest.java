package assignment4.sax;

import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;


public class XmlSAXTest {
    public static void main(String[] args) {
        SAXParserFactory parserFactory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = parserFactory.newSAXParser();
            MySAXHandler saxHandler = new MySAXHandler("课程成绩列表");
            parser.parse("src/assignment4/xml/文档3.xml",saxHandler);
			List<List<Map<String,String>>> result = saxHandler.getList();
            outputXml(result);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    static DocumentBuilder builder;
    static Document document;
    public static void outputXml(List<List<Map<String,String>>> domContent){
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
            //���xml
            document.appendChild(root);
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer transformer = tf.newTransformer();
            DOMSource source = new DOMSource(document);
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty( "{http://xml.apache.org/xalan}indent-amount", "4");  
            transformer.setOutputProperty(OutputKeys.METHOD, "xml");
			

            PrintWriter pw = new PrintWriter(new FileOutputStream("src/assignment4/xml/文档4.xml"));
            StreamResult result = new StreamResult(pw);
            transformer.transform(source, result);
//            System.out.println("���xml4�ɹ�!");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
