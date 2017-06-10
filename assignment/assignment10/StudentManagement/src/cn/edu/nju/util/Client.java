package cn.edu.nju.util;

import cn.edu.nju.jw.schema.ѧ���б���Ϣ;
import cn.edu.nju.jw.wsdl.AddInfoFault;
import cn.edu.nju.jw.wsdl.NoneType;
import cn.edu.nju.jw.wsdl.StudentManagementInterface;
import cn.edu.nju.jw.wsdl.StudentService;


public class Client {
	public static void main(String[] args) {  
		  
		StudentService service = new StudentService();
		StudentManagementInterface itf = service.getPort(StudentManagementInterface.class);
		
		ѧ���б���Ϣ list = itf.getAllStudents(null);
		System.out.println(list.getѧ��().size());
		try {
			itf.addStudent(null);
		} catch (AddInfoFault e) {
			e.printStackTrace();
		}
    }  
}
