<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="javax.servlet.http.HttpSession" %>
<%@ page import="javax.servlet.*" %>
<%@ page import="java.sql.*" %>
<%@ page import="com.dao.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>My acount sinh vien</title>
</head>
<body>
	<%@ include file="/ThietKe/header.jsp" %>
	<%@ include file="/ThietKe/MenuTop.jsp" %>
	<div id=wraper>
		<%@ include file="/ThietKe/menuleftSinhVien.jsp" %>
		<div id=main>
		
		<%  
        	String name=(String)session.getAttribute("namesv");
            ResultSet sinhvientheoten = DAO.sinhviennoiloptheoten(name);
            while(sinhvientheoten.next()){ 
        %>
			<div class="ThongTin">
            	<h4>Thông tin người dùng:</h4>
 				<ul>
  					<li>User:<%=name%></li>
  					<li>Pass:<%= sinhvientheoten.getString(3)%></li>
  					<li>Lớp:<%= sinhvientheoten.getString(6)%></li>
				</ul>
            </div>
        <% 
            } 
        %>
            <div class="ThongTin">
            	<form action="SuaPassSinhVien" method="post">
				Đổi password: <input type="text" name="pass" placeholder="password mới">  <input type="submit" value="Lưu">
				</form>
            </div>	
		</div>
	</div>
	<%@ include file="/ThietKe/footer.jsp" %>
</body>
</html>