<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="NewFile.css" />
</head>
<body>
	<%@ include file="/ThietKe/header.jsp" %>
	<%@ include file="/ThietKe/MenuTop.jsp" %>
	<div id=wraper>
		<%@ include file="/ThietKe/menuleft.jsp" %>
		<div id=main style="text-align:left;">
			<div>
				<form action="ThemCau" method="post">
		Mã đề: <input type="text" name="idde" value=<%=request.getParameter("id") %> style="width:20px">
			
			
			
			<input type="text" name="C1" value="Cau:" style="width:750px"><br>
			<input type="radio" name="dapan" value="A"><input type="text" name="C1a" value="A:" style="width:700px"><br>
			<input type="radio" name="dapan" value="B"><input type="text" name="C1b" value="B:" style="width:700px"><br>
			<input type="radio" name="dapan" value="C"><input type="text" name="C1c" value="C:" style="width:700px"><br>
			<input type="radio" name="dapan" value="D"><input type="text" name="C1d" value="D:" style="width:700px"><br>
			<br>
			
			
			<input type="submit" value="Thêm">
			</form>
			
			</div>
		</div>
	
	</div>
	<%@ include file="/ThietKe/footer.jsp" %>
</body>
</html>