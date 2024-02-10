package com.cars.controller;

import java.io.IOException;
import java.util.List;

import com.cars.implementation.Implementation;
import com.servlet.encapsulatedclass.Carsentity;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class FetchServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	public FetchServlet() {
		super();
	}
	protected void doGet(HttpServletRequest request,HttpServletResponse response) {
		System.out.println("Get is triggered");
		Implementation implementation = new Implementation();
		List<Carsentity>result=implementation.Fetch();
		HttpSession session = request.getSession();
		session.setAttribute("Details",result);
		
		RequestDispatcher req=request.getRequestDispatcher("/Details.jsp");
		try {
			req.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
