<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="javax.servlet.*"%>
<%@ page import="com.dao.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

</head>
<body>
	<%@ include file="/ThietKe/header.jsp"%>
	<%@ include file="/ThietKe/MenuTop.jsp"%>
	<div id=wraper>
		<%@ include file="/ThietKe/menuleftSinhVien.jsp"%>
		<div id=main style="text-align: left;">


			<form action="Chamdiem" method="post" class="ThongTin">
				<br> Mã đề: <label name="idde"><%=request.getParameter("id")%></label><br>
				<input type="hidden" name="made"
					value=<%=request.getParameter("id")%>>
				<%
					//Lay idsinhvien
					
					String name = (String) session.getAttribute("namesv");
					int idsv = DAO.layidsv(name);
					//MaDe
					int idde = Integer.parseInt(request.getParameter("id"));
					//Danh sach id cau

					Connection con = null;
					Statement stmt = null;

					try {
						ResultSet bangbailam = DAO.bangbailamtheosinhvien(idsv, idde);
						//Dem so cau
						int socau = 0;
						while (bangbailam.next())
							socau++;
						bangbailam.beforeFirst();
						//Danh sach ma cau
						int[] dsidCau = new int[socau];
						int i = 0;
						while (bangbailam.next()) {
							dsidCau[i] = Integer.parseInt(bangbailam.getString(3));
							i++;

						}
						//Danh sach dap an
						bangbailam.beforeFirst();
						int[] dsDapAnChon = new int[socau];
						int j = 0;
						while (bangbailam.next()) {
							dsDapAnChon[j] = Integer.parseInt(bangbailam.getString(4));
							j++;
						}
						//Chuyen sang kytu
						String[] dsDapAnChonKyTu=new String[socau];
						for(int p=0;p<socau;p++)
						{
							if(dsDapAnChon[p]==1)
								dsDapAnChonKyTu[p]="chon A";
							if(dsDapAnChon[p]==2)
								dsDapAnChonKyTu[p]="chon B";
							if(dsDapAnChon[p]==3)
								dsDapAnChonKyTu[p]="chon C";
							if(dsDapAnChon[p]==4)
								dsDapAnChonKyTu[p]="chon D";
							if(dsDapAnChon[p]==5)
								dsDapAnChonKyTu[p]="chua chon";
						}
						//Danh sach dap an dung
						String[] dsDapAnDung=new String[socau];
						ResultSet dapandung;
						for(int p=0;p<socau;p++)
						{
							dapandung = DAO.dapandung(dsidCau[p]);
							while(dapandung.next()){
								if(Integer.parseInt(dapandung.getString(8))==0)
									dsDapAnDung[p]="A";
								else if(Integer.parseInt(dapandung.getString(9))==0)
									dsDapAnDung[p]="B";
								else if(Integer.parseInt(dapandung.getString(10))==0)
									dsDapAnDung[p]="C";
								else if(Integer.parseInt(dapandung.getString(11))==0)
									dsDapAnDung[p]="D";
							}
						}
						//Danh sach noi dung cau
						String[] dsnoidungcau = new String[socau];
						ResultSet noidungcauid;
						for (int k = 0; k < socau; k++) {
							noidungcauid = DAO.dapandung(dsidCau[k]);

							while (noidungcauid.next()) {
				%>
				<div>
        			<%= noidungcauid.getString(3) %>
        		</div>
				<div>
					<%=noidungcauid.getString(4)%>
				</div>
				<div>
					<%=noidungcauid.getString(5)%>
				</div>
				<div>
					<%=noidungcauid.getString(6)%>
				</div>
				<div>
					<%=noidungcauid.getString(7)%>
				</div>
				<div>
					Bạn <%=dsDapAnChonKyTu[k]%> - Đáp án đúng là: <%=dsDapAnDung[k]%>
				</div>
				<%
					}
				%>	
						<%}
						
					} catch (Exception e) {
						out.println(e);
					}
				%>
			</form>
		</div>
	</div>

</body>
</html>