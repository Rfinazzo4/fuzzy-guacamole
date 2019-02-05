import java.util.ArrayList;
public class Recipe {
	private String name;
	private ArrayList<Ingredient> ingredients;
	
	public Recipe(String n) {
		name = n;
		ingredients = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
