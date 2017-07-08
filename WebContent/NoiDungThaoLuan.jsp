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
			Chủ đề: <label><%=request.getParameter("id") %></label>
            	<TABLE style="width:100%">
             	<TR>
                    <th>Nội dung thảo luận</th>
                </TR>
            	<%  
            String idchude = request.getParameter("id");
            ResultSet resultset = DAO.laynoidungtheoidchude(idchude);
            while(resultset.next()){ 
        %>
                <TR>
                    <TD> <%= resultset.getString(3) %> </TD>
                </TR>
           
        <% 
            } 
        %>
         </TABLE>
         <br>
         <div>
            	<form action="ThemNoiDungVaoThaoLuan" method="post">
            		<input type="hidden" name="idchude" value=<%=request.getParameter("id") %>>
            		<textarea rows="4" cols="50"  name="noidungthaoluan" placeholder="noi dung"></textarea><br>
					<input type="submit" value="Add thảo luận">
				</form>
          </div>
            	
            </div>
		</div>
	</div>
	<%@ include file="/ThietKe/footer.jsp" %>
</body>
</html>