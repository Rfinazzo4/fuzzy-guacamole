package model;

public class Measurement {
	private String type;
	private double quantity;
	
	
	// constructor that will only take the measurement amount.
	// in cases where no type is needed for ingredient
	// ex (n eggs, n apple, n banana )
	public Measurement(double quantity) {
		this.quantity = quantity;
		this.type = null;
	}
	
	// constructor that will take quantity amount and measurement type.
	// type ex("n cups of, n tbs of, n gallon of" )
	public Measurement(double quantity, String type) {
		this.quantity = quantity;
		this.type = type;
	}
	
	
	/**
	 * @return the quantity
	 */
	public double getQuantity() {
		return quantity;
	}
	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	
	// s to see if type of measurement is assigned 
	public boolean hasType() {
		return (type != null)? true : false;
	}
	
	@Override
	//to string for Measurement 
	public String toString() {
		if(type == null)
			return quantity + " ";
		return quantity + " " + type + " ";
		
	}
	
}
