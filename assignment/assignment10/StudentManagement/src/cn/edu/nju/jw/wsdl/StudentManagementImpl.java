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
		Document doc = StudentScoreListBuilder.getDocument("文档2");
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
		学生列表信息 list = getAllStudents(new NoneType());
		for (学生类型 student : list.get学生()) {
			if(student.get学号().equals(addInfo.get学号()))
				throw new AddInfoFault("列表中已有相应学号的学生","列表中已有相应学号的学生");
		}
		list.get学生().add(addInfo);
		Document doc = StudentScoreListBuilder.create(list);
		
		return StudentScoreListBuilder.saveDocument(doc);
	}

	@Override
	public String updateStudent(学生类型 updateInfo) throws UpdateInfoFault {
		boolean found=false;
		学生列表信息 list = getAllStudents(new NoneType());
		for (int i=0;i<list.get学生().size();++i) {
			if(list.get学生().get(i).get学号().equals(updateInfo.get学号())){
				list.get学生().set(i, updateInfo);
				found=true;
			}
		}
		if(found){
			Document doc = StudentScoreListBuilder.create(list);
			return StudentScoreListBuilder.saveDocument(doc);
		}else{
			throw new UpdateInfoFault("列表中没有相应学号的学生","列表中没有相应学号的学生");
		}
	}

	@Override
	public String deleteStudent(学生类型 deleteInfo) throws DeleteInfoFault {
		boolean found=false;
		学生列表信息 list = getAllStudents(new NoneType());
		for (int i=0;i<list.get学生().size();++i) {
			if(list.get学生().get(i).get学号().equals(deleteInfo.get学号())){
				list.get学生().remove(i);
				found=true;
			}
		}
		if(found){
			Document doc = StudentScoreListBuilder.create(list);
			return StudentScoreListBuilder.saveDocument(doc);
		}else{
			throw new DeleteInfoFault("列表中没有相应学号的学生","列表中没有相应学号的学生");
		}
	}

}
