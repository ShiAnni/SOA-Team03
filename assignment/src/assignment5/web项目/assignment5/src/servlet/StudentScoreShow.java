package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.namespace.QName;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPBodyElement;
import javax.xml.soap.SOAPConstants;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;

import data.Score;
import data.StudentScoreListBuilder;

/**
 * Servlet implementation class StudentScoreShow
 */
@WebServlet("/StudentScoreShow")
public class StudentScoreShow extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		packageSOAPEnv(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	/**
	 * 不会关注里面的实现（如何组装SOAP不管（报文、文本还是saj接口都不管））要有对应的数据结构，信息放到文档中或者数据库中都可以，xml文档也可以 硬编码也可以 重点是接口
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	private void packageSOAPEnv(HttpServletRequest request, HttpServletResponse response) throws IOException{
		String id = request.getParameter("id");
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/soap+xml;charset=utf-8");
		response.setHeader("Content-Disposition", "attachment; filename=result.xml");
		response.setCharacterEncoding("utf-8");
		
		try {
			MessageFactory messageFactory = MessageFactory.newInstance();
			SOAPMessage message = messageFactory.createMessage();
			SOAPPart part = message.getSOAPPart();
			SOAPEnvelope envelope = part.getEnvelope();
			SOAPBody body = envelope.getBody();
			

			QName envName = new QName("http://jw.nju.edu.cn", "getStudentScoreResponse", "tns");
			
			if (id == null) {
				body.addFault(SOAPConstants.SOAP_SENDER_FAULT, "请求缺少参数");
			}else{
				List<Score> scores = StudentScoreListBuilder.getScoreById(id);
				if(scores==null)	body.addFault(SOAPConstants.SOAP_SENDER_FAULT, "输入学号错误或该学号无对应学生");
				else{
					SOAPBodyElement element = body.addBodyElement(envName);
					QName rootQName = element.createQName("课程成绩列表", "tns");
					SOAPElement root = element.addChildElement(rootQName);
					/**
					 * <学生列表 xmlns="http://jw.nju.edu.cn/schema" xmlns:xsi=
					 * "http://www.w3.org/2001/XMLSchema-instance"
					 * xsi:schemaLocation="http://jw.nju.edu.cn/schema
					 * ../schema/StudentList.xsd">
					 */
					root.setAttribute("xmlns:xsi", "http://www.w3.org/2001/XMLSchema-instance");
					root.setAttribute("xsi:schemaLocation", "http://jw.nju.edu.cn/schema ../schema/ScoreList.xsd");
					
					for (Score score : scores) {
						QName scoreQName = root.createQName("成绩", "tns");
						SOAPElement scoreElement = root.addChildElement(scoreQName);
						scoreElement.setAttribute("成绩类型", score.getScoreType());
						scoreElement.setAttribute("课程编号", score.getCourseNumber());
						
						QName idQName = scoreElement.createQName("学号", "tns");
						SOAPElement studentIdDOM = scoreElement.addChildElement(idQName);
						studentIdDOM.addTextNode(id);
	
						QName scorelistQName = scoreElement.createQName("得分", "tns");
						SOAPElement scorelistDOM = scoreElement.addChildElement(scorelistQName);
						scorelistDOM.setTextContent(score.getScore()+"");
					}
				}
			}
			
			message.writeTo(response.getOutputStream());
		} catch (SOAPException e) {
			e.printStackTrace();
		}
	}

}
