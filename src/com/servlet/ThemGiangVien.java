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
 * Servlet implementation class ThemGiangVien
 */
@WebServlet("/ThemGiangVien")
public class ThemGiangVien extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ThemGiangVien() {
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
		
		String user=request.getParameter("user");
		String pass=request.getParameter("pass");
		
		PrintWriter out=response.getWriter();
		
			try
			{
				int i = DAO.ThemGiangVien(user, pass);
				if(i>0)
					out.println("Them giang vien thanh cong");
				else
					out.println("Them giang vien khong thanh cong");
			}
			catch(Exception e)
			{
				out.println(e);       
			}
	}

}
