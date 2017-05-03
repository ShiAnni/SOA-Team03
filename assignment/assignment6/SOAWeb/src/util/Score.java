package util;


//Score类封装了成绩信息
public class Score {
	private String studentId;
    private String courseNumber;
    private String scoreType;
    private int score;

    
    public Score(String studentId, String courseNumber, String scoreType, int score) {
		this.studentId = studentId;
		this.courseNumber = courseNumber;
		this.scoreType = scoreType;
		this.score = score;
	}

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
        return score;
    }

    public void setScore(int score) {
    	this.score = score;
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
                "| score=" + score;
    }
}
