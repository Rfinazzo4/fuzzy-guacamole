package model;

public class Measurement {
	private String type;
	private double quantity;
	private double exactQuantity;
	
	// constructor that will only take the measurement amount.
	// in cases where no type is needed for ingredient
	// ex (n eggs, n apple, n banana )
	public Measurement(double quantity) {
		this.quantity = quantity;
		this.exactQuantity = quantity;
		this.type = null;
	}
	
	// constructor that will take quantity amount and measurement type.
	// type ex("n cups of, n tbs of, n gallon of" )
	public Measurement(double quantity, String type) {
		this.quantity = quantity;
		this.exactQuantity = quantity;
		this.type = type;
	}
	
	//Getter/Setters for Quantity
	public double getQuantity() {
		return quantity;
	}
	
	public void setQuantity(double quantity) {
		this.quantity = quantity;
		this.exactQuantity = quantity;
	}
	
	//will accept a new qty and return the ratio difference from new qty to exact qty
	public double getRatio(double Qty) {
		return Qty / exactQuantity;
	}

	//will accept a ratio and change the Quantity to match the new ratio.
	public void ratioChange(double ratio) {
		exactQuantity = ratio * exactQuantity;
		quantity = exactQuantity; //temp
		//call method to alter quantity to be only half or whole numbers
		// private void updateQuantity()
	}
	
	//private void updateQuantity(){
	//add method to alter quantity to only be whole or half numbers using 
	//exact quantity.
	//}
	
	
	//create way to format the out put nice
	
	
	// To see if type of measurement is assigned 
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
