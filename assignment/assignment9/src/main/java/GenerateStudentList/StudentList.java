package GenerateStudentList;

import javax.xml.bind.annotation.*;
import java.util.List;


@XmlRootElement(name = "学生列表")
@XmlAccessorType(XmlAccessType.FIELD)
public class StudentList {

    @XmlElement(name = "学生")
    private List<Student> student;

    public StudentList() {
    }

    public StudentList(List<Student> studentScore) {
        this.student = studentScore;
    }


    public List<Student> getStudent() {
        return student;
    }

    public void setStudent(List<Student> student) {
        this.student = student;
    }

}
