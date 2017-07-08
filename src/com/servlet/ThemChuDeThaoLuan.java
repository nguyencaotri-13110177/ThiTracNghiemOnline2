package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.DAO;

/**
 * Servlet implementation class ThemChuDeThaoLuan
 */
@WebServlet("/ThemChuDeThaoLuan")
public class ThemChuDeThaoLuan extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ThemChuDeThaoLuan() {
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
		
		String tenchude=request.getParameter("tenchude");
		
		PrintWriter out=response.getWriter();
		
		response.setContentType("text/html;charset=UTF-8");
		
			try
			{
				int i = DAO.ThemChuDeThaoLuan(tenchude);
				if(i>0)
				{
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
