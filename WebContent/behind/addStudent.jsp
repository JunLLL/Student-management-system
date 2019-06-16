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
		
		<title>添加学生信息</title>
	</head>

	<body>
		<center>
			<h1>
				添加学生信息
			</h1>
			<form action="<%=basePath%>Student/addStudent" method="post">
				<table>
					<tr>
						<td>
							学号：
						</td>
						<td>
							<input type="text" name="id" />
						</td>
					</tr>
					<tr>
						<td>
							姓名：
						</td>
						<td>
							<input type="text" name="name" />
						</td>
					</tr>
					<tr>
						<td>
							密码：
						</td>
						<td>
							<input type="text" name="password" />
						</td>
					</tr>
					<tr>
						<td>
							性别：
						</td>
						<td>
							<input type="text" name="sex" />
						</td>
					</tr>
					<tr>
						<td>
							班级：
						</td>
						<td>
							<input type="text" name="clazz" />
						</td>
					</tr>
					<tr>
						<td>
							生日：
						</td>
						<td>
							<input type="text" name="birthday" />
						</td>
					</tr>
					<tr>
						<td align="center" colspan="2">
							<input type="submit" value="提交">
							<input type="reset" value="重置">
						</td>
					</tr>
				</table>
			</form>
		</center>
	</body>
</html>
