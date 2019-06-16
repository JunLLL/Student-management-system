<%@ page language="java" contentType="text/html;charset=utf-8"%>
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

		<title>管理员信息</title>
	</head>
	<body>
		<center>
			<br />
			<br />
			<font size="5" style="font-family: 微软雅黑">管理员信息列表</font>

			<br />
			<br />
			<table>
				<c:forEach items="${admins}" var="admin">
					<tr>
						<td>
							用户名：
						</td>
						<td>
							<c:out value="${admin.username}"></c:out>
						</td>
					</tr>
					<tr>
						<td>
							密码：
						</td>
						<td>
							<c:out value="${admin.password}"></c:out>
						</td>
					</tr>
					<tr>
						<td>
							备注：
						</td>
						<td>
							<c:out value="${admin.name}"></c:out>
						</td>
					</tr>
					</c:forEach>
			</table>
		</center>
	</body>
</html>