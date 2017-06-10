package cn.edu.nju.util;

import org.w3c.dom.Document;

import cn.edu.nju.jw.schema.ѧ���б���Ϣ;
import cn.edu.nju.jw.schema.ѧ������;
import cn.edu.nju.jw.wsdl.AddInfoFault;
import cn.edu.nju.jw.wsdl.DeleteInfoFault;
import cn.edu.nju.jw.wsdl.NoneType;
import cn.edu.nju.jw.wsdl.StudentManagementInterface;
import cn.edu.nju.jw.wsdl.StudentService;
import cn.edu.nju.jw.wsdl.UpdateInfoFault;


public class Client {
	public static void main(String[] args) {  
		  
		StudentService service = new StudentService();
		StudentManagementInterface itf = service.getPort(StudentManagementInterface.class);
		
		ѧ���б���Ϣ list = itf.getAllStudents(new NoneType());
		System.out.println(list.getѧ��().size());
		
		Document doc1 = StudentScoreListBuilder.getDocument("�ĵ�11");
		Document doc2 = StudentScoreListBuilder.getDocument("�ĵ�12");
		Document doc3 = StudentScoreListBuilder.getDocument("�ĵ�13");
		ѧ������ student1 = StudentScoreListBuilder.getStudent(doc1.getDocumentElement());
		ѧ������ student2 = StudentScoreListBuilder.getStudent(doc2.getDocumentElement());
		ѧ������ student3 = StudentScoreListBuilder.getStudent(doc3.getDocumentElement());
		System.out.println(itf.checkStudent(student1));
		System.out.println(itf.checkStudent(student2));
		
		try {
			itf.addStudent(student2);
			System.out.println("��ӳɹ�");
		} catch (AddInfoFault e) {
			System.out.println(e.getFaultInfo());
		}
		
		try {
			itf.addStudent(student3);
			System.out.println("��ӳɹ�");
		} catch (AddInfoFault e) {
			System.out.println(e.getFaultInfo());
		}
		
		try {
			itf.deleteStudent(student3);
			System.out.println("ɾ���ɹ�");
		} catch (DeleteInfoFault e) {
			System.out.println(e.getFaultInfo());
		}
		
		try {
			itf.deleteStudent(student3);
			System.out.println("ɾ���ɹ�");
		} catch (DeleteInfoFault e) {
			System.out.println(e.getFaultInfo());
		}
		
		try {
			itf.updateStudent(student2);
			System.out.println("�޸ĳɹ�");
		} catch (UpdateInfoFault e) {
			System.out.println(e.getFaultInfo());
		}
		
		try {
			itf.updateStudent(student3);
			System.out.println("�޸ĳɹ�");
		} catch (UpdateInfoFault e) {
			System.out.println(e.getFaultInfo());
		}
		
		try {
			itf.addStudent(student3);
			System.out.println("��ӳɹ�");
		} catch (AddInfoFault e) {
			System.out.println(e.getFaultInfo());
		}
    }  
}
