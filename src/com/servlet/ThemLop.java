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
 * Servlet implementation class ThemLop
 */
@WebServlet("/ThemLop")
public class ThemLop extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ThemLop() {
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
		
		String tenlop=request.getParameter("tenlop");
		
		PrintWriter out=response.getWriter();
		
			try
			{
				int i = DAO.ThemLop(tenlop);
				if(i>0)
					out.println("Them lop thanh cong");
				else
					out.println("Them lop khong thanh cong");
			}
			catch(Exception e)
			{
				out.println(e);       
			}
	}

}
