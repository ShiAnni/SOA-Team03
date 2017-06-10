package cn.edu.nju.util;

import java.io.File;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import cn.edu.nju.jw.schema.学生列表信息;
import cn.edu.nju.jw.schema.学生类型;
import cn.edu.nju.jw.schema.成绩性质类型;
import cn.edu.nju.jw.schema.成绩类型;
import cn.edu.nju.jw.schema.课程成绩列表类型;
import cn.edu.nju.jw.schema.课程成绩类型;
import cn.edu.nju.schema.个人基本信息类型;
import cn.edu.nju.schema.性别类型;
import cn.edu.nju.schema.生日类型;
import cn.edu.nju.schema.部门人员类型;
import cn.edu.nju.schema.部门人数类型;
import cn.edu.nju.schema.部门信息类型;
import cn.edu.nju.schema.部门类型类型;
import cn.edu.nju.schema.部门规模类型;

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
			list.get学生().add(getStudent((Element)students.item(i)));
		}
		return list;
	}
	
	public static 学生类型 getStudent(Element student){
		学生类型 item = new 学生类型();
		String ID = student.getAttribute("学号");
		个人基本信息类型 personInfo = getPersonInfo(student);
		课程成绩列表类型 courseInfo = getCourseInfo(student);
		item.set学号(ID);
		item.set学生基本信息(personInfo);
		item.set课程成绩列表(courseInfo);
		return item;
	}
	
	public static 个人基本信息类型 getPersonInfo(Element student){
		Element ePersonInfo = (Element) student.getElementsByTagName("学生基本信息").item(0);
		String name = ePersonInfo.getElementsByTagName("姓名").item(0).getTextContent();
		性别类型 sex = 性别类型.fromValue(ePersonInfo.getElementsByTagName("性别").item(0).getTextContent());
		int year = Integer.parseInt(ePersonInfo.getElementsByTagName("入学年份").item(0).getTextContent());
		
		int birthYear =  Integer.parseInt(((Element) ePersonInfo.getElementsByTagName("出生日期").item(0)).getElementsByTagName("年").item(0).getTextContent());
		int birthMonth =  Integer.parseInt(((Element) ePersonInfo.getElementsByTagName("出生日期").item(0)).getElementsByTagName("月").item(0).getTextContent());
		int birthDate =  Integer.parseInt(((Element) ePersonInfo.getElementsByTagName("出生日期").item(0)).getElementsByTagName("日").item(0).getTextContent());
		生日类型 birthday = new 生日类型();
		birthday.set年(birthYear);
		birthday.set月(birthMonth);
		birthday.set日(birthDate);
		
		String phone = ePersonInfo.getElementsByTagName("手机").item(0).getTextContent();
		String address = ePersonInfo.getElementsByTagName("家庭住址").item(0).getTextContent();
		部门信息类型 department = getDepartmentInfo((Element) ePersonInfo.getElementsByTagName("部门信息").item(0));
		
		个人基本信息类型 personInfo = new 个人基本信息类型();
		personInfo.set姓名(name);
		personInfo.set性别(sex);
		personInfo.set入学年份(year);
		personInfo.set出生日期(birthday);
		personInfo.set手机(phone);
		personInfo.set家庭住址(address);
		personInfo.set部门信息(department);
//		System.out.println(personInfo);
		return personInfo;
	}
	
	private static 部门信息类型 getDepartmentInfo(Element department){
		部门信息类型 departmentType = new 部门信息类型();
		String name = department.getElementsByTagName("部门名称").item(0).getTextContent();
		String ID = department.getAttribute("部门编号");
		部门类型类型 type = 部门类型类型.fromValue(department.getAttribute("部门类型"));
		部门规模类型 size = new 部门规模类型();
		NodeList NOPs = ((Element) department.getElementsByTagName("部门规模").item(0)).getElementsByTagName("人数");
		for (int i = 0; i < NOPs.getLength(); i++) {
			部门人员类型 t = 部门人员类型.fromValue(((Element) NOPs.item(i)).getAttribute("类型"));
			int num = Integer.parseInt(NOPs.item(i).getTextContent());
			部门人数类型 nt = new 部门人数类型();
			nt.setValue(num);
			nt.set类型(t);
			size.get人数().add(nt);
		}
		departmentType.set部门名称(name);
		departmentType.set部门类型(type);
		departmentType.set部门编号(ID);
		departmentType.set部门规模(size);
		return departmentType;
	}
	
	public static 课程成绩列表类型 getCourseInfo(Element student){
		Element eCourseInfo = (Element) student.getElementsByTagName("课程成绩列表").item(0);
		NodeList courses = eCourseInfo.getElementsByTagName("课程成绩");
		课程成绩列表类型 courseList = new 课程成绩列表类型();
		
		for (int i = 0; i < courses.getLength(); i++) {
			课程成绩类型 score = getScoreType((Element) courses.item(i));
			courseList.get课程成绩().add(score);
		}
//		System.out.println(courseList);
		return courseList;
	}
	
	private static 课程成绩类型 getScoreType(Element eCourse){
		课程成绩类型 score = new 课程成绩类型();
		String ID = eCourse.getAttribute("课程编号");
		成绩性质类型 type = 成绩性质类型.fromValue(eCourse.getAttribute("成绩性质"));
		NodeList list = eCourse.getElementsByTagName("成绩");
		for(int i=0;i<list.getLength();++i){
			成绩类型 point = getScore((Element) list.item(0));
			score.get成绩().add(point);
		}
		score.set成绩性质(type);
		score.set课程编号(ID);
		return score;
	}
	
	private static 成绩类型 getScore(Element escore){
		String stuID = escore.getElementsByTagName("学号").item(0).getTextContent();
		int point = Integer.parseInt(escore.getElementsByTagName("得分").item(0).getTextContent());
		成绩类型 score = new 成绩类型();
		score.set学号(stuID);
		score.set得分(point);
		return score;
	}
	
	public static Document create(学生列表信息 list){
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = null;
		try {
			builder = factory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
		Document document = builder.newDocument();

		Attr xsiAttr = document.createAttribute("xmlns:xsi");
		xsiAttr.setValue(NS_XSI);
		Attr jwAttr = document.createAttribute("xmlns");
		jwAttr.setValue(NS_JW);
		Attr schemaAttr = document.createAttribute("xsi:schemaLocation");
		schemaAttr.setValue(SXL);
		
		if (document != null) {
			
			Element studentList = document.createElement("学生列表");
			studentList.setAttributeNode(jwAttr);
			studentList.setAttributeNode(xsiAttr);
			studentList.setAttributeNode(schemaAttr);
			
			for(int i = 0; i < list.get学生().size(); i++) {
				addStudent(document,studentList, list.get学生().get(i));
			}
			
			document.appendChild(studentList);
		}
		
		return document;
	}
	
	private static void addStudent(Document document, Element studentList, 学生类型 studentT) {
		Attr njuAttr = document.createAttribute("xmlns");
		njuAttr.setValue(NS_NJU);
		
		Element student = document.createElement("学生");
		student.setAttribute("学号", studentT.get学号());
		
		//学生基本信息
		Element personInfo = document.createElement("学生基本信息");
		personInfo.setAttributeNode(njuAttr);
		Element name = document.createElement("姓名");
		Element sex = document.createElement("性别");
		Element comin = document.createElement("入学年份");
		name.setTextContent(studentT.get学生基本信息().get姓名());
		sex.setTextContent(studentT.get学生基本信息().get性别().toString());
		comin.setTextContent(studentT.get学生基本信息().get入学年份()+"");
		personInfo.appendChild(name);
		personInfo.appendChild(sex);
		personInfo.appendChild(comin);
		
		
		Element birth = document.createElement("出生日期");
		Element year = document.createElement("年");
		Element month = document.createElement("月");
		Element day = document.createElement("日");
		year.setTextContent(studentT.get学生基本信息().get出生日期().get年() + "");
		month.setTextContent(studentT.get学生基本信息().get出生日期().get月() + "");
		day.setTextContent(studentT.get学生基本信息().get出生日期().get日() + "");
		birth.appendChild(year);
		birth.appendChild(month);
		birth.appendChild(day);
		personInfo.appendChild(birth);
		
		Element telephone = document.createElement("手机");
		Element address = document.createElement("家庭住址");
		telephone.setTextContent(studentT.get学生基本信息().get手机());
		address.setTextContent(studentT.get学生基本信息().get家庭住址());
		personInfo.appendChild(telephone);
		personInfo.appendChild(address);
		
		Element department = document.createElement("部门信息");
		department.setAttribute("部门类型", studentT.get学生基本信息().get部门信息().get部门类型().toString());
		department.setAttribute("部门编号", studentT.get学生基本信息().get部门信息().get部门编号());
		Element departmentName = document.createElement("部门名称");
		departmentName.setTextContent("软件学院");
		department.appendChild(departmentName);
		
		Element size = document.createElement("部门规模");
		for (部门人数类型 people : studentT.get学生基本信息().get部门信息().get部门规模().get人数()) {
			Element studentSize = document.createElement("人数");
			studentSize.setAttribute("类型", people.get类型().toString());
			studentSize.setTextContent(people.getValue()+"");
			size.appendChild(studentSize);
		}
		department.appendChild(size);
		personInfo.appendChild(department);
		
		student.appendChild(personInfo);
		
		//课程成绩列表
		Element scoreList = document.createElement("课程成绩列表");
		for(课程成绩类型 peopleScore:studentT.get课程成绩列表().get课程成绩()) {
			for(成绩类型 score:peopleScore.get成绩()) {
				Element scoreDes = document.createElement("课程成绩");
				scoreDes.setAttribute("课程编号", peopleScore.get课程编号());
				scoreDes.setAttribute("成绩性质", peopleScore.get成绩性质().toString());
				Element usualScore = document.createElement("成绩");
				Element scoreStudentId = document.createElement("学号");
				scoreStudentId.setTextContent(score.get学号());
				usualScore.appendChild(scoreStudentId);
				Element scorePoint = document.createElement("得分");
				scorePoint.setTextContent(score.get得分() + "");
				usualScore.appendChild(scorePoint);
				
				scoreDes.appendChild(usualScore);
				scoreList.appendChild(scoreDes);
			}
		}
		student.appendChild(scoreList);
		studentList.appendChild(student);
		
	}

	private static final String NS_JW = "http://jw.nju.edu.cn/schema";
	private static final String NS_NJU = "http://www.nju.edu.cn/schema";
	private static final String NS_XSI = "http://www.w3.org/2001/XMLSchema-instance";
	private static final String SXL = NS_JW+" WebContent/WEB-INF/schema/StudentList.xsd";
	
}
