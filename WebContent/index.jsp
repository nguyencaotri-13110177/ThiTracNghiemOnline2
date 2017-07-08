<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Dang nhap</title>
<link rel="stylesheet" type="text/css" href="NewFile.css" />
</head>
<body>
	<div id="top">
		<IMG src="onlinetest.jpg" align="left" width="900" height="150" />
	</div>
	<div id="menu"></div>
	<div id="wraper">
		<div id="main" style="width: 900px;">
			<div class="ThongTin">
				<h3>ĐĂNG NHẬP HỆ THỐNG THI ONLINE TRỰC TUYẾN</h3>
				<form action="LoginFormServerlet" method="post">
					Chọn loại tài khoản: <input type="radio" name="actor"
						value="aStudent">Student <input type="radio" name="actor"
						value="aTeacher">Teacher <input type="radio" name="actor"
						value="aAdmin">Admin <br> User name:<br> <input
						type="text" name="username"> <br> password:<br>
					<input type="password" name="pass"> <br> <input
						type="submit" value="Đăng nhập"> <input type="reset"
						value="Reset form">
				</form>
			</div>
		</div>

	</div>
	<div id="bottom">thong tin nhom</div>
</body>
</html>