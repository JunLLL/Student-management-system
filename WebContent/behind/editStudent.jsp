<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">
		<title>修改学生信息</title>
	</head>

	<body background="<%=basePath%>images/main.GIF">
		<center>
			<h2>
				修改学生信息
			</h2>
			<br>
			<form action="<%=basePath%>Student/updateStudent" method="post">

				<table>
					<tr>
						<td>
							<label>学号</label>
							<input  readonly="readonly" name="id" value="${student.id}">
						</td>
						<td>
							<label>姓名</label>
							<input name="name" value="${student.name}">
						</td>
						<td>
							<label>性别</label>
							<input name="sex" value="${student.sex}">
						</td>
						<td>
							<label>班级</label>
							<input name="clazz" value="${student.clazz}">
						</td>
						<td>
							<label>出生日期</label>
							<input name="birthday" value="${student.birthday}">
						</td>
					</tr>
					<tr>
						<td colspan="4">
							<input type="submit" value="更 新">
						</td>
					</tr>
				</table>
			</form>
		</center>
	</body>
</html>