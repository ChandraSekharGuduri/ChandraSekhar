package com.servlet.encapsulatedclass;

public class Carsentity {
 
	private String modelname;
	private int variant;
	private String price;
	private String topspeed;
	private String fueltype;
	
	public String getModelname() {
		return modelname;
	}
	public void setModelname(String modelname) {
		this.modelname = modelname;
	}
	public int getVariant() {
		return variant;
	}
	public void setVariant(int variant) {
		this.variant = variant;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getTopspeed() {
		return topspeed;
	}
	public void setTopspeed(String topspeed) {
		this.topspeed = topspeed;
	}
	public String getFueltype() {
		return fueltype;
	}
	public void setFueltype(String fueltype) {
		this.fueltype = fueltype;
	}
	
}
