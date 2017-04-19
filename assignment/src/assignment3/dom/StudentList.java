package assignment3.dom;



import java.io.FileOutputStream;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Namespace;
import org.dom4j.QName;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

import assignment3.validator.XMLValidator;

public class StudentList {
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
	
	private static final String FILE_PATH = "src/assignment3/xml/StudentList.xml";
	private static final String XSD_PATH = "src/assignment3/schema/StudentList.xsd";
	private static final String NS_JW = "http://jw.nju.edu.cn/schema";
	private static final String NS_NJU = "http://www.nju.edu.cn/schema";
	private static final String NS_XSI = "http://www.w3.org/2001/XMLSchema-instance";
	
	public static void create() {
		Document doc = DocumentHelper.createDocument();
		Namespace xsi = DocumentHelper.createNamespace("xsi", NS_XSI);
		if (doc != null) {
			Element studentList = doc.addElement("学生列表",NS_JW);
			studentList.add(xsi);
			QName schema = new QName("schemaLocation", xsi);
			studentList.addAttribute(schema, "http://jw.nju.edu.cn/schema ../schema/StudentList.xsd");
			for(int i = 0; i < idList.length; i++) {
				Element student = studentList.addElement("学生");
				student.addAttribute("学号", idList[i]);
				
				//学生基本信息
				Element personInfo = student.addElement("学生基本信息",NS_NJU);
				personInfo.addElement("姓名").addText(nameList[i]);
				personInfo.addElement("性别").addText(genderList[i]);
				personInfo.addElement("入学年份").addText("2014");
				Element birth = personInfo.addElement("出生日期");
				birth.addElement("年").addText(birthYearList[i] + "");
				birth.addElement("月").addText(birthMonthList[i] + "");
				birth.addElement("日").addText(birthDayList[i] + "");
				personInfo.addElement("手机").addText(phoneList[i]);
				personInfo.addElement("家庭住址").addText(addressList[i]);
				
				Element department = personInfo.addElement("部门信息");
				department.addAttribute("部门类型", "院系");
				department.addAttribute("部门编号", "001250");
				department.addElement("部门名称").addText("软件学院");
				Element size = department.addElement("部门规模");
				Element studentSize = size.addElement("人数");
				studentSize.addAttribute("类型", "学生");
				studentSize.addText("218");
				Element teacherSize = size.addElement("人数");
				teacherSize.addAttribute("类型", "教师");
				teacherSize.addText("48");
				Element managerSize = size.addElement("人数");
				managerSize.addAttribute("类型", "管理人员");
				managerSize.addText("17");
				
				//课程成绩列表
				Element scoreList = student.addElement("课程成绩列表");
				for(int j = 0; j < courseIDList.length; j++) {
					for(int k = 0; k < scoreTypeList.length; k++) {
						Element scoreDes = scoreList.addElement("课程成绩");
						scoreDes.addAttribute("课程编号", courseIDList[j]);
						scoreDes.addAttribute("成绩性质", scoreTypeList[k]);
						Element usualScore = scoreDes.addElement("成绩");
						usualScore.addElement("学号").addText(idList[i]);
						int score = 0;
						if (i < nameList.length / 2) {
							score = (int) (Math.random() * 40) + 60;
						} else {
							score = (int) (Math.random() * 60);
						}
						usualScore.addElement("得分").addText(score + "");
					}
				}
			}
			try {
				OutputFormat format = OutputFormat.createPrettyPrint();
				format.setEncoding("utf-8");
				FileOutputStream fos = new FileOutputStream(FILE_PATH);
				XMLWriter writer = new XMLWriter(fos, format);
				writer.write(doc);
				writer.close();
			}catch (Exception e) {
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
}
