<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="java.sql.*" %>
 <%@ page import="com.dao.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Vao thi</title>
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
<link rel="stylesheet" type="text/css" href="NewFile.css" />
</head>
<body>
	<%@ include file="/ThietKe/header.jsp" %>
	<%@ include file="/ThietKe/MenuTop.jsp" %>
	<div id=wraper>
		<%@ include file="/ThietKe/menuleftSinhVien.jsp" %>
		<div id=main style="text-align:left;" >
			<div class="ThongTin">
				<TABLE style="width:100%" >
             	<TR>
                    <th>Mã đề</th>		
    				<th>Tên đề</th>
    				<th>Ngày hết hạn</th>
    				<th>Tác vụ</th>
                </TR>
            	<%  
            String name=(String)session.getAttribute("namesv");
    		int idlop=DAO.layidlop(name);
            ResultSet resultset = DAO.giaobaitheolop(idlop);
            while(resultset.next()){ 
        %>
                <TR>
                    <TD> <%= resultset.getString(1) %> </TD>
                    <TD> <%= resultset.getString(5) %> </TD>
                    <TD> <%= resultset.getString(3) %> </TD>
                    <td><a href=Lambai.jsp?id=<%=resultset.getString(1) %>> Làm bài </a></td>
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