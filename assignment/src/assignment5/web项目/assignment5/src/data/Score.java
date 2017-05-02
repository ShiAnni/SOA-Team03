package data;

public class Score {
	private String courseId;
	private String scoreType;
	private int point;
	
	public Score(String courseId, String scoreType, int point) {
		this.courseId = courseId;
		this.scoreType = scoreType;
		this.point = point;
	}

	public String getCourseId() {
		return courseId;
	}

	public String getScoreType() {
		return scoreType;
	}

	public int getPoint() {
		return point;
	}
}
