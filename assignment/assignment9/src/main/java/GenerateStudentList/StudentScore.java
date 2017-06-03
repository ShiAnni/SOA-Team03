package GenerateStudentList;

import GenerateStudentList.CourseScore;

import javax.xml.bind.annotation.XmlElement;
import java.util.List;



public class StudentScore {
    @XmlElement(name = "课程成绩")
    public List<CourseScore> studentScore;

    public StudentScore(List<CourseScore> studentScore) {
        this.studentScore = studentScore;
    }

    public StudentScore() {
    }

}
