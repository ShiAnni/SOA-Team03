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

import cn.edu.nju.jw.schema.ѧ���б���Ϣ;
import cn.edu.nju.jw.schema.ѧ������;
import cn.edu.nju.jw.schema.�ɼ���������;
import cn.edu.nju.jw.schema.�ɼ�����;
import cn.edu.nju.jw.schema.�γ̳ɼ��б�����;
import cn.edu.nju.jw.schema.�γ̳ɼ�����;
import cn.edu.nju.schema.���˻�����Ϣ����;
import cn.edu.nju.schema.�Ա�����;
import cn.edu.nju.schema.��������;
import cn.edu.nju.schema.������Ա����;
import cn.edu.nju.schema.������������;
import cn.edu.nju.schema.������Ϣ����;
import cn.edu.nju.schema.������������;
import cn.edu.nju.schema.���Ź�ģ����;

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
            document = builder.parse(filePath + "�ĵ�2.xml");
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
            StreamResult result = new StreamResult(new File(filePath + "�ĵ�2.xml"));
            transformer.transform(source, result);
            return "�����ɹ�";
        } catch (Exception e) {
            e.printStackTrace();
            return "����ʧ�ܣ� " + e.getMessage();
        }
	}
	
	public static ѧ���б���Ϣ getRootList(NodeList students){
		ѧ���б���Ϣ list = new ѧ���б���Ϣ();
		for(int i=0;i<students.getLength();++i){
			list.getѧ��().add(getStudent((Element)students.item(i)));
		}
		return list;
	}
	
	public static ѧ������ getStudent(Element student){
		ѧ������ item = new ѧ������();
		String ID = student.getAttribute("ѧ��");
		���˻�����Ϣ���� personInfo = getPersonInfo(student);
		�γ̳ɼ��б����� courseInfo = getCourseInfo(student);
		item.setѧ��(ID);
		item.setѧ��������Ϣ(personInfo);
		item.set�γ̳ɼ��б�(courseInfo);
		return item;
	}
	
	public static ���˻�����Ϣ���� getPersonInfo(Element student){
		Element ePersonInfo = (Element) student.getElementsByTagName("ѧ��������Ϣ").item(0);
		String name = ePersonInfo.getElementsByTagName("����").item(0).getTextContent();
		�Ա����� sex = �Ա�����.fromValue(ePersonInfo.getElementsByTagName("�Ա�").item(0).getTextContent());
		int year = Integer.parseInt(ePersonInfo.getElementsByTagName("��ѧ���").item(0).getTextContent());
		
		int birthYear =  Integer.parseInt(((Element) ePersonInfo.getElementsByTagName("��������").item(0)).getElementsByTagName("��").item(0).getTextContent());
		int birthMonth =  Integer.parseInt(((Element) ePersonInfo.getElementsByTagName("��������").item(0)).getElementsByTagName("��").item(0).getTextContent());
		int birthDate =  Integer.parseInt(((Element) ePersonInfo.getElementsByTagName("��������").item(0)).getElementsByTagName("��").item(0).getTextContent());
		�������� birthday = new ��������();
		birthday.set��(birthYear);
		birthday.set��(birthMonth);
		birthday.set��(birthDate);
		
		String phone = ePersonInfo.getElementsByTagName("�ֻ�").item(0).getTextContent();
		String address = ePersonInfo.getElementsByTagName("��ͥסַ").item(0).getTextContent();
		������Ϣ���� department = getDepartmentInfo((Element) ePersonInfo.getElementsByTagName("������Ϣ").item(0));
		
		���˻�����Ϣ���� personInfo = new ���˻�����Ϣ����();
		personInfo.set����(name);
		personInfo.set�Ա�(sex);
		personInfo.set��ѧ���(year);
		personInfo.set��������(birthday);
		personInfo.set�ֻ�(phone);
		personInfo.set��ͥסַ(address);
		personInfo.set������Ϣ(department);
//		System.out.println(personInfo);
		return personInfo;
	}
	
	private static ������Ϣ���� getDepartmentInfo(Element department){
		������Ϣ���� departmentType = new ������Ϣ����();
		String name = department.getElementsByTagName("��������").item(0).getTextContent();
		String ID = department.getAttribute("���ű��");
		������������ type = ������������.fromValue(department.getAttribute("��������"));
		���Ź�ģ���� size = new ���Ź�ģ����();
		NodeList NOPs = ((Element) department.getElementsByTagName("���Ź�ģ").item(0)).getElementsByTagName("����");
		for (int i = 0; i < NOPs.getLength(); i++) {
			������Ա���� t = ������Ա����.fromValue(((Element) NOPs.item(i)).getAttribute("����"));
			int num = Integer.parseInt(NOPs.item(i).getTextContent());
			������������ nt = new ������������();
			nt.setValue(num);
			nt.set����(t);
			size.get����().add(nt);
		}
		departmentType.set��������(name);
		departmentType.set��������(type);
		departmentType.set���ű��(ID);
		departmentType.set���Ź�ģ(size);
		return departmentType;
	}
	
	public static �γ̳ɼ��б����� getCourseInfo(Element student){
		Element eCourseInfo = (Element) student.getElementsByTagName("�γ̳ɼ��б�").item(0);
		NodeList courses = eCourseInfo.getElementsByTagName("�γ̳ɼ�");
		�γ̳ɼ��б����� courseList = new �γ̳ɼ��б�����();
		
		for (int i = 0; i < courses.getLength(); i++) {
			�γ̳ɼ����� score = getScoreType((Element) courses.item(i));
			courseList.get�γ̳ɼ�().add(score);
		}
//		System.out.println(courseList);
		return courseList;
	}
	
	private static �γ̳ɼ����� getScoreType(Element eCourse){
		�γ̳ɼ����� score = new �γ̳ɼ�����();
		String ID = eCourse.getAttribute("�γ̱��");
		�ɼ��������� type = �ɼ���������.fromValue(eCourse.getAttribute("�ɼ�����"));
		NodeList list = eCourse.getElementsByTagName("�ɼ�");
		for(int i=0;i<list.getLength();++i){
			�ɼ����� point = getScore((Element) list.item(0));
			score.get�ɼ�().add(point);
		}
		score.set�ɼ�����(type);
		score.set�γ̱��(ID);
		return score;
	}
	
	private static �ɼ����� getScore(Element escore){
		String stuID = escore.getElementsByTagName("ѧ��").item(0).getTextContent();
		int point = Integer.parseInt(escore.getElementsByTagName("�÷�").item(0).getTextContent());
		�ɼ����� score = new �ɼ�����();
		score.setѧ��(stuID);
		score.set�÷�(point);
		return score;
	}
	
	
	
	
}