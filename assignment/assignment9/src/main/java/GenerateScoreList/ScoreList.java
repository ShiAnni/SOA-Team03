package GenerateScoreList;

import GenerateStudentList.CourseScore;

import javax.xml.bind.annotation.*;
import java.util.List;


@XmlRootElement(name = "课程成绩列表")
@XmlAccessorType(XmlAccessType.FIELD)
public class ScoreList {
    @XmlElement(name = "课程成绩")
    public List<CourseScore> courseScoreList;

    public ScoreList(List<CourseScore> courseScoreList) {
        this.courseScoreList = courseScoreList;
    }

    public List<CourseScore> getCourseScoreList() {
        return courseScoreList;
    }

    public void setCourseScoreList(List<CourseScore> courseScoreList) {
        this.courseScoreList = courseScoreList;
    }

    public ScoreList() {
    }
}
