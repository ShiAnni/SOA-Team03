package GenerateStudentList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Created by ch on 2017/5/28.
 */
public class Score {
    @XmlElement(name = "学号")
    private String studentId;//学号
    @XmlElement(name = "得分")
    private int scoreValue;//得分

    @XmlTransient
    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }


    @XmlTransient
    public int getScoreValue() {
        return scoreValue;
    }

    public void setScoreValue(int scoreValue) {
        this.scoreValue = scoreValue;
    }

    public Score(String studentId, int scoreValue) {
        this.studentId = studentId;
        this.scoreValue = scoreValue;
    }

    /**
     * 根据成绩获得ID
     * @param scoreValue
     * @return
     */
    public  String getStudent(int scoreValue){
        if(scoreValue==scoreValue){
            return  studentId;
        }
        return null;
    }

    public Score() {
    }
}
