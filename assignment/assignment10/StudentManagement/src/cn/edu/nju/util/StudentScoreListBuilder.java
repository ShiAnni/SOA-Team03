package cn.edu.nju.util;

import java.io.File;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import cn.edu.nju.jw.schema.学生列表信息;
import cn.edu.nju.jw.schema.学生类型;
import cn.edu.nju.jw.schema.课程成绩列表类型;
import cn.edu.nju.schema.个人基本信息类型;

public class StudentScoreListBuilder {
	
	public static void main(String[] args){
		Document doc = getDocument();
		System.out.println(saveDocument(doc));
	}
	
	public static Document getDocument(){
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();  
		factory.setIgnoringElementContentWhitespace(true);
        URL url = StudentScoreListBuilder.class.getResource("");
        String filePath = url.getPath().replace("build/classes/cn/edu/nju/util/", "");
        
        Document document=null;
        try{    
            DocumentBuilder builder = factory.newDocumentBuilder();
            document = builder.parse(filePath + "文档2.xml");
        } catch(Exception e){
            e.printStackTrace();
        }
        return document;
	}
	
	public static String saveDocument(Document document){
		URL url = StudentScoreListBuilder.class.getResource("");
        String filePath = url.getPath().replace("build/classes/cn/edu/nju/util/", "");
		
        try{
            TransformerFactory tFactory = TransformerFactory.newInstance();
            Transformer transformer = tFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(new File(filePath + "文档2.xml"));
            transformer.transform(source, result);
            return "操作成功";
        } catch (Exception e) {
            e.printStackTrace();
            return "操作失败： " + e.getMessage();
        }
	}
	
	public static 学生列表信息 getRootList(NodeList students){
		学生列表信息 list = new 学生列表信息();
		for(int i=0;i<students.getLength();++i){
			list.get学生().add(getScore((Element)students.item(i)));
		}
		return list;
	}
	
	public static 学生类型 getScore(Element student){
		学生类型 item = new 学生类型();
		String ID = student.getAttribute("学号");
		System.out.println(ID);
		个人基本信息类型 personInfo = getPersonInfo(student);
		课程成绩列表类型 courseInfo = getCourseInfo(student);
		item.set学号(ID);
		item.set学生基本信息(personInfo);
		item.set课程成绩列表(courseInfo);
		return item;
	}
	
	public static 个人基本信息类型 getPersonInfo(Element student){
		return new 个人基本信息类型();
	}
	
	public static 课程成绩列表类型 getCourseInfo(Element student){
		return new 课程成绩列表类型();
	}
	
	
}
