<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="com.dao.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
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
		<%@ include file="/ThietKe/menuleft.jsp" %>
		<div id=main style="text-align:left;" >
			<div class="ThongTin">
			Tạo đề:
				<form action="AddDe" method="post">
					<input type="text" name="tende" value="Tên đề">
					<input type="text" name="ngaytao" value="Ngày tạo">
					<input type="submit" value="Tạo đề">
			</form>
			</div>
			<div class="ThongTin">
				<TABLE style="width:100%" >
             	<TR>
                    <th>Mã đề</th>		
    				<th>Tên đề</th>
    				<th>Ngày tạo</th>
    				<th>Tác vụ</th>
                </TR>
            	<%  
            //ResultSet resultset = statement.executeQuery("select * from de");
            ResultSet resultset=DAO.bangde();

            while(resultset.next()){ 
        %>
                <TR>
                    <TD> <%= resultset.getString(1) %> </TD>
                    <TD> <%= resultset.getString(2) %> </TD>
                    <TD> <%= resultset.getString(3) %> </TD>
                    <td><a href=ThemCau.jsp?id=<%=resultset.getString(1) %>> Thêm câu </a>;<a href=XoaDe?id=<%=resultset.getString(1) %>> Xóa đề </a></td>
                </TR>
           
        <% 
            } 
        %>
         </TABLE>
			</div>
		</div>
	
	</div>
	<%@ include file="/ThietKe/footer.jsp" %>
</body>
</html>