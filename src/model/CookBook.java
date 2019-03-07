package model;
import java.io.*;
import java.util.*;
public class CookBook {
	private HashMap <String, Recipe > recipes = new HashMap<String, Recipe>();
	// -->  <Recipe name, Recipe instance>

	public CookBook(String fileName) throws Exception{
		
		BufferedReader in;
		//read in file add to recipes
		try {
			in = new BufferedReader(new FileReader(fileName));
		} catch (FileNotFoundException e) {
			throw new Exception(GuacException.FILE_NOT_FOUND);
		}
		
		
		
		//Create local variable for creating ingredients and recipes
		String line = "";
		String key;
		float serving;
		ArrayList<Ingredient> ingred = new ArrayList<Ingredient>();
		
		//Start reading the file
		while((line=in.readLine())!=null) { //if at EOF, break out of loop
			//read in the key(recipe name) for the recipes
			key = line;
			//read in serving size 
			serving = Float.parseFloat(in.readLine());
			
			//check for whitespace
			line = in.readLine();
			while (line.equals("")) {
				line = in.readLine();
			}
			
			//loop through ingredients
			while(line!="======="&&line!=null){
				//add to ingredient list and read next possible ingredient
				ingred.add(new Ingredient(line));
				line = in.readLine();
			}
			
			//finally, create recipe and add to our recipes
			Recipe toAdd = new Recipe(key, serving, ingred);
			this.recipes.put(toAdd.getRecipeName(), toAdd);
		}
			
	}
	
	//Getters
	public HashMap <String, Recipe> getRecipes(){
		//returns the hashap of recipes
		return recipes;
	}
	
	public String getRecipe(String name) {
		//returns the specific recipe in string format
		return recipes.get(name).toString();
	}
	
	public Set<String> getRecipeList() {
		//returns the set of recipes names(keys)
		return recipes.keySet();
	}
	
	
	public void addRecipes(String fileName) throws Exception{
		
		BufferedReader in;
		//read in file add to recipes
		try {
			in = new BufferedReader(new FileReader(fileName));
		} catch (FileNotFoundException e) {
			throw new Exception(GuacException.FILE_NOT_FOUND);
		}
		
		//Create local variable for creating ingredients and recipes
		String line = "";
		String key;
		float serving;
		ArrayList<Ingredient> ingred = new ArrayList<Ingredient>();
		
		//Start reading the file
		while((line=in.readLine())!=null) { //if at EOF, break out of loop
			//read in the key(recipe name) for the recipes
			key = line;
			//read in serving size 
			serving = Float.parseFloat(in.readLine());
			
			//check for whitespace
			line = in.readLine();
			while (line.equals("")) {
				line = in.readLine();
			}
			
			//loop through ingredients
			while(line!="======="&&line!=null){
				//add to ingredient list and read next possible ingredient
				ingred.add(new Ingredient(line));
				line = in.readLine();
			}
			
			//finally, create recipe and add to our recipes
			Recipe toAdd = new Recipe(key, serving, ingred);
			recipes.put(toAdd.getRecipeName(), toAdd);
		}
		
	}
	
	public void addRecipe(Recipe toAdd) {
		//Create a recipe, the proceed to add to the recipes
		recipes.put(toAdd.getRecipeName(), toAdd);
	}
	
	public void deleteRecipe(String name) {
		//remove a recipe from the recipes(map)
		recipes.remove(name);
	}
	
	
	public void modifyRecipe(String oldName, String newName) {
		//This method modifies the recipe name
		
		//set old object to temporary object
		Recipe temp = recipes.get(oldName);
		
		//remove old object
		recipes.remove(oldName);
		
		//change old recipe name to new recipe name
		temp.setRecipeName(newName);
		
		
		//add new key value pair to the hashmap
		recipes.put(newName,temp);
		
	}
	
	
	public void modifyRecipeServingSize(String name, float newSize) {
		//modify the serving size of the ingredient
		recipes.get(name).setServing(newSize);
	}
	
	public void addIngredientToRecipe(String rName, Ingredient ing) {
		//@@@@@@@@@@@@
		recipes.get(rName).addIngredient(ing);
	}
	
	public void modifyIngredientQty(String rName, Ingredient ing, float Qty) {
		//not set in stone
		//@@@@@@@@@@@@@
		recipes.get(rName).modifyIngredientQty(ing, Qty);
	}
	
	public void modifyIngredientName(String rName, Ingredient ing, String newName) {
		recipes.get(rName).modifyIngredientName(ing, newName);
	}
	
	@Override
	public String toString() {
		String toPrint="";
		for (HashMap.Entry<String, Recipe> entry : recipes.entrySet()) {
			toPrint+=entry.getValue().toString();
			toPrint+="\n=======\n";
		}
		return toPrint;
	}
}
