package cn.edu.nju.client;

import cn.edu.nju.jw.schema.成绩性质类型;
import cn.edu.nju.jw.schema.成绩类型;
import cn.edu.nju.jw.schema.课程成绩类型;
import cn.edu.nju.jw.wsdl.AddScoreFault;
import cn.edu.nju.jw.wsdl.DeleteScoreFault;
import cn.edu.nju.jw.wsdl.ModifyScoreFault;
import cn.edu.nju.jw.wsdl.ScoreInterface;
import cn.edu.nju.jw.wsdl.ScoreService;
import cn.edu.nju.jw.wsdl.SearchScoreFault;


public class Client {
	public static void main(String[] args) {  
		  
		ScoreService service = new ScoreService();
        ScoreInterface itf = service.getScorePort();
        
        课程成绩类型 single = new 课程成绩类型();
    	成绩类型 singlescore = new 成绩类型();
    	singlescore.set学号("141250148");
    	singlescore.set得分(95);
        single.set成绩性质(成绩性质类型.平时成绩);
        single.set课程编号("000001");
        single.get成绩().add(singlescore);
        try {
			itf.addScore(single);
			System.out.println("addScoreSuccess--Client");
		} catch (AddScoreFault e) {
			System.out.println("addScoreError");
			e.printStackTrace();
		}
        try {
        	itf.searchScore("123");
        } catch (SearchScoreFault e) {
        	System.out.println("查找的学号不存在");
        }
        
        try {
        	System.out.println(itf.searchScore("141250148").get课程成绩().size());
        	System.out.println("查找成功");
        } catch (SearchScoreFault e) {
        	e.printStackTrace();
        }
        
		try {
			itf.deleteScore(single);
			System.out.println("deleteScoreSuccess--Client");
		} catch (DeleteScoreFault e1) {
			System.out.println("deleteScoreError");
			e1.printStackTrace();
		}
		try {
        	System.out.println(itf.searchScore("141250158").get课程成绩().size());
        } catch (SearchScoreFault e) {
        	e.printStackTrace();
        }
		课程成绩类型 single2 = new 课程成绩类型();
    	成绩类型 singlescore2 = new 成绩类型();
    	singlescore2.set学号("141250158");
    	singlescore2.set得分(58);
    	single2.set成绩性质(成绩性质类型.总评成绩);
        single2.set课程编号("000001");
        single2.get成绩().add(singlescore2);
        try {
			itf.modifyScore(single2);
			System.out.println("modifyScoreSuccess--Client");
		} catch (ModifyScoreFault e) {
			System.out.println("modifyScoreError");
			e.printStackTrace();
		}
    }  
}
