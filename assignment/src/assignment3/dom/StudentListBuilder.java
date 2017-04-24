package assignment3.dom;



import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import assignment3.validator.XMLValidator;

public class StudentListBuilder {
	private static String[] idList = {"141250010", "141250122", "141250146", "141250176", "141250150", "141250209", "141250171", "141250162", "141250170", "141250121"};
	private static String[] nameList = {"陈欢", "谭琼", "王子安", "于海强", "伍佳艺", "周小帆", "姚朋", "徐文杰", "杨宇宁", "谭期友"};
	private static String[] genderList = {"男", "女", "男", "男", "男", "女", "男", "男", "女", "男"};
	private static int[] birthYearList = {1995, 1996, 1996, 1995, 1996, 1996, 1997, 1995, 1996, 1995};
	private static int[] birthMonthList = {1, 8, 3, 4, 5, 6, 7, 10, 12, 2};
	private static int[] birthDayList = {21, 6, 7, 10, 22, 30, 10, 15, 12, 17};
	private static String[] phoneList = {"13087211123", "13585178653", "13115872838", "13688776788", "13908991788",
			"15213519368", "15186897677", "18909178654", "15208190899", "13666325878"};
	private static String[] addressList = {"江苏省南京市汉口路1号", "江苏省南京市汉口路2号", "江苏省南京市汉口路3号", "江苏省南京市汉口路4号", "江苏省南京市汉口路5号",
			"江苏省南京市汉口路6号", "江苏省南京市汉口路7号", "江苏省南京市汉口路8号", "江苏省南京市汉口路9号", "江苏省南京市汉口路10号"};
	private static String[] courseIDList = {"000001", "000002", "000003", "000004", "000005"};
	private static String[] scoreTypeList = {"平时成绩", "期末成绩", "总评成绩"};
	
	private static final String INPUT_FILE_PATH = "src/assignment3/xml/文档1.xml";
	private static final String FILE_PATH = "src/assignment3/xml/文档2.xml";
	private static final String XSD_PATH = "src/assignment3/schema/StudentList.xsd";
	private static final String NS_JW = "http://jw.nju.edu.cn/schema";
	private static final String NS_NJU = "http://www.nju.edu.cn/schema";
	private static final String NS_XSI = "http://www.w3.org/2001/XMLSchema-instance";
	private static final String SXL = NS_JW+" ../schema/StudentList.xsd";
	
	public static void create() {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		Document document = null;
		
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			document = builder.parse(INPUT_FILE_PATH);
		} catch (ParserConfigurationException e1) {
			e1.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Attr xsiAttr = document.createAttribute("xmlns:xsi");
		xsiAttr.setValue(NS_XSI);
		Attr jwAttr = document.createAttribute("xmlns");
		jwAttr.setValue(NS_JW);
		Attr schemaAttr = document.createAttribute("xsi:schemaLocation");
		schemaAttr.setValue(SXL);
		
		if (document != null) {
			Element student = document.getDocumentElement();
			student.removeAttribute("xmlns:xsi");
			student.removeAttribute("xmlns");
			student.removeAttribute("xsi:schemaLocation");
			Element studentList = document.createElement("学生列表");
			studentList.setAttributeNode(jwAttr);
			studentList.setAttributeNode(xsiAttr);
			studentList.setAttributeNode(schemaAttr);
			
			studentList.appendChild(student);
			for(int i = 0; i < idList.length; i++) {
				addStudent(document,studentList, i);
			}
			
			document.appendChild(studentList);
			DOMSource source = new DOMSource(document);
			try {
				Result result = new StreamResult(new FileOutputStream(new File(FILE_PATH)));
				Transformer transformer = TransformerFactory.newInstance().newTransformer();
				transformer.setOutputProperty(OutputKeys.INDENT, "yes");
				transformer.setOutputProperty( "{http://xml.apache.org/xalan}indent-amount", "4");  
				transformer.setOutputProperty(OutputKeys.METHOD, "xml");
				transformer.transform(source, result);
			} catch (TransformerException e) {
				e.printStackTrace();
			}catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		boolean isValid = XMLValidator.validateXML(XSD_PATH, FILE_PATH);
		if (isValid) {
			System.out.println(FILE_PATH + "验证正确");
		} else {
			System.out.println(FILE_PATH + "验证失败");
		}
	}

	private static void addStudent(Document document,Element studentList, int i) {
		Attr njuAttr = document.createAttribute("xmlns");
		njuAttr.setValue(NS_NJU);
		
		Element student = document.createElement("学生");
		student.setAttribute("学号", idList[i]);
		
		//学生基本信息
		Element personInfo = document.createElement("学生基本信息");
		personInfo.setAttributeNode(njuAttr);
		Element name = document.createElement("姓名");
		Element sex = document.createElement("性别");
		Element comin = document.createElement("入学年份");
		name.setTextContent(nameList[i]);
		sex.setTextContent(genderList[i]);
		comin.setTextContent("2014");
		personInfo.appendChild(name);
		personInfo.appendChild(sex);
		personInfo.appendChild(comin);
		
		
		Element birth = document.createElement("出生日期");
		Element year = document.createElement("年");
		Element month = document.createElement("月");
		Element day = document.createElement("日");
		year.setTextContent(birthYearList[i] + "");
		month.setTextContent(birthMonthList[i] + "");
		day.setTextContent(birthDayList[i] + "");
		birth.appendChild(year);
		birth.appendChild(month);
		birth.appendChild(day);
		personInfo.appendChild(birth);
		
		Element telephone = document.createElement("手机");
		Element address = document.createElement("家庭住址");
		telephone.setTextContent(phoneList[i]);
		address.setTextContent(addressList[i]);
		personInfo.appendChild(telephone);
		personInfo.appendChild(address);
		
		Element department = document.createElement("部门信息");
		department.setAttribute("部门类型", "院系");
		department.setAttribute("部门编号", "001250");
		Element departmentName = document.createElement("部门名称");
		departmentName.setTextContent("软件学院");
		department.appendChild(departmentName);
		
		Element size = document.createElement("部门规模");
		Element studentSize = document.createElement("人数");
		studentSize.setAttribute("类型", "学生");
		studentSize.setTextContent("218");
		Element teacherSize = document.createElement("人数");
		teacherSize.setAttribute("类型", "教师");
		teacherSize.setTextContent("48");
		Element managerSize = document.createElement("人数");
		managerSize.setAttribute("类型", "管理人员");
		managerSize.setTextContent("17");
		size.appendChild(studentSize);
		size.appendChild(teacherSize);
		size.appendChild(managerSize);
		department.appendChild(size);
		personInfo.appendChild(department);
		
		student.appendChild(personInfo);
		
		//课程成绩列表
		Element scoreList = document.createElement("课程成绩列表");
		for(int j = 0; j < courseIDList.length; j++) {
			for(int k = 0; k < scoreTypeList.length; k++) {
				Element scoreDes = document.createElement("课程成绩");
				scoreDes.setAttribute("课程编号", courseIDList[j]);
				scoreDes.setAttribute("成绩性质", scoreTypeList[k]);
				Element usualScore = document.createElement("成绩");
				Element scoreStudentId = document.createElement("学号");
				scoreStudentId.setTextContent(idList[i]);
				usualScore.appendChild(scoreStudentId);
				int score = 0;
				if (i < nameList.length / 2 || j%2==0) {
					score = (int) (Math.random() * 40) + 60;
				} else {
					score = (int) (Math.random() * 60);
				}
				Element scorePoint = document.createElement("得分");
				scorePoint.setTextContent(score + "");
				usualScore.appendChild(scorePoint);
				
				scoreDes.appendChild(usualScore);
				scoreList.appendChild(scoreDes);
			}
		}
		student.appendChild(scoreList);
		studentList.appendChild(student);
	}
}
