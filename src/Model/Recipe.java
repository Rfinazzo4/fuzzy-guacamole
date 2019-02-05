package Model;
import java.util.ArrayList;
public class Recipe {
	private String name;
	private ArrayList<Ingredient> ingredients;
	private int servings;
	
	public Recipe() {
		
	}
	
	public Recipe(String filename) {
		ingredients = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getServings() {
		return servings;
	}

	public void setServings(int servings) {
		this.servings = servings;
	}
	
	public void addItem(String name, double quantity, String type) {
		
	}
	
	public void removeItem(String name) {
		
	}
	
	
}
