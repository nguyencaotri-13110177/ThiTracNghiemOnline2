package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.*;

/**
 * Servlet implementation class ThemCau
 */
@WebServlet("/ThemCau")
public class ThemCau extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ThemCau() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
				String idde1=request.getParameter("idde");
				int idde = Integer.parseInt(idde1);
				
				String c1=request.getParameter("C1");
				String c1a=request.getParameter("C1a");
				String c1b=request.getParameter("C1b");
				String c1c=request.getParameter("C1c");
				String c1d=request.getParameter("C1d");
				String dapan = request.getParameter("dapan");
				
				int A1=1;
				int B1=2;
				int C1=3;
				int D1=4;
				
				if("A".equals(dapan))
					A1=0;
				else if("B".equals(dapan))
					B1=0;
				else if("C".equals(dapan))
					C1=0;
				else
					D1=0;
				
				
				
				PrintWriter out=response.getWriter();
				request.setCharacterEncoding("UTF-8");
				

				
					try
					{
						
						int i = DAO.ThemCau(idde, c1, c1a, c1b, c1c, c1d, A1, B1, C1, D1);
						if(i>0)
						{
							out.println("Them thanh cong");
							
							out.print("<a href=ThemCau.jsp?id='"+idde+"'>Them tiep</a>");
							out.print("     ");
							out.print("<a href=QuanLyDe.jsp>Xong</a>");
						}
						else
						{
							out.println("Them khong thanh cong");
						
						}
					}
					catch(Exception e)
					{
						out.println(e);       
					}
	}

}
