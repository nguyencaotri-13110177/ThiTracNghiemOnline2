package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.DAO;

/**
 * Servlet implementation class SuaPassGiangVien
 */
@WebServlet("/SuaPassGiangVien")
public class SuaPassGiangVien extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SuaPassGiangVien() {
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
		
		HttpSession session=request.getSession();
		String name=(String)session.getAttribute("namegv");
		int idgiangvien=DAO.layidgv(name);
		String pass=request.getParameter("pass");
		
		PrintWriter out=response.getWriter();
		response.setContentType("text/html;charset=UTF-8");
		
			try
			{
				int i = DAO.SuaPassGiangVien(pass, idgiangvien);
				if(i>0)
				{
					out.println("Sua pass thanh cong");
				}
				else
					out.println("Sua pass khong thanh cong");
			}
			catch(Exception e)
			{
				out.println(e);       
			}
			
	}

}
