package cn.edu.nju.jw.wsdl;

import javax.jws.WebService;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import cn.edu.nju.jw.schema.ѧ���б���Ϣ;
import cn.edu.nju.jw.schema.ѧ������;
import cn.edu.nju.util.StudentScoreListBuilder;
@WebService
public class StudentManagementImpl implements StudentManagementInterface {

	@Override
	public ѧ���б���Ϣ getAllStudents(NoneType none) {
		Document doc = StudentScoreListBuilder.getDocument();
		NodeList students = doc.getDocumentElement().getElementsByTagName("ѧ��");
		return StudentScoreListBuilder.getRootList(students);
	}

	@Override
	public ��֤��Ϣ checkStudent(ѧ������ checkInfo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String addStudent(ѧ������ addInfo) throws AddInfoFault {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateStudent(ѧ������ updateInfo) throws UpdateInfoFault {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteStudent(ѧ������ deleteInfo) throws DeleteInfoFault {
		// TODO Auto-generated method stub
		return null;
	}

}
