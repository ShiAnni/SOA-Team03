package cn.edu.nju.jw.wsdl;

import javax.jws.WebService;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import cn.edu.nju.jw.schema.学生列表信息;
import cn.edu.nju.jw.schema.学生类型;
import cn.edu.nju.util.StudentScoreListBuilder;
@WebService
public class StudentManagementImpl implements StudentManagementInterface {

	@Override
	public 学生列表信息 getAllStudents(NoneType none) {
		Document doc = StudentScoreListBuilder.getDocument();
		NodeList students = doc.getDocumentElement().getElementsByTagName("学生");
		return StudentScoreListBuilder.getRootList(students);
	}

	@Override
	public 验证信息 checkStudent(学生类型 checkInfo) {
		// TODO Auto-generated method stub
		return null;
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
