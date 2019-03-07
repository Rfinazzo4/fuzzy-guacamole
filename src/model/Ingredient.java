package model;

public class Ingredient {
	private String name;
	private String measurement;
	double quantity;
	
	

	
	public Ingredient(String name, String measurement, double quantity){
		this.name = name;
		this.measurement = measurement;
		this.quantity = quantity;
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
		int pos = 0;
		if(line.matches(pattern1)) {
			pos = line.indexOf(" ");
			quantity = Double.parseDouble(line.substring(0, pos));
			line = line.substring(pos+1);
			measurement = line.substring(0,line.indexOf(" "));
			name = line.substring(line.indexOf("of ")+3); 
		}else if(line.matches(pattern2)){
			measurement = "";
			quantity = Double.parseDouble(line.substring(0, line.indexOf(" ")));
			name = line.substring(line.indexOf(" ")+ 1);
		}
		else
			throw new Exception(GuacException.INVALID_SYNTAX);
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
