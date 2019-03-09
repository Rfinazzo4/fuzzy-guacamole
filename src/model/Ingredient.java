package model;

public class Ingredient {
	private String name;
	private Measurement measurement;

	//constructor that accepts name and quantity
	public Ingredient(String name, double quantity){
		this.name = name;
		this.measurement = new Measurement(quantity);
	}
	
	//constructor that accepts name measurement type, and quantity
	public Ingredient(String name, String measurementType, double quantity){
		this.name = name;
		this.measurement = new Measurement(quantity, measurementType);
	}
	
	public Ingredient(String line) throws Exception{
		// This constructor will use regex to identify if line
		// has a measurement or not. It will then use the indexOf()
		// and substring String methods to select each data member value.
		// I am not using the split(regex) nor the StringTokenizer()
		// methods as the indexOf() coupled with substring is actually
		// much faster than the other two.
		String pattern1 = "\\d+\\s+\\w+\\sof\\s[\\w\\s]+$";
		String pattern2 = "\\d+\\s(?!of)[\\w\\s]+$";
		String measurementType = null;
		int pos = 0;
		double quantity;
		if(line.matches(pattern1)) {
			pos = line.indexOf(" ");
			quantity = Double.parseDouble(line.substring(0, pos));
			line = line.substring(pos+1);
			measurementType = line.substring(0,line.indexOf(" "));
			name = line.substring(line.indexOf("of ")+3); 
		}else if(line.matches(pattern2)){
			quantity = Double.parseDouble(line.substring(0, line.indexOf(" ")));
			name = line.substring(line.indexOf(" ")+ 1);
		}
		else
			throw new Exception(GuacException.INVALID_SYNTAX);
		this.measurement = new Measurement(quantity, measurementType);
	}
	
	//Getter/Setter for Ingredient Name
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	//Getter/Setter for Ingredient Quantity
	public double getQuantity() {
		return measurement.getQuantity();
	}
	public void setQuantity(double quantity) {
		this.measurement.setQuantity(quantity);
	}
	
	//will accept new quantity and return the ratio
	public double getRatio(double Qty) {
		return measurement.getRatio(Qty);
	}
	
	//will accept new ratio to alter quantity.
	public void ratioChange(double ratio) {
		measurement.ratioChange(ratio);
	}
	
	//to String for Ingredient
	public String toString() {
		if(measurement.hasType())
			return measurement + "of " + name;
		return measurement + name;
	}
	
}
