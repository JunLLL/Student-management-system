<%@ page language="java" contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

		<title>查看个人成绩</title>

		<style type="text/css">
<!--
.style1 {
	color: #FFFFFF
}
.infotable th{
	color: white;
}
-->
</style>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	</head>

	<body background="<%=basePath%>images/main.GIF">
		<center>
			<h2>
				<img src="<%=basePath%>images/jiantou.jpg">
				当前位置：成绩查询
			</h2>
			<table width="460" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td>
						<table class="infotable" width="460" border="1 solid" cellspacing="0" cellpadding="10">
							<tr>
								<th align="center" width="100" height="40" bgcolor="gray">
									学号
								</th>
								<td width="233" align="center">
									${scoresVo.id }
								</td>
							</tr>
							<tr>
								<th height="40" bgcolor="gray" align="center">
									姓名
								</th>
								<td height="40" align="center">
									${scoresVo.name }
								</td>
							</tr>
							<c:forEach items="${scoresVo.scores}" var="scores">
								<tr>
									<th height="40" bgcolor="gray" align="center">
										科目
									</th>
									<td height="40" align="center">
										<c:out value="${scores.course.name}"></c:out>
										
									</td>
								</tr>
								
								<tr>
									<th height="40" bgcolor="gray" align="center">
										成绩
									</th>
									<td height="40" colspan="2" align="center">
										<c:out value="${scores.score}"></c:out>
									</td>
								</tr>
							</c:forEach>
							
							<!-- 	<tr>
									<th height="40" bgcolor="gray" align="center">
										科目
									</th>
									<td height="40" align="center">
										<s:property value="course.name" />
									</td>
								</tr>
								<tr>
									<th height="40" bgcolor="gray" align="center">
										成绩
									</th>
									<td height="40" colspan="2" align="center">
										<s:property value="score" />
									</td>
								</tr> -->
						</table>
					</td>
				</tr>
			</table>
		</center>
		<br>
	</body>
</html>