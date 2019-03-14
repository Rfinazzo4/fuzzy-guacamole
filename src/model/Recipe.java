package model;


import java.util.List;
import java.util.ArrayList;

public class Recipe {

	private String recipeName;
	private float serving;
	private ArrayList<Ingredient> recipeIngredients;
	
	// Constructor accepts Recipe name, servings, and a list of Ingredients
	public Recipe(String recipeName, float serving, ArrayList<Ingredient> recipeIngredient){
		this.recipeName = recipeName;
		this.serving = serving;
		this.recipeIngredients = recipeIngredient;
	}

	//Getter/Setters for RecipeName
	public String getRecipeName() {
		return recipeName;
	}

	public void setRecipeName(String recipeName) {
		this.recipeName = recipeName;
	}
	
	//Getter/Setters for servings
	public float getServing() {
		return serving;
	}

	public void setServing(float serving) {
		this.serving = serving;
	}

	//Getter/Setters for list of Ingredient
	public ArrayList<Ingredient> getRecipeIngredient() {
		return recipeIngredients;
	}

	public void setRecipeIngredient(ArrayList<Ingredient> recipeIngredient) {
		this.recipeIngredients = recipeIngredient;
	}
	
	//Goes through all ingredients and calls the toString method from them
	//Then returns a string with all the ingredients information.
	public String getIngredient() {
		String Ingredients = "";
		for(Ingredient I: recipeIngredients) {
			Ingredients += I + "\n";
		}
		return Ingredients;
	}
	
	@Override
	//tostring will return a String with the whole recipe
	public String toString() {
		return recipeName +"\nServings: " + serving 
				+ "\nList of Ingredients:\n" + getIngredient();
	}
	
	//Will modify Qty of specific ingredient.
	public void modifyIngredientQty(Ingredient ing, double quantity) throws Exception {
		double ratio;
		Ingredient I = ingInRecipe(ing);
		
		if(I == null) {
			//Throws exception if ingredient is not part of recipe
			throw new Exception(GuacException.INGREDIENT_NOT_FOUND);
		}
		//if Ingredient found get new ratio and loop though
		//Ingredients once more calling ratioChange
		ratio = I.getRatio(quantity);
		for (Ingredient  Ing: recipeIngredients) 
			Ing.ratioChange(ratio);
		
	}
	
	//Add Ingredient to recipe
	public void addIngredient(Ingredient ing) throws Exception {
		if(ingInRecipe(ing) == null)
			recipeIngredients.add(ing);
		throw new Exception(GuacException.DUPLICATE_INGREDIENT);
	}
	
	//will modify the name of an Ingredient in the recipe
	public void modifyIngredientName(Ingredient ing,String newName) throws Exception {
		Ingredient I = ingInRecipe(ing);
		if(I == null) {
			//Throws exception if ingredient is not part of recipe
			throw new Exception(GuacException.INGREDIENT_NOT_FOUND);
		}
		I.setName(newName);
		return;
		
	}
	
	//Search through Ingredients in recipe. If Ingredient is found we will
	//return the Ingredient object
	private Ingredient ingInRecipe(Ingredient ing) {
		for(Ingredient  I: recipeIngredients) {
			if(I.getName().equalsIgnoreCase(ing.getName()))
				return I;
		}
		return null;	
	}
}
