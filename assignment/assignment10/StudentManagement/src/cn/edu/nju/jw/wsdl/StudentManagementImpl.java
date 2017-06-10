package cn.edu.nju.jw.wsdl;

import javax.jws.WebService;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import cn.edu.nju.jw.schema.学生列表信息;
import cn.edu.nju.jw.schema.学生类型;
import cn.edu.nju.util.StudentScoreListBuilder;
@WebService(endpointInterface="cn.edu.nju.jw.wsdl.StudentManagementInterface")  
public class StudentManagementImpl implements StudentManagementInterface {

	@Override
	public 学生列表信息 getAllStudents(NoneType none) {
		Document doc = StudentScoreListBuilder.getDocument();
		NodeList students = doc.getDocumentElement().getElementsByTagName("学生");
		return StudentScoreListBuilder.getRootList(students);
	}

	@Override
	public 验证信息 checkStudent(学生类型 checkInfo) {
		学生列表信息 list = getAllStudents(new NoneType());
		for (学生类型 student : list.get学生()) {
			if(checkInfo.equals(student))
				return 验证信息.正确;
		}
		return 验证信息.错误;
	}

	@Override
	public String addStudent(学生类型 addInfo) throws AddInfoFault {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateStudent(学生类型 updateInfo) throws UpdateInfoFault {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteStudent(学生类型 deleteInfo) throws DeleteInfoFault {
		// TODO Auto-generated method stub
		return null;
	}

}
