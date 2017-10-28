package com.jlc.servlets;

import java.io.IOException;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ShowCartServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession sess = request.getSession(false);
		if(sess == null){
			request.setAttribute("MGS", "Session is destroyed");
			RequestDispatcher rd = request.getRequestDispatcher("showbooks.jlc");
			rd.forward(request, response);
		}else {
			Enumeration<String> enms = sess.getAttributeNames();
			List<String> selectedList = Collections.list(enms);
			selectedList.remove("BOOKS");
			if(selectedList.size() == 0){
				request.setAttribute("MGS", "No Books Selected");
			}else {
				request.setAttribute("CART", selectedList);
			}
			RequestDispatcher rd = request.getRequestDispatcher("showcart.jlc");
			rd.forward(request, response);
		}
	}
}
