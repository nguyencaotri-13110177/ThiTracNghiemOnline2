<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.sql.*" %>
    <%@ page import="javax.servlet.*" %>
     <%@ page import="com.dao.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lam bai</title>
<script type="text/JavaScript">
            function setTimeForSubmit() {
                window.setTimeout("submitForm()", 3000);//Expire after 3 s
            }
            function submitForm() {
            	document.getElementById("fom1").submit();
            }
            var mins = 0; // write mins to javascript  
            var secs = 15; // write secs to javascript  
            function timer()
            {
                // tic tac
                --secs;
                if (secs == -1)
                {
                    secs = 59;
                    --mins;
                }

                // leading zero? formatting  
                if (secs < 10)
                    secs = "0" + secs;
                if (mins < 10)
                    mins = "0" + parseInt(mins, 10);

                // display  
                document.fom.mins.value = mins;
                document.fom.secs.value = secs;

                // continue?  
                if (secs == 0 && mins == 0) // time over  
                {
                	//submitForm();
                    //document.getElementById("fom1").disabled = true;
                    fom.myButton.disabled = true;
                    //document.getElementById("fom1").submit();
                    ThongBao();
                    //setTimeForSubmit();
                    submitForm();
                }
                else // call timer() recursively every 1000 ms == 1 sec  
                {
                    window.setTimeout("timer()", 1000);
                }
            }
            /*window.history.forward();
            function noBack() {
                window.history.forward();
            }*/
</script> 
<script>
function ThongBao() {
    alert("Đã hết giờ làm bài. Click OK để gửi!");
}
</script>
</head>
<body >
	<%@ include file="/ThietKe/header.jsp" %>
	<%@ include file="/ThietKe/MenuTop.jsp" %>
	<div id=wraper>
		<%@ include file="/ThietKe/menuleftSinhVien.jsp" %>
		<div id=main style="text-align:left;" >
		
			<form action="Chamdiem" method="post" class="ThongTin" id="fom1" name="fom">
			<span>Thời gian còn lại </span><span class="testTitle">: </span>
			<input type="text" name="mins" size="1" disabled style="border:solid red">
			<span>:</span>
			<input type="text" name="secs" size="1" disabled style="border:solid red">  
			<script> timer();</script>
			<br>
		Mã đề: <label><%=request.getParameter("id") %></label><br> <input type="hidden" name="made" value=<%=request.getParameter("id") %>>
		<%  
            String idde = request.getParameter("id");
            ResultSet bangdanhsachcautheode = DAO.bangcautheode(idde);
            int t=0;
            while(bangdanhsachcautheode.next())t++;
         %>
         	Bài thi có: <label><%=t%> câu</label><br> <input type="hidden" name="socau" value=<%=t%>>
             
        <% 
        	ResultSet bangdanhsachcautheode2 = DAO.bangcautheode(idde);
            int i=0;
            while(bangdanhsachcautheode2.next()){i++;
        %>
        	<div>
        		<%= bangdanhsachcautheode2.getString(3) %><input type="hidden" name="idcau_<%=i %>" value=<%= bangdanhsachcautheode2.getString(1) %>>
        	</div>
        	<div>
				<input type="radio" name=<%=i %> value=<%= bangdanhsachcautheode2.getString(8) %>><%= bangdanhsachcautheode2.getString(4) %>
			</div>
            <div>
				<input type="radio" name=<%=i %> value=<%= bangdanhsachcautheode2.getString(9) %>><%= bangdanhsachcautheode2.getString(5) %>
			</div>
			<div>
				<input type="radio" name=<%=i %> value=<%= bangdanhsachcautheode2.getString(10) %>><%= bangdanhsachcautheode2.getString(6) %>
			</div>
			<div>
				<input type="radio" name=<%=i %> value=<%= bangdanhsachcautheode2.getString(11) %>><%= bangdanhsachcautheode2.getString(7) %>
			</div>
			<div>
			</div>
			<br><br>
        <% 
            }
        %>
			<input type="submit" value="Nop bai" name="myButton">
			</form>
		</div>
	</div>

</body>
</html>