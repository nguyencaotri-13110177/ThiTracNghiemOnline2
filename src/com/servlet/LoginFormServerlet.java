package com.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.*;
/**
 * Servlet implementation class LoginFormServerlet
 */
@WebServlet("/LoginFormServerlet")
public class LoginFormServerlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginFormServerlet() {
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
		
		String user=request.getParameter("username");/*ten cua the input trong html*/
		String pass=request.getParameter("pass");
		
		String actor = request.getParameter("actor");
		
		response.setContentType("text/html;charset=UTF-8");
		
		//PrintWriter out = response.getWriter();
		if("aStudent".equals(actor))
		{
			if(DAO.ktsinhvien(user, pass))
			{
				RequestDispatcher rd=request.getRequestDispatcher("SinhVien.jsp");
				HttpSession session =request.getSession();
				session.setAttribute("namesv", user);
				rd.forward(request, response);
				
			}else
			{
				
				/*out.print("Sorry username or password error!");*/
				RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
				//rd.include(request, response);
				rd.forward(request, response);
			}
		}else if("aTeacher".equals(actor))
		{
			if(DAO.ktgiangvien(user, pass))
			{
				//ResultSet id = statement.executeQuery("select idsinhvien from sinhvien where user="+user);
				RequestDispatcher rd=request.getRequestDispatcher("GiangVien.jsp");
				HttpSession session =request.getSession();
				session.setAttribute("namegv", user);
				rd.forward(request, response);
				
			}else
			{
				
				/*out.print("Sorry username or password error!");*/
				RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
				//rd.include(request, response);
				rd.forward(request, response);
			}
		}else if("aAdmin".equals(actor))
		{
			if(DAO.ktadmin(user, pass))
			{
				RequestDispatcher rd=request.getRequestDispatcher("Admin.jsp");
				rd.forward(request, response);
				
			}else
			{
				
				/*out.print("Sorry username or password error!");*/
				RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
				//rd.include(request, response);
				rd.forward(request, response);
			}
		}else
		{
			/*out.print("Sorry username or password error!");*/
			RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
			//rd.include(request, response);
			rd.forward(request, response);
		}
	}

}
