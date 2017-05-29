package GenerateStudentList;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * Created by ch on 2017/5/28.
 */
@XmlRootElement(name = "学生")
@XmlAccessorType(XmlAccessType.FIELD)
public class Student {
    @XmlElement(name = "学号")
    private String studentId;
    @XmlElement(name = "姓名")
    private String studentName;
    @XmlElement(name = "性别")
    private String sex;
    @XmlElement(name = "手机")
    private String phone;
    @XmlElement(name = "住址")
    private String address;
    @XmlElement(name = "课程成绩列表")
    private List<StudentScore> studentScore;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Student(String studentId, String studentName, String sex, String phone, String address) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.sex = sex;
        this.phone = phone;
        this.address = address;
    }

    public Student(String studentId, String studentName) {
        this.studentId = studentId;
        this.studentName = studentName;
    }



    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public List<StudentScore> getStudentScore() {
        return studentScore;
    }

    public void setStudentScore(List<StudentScore> studentScore) {
        this.studentScore = studentScore;
    }

    public Student() {
    }

    @Override
    public String toString() {
        return "GenerateStudentList.Student{" +
                "studentId='" + studentId + '\'' +
                ", studentName='" + studentName + '\'' +
                '}';
    }
}
