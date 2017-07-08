<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="com.dao.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
            	<form action="SuaSinhVien" method="post">
            	ID sinh viên: <label><%=request.getParameter("id") %></label><input type="hidden" name="idsinhvien" value=<%=request.getParameter("id") %>>
				<input type="text" name="user" placeholder="user mới"> <input type="text" name="pass" placeholder="password mới"> <select name="idlop">
								<%
								ResultSet banglop2 = DAO.banglop();
								while (banglop2.next()) {
								%>
										<option value=<%=banglop2.getString(1)%>><%=banglop2.getString(2)%></option>
								<%
								}
								%>
								</select> <input type="submit" value="Lưu">
				</form>
     </div>	
</body>
</html>