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
		
		<title>添加教师信息</title>
	</head>

	<body>
		<center>
			<form action="<%=basePath%>Teacher/addTeacher" method="post">
				<table>
					<tr>
						<td>
							教工号
						</td>
						<td>
							<input type="text" name="id" />
						</td>
					</tr>
					<tr>
						<td>
							姓名
						</td>
						<td>
							<input type="text" name="name" />
						</td>
					</tr>
					<tr>
						<td>
							密码
						</td>
						<td>
							<input type="text" name="password" />
						</td>
					</tr>
					<tr>
						<td>
							性别
						</td>
						<td>
							<input type="text" name="sex" />
						</td>
					</tr>
					<tr>
						<td>
							出生日期
						</td>
						<td>
							<input type="text" name="birthday" />
						</td>
					</tr>
					<tr>
						<td>
							课程名
						</td>
						<td>
							<input type="text" name="course.name" />
						</td>
					</tr>
					<tr>
						<td>
							职称
						</td>
						<td>
							<input type="text" name="professional" />
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
