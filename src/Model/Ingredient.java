package Model;

public class Ingredient {
	private String name;
	private float quantity;
	private String quanType;
	
	public Ingredient(String n, float q, String qt) {
		name = n;
		setQuantity(q);
		quanType = qt;
	}

	public float getQuantity() {
		return quantity;
	}

	public void setQuantity(float quantity) {
		this.quantity = quantity;
	}
}
