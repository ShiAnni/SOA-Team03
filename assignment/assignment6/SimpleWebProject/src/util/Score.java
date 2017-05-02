package util;

/**
 * Created by WH on 2016/4/26.
 */

//Score类封装了成绩信息
public class Score {
    private String studentId;
    private String courseNumber;
    private String scoreType;
    private int Score;

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getCourseNumber() {
        return courseNumber;
    }

    public void setCourseNumber(String courseNumber) {
        this.courseNumber = courseNumber;
    }

    public int getScore() {
        return Score;
    }

    public void setScore(int score) {
        Score = score;
    }

    public String getScoreType() {
        return scoreType;
    }

    public void setScoreType(String scoreType) {
        this.scoreType = scoreType;
    }

    @Override
    public String toString() {
        return  "studentId='" + studentId + '\'' +
                "| courseNumber='" + courseNumber + '\'' +
                "| scoreType='" + scoreType + '\'' +
                "| Score=" + Score;
    }
}
