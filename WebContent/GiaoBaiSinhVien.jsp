<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="com.dao.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Giao bai sv</title>
<link rel="stylesheet" type="text/css" href="NewFile.css" />
<style>
.ThongTin {
	border: 1px solid;
	padding: 5px;
	margin: 5px 10px 5px 10px;
	font-family: Times New Roman;
	text-align: left;
}

table, th, td {
	border: 1px solid black;
	border-collapse: collapse;
}

th, td {
	padding: 5px;
}
</style>
</head>
<body>
	<%@ include file="/ThietKe/header.jsp"%>
	<%@ include file="/ThietKe/MenuTop.jsp"%>
	<div id=wraper>
		<%@ include file="/ThietKe/menuleft.jsp" %>
		<div id=main>
			<div id="main">
				<div class="ThongTin">
					<TABLE style="width: 100%">
						<TR>
							<th>Mã đề</th>
							<th>Lớp nhận</th>
							<th>Thời gian hết hạn</th>
							<th>Tác vụ</th>
						</TR>
						<%
							ResultSet resultset = DAO.giaobaivoilop();
							while (resultset.next()) {
						%>
						<TR>
							<TD><%=resultset.getString(1)%></TD>
							<TD><%=resultset.getString(5)%></TD>
							<TD><%=resultset.getString(3)%></TD>
							<td><a href="DeleteGiaoBai?idde=<%=resultset.getString(1) %>&idlop=<%=resultset.getString(2) %>&thoigian=<%=resultset.getString(3) %>"> Delete </a>
						</TR>

						<%
							}
						%>
					</TABLE>

					<br>
					<h3>Giao bài:</h3>
					<form action="Addgiaobai" method="post">
						<table style="width: 100%">
							<tr>
								<th>Chọn mã đề</th>
								<th>Chọn lớp</th>
								<th>Thời gian hết hạn</th>
							</tr>
							<tr>
								<th><select name="idde">
								<%
								ResultSet bangde = DAO.bangde();
								while (bangde.next()) {
								%>
										<option value=<%=bangde.getString(1)%>><%=bangde.getString(1)%></option>
								<%
								}
								%>
								</select></th>
								<th><select name="idlop">
								<%
								ResultSet banglop = DAO.banglop();
								while (banglop.next()) {
								%>
										<option value=<%=banglop.getString(1)%>><%=banglop.getString(2)%></option>
								<%
								}
								%>
								</select></th>
								<th><input type="text" name="thoigianhethan"></th>
							</tr>
						</table>
						<input type="submit" value="Giao bài">
					</form>
					<br>
				</div>

			</div>
		</div>
	</div>
	<%@ include file="/ThietKe/footer.jsp"%>
</body>
</html>