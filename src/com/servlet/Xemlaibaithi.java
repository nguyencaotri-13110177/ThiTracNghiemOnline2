package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.*;

/**
 * Servlet implementation class Xemlaibaithi
 */
@WebServlet("/Xemlaibaithi")
public class Xemlaibaithi extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Xemlaibaithi() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		//Lay idsinhvien
				HttpSession session=request.getSession();  
				String name=(String)session.getAttribute("namesv");
				int idsv=DAO.layidsv(name);
				//MaDe
				int idde=Integer.parseInt(request.getParameter("id"));
				//Danh sach id cau
				
				
				
				
				PrintWriter out=response.getWriter();
				
				try
				{
					Class.forName("com.mysql.jdbc.Driver");
					
					ResultSet bangbailam = DAO.bangbailam(idsv, idde);
					//Dem so cau
					int socau=0;
					while(bangbailam.next())socau++;
					bangbailam.beforeFirst();
					//Danh sach ma cau
					int[] dsidCau=new int[socau];
					int i=0;
					while(bangbailam.next()){
						dsidCau[i] = Integer.parseInt(bangbailam.getString(3));
						i++;
						
					}
					//Danh sach dap an
					bangbailam.beforeFirst();
					int[] dsDapAnChon=new int[socau];
					int j=0;
					while(bangbailam.next()){
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
					
					
					for(int m=0;m<socau;m++)
					{
						out.println(dsDapAnChonKyTu[m]); 
						out.println(dsDapAnDung[m]); 
					}
 
				}
				catch(Exception e)
				{
					out.println(e);       
				}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
