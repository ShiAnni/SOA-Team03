package GenerateStudentList;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * Created by ch on 2017/5/28.
 */
public class CourseScore {
    @XmlAttribute(name = "成绩性质")
    private String scoreType;//成绩性质
    @XmlAttribute(name = "课程编号")
    private String courseId;//课程编号

    @XmlElement(name = "成绩")
    private List<Score> scores;//成绩

    @XmlTransient
    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    @XmlTransient
    public String getScoreType() {
        return scoreType;
    }

    public void setScoreType(String scoreType) {
        this.scoreType = scoreType;
    }


    @XmlTransient
    public List<Score> getScores() {
        return scores;
    }

    public void setScores(List<Score> scores) {
        this.scores = scores;
    }

    public CourseScore(String courseId) {
        this.courseId = courseId;
    }

    public CourseScore(String courseId, String scoreType) {
        this.courseId = courseId;
        this.scoreType = scoreType;
    }

    public CourseScore(String courseId, String scoreType, List<Score> scores) {
        this.courseId = courseId;
        this.scoreType = scoreType;
        this.scores = scores;
    }

    public CourseScore() {
    }
}
