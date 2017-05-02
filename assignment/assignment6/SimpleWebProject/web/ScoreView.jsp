<%@ page import="util.Score" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%--
  Created by IntelliJ IDEA.
  User: WH
  Date: 2016/5/1
  Time: 16:29
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>学生成绩列表</title>
</head>
<body>
<table>
    <tr>
        <th>学生id</th>
        <th>课程编号</th>
        <th>成绩性质</th>
        <th>得分情况</th>
        <th>操作</th>
    </tr>

        <%
            List<Score> sList = (List<Score>) session.getAttribute("resultList");
            for(Score score : sList){
        %>
    <%
        String linkAndParam = "student="+score.getStudentId()+"&"
                +"courseNumber="+score.getCourseNumber()+"&"
                +"scoreType="+score.getScoreType()+"&"
                +"newScore="+88;
    %>
    <tr>
        <td><%= score.getStudentId()%></td>
        <td><%= score.getCourseNumber()%></td>
        <td><%= score.getScoreType()%></td>
        <td><%= score.getScore()%></td>
        <td><a href="updateClient?<%=linkAndParam%>">修改</a>
        </td>
    </tr>
        <%
            }
        %>

</table>

</body>
</html>
