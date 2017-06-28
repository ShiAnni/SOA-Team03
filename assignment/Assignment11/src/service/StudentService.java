package service;

import java.util.ArrayList;
import java.util.List;

import javax.xml.ws.Holder;
import javax.xml.ws.handler.Handler;
import javax.xml.ws.handler.HandlerResolver;
import javax.xml.ws.handler.PortInfo;

import org.eclipse.jdt.internal.compiler.ast.ThisReference;

import cn.edu.nju.jw.schema.AuthorityException;
import cn.edu.nju.jw.schema.IdNotFoundException;
import cn.edu.nju.jw.schema.Score;
import cn.edu.nju.jw.schema.ScoreControllerService;
import cn.edu.nju.jw.schema.ScoreModifyException;
import cn.edu.nju.jw.schema.ScoreTypeException;
import cn.edu.nju.jw.schema.成绩性质类型;
import cn.edu.nju.jw.schema.成绩类型;
import cn.edu.nju.jw.schema.课程成绩列表类型;
import cn.edu.nju.jw.schema.课程成绩类型;
import handler.AddAuthInfoHandler;
import handler.ValidAuthInfoHandler;

public class StudentService {

	private String email;
	private String password;
	private Score port;
	private ScoreControllerService factory;

	public StudentService(String email, String password) {
		this.email = email;
		this.password = password;
		
		init();
	}
	
	private void init(){
		//添加Handler
		factory = new ScoreControllerService();
		factory.setHandlerResolver(new HandlerResolver(){
			public List<Handler> getHandlerChain(PortInfo portInfo) {
				List<Handler> handlerList = new ArrayList<Handler>();
				handlerList.add(new AddAuthInfoHandler(email, password));
				handlerList.add(new ValidAuthInfoHandler());
				return handlerList;
			}
		});
		port = factory.getScorePort();
	}
	
	
	
	//1. Score add
	public void addScore(Holder<课程成绩列表类型> 课程成绩列表) {
		try {
			port.addScore(课程成绩列表);
		} catch (AuthorityException e) {
			System.out.println("权限错误");
		} catch (IdNotFoundException e) {
			System.out.println("学号错误");
		} catch (ScoreModifyException e) {
			System.out.println("修改错误");
		} catch (ScoreTypeException e) {
			System.out.println("分数类型错误");
		}
	}
	
	//2. Score get
	public 课程成绩列表类型 getScore(String id) {
		try {
			System.out.println(id+"id");
			System.out.println(port+"port");
			System.out.println(port.getScore(id)+"q");
			return port.getScore(id);
		} catch (IdNotFoundException e) {
			System.out.println("ID不存在");
		}
		return null;
	}

	
	//3. Score update
	public void modifyScore(Holder<课程成绩列表类型> 课程成绩列表) {
		try {
			port.modifyScore(课程成绩列表);
		}  catch (AuthorityException e) {
			System.out.println("权限错误");
		} catch (IdNotFoundException e) {
			System.out.println("学号错误");
		} catch (ScoreModifyException e) {
			System.out.println("修改错误");
		} catch (ScoreTypeException e) {
			System.out.println("分数类型错误");
		}
	}
	
	//4. Score delete
	public void deleteScore(Holder<课程成绩列表类型> 课程成绩列表) {
		try {
			port.deleteScore(课程成绩列表);
		} catch (AuthorityException e) {
			System.out.println("权限错误");
		} catch (IdNotFoundException e) {
			System.out.println("学号错误");
		} catch (ScoreModifyException e) {
			System.out.println("修改错误");
		} catch (ScoreTypeException e) {
			System.out.println("分数类型错误");
		}
	}
	
	//TODO 封装学生管理和成绩管理的方法 处理出错情况
	public static void main(String[] args) {
		//testTeacher();
		testStudent();
	}
	
	public static void testTeacher() {
		//1. 老师增删改查成绩
		StudentService service = new StudentService("bj@nju.edu.cn", "123456");
		//查
		System.out.println("查询141250019的成绩！");
		课程成绩列表类型 score = service.getScore("141250019");
		if (score != null) {
			List<课程成绩类型> 课程成绩 = score.get课程成绩();
			for (int i = 0; i < 课程成绩.size(); i++) {
				System.out.println(课程成绩.get(i).get课程编号() + "  " + 课程成绩.get(i).get成绩性质() + "  " + 课程成绩.get(i).get成绩().get(0).get学号() + " " + 课程成绩.get(i).get成绩().get(0).get得分());
			}
		} else {
			System.out.println("无141250019的成绩！");
		}
		
		//为141250019增加课程000009的总评成绩 100
		
		System.out.println("增加141250019的成绩，课程号为00009，成绩类型为平时成绩，成绩为100！");
		List<课程成绩类型> 课程成绩 = new ArrayList<课程成绩类型>();
		
		课程成绩类型 scoreType = new 课程成绩类型();
		scoreType.set成绩性质(成绩性质类型.平时成绩);
		scoreType.set课程编号("000009");
		List<成绩类型> 成绩 = new ArrayList<>();
		成绩类型 oneScore = new 成绩类型();
		oneScore.set学号("141250019");
		oneScore.set得分(100);
		成绩.add(oneScore);
		scoreType.set成绩(成绩);
		
		课程成绩.add(scoreType);
		课程成绩列表类型 scoreList = new 课程成绩列表类型();
		scoreList.set课程成绩(课程成绩);
		Holder<课程成绩列表类型> scores = new Holder<>(scoreList);
		service.addScore(scores);
		
		//查
		System.out.println("加了一个成绩之后查询141250019的成绩！");
		课程成绩列表类型 scoreTwo = service.getScore("141250019");
		if (scoreTwo != null) {
			List<课程成绩类型> 课程成绩Two = score.get课程成绩();
			for (int i = 0; i < 课程成绩Two.size(); i++) {
				System.out.println(课程成绩Two.get(i).get课程编号() + "  " + 课程成绩Two.get(i).get成绩性质() + "  " + 课程成绩Two.get(i).get成绩().get(0).get学号() + " " + 课程成绩Two.get(i).get成绩().get(0).get得分());
			}
		} else {
			System.out.println("无141250019的成绩！");
		}			
		
		//修改
		System.out.println("修改141250019的成绩！课程号为00009，成绩类型为平时成绩，成绩为100修改为99");
		List<课程成绩类型> 课程成绩Three = new ArrayList<课程成绩类型>();
		
		课程成绩类型 scoreTypeThree = new 课程成绩类型();
		scoreTypeThree.set成绩性质(成绩性质类型.平时成绩);
		scoreTypeThree.set课程编号("000009");
		List<成绩类型> 成绩Three = new ArrayList<>();
		成绩类型 oneScoreModify = new 成绩类型();
		oneScoreModify.set学号("141250019");
		oneScoreModify.set得分(99);
		成绩Three.add(oneScoreModify);
		scoreTypeThree.set成绩(成绩Three);
		
		课程成绩Three.add(scoreTypeThree);
		课程成绩列表类型 scoreListModify = new 课程成绩列表类型();
		scoreListModify.set课程成绩(课程成绩Three);
		Holder<课程成绩列表类型> scoresModify = new Holder<>(scoreListModify);
		service.addScore(scoresModify);
		
		System.out.println("加了一个成绩之后查询141250019的成绩！");
		课程成绩列表类型 scoreFour = service.getScore("141250019");
		if (scoreFour != null) {
			List<课程成绩类型> 课程成绩Four = scoreFour.get课程成绩();
			for (int i = 0; i < 课程成绩Four.size(); i++) {
				System.out.println(课程成绩Four.get(i).get课程编号() + "  " + 课程成绩Four.get(i).get成绩性质() + "  " + 课程成绩Four.get(i).get成绩().get(0).get学号() + " " + 课程成绩Four.get(i).get成绩().get(0).get得分());
			}
		} else {
			System.out.println("无141250019的成绩！");
		}
		//删除
		System.out.println("删除141250019的某一成绩");
		
		System.out.println("删除141250019的成绩，课程号为00004，成绩类型为总评成绩，成绩为99！");
		List<课程成绩类型> 课程成绩Four = new ArrayList<课程成绩类型>();
//		System.out.println("修改141250019的成绩！课程号为00009，成绩类型为平时成绩，成绩为100修改为99");
//		List<课程成绩类型> 课程成绩Three = new ArrayList<课程成绩类型>();
		
//		课程成绩类型 scoreType = new 课程成绩类型();
//		scoreType.set成绩性质(成绩性质类型.平时成绩);
//		scoreType.set课程编号("000009");
//		List<成绩类型> 成绩 = new ArrayList<>();
		
//		成绩类型 oneScore = new 成绩类型();
//		oneScore.set学号("141250019");
//		oneScore.set得分(100);
//		成绩.add(oneScore);
//		scoreType.set成绩(成绩);
		课程成绩类型 scoreTypeFour = new 课程成绩类型();
		
		scoreTypeFour.set成绩性质(成绩性质类型.总评成绩);
		scoreTypeFour.set课程编号("000004");
		List<成绩类型> 成绩Four = new ArrayList<>();
		
		成绩类型 oneScoreDelete = new 成绩类型();
		
		oneScoreDelete.set学号("141250019");
		oneScoreDelete.set得分(99);
		//成绩Four.add(oneScoreDelete);
		
		成绩Four.add(oneScoreDelete);
		scoreTypeFour.set成绩(成绩Four);
		
		课程成绩Four.add(scoreTypeFour);
		课程成绩列表类型 scoreListDelete = new 课程成绩列表类型();
		scoreListDelete.set课程成绩(课程成绩Four);
		Holder<课程成绩列表类型> scoresDelete = new Holder<>(scoreListDelete);
		service.deleteScore(scoresDelete);
//		课程成绩.add(scoreType);
//		课程成绩列表类型 scoreList = new 课程成绩列表类型();
//		scoreList.set课程成绩(课程成绩);
//		Holder<课程成绩列表类型> scores = new Holder<>(scoreList);
//		service.addScore(scores);
	
		System.out.println("删除一个成绩之后查询141250019的成绩！");
		课程成绩列表类型 scoreFive = service.getScore("141250019");
		if (scoreFive != null) {
			List<课程成绩类型> 课程成绩Five = scoreFive.get课程成绩();
			for (int i = 0; i < 课程成绩Five.size(); i++) {
				System.out.println(课程成绩Five.get(i).get课程编号() + "  " + 课程成绩Five.get(i).get成绩性质() + "  " + 课程成绩Five.get(i).get成绩().get(0).get学号() + " " + 课程成绩Five.get(i).get成绩().get(0).get得分());
			}
		} else {
			System.out.println("无141250019的成绩！");
		}
		
		
		
	}
	
	public static void testStudent() {
		StudentService service = new StudentService("141250019@smail.nju.edu.cn", "14125001");
		//查
				System.out.println("查询141250019的成绩！");
				
				课程成绩列表类型 score = service.getScore("141250019");
				
				if (score != null) {
					List<课程成绩类型> 课程成绩 = score.get课程成绩();
					for (int i = 0; i < 课程成绩.size(); i++) {
						System.out.println(课程成绩.get(i).get课程编号() + "  " + 课程成绩.get(i).get成绩性质() + "  " + 课程成绩.get(i).get成绩().get(0).get学号() + " " + 课程成绩.get(i).get成绩().get(0).get得分());
					}
				} else {
					System.out.println("无141250019的成绩！");
				}
	}
}
