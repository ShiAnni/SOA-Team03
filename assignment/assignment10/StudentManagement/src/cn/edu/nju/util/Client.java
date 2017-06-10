package cn.edu.nju.util;

import cn.edu.nju.jw.schema.学生列表信息;
import cn.edu.nju.jw.schema.学生类型;
import cn.edu.nju.jw.wsdl.AddInfoFault;
import cn.edu.nju.jw.wsdl.NoneType;
import cn.edu.nju.jw.wsdl.StudentManagementInterface;
import cn.edu.nju.jw.wsdl.StudentService;


public class Client {
	public static void main(String[] args) {  
		  
		StudentService service = new StudentService();
		StudentManagementInterface itf = service.getPort(StudentManagementInterface.class);
		
		学生列表信息 list = itf.getAllStudents(new NoneType());
		System.out.println(list.get学生().size());
		try {
			itf.addStudent(new 学生类型());
		} catch (AddInfoFault e) {
			e.printStackTrace();
		}
    }  
}
