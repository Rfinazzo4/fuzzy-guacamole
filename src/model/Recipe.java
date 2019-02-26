package model;


import java.util.List;
import java.util.ArrayList;

public class Recipe {

	private String recipeName;
	private float serving;
	private double exactServings;
	private ArrayList<Ingredient> recipeIngredients;
	
	//might want to change controller to create recipe and pass said recipe to kb.
	public Recipe(String recipeName, float serving, ArrayList<Ingredient> recipeIngredient){
		this.recipeName = recipeName;
		this.serving = serving;
		this.recipeIngredients = recipeIngredient;
		this.exactServings = serving;
	}

	/**
	 * @return the recipeName
	 */
	public String getRecipeName() {
		return recipeName;
	}

	/**
	 * @param recipeName the recipeName to set
	 */
	public void setRecipeName(String recipeName) {
		this.recipeName = recipeName;
	}

	/**
	 * @return the serving
	 */
	public float getServing() {
		return serving;
	}

	/**
	 * @param serving the serving to set
	 */
	public void setServing(float serving) {
		this.serving = serving;
	}

	/**
	 * @return the recipeIngredient
	 */
	public ArrayList<Ingredient> getRecipeIngredient() {
		return recipeIngredients;
	}

	/**
	 * @param recipeIngredient the recipeIngredient to set
	 */
	public void setRecipeIngredient(ArrayList<Ingredient> recipeIngredient) {
		this.recipeIngredients = recipeIngredient;
	}
	
	//Goes through all ingredients and calls the toString method from them
	public String getIngredient() {
		String Ingredients = "";
		for(Ingredient I: recipeIngredients) {
			Ingredients += I + "\n";
		}
		
		return Ingredients;
	}
	
	@Override
	public String toString() {
		return recipeName +"\nServings: " + serving 
				+ "\nList of Ingredients:\n" + getIngredient();
		
	}
	
	public void modifyIngredient(String ingredientName, double quantity) throws Exception {
		double currentQuantity = -1.0, ratio;
		
		for(Ingredient  I: recipeIngredients) {
			if(I.getName().equalsIgnoreCase(ingredientName)) {
				currentQuantity = I.getQuantity();
			}
		}
		if(currentQuantity == -1.0)
			throw new Exception("Ingredient not found.");
		ratio = quantity / currentQuantity;
		
		for(Ingredient  I: recipeIngredients) {
			I.setQuantity(ratio * I.getQuantity());
		}
		
		ExactlyChangeServings(ratio);
	}
	
	//private method to change the servings to be as exact as possible.
	//need to edit so servings can be 1/2 a servings. change round feature.
	private void ExactlyChangeServings(double ratio) {
		exactServings = exactServings * ratio;
		setServing((float) Math.round(exactServings));
	}
	
	//modify recipe where we can add ingredients/change name
	
	
	
}
