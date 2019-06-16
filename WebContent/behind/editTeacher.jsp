<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
		<title>修改教师信息</title>
	</head>

	<body background="<%=basePath%>images/main.GIF">
		<center>
			<h2>
				修改教师信息
			</h2>
			<br>
			<form action="<%=basePath%>Teacher/updateTeacher" method="post">

				<table>
					<tr>
						<td>
							<label>教工号</label>
							<input readonly="readonly" name="id" value="${teacher.id}">
						</td>
						<td>
							<label>姓名</label>
							<input name="name" value="${teacher.name}">
						</td>
						<td>
							<label>性别</label>
							<input name="sex" value="${teacher.sex}">
						</td>
						<td>
							<label>出生日期</label>
							<input name="birthday" value="${teacher.birthday}">
						</td>
						<td>
							<label>课程名</label>
							<input name="course.name" value="${teacher.course.name}">
						</td>
						<td>
							<label>职称</label>
							<input name="professional" value="${teacher.professional}">
						</td>
					</tr>
					<tr>
						<td colspan="4">
							<input type="submit" value="更 新"/>
						</td>
					</tr>
				</table>
			</form>
		</center>
	</body>
</html>