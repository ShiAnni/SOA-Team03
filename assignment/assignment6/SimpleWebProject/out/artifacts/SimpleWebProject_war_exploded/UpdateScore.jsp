<%--
  Created by IntelliJ IDEA.
  Date: 2017/5/1
  Time: 17:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>更新学生成绩</title>
</head>
<body>
<h3>更新成绩</h3>


<form action="updateClient" method="post">
    <%--disabled input will not be submited , they are read-only--%>
    学生编号：<input type="text" disabled value="<%=session.getAttribute("studentId")%>"/>
    课程编号：<input type="text" disabled value="<%=session.getAttribute("courseNumber")%>"/>
    成绩类型：<input type="text" disabled value="<%=session.getAttribute("scoreType")%>"/>
    输入成绩: <input type="text" name="newScore"/>
    <input type="submit" value="Submit" />
</form>
</body>
</html>
