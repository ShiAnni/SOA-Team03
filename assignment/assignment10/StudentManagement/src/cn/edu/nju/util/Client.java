package cn.edu.nju.util;

import org.w3c.dom.Document;

import cn.edu.nju.jw.schema.学生列表信息;
import cn.edu.nju.jw.schema.学生类型;
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
		
		学生列表信息 list = itf.getAllStudents(new NoneType());
		System.out.println(list.get学生().size());
		
		Document doc1 = StudentScoreListBuilder.getDocument("文档11");
		Document doc2 = StudentScoreListBuilder.getDocument("文档12");
		Document doc3 = StudentScoreListBuilder.getDocument("文档13");
		学生类型 student1 = StudentScoreListBuilder.getStudent(doc1.getDocumentElement());
		学生类型 student2 = StudentScoreListBuilder.getStudent(doc2.getDocumentElement());
		学生类型 student3 = StudentScoreListBuilder.getStudent(doc3.getDocumentElement());
		System.out.println(itf.checkStudent(student1));
		System.out.println(itf.checkStudent(student2));
		
		try {
			itf.addStudent(student2);
			System.out.println("添加成功");
		} catch (AddInfoFault e) {
			System.out.println(e.getFaultInfo());
		}
		
		try {
			itf.addStudent(student3);
			System.out.println("添加成功");
		} catch (AddInfoFault e) {
			System.out.println(e.getFaultInfo());
		}
		
		try {
			itf.deleteStudent(student3);
			System.out.println("删除成功");
		} catch (DeleteInfoFault e) {
			System.out.println(e.getFaultInfo());
		}
		
		try {
			itf.deleteStudent(student3);
			System.out.println("删除成功");
		} catch (DeleteInfoFault e) {
			System.out.println(e.getFaultInfo());
		}
		
		try {
			itf.updateStudent(student2);
			System.out.println("修改成功");
		} catch (UpdateInfoFault e) {
			System.out.println(e.getFaultInfo());
		}
		
		try {
			itf.updateStudent(student3);
			System.out.println("修改成功");
		} catch (UpdateInfoFault e) {
			System.out.println(e.getFaultInfo());
		}
		
		try {
			itf.addStudent(student3);
			System.out.println("添加成功");
		} catch (AddInfoFault e) {
			System.out.println(e.getFaultInfo());
		}
    }  
}
