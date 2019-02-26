package model;
import java.io.*;
import java.util.*;
public class CookBook {
	private HashMap <String, Recipe > cookbook = new HashMap<String, Recipe>();
	// -->  <Recipe name, Recipe instance>

	public CookBook(String fileName) throws FileNotFoundException, IOException {
		BufferedReader in = new BufferedReader(new FileReader(fileName));
		//read in file add to cookbook
	}
	
	public void addRecipes(String fileName) {
		//read in a single recipe, add to cookbook
		
	}
	
	public void addRecipe(String name, List<Ingredient> ingred, int serving) {
		//Create a recipe, the proceed to add to the cookbook
		Recipe toAdd = new Recipe(name, ingred, serving);
		cookbook.put(name, toAdd);
	}
	
	public void deleteRecipe(String name) {
		//remove a recipe from the cookbook(map)
		cookbook.remove(name);
	}
	
	public String getRecipe(String name) {
		//returns the recipe in string format
		return cookbook.get(name).toString();
	}
	
	public Set<String> getRecipeList() {
		//returns the set of recipes names(keys)
		return cookbook.keySet();
	}
	
	public void modifyRecipe(String name) {
		//retrieves the value at key(name)
		//then will prompt the user to edit any of the information
		//Then will edit the value.
	}
	
	@Override
	public String toString() {
		String toPrint="";
		for (HashMap.Entry<String, Recipe> entry : cookbook.entrySet()) {
			toPrint+=entry.getValue().toString();
			toPrint+="\n=======\n";
		}
		return toPrint;
	} 
}
