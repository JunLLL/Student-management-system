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

		<title>管理页面</title>
		<style type=text/css>
BODY {
	BACKGROUND: #799ae1;
	MARGIN: 0px;
	FONT: 9pt 宋体
}

TABLE {
	BORDER-RIGHT: 0px;
	BORDER-TOP: 0px;
	BORDER-LEFT: 0px;
	BORDER-BOTTOM: 0px
}

TD {
	FONT: 12px 宋体
}

IMG {
	BORDER-RIGHT: 0px;
	BORDER-TOP: 0px;
	VERTICAL-ALIGN: bottom;
	BORDER-LEFT: 0px;
	BORDER-BOTTOM: 0px
}

A {
	FONT: 12px 宋体;
	COLOR: #000000;
	TEXT-DECORATION: none
}

A:hover {
	COLOR: #428eff;
	TEXT-DECORATION: underline
}

.sec_menu {
	BORDER-RIGHT: white 1px solid;
	BACKGROUND: #d6dff7;
	OVERFLOW: hidden;
	BORDER-LEFT: white 1px solid;
	BORDER-BOTTOM: white 1px solid
}

.menu_title {
	
}

.menu_title SPAN {
	FONT-WEIGHT: bold;
	LEFT: 7px;
	COLOR: #215dc6;
	POSITION: relative;
	TOP: 2px
}

.menu_title2 {
	
}

.menu_title2 SPAN {
	FONT-WEIGHT: bold;
	LEFT: 8px;
	COLOR: #428eff;
	POSITION: relative;
	TOP: 2px
}
</style>

		<SCRIPT language=javascript1.2>
function showsubmenu(sid)
{
whichEl = eval("submenu" + sid);
if (whichEl.style.display == "none")
{
eval("submenu" + sid + ".style.display=\"\";");
}
else
{
eval("submenu" + sid + ".style.display=\"none\";");
}
}

 
</SCRIPT>

		<META http-equiv=Content-Type content="text/html; charset=gb2312">
		<META content="MSHTML 6.00.2900.2180" name=GENERATOR>
	</HEAD>
	<BODY leftMargin=0 topMargin=0 marginwidth="0" marginheight="0">
		<TABLE cellSpacing=0 cellPadding=0 width="100%" align=left border=0>
			<TBODY>
				<TR>
					<TD vAlign=top bgColor=#799ae1>
						<TABLE cellSpacing=0 cellPadding=0 width=158 align=center>
							<TBODY>
								<TR>
									<TD vAlign=bottom height=42>
										<IMG height=38 src="<%=basePath%>images/title.jpg" width=158>
									</TD>
								</TR>
							</TBODY>
						</TABLE>
						<TABLE cellSpacing=0 cellPadding=0 width=158 align=center>
							<TBODY>
								<TR>
									<TD class=menu_title
										onMouseOver="this.className='menu_title2';"
										onmouseout="this.className='menu_title';" height=25>
										<SPAN><a href="<%=basePath%>logout.jsp"
											target="_parent"><B>退出</B> </a> </SPAN>
									</TD>
								</TR>
								<TR>
									<c:set var="admin" value="${sessionScope.admin}" />
									<TD class=menu_title
										onMouseOver="this.className='menu_title2';"
										onmouseout="this.className='menu_title';" height=25>
										&nbsp;管理员：${admin.name }
									</TD>
								</TR>
							</TBODY>
						</TABLE>
						<TABLE cellSpacing=0 cellPadding=0 width=158 align=center>
							<TBODY>
								<TR>
									<TD class=menu_title id=menuTitle1
										onmouseover="this.className='menu_title2';"
										onclick=showsubmenu(0)
										onmouseout="this.className='menu_title';">
										<span><B>管理员信息管理</B> </span>
									</TD>
								</TR>
								<TR>
									<TD id=submenu0>
										<DIV class=sec_menu style="WIDTH: 158px;margin-top: 5px">
											<TABLE cellSpacing=0 cellPadding=0 width=135 align=center>
												<TBODY>
													<TR>
														<TD height=20>
															<a href="<%=basePath%>adminAction" target="mainFrame">管理员信息</a>
														</TD>
													</TR>
												</TBODY>
											</TABLE>
										</DIV>
										<DIV style="WIDTH: 158px">
											<TABLE cellSpacing=0 cellPadding=0 width=135 align=center>
												<TBODY>
													<TR>
														<TD height=20></TD>
													</TR>
												</TBODY>
											</TABLE>
										</DIV>
									</TD>
								</TR>
							</TBODY>
						</TABLE>

						<TABLE cellSpacing=0 cellPadding=0 width=158 align=center style="margin-top: 5px;">
							<TBODY>
								<TR>
									<TD class=menu_title id=menuTitle1
										onmouseover="this.className='menu_title2';"
										onclick=showsubmenu(2)
										onmouseout="this.className='menu_title';">
										<SPAN>学生管理</SPAN>
									</TD>
								</TR>
								<TR>
									<TD id=submenu2>
										<DIV class=sec_menu style="WIDTH: 158px;margin-top: 5px;">
											<TABLE cellSpacing=0 cellPadding=0 width=135 align=center>
												<TBODY>

													<TR>
														<TD height=20>
															<a href="<%=basePath%>Student/listStudent" target="mainFrame">学生列表</a>
														</TD>
													</TR>
													<TR>
														<TD height=20>
															<a href="<%=basePath%>behind/addStudent.jsp" target="mainFrame">添加学生</a>
														</TD>
													</TR>
												</TBODY>
											</TABLE>
										</DIV>
										<DIV style="WIDTH: 158px">
											<TABLE cellSpacing=0 cellPadding=0 width=135 align=center>
												<TBODY>
													<TR>
														<TD height=20></TD>
													</TR>
												</TBODY>
											</TABLE>
										</DIV>
									</TD>
								</TR>
							</TBODY>
						</TABLE>


						<TABLE cellSpacing=0 cellPadding=0 width=158 align=center style="margin-top: 5px;">
							<TBODY>
								<TR>
									<TD class=menu_title id=menuTitle1
										onmouseover="this.className='menu_title2';"
										onclick=showsubmenu(1)
										onmouseout="this.className='menu_title';">
										<SPAN>教师管理</SPAN>
									</TD>
								</TR>
								<TR>
									<TD id=submenu1>
										<DIV class=sec_menu style="WIDTH: 158px;margin-top: 5px">
											<TABLE cellSpacing=0 cellPadding=0 width=135 align=center>
												<TBODY>
													<TR>
														<TD height=20>
															<a href="<%=basePath%>Teacher/listTeacher" target="mainFrame">教师列表</a>
														</TD>
													</TR>
													<TR>
														<TD height=20>
															<a href="<%=basePath%>behind/addTeacher.jsp" target="mainFrame">添加教师</a>
														</TD>
													</TR>
												</TBODY>
											</TABLE>
										</DIV>
										<DIV style="WIDTH: 158px">
											<TABLE cellSpacing=0 cellPadding=0 width=135 align=center>
												<TBODY>
													<TR>
														<TD height=20></TD>
													</TR>
												</TBODY>
											</TABLE>
										</DIV>
									</TD>
								</TR>
							</TBODY>
						</TABLE>
				</TR>
			</TBODY>
		</TABLE>
	</BODY>
</html>
