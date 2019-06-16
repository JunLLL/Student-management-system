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
		<title>学生信息</title>
	</head>
	<script language="javascript" type="text/javascript">
function doEdit(id) {
	frm.action = "<%=basePath%>Student/editStudent?id="+id;
}

function dofind() {
	var sid = document.getElementById("sid");
	if(sid.value==""){
		alert("学号不能为空!!!")
	}else{
		document.forms[0].action = "<%=basePath%>Student/getStudentById";
		document.forms[0].submit;
	}
}

function dodelete(id) {
	frm.action = "<%=basePath%>Student/deleteStudent?id=" + id;
	if (!confirm("确认要删除？")) {
		window.event.returnValue = false;
	}
}

function getPwd(id) {
	frm.action = "<%=basePath%>Student/getStudentPwd?id="+id;
}
</script>

	<body>
		<center>
			<h1>
				学生信息列表
			</h1>
			<form action="" theme="simple">
				<table width="60%">
					<tr>
						<td>
							<font color=red><br> <marquee direction=left
									scrollamount="4">
									<b>※温馨提示：修改后的信息如没能正确反映请刷新后查看 删除的信息将不能复原，请慎重考虑※</b>
								</marquee> </font>
						</td>
					</tr>
				</table>
				<table>
					<tr>
						<td>
							<input id="sid" name="id">
						</td>
						<td>
							<input type="submit" value="按学号查询" align="bottom"
								onClick="dofind()" />
						</td>
					</tr>
				</table>
			</form>
			
			<form action="" method="post" name="frm">
				<table width="80%" border="1 solid" cellpadding="10" cellspacing="0">
					<tr
						style="background-color: gray;height: 30px; color: white;">
						<th>
							学号
						</th>
						<th>
							姓名
						</th>
						<th>
							性别
						</th>
						<th>
							班级
						</th>
						<th>
							出生日期
						</th>
						<th>
							密码
						</th>
						<th colspan="3">
							操作
						</th>
					</tr>
					<c:forEach items="${students}" var="student">
						<tr
							style="background-color: white; height: 30px;">
							<td align="center">
								<c:out value="${student.id}"></c:out>
							</td>
							<td align="center">
								<c:out value="${student.name}"></c:out>
							</td>
							<td align="center">
								<c:out value="${student.sex}"></c:out>
							</td>
							<td align="center">
								<c:out value="${student.clazz}"></c:out>
							</td>
							<td align="center">
								<c:out value="${student.birthday}"></c:out>
							</td>
							<td align="center">
								<c:out value="${student.password}"></c:out>
							</td>
							<td align="center">
								<input type="submit" value="编辑" align="bottom"
									onClick="doEdit(${student.id});" />
							</td>
							<td align="center">
								<input type="submit" value="删除" align="bottom"
									onclick="dodelete(${student.id});" />
							</td>
							<td align="center">
								<input type="submit" value="修改密码" align="bottom"
									onclick="getPwd(${student.id});" />
							</td>
						</tr>
					</c:forEach>
				</table>
			</form>
		</center>
	</body>
</html>