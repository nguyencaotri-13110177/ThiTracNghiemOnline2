package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.DAO;

@WebServlet("/Addgiaobai")
public class Addgiaobai extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Addgiaobai() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int idde=Integer.parseInt(request.getParameter("idde"));
		int idlop=Integer.parseInt(request.getParameter("idlop"));
		String thoigianhethan = request.getParameter("thoigianhethan");
		
		PrintWriter out=response.getWriter();
		
		response.setContentType("text/html;charset=UTF-8");
		
			try
			{
				int i = DAO.Addgiaobai(idde, idlop, thoigianhethan);
				if(i>0)
				{
					out.println("Giao bai thanh cong");
				}
				else
					out.println("Giao bai khong thanh cong");
			}
			catch(Exception e)
			{
				out.println(e);       
			}
	}

}
