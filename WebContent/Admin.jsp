<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Admin</title>
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
		<%@ include file="/ThietKe/menuleftAdmin.jsp"%>
		<div id=main>
			<div id="main">
			

			</div>
		</div>
	</div>
	<%@ include file="/ThietKe/footer.jsp"%>
</body>
</html>