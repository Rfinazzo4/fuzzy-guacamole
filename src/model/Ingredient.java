package model;

public class Ingredient {
	private String name;
	private String measurement;
	double quantity;
	
	Ingredient(String name, String measurement, double quantity){
		this.name = name;
		this.measurement = measurement;
		this.quantity = quantity;
	}
	
	public String getMeasurement() {
		return measurement;
	}
	public void setMeasurement(String measurement) {
		this.measurement = measurement;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getQuantity() {
		return quantity;
	}
	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}
	
	public String toString() {
		if(measurement != null || !measurement.equals(""))
			return quantity + " " + measurement + " of " + name;
		return quantity + " " + name;
	}
	
	
}
