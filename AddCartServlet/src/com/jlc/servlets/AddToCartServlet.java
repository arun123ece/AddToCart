package com.jlc.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AddToCartServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession sess = request.getSession(false);
		if(sess == null){
			request.setAttribute("MGS", "Session is destroyed");
		}else {
			String bnm = request.getParameter("bname");
			sess.setAttribute(bnm, bnm);
			sess.setAttribute("ADDED", bnm+" is added to cart");
		}
		RequestDispatcher rd = request.getRequestDispatcher("showbooks.jlc");
		rd.forward(request, response);
	}
	public  static void m1(){
		
		System.out.println("Hello m1()");
	}
}
