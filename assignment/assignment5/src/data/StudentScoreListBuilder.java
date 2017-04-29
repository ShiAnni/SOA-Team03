package data;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.DOMReader;
import org.xml.sax.SAXException;

public class StudentScoreListBuilder {
	private static Map<String, List<Score>> scoreList = new HashMap<>();
	static{
		try {
			initiateScoreList();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static List<Score> getScoreById(String id){
		if(scoreList.containsKey(id))
			return scoreList.get(id);
		else
			return null;
	}
	@SuppressWarnings("unchecked")
	private static void initiateScoreList() throws ParserConfigurationException, SAXException, IOException{
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();  
        DocumentBuilder builder = factory.newDocumentBuilder();  
        DOMReader reader = new DOMReader();
        String path = "D:/program/git/SOA-Team03/assignment/assignment5/";
		Document document =  reader.read(builder.parse(new File(path+"src/data/文档2.xml")));
		Element studentList = document.getRootElement();
		List<Element> students = studentList.elements("学生");
		for (Element student : students) {
			String studentId = student.attributeValue("学号");
			List<Score> scores = new ArrayList<>();
			List<Element> scoreElements = student.element("课程成绩列表").elements("课程成绩");
			for (Element element : scoreElements) {
				String scoreType = element.attributeValue("成绩性质");
				String courseId = element.attributeValue("课程编号");
				int score = Integer.parseInt(element.element("成绩").element("得分").getText());
				scores.add(new Score(courseId, scoreType, score));
			}
			scoreList.put(studentId, scores);
		}
	}
	
	
}
