package com.cars.controller;

import java.io.IOException;
import java.io.PrintWriter;

import com.servlet.encapsulatedclass.Carsentity;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class ServletCarData extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	public ServletCarData() {
		super();
	}

	protected void doGet(HttpServletRequest request ,HttpServletResponse response) throws IOException {

		response.setContentType("text/html");

		// session.setAttribute("carObject", entity);

		HttpSession session = request.getSession();
		Object obj = session.getAttribute("carObject");

		Carsentity car = null;
		if(obj!=null) {
			car = (Carsentity) obj;
		}
		RequestDispatcher rd = request.getRequestDispatcher("/CarServlet");
		session.setAttribute("ServletCarData", rd);

		PrintWriter out = response.getWriter();
		out.print("<html><body><table>");
		out.print("<button>");
		out.print("<a href = 'CarServlet'>Data</a>");
		out.print("</button>");
		out.print("</table></body></html>");


	}


}

