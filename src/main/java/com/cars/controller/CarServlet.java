package com.cars.controller;

import java.io.IOException;
import java.io.PrintWriter;

import com.servlet.encapsulatedclass.Carsentity;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class CarServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	public CarServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request ,HttpServletResponse response) throws IOException {

		response.setContentType("text/html");

		HttpSession session = request.getSession();
		Object obj = session.getAttribute("carObject");

		Carsentity car = null;
		if(obj!=null) {
			car = (Carsentity) obj;
		}
		PrintWriter out = response.getWriter();
		out.print("<html><body><table>");
		out.print("<tr><th>Modelname :</th><th>Variant :</th><th>Price :</th><th>Topspeed :</th><th>Fueltype :</th></tr>");
		out.print("<tr><td>"+car.getModelname()+"</td>");
		out.print("<td>"+car.getVariant()+"</td>");
		out.print("<td>"+car.getPrice()+"</td>");
		out.print("<td>"+car.getTopspeed()+"</td>");
		out.print("<td>"+car.getFueltype()+"</td></tr>");
		out.print("<tr><td><button><a href = 'Index.html'>Back To Home Page</a></button>");
		out.print("</table></body></html>");

	}
}

