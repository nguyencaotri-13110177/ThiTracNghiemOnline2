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
 * Servlet implementation class DeleteGiaoBai
 */
@WebServlet("/DeleteGiaoBai")
public class DeleteGiaoBai extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteGiaoBai() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String idde = request.getParameter("idde");
		String idlop = request.getParameter("idlop");
		String thoigian = request.getParameter("thoigian");

		PrintWriter out=response.getWriter();

		try
		{
			int i = DAO.DeleteGaioBai(idde, idlop, thoigian);
			if(i>0)
				out.println("Xoa giao bai thanh cong");
			else
				out.println("Xoa giao bai khong thanh cong");
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
