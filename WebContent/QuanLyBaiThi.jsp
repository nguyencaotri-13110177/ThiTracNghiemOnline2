<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.sql.*" %>
    <%@ page import="com.dao.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Quan ly bai thi</title>
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
		<%@ include file="/ThietKe/menuleftSinhVien.jsp" %>
		<div id=main>
			<div class="ThongTin">
            	
            	<TABLE style="width:100%">
             	<TR>
                    <th>Mã Đề</th>		
    				<th>Điểm</th>
    				<th>Tác vụ</th>
                </TR>
            	<%  
            String namesv=(String)session.getAttribute("namesv");
            int idsinhvien=DAO.layidsv(namesv);
            ResultSet resultset = DAO.ketquatheohocsinh(idsinhvien);
            while(resultset.next()){ 
        %>
                <TR>
                    <TD> <%= resultset.getString(2) %> </TD>
                    <TD> <%= resultset.getString(3) %> </TD>
                    <td><a href=Xemlaibaithi.jsp?id=<%=resultset.getString(2) %>> xem lại </a></td>
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