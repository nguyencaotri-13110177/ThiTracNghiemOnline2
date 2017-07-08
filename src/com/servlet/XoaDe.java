package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.*;

/**
 * Servlet implementation class XoaDe
 */
@WebServlet("/XoaDe")
public class XoaDe extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public XoaDe() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String value = request.getParameter("id");
		
		PrintWriter out=response.getWriter();
		
			try
			{
				
				//Xoa tat ca cac cau cua de
				ResultSet resultset = DAO.bangcau(value);
				int t=0;
				while(resultset.next())
				{
					t++;
				}
				for(int i=1;i<=t;i++)
					DAO.XoaCau(value);
				//Xoa de
				int i = DAO.XoaDe(value);
				
				if(i>0)
				{
					out.println("Xoa thanh cong");
				}
				else
					out.println("Xoa khong thanh cong");
				

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
