<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="com.dao.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Quan ly sinh vien</title>
<link rel="stylesheet" type="text/css" href="NewFile.css" />
<style>
.ThongTin{
	border:1px solid;
	 padding:5px;
	 margin:5px 10px 5px 10px;
	 font-family:Times New Roman;
	 text-align:left;
	 
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
	<%@ include file="/ThietKe/header.jsp" %>
	<%@ include file="/ThietKe/MenuTop.jsp" %>
	<div id=wraper>
		<%@ include file="/ThietKe/menuleftAdmin.jsp" %>
		<div id=main>
			<div id="main">	
             	<div class="ThongTin">
             	Danh sách lớp:
             	<TABLE style="width:100%">
             	<TR>
                    <th>ID lớp</th>		
    				<th>Tên lớp</th>
    				<th>Tác vụ</th>
                </TR>
            	<%  
            ResultSet banglop = DAO.banglop();
            while(banglop.next()){ 
        %>
                <TR>
                    <TD> <%= banglop.getString(1) %> </TD>
                    <TD> <%= banglop.getString(2) %> </TD>
                    <td><a href=Xoalop?id=<%=banglop.getString(1) %>> Delete </a></td>
                </TR> 
        <% 
            } 
        %>
         </TABLE>
         <br>
         <div>
            	<form action="ThemLop" method="post">
				Thêm lớp: <input type="text" name="tenlop" placeholder="Tên lớp mới"> <input type="submit" value="Thêm lớp">
				</form>
         </div>	
             	<br>
             	Danh sách sinh viên:
             	<TABLE style="width:100%">
             	<TR>
                    <th>user ID</th>		
    				<th>User name</th>
    				<th>password</th>
    				<th>Lớp</th>
    				<th>Tác vụ</th>
                </TR>
            	<%  
            ResultSet resultset = DAO.sinhvientheolop();
            while(resultset.next()){ 
        %>
                <TR>
                    <TD> <%= resultset.getString(1) %> </TD>
                    <TD> <%= resultset.getString(2) %> </TD>
                    <TD> <%= resultset.getString(3) %> </TD>
                    <TD> <%= resultset.getString(6) %> </TD>
                    <td><a href=XoaSinhVien?id=<%=resultset.getString(1) %>> Delete </a>;<a href=SuaThongTinSinhVien.jsp?id=<%=resultset.getString(1) %> target="_blank"> Sửa </a></td>
                </TR> 
        <% 
            } 
        %>
         </TABLE>
  <br>
  		<div>
            	<form action="ThemSinhVien" method="post">
				Thêm sinh viên: <input type="text" name="user" placeholder="user name"> <input type="text" name="pass" placeholder="password"> <select name="idlop">
								<%
								ResultSet banglop2 = DAO.banglop();
								while (banglop2.next()) {
								%>
										<option value=<%=banglop2.getString(1)%>><%=banglop2.getString(2)%></option>
								<%
								}
								%>
								</select> <input type="submit" value="Thêm sinh viên">
				</form>
         </div>	
  <br>
  <h3>Thêm danh sách:</h3>
  <table style="width:100%">
  <tr>
    <th>Kéo thả danh sách vào đây</th>		
  </tr>
  </table>
  <input type="submit" value="Thêm">
            </div>
        
        </div>
		</div>
	</div>
	<%@ include file="/ThietKe/footer.jsp" %>
</body>
</html>