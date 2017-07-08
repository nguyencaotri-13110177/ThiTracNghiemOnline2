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
 * Servlet implementation class AddDe
 */
@WebServlet("/AddDe")
public class AddDe extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public AddDe() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String tende=request.getParameter("tende");
		String ngaytao=request.getParameter("ngaytao");
		
		PrintWriter out=response.getWriter();
		
		response.setContentType("text/html;charset=UTF-8");
		
			try
			{
				int i = DAO.AddDe(tende, ngaytao);
				if(i>0)
				{
					
					//RequestDispatcher rd=request.getRequestDispatcher("themde2.jsp");
					//rd.forward(request, response);
					out.println("Them de thanh cong");
				}
				else
					out.println("Insert Unsuccessful");
			}
			catch(Exception e)
			{
				out.println(e);       
			}
	}

}
