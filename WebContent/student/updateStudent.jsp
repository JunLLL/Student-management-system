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

		<title>修改个人信息</title>

<style type="text/css">
	
	.style1 {
		color: #FFFFFF
	}
	.infotable th{
		color: white;
	}
	/*上传文件的按钮css美化*/	
	.file {
    position: relative;
    display: inline-block;
    background: gray;
    border: 1px solid #99D3F5;
    border-radius: 4px;
    padding: 4px 12px;
    overflow: hidden;
    color: white;
    text-decoration: none;
    text-indent: 0;
    line-height: 20px;
	}
	.file input {
	    position: absolute;
	    font-size: 100px;
	    right: 0;
	    top: 0;
	    opacity: 0;
	}
	.file:hover {
	    background: #AADFFD;
	    border-color: #78C3F3;
	    color: #004974;
	    text-decoration: none;
	}
</style>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	</head>

	<body background="<%=basePath%>images/main.GIF">
		<center>
			<h2>
				<img src="<%=basePath%>images/jiantou.jpg">
				当前位置：修改个人信息
			</h2>
			<c:set var="student" value="${sessionScope.student}" />
			<form method="post" action="<%=basePath%>Student/update" enctype="multipart/form-data">
				<table width="460" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td>
							<table class="infotable" width="460" border="1 solid" cellspacing="0" cellpadding="10">
								<tr>
									<th align="center" width="100" height="40" bgcolor="gray">
										学号
									</th>
									<td width="233" align="center">
										<input type="text" readonly="readonly" name="id"
											value=${student.id } />
									</td>
									<td width="120" rowspan="3" align="center">
										<img src="<%=basePath%>Student/getPhotoImage?id=${student.id}" width="100" height="110"/>
										<div style="width: 95px;height: 10px;">
											<a href="javascript:;" class="file">选择照片
												<input type="file" name="file" id="file">
											</a>
												<!-- <input id="file" name="file" type="file" value="选择" style="display: none;" > -->
										</div>
									</td>
								</tr>
								<tr>
									<th height="40" bgcolor="gray" align="center">
										姓名
									</th>
									<td height="40" align="center">
										<input type="text" name="name" value=${student.name } />
									</td>
								</tr>
								<tr>
									<th height="40" bgcolor="gray" align="center">
										性别
									</th>
									<td height="40" align="center">
										<input type="text" name="sex" value=${student.sex } />
									</td>
								</tr>
								<tr>
									<th height="40" bgcolor="gray" align="center">
										班级
									</th>
									<td height="40" colspan="2" align="center">
										<input type="text" name="clazz"
											value=${student.clazz } />
									</td>
								</tr>
								<tr>
									<th height="40" bgcolor="gray" align="center">
										出生日期
									</th>
									<td height="40" colspan="2" align="center">
										<input type="text" name="birthday"
											value=${student.birthday } />
									</td>
								</tr>
								<tr>
									<th height="110" align="center" bgcolor="gray">
										个人简介
									</th>
									<td colspan="2" align="center">
										此人很懒，什么都没留下！
									</td>
								</tr>
								<tr>
									<th height="40" bgcolor="gray" align="center">
										操作
									</th>
									<td height="40" colspan="2" align="center">
										<input type="submit" name=submit value="修改" />
									</td>
								</tr>
							</table>
						</td>
					</tr>
				</table>
			</form>
		</center>
		<br>
	</body>
</html>