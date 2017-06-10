package cn.edu.nju.jw.wsdl;

import javax.jws.WebService;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import cn.edu.nju.jw.schema.ѧ���б���Ϣ;
import cn.edu.nju.jw.schema.ѧ������;
import cn.edu.nju.util.StudentScoreListBuilder;
@WebService(endpointInterface="cn.edu.nju.jw.wsdl.StudentManagementInterface")  
public class StudentManagementImpl implements StudentManagementInterface {

	@Override
	public ѧ���б���Ϣ getAllStudents(NoneType none) {
		Document doc = StudentScoreListBuilder.getDocument("�ĵ�2");
		NodeList students = doc.getDocumentElement().getElementsByTagName("ѧ��");
		return StudentScoreListBuilder.getRootList(students);
	}

	@Override
	public ��֤��Ϣ checkStudent(ѧ������ checkInfo) {
		ѧ���б���Ϣ list = getAllStudents(new NoneType());
		for (ѧ������ student : list.getѧ��()) {
			if(checkInfo.equals(student))
				return ��֤��Ϣ.��ȷ;
		}
		return ��֤��Ϣ.����;
	}

	@Override
	public String addStudent(ѧ������ addInfo) throws AddInfoFault {
		ѧ���б���Ϣ list = getAllStudents(new NoneType());
		for (ѧ������ student : list.getѧ��()) {
			if(student.getѧ��().equals(addInfo.getѧ��()))
				throw new AddInfoFault("�б���������Ӧѧ�ŵ�ѧ��","�б���������Ӧѧ�ŵ�ѧ��");
		}
		list.getѧ��().add(addInfo);
		Document doc = StudentScoreListBuilder.create(list);
		
		return StudentScoreListBuilder.saveDocument(doc);
	}

	@Override
	public String updateStudent(ѧ������ updateInfo) throws UpdateInfoFault {
		boolean found=false;
		ѧ���б���Ϣ list = getAllStudents(new NoneType());
		for (int i=0;i<list.getѧ��().size();++i) {
			if(list.getѧ��().get(i).getѧ��().equals(updateInfo.getѧ��())){
				list.getѧ��().set(i, updateInfo);
				found=true;
			}
		}
		if(found){
			Document doc = StudentScoreListBuilder.create(list);
			return StudentScoreListBuilder.saveDocument(doc);
		}else{
			throw new UpdateInfoFault("�б���û����Ӧѧ�ŵ�ѧ��","�б���û����Ӧѧ�ŵ�ѧ��");
		}
	}

	@Override
	public String deleteStudent(ѧ������ deleteInfo) throws DeleteInfoFault {
		boolean found=false;
		ѧ���б���Ϣ list = getAllStudents(new NoneType());
		for (int i=0;i<list.getѧ��().size();++i) {
			if(list.getѧ��().get(i).getѧ��().equals(deleteInfo.getѧ��())){
				list.getѧ��().remove(i);
				found=true;
			}
		}
		if(found){
			Document doc = StudentScoreListBuilder.create(list);
			return StudentScoreListBuilder.saveDocument(doc);
		}else{
			throw new DeleteInfoFault("�б���û����Ӧѧ�ŵ�ѧ��","�б���û����Ӧѧ�ŵ�ѧ��");
		}
	}

}
