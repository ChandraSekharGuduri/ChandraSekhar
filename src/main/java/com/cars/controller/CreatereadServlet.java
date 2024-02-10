package com.cars.controller;

import java.io.IOException;

import com.cars.implementation.Implementation;
import com.servlet.encapsulatedclass.Carsentity;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class CreatereadServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	public CreatereadServlet() {
		super();
	}
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		System.out.println("POST method triggered");
		String modelname=request.getParameter("modelname");
		String variant=request.getParameter("variant");
		int FEvariant=0;
	 try {
		 FEvariant=Integer.parseInt(variant);
	 }catch(Exception e) {
		 FEvariant=0;
	 }
	 String price=request.getParameter("price");
	 String topspeed=request.getParameter("topspeed");
	 String fueltype=request.getParameter("fueltype");
	
	
	Carsentity car=new Carsentity();
	car.setModelname(modelname);
	car.setVariant(FEvariant);
	car.setPrice(price);
	car.setTopspeed(topspeed);
	car.setFueltype(fueltype);
	
	Implementation imp=new Implementation();
	int result = imp.Insertmethod(car);
	
	HttpSession session =request.getSession();
	session.setAttribute("CarsInsert", car);
	
	RequestDispatcher success=request.getRequestDispatcher("/Success.html");
	RequestDispatcher failed=request.getRequestDispatcher("/Failure.html");
	
	if(result>0) {
		success.forward(request, response);
	}else {
		failed.forward(request, response);
	}
}
	protected void doGet(HttpServletRequest request ,HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Get Method Triggered");

		String modelname=request.getParameter("modelname");

		
		Carsentity car = new Carsentity();
		car.setModelname(modelname);

		Implementation imp =new Implementation();

		Carsentity entity = imp.Search(modelname);

		HttpSession session = request.getSession();
		session.setAttribute("carObject", entity);

		RequestDispatcher success = request.getRequestDispatcher("/CarServlet");
		RequestDispatcher failed = request.getRequestDispatcher("Failure.html");

		if(entity!=null) {
			success.forward(request, response);

		}
		else {
			failed.forward(request, response);
		}




	}
}