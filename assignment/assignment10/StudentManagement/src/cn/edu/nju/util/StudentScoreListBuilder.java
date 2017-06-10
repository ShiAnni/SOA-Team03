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
import cn.edu.nju.jw.schema.�γ̳ɼ��б�����;
import cn.edu.nju.schema.���˻�����Ϣ����;

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
			list.getѧ��().add(getScore((Element)students.item(i)));
		}
		return list;
	}
	
	public static ѧ������ getScore(Element student){
		ѧ������ item = new ѧ������();
		String ID = student.getAttribute("ѧ��");
		System.out.println(ID);
		���˻�����Ϣ���� personInfo = getPersonInfo(student);
		�γ̳ɼ��б����� courseInfo = getCourseInfo(student);
		item.setѧ��(ID);
		item.setѧ��������Ϣ(personInfo);
		item.set�γ̳ɼ��б�(courseInfo);
		return item;
	}
	
	public static ���˻�����Ϣ���� getPersonInfo(Element student){
		return new ���˻�����Ϣ����();
	}
	
	public static �γ̳ɼ��б����� getCourseInfo(Element student){
		return new �γ̳ɼ��б�����();
	}
	
	
}
