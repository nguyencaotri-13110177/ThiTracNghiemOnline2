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
 * Servlet implementation class SuaSinhVien
 */
@WebServlet("/SuaSinhVien")
public class SuaSinhVien extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SuaSinhVien() {
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
		
		String idsinhvien=request.getParameter("idsinhvien");
		String user=request.getParameter("user");
		String pass=request.getParameter("pass");
		String idlop=request.getParameter("idlop");
		
		PrintWriter out=response.getWriter();
		response.setContentType("text/html;charset=UTF-8");
		
			try
			{
				int i = DAO.SuaSinhVien(user, pass, idlop, idsinhvien);
				if(i>0)
				{
					out.println("Sua sinh vien thanh cong");
				}
				else
					out.println("Sua sinh vien khong thanh cong");
			}
			catch(Exception e)
			{
				out.println(e);       
			}
	}

}
