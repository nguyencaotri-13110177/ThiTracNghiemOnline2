package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.*;

/**
 * Servlet implementation class Chamdiem
 */
@WebServlet("/Chamdiem")
public class Chamdiem extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Chamdiem() {
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
		
		String socau1=request.getParameter("socau");
		int socau = Integer.parseInt(socau1);
		
		String[] dscau=new String[socau];
		for(int i=0;i<socau;i++)
			dscau[i] = request.getParameter(Integer.toString(i+1));
		
		int diem=0;
		for(int j=0;j<socau;j++)
			if("0".equals(dscau[j]))
				diem++;
		
		//Lay idsinhvien
		HttpSession session=request.getSession();  
		String name=(String)session.getAttribute("namesv");
		int idsv=DAO.layidsv(name);
		//MaDe
		int made=Integer.parseInt(request.getParameter("made"));
		//Danh sach id cau
		int[] dsMaCau=new int[socau];
		for(int i=0;i<socau;i++)
			dsMaCau[i] = Integer.parseInt(request.getParameter("idcau_"+Integer.toString(i+1)));
		//Danh sach dap an hs chon
		int[] dsDapAnHS=new int[socau];
		for(int i=0;i<socau;i++)
			if(dscau[i]==null)
				dsDapAnHS[i] = 5;
			else
				dsDapAnHS[i] = Integer.parseInt(dscau[i]);
		//Luu bai cua hoc sinh
		for(int i=0;i<socau;i++)
			DAO.addbailamsv(idsv, made, dsMaCau[i], dsDapAnHS[i]);
		//Luu diem cua hs
		DAO.luuketqua(idsv, made, diem);
		
		PrintWriter out = response.getWriter();
		
		out.println("Diem cua ban la: "+diem);
		
		out.print("<a href=Xemlaibaithi.jsp?id="+made+">Xem lai bai lam</a>");
		out.print("     ");
		out.print("<a href=VaoThi.jsp>Lam tiep</a>");
	}

}
