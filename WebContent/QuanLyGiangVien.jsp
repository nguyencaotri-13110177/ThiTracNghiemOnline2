<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="com.dao.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Quan ly giang vien</title>
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
             	<TABLE style="width:100%">
             	<TR>
                    <th>user ID</th>		
    				<th>User name</th>
    				<th>password</th>
    			
    				<th>Tác vụ</th>
                </TR>
            	<%  
            ResultSet resultset = DAO.tatcagiangvien();
            while(resultset.next()){ 
        %>
                <TR>
                    <TD> <%= resultset.getString(1) %> </TD>
                    <TD> <%= resultset.getString(2) %> </TD>
                    <TD> <%= resultset.getString(3) %> </TD>
                    
                    <td><a href=DeleteUser?id=<%=resultset.getString(1) %>> Delete </a>;<a href=SuaThongInNguoiDung.jsp?id=<%=resultset.getString(1) %> target="_blank"> Sửa </a></td>
                </TR>
           
        <% 
            } 
        %>
         </TABLE>
  
  <br>
  <h3>Thêm từng người:</h3>
  <form action="ThemGiangVien" method="post">
  <table style="width:100%">
  <tr>
    		
    <th>User</th>
    <th>password</th>
    
  
  </tr>
  <tr>
    		
    <th>
    <input type="text" name="user">
    </th>
    <th>
    <input type="text" name="pass">
    </th>
    
 
  </tr>
  
  </table>
  <input type="submit" value="Thêm">

  </form>
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