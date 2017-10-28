package com.jlc.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SearchBookServlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String cat = request.getParameter("category");
		if(cat != null && cat.equals("Java")){
			
			ArrayList<String> blist = new ArrayList<String>();
			blist.add("Java");
			blist.add("JDBC");
			blist.add("Servlet");
			blist.add("JSP");
			blist.add("EJB");
			blist.add("RMI");
			HttpSession sess = request.getSession();
			sess.setAttribute("BOOKS", blist);
		}else {
			request.setAttribute("MGS", "No Books Found With Categories" +cat);
		}
		RequestDispatcher rd = request.getRequestDispatcher("showbooks.jsp");
		rd.forward(request, response);
	}
}
