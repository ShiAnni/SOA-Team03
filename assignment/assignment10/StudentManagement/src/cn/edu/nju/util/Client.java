package cn.edu.nju.util;

import cn.edu.nju.jw.schema.ѧ���б���Ϣ;
import cn.edu.nju.jw.schema.ѧ������;
import cn.edu.nju.jw.wsdl.AddInfoFault;
import cn.edu.nju.jw.wsdl.NoneType;
import cn.edu.nju.jw.wsdl.StudentManagementInterface;
import cn.edu.nju.jw.wsdl.StudentService;


public class Client {
	public static void main(String[] args) {  
		  
		StudentService service = new StudentService();
		StudentManagementInterface itf = service.getPort(StudentManagementInterface.class);
		
		ѧ���б���Ϣ list = itf.getAllStudents(new NoneType());
		System.out.println(list.getѧ��().size());
		try {
			itf.addStudent(new ѧ������());
		} catch (AddInfoFault e) {
			e.printStackTrace();
		}
    }  
}
