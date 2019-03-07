package model;

public interface GuacException {
	public final static String INVALID_SYNTAX = "Invalid Syntax";
	public final static String EXIT_SAVE = "Error while saving current Cook Book!";
	public final static String INGREDIENT_NOT_FOUND = "Ingredient was not found in this recipe";
	public final static String FILE_NOT_FOUND = "File was not found!";
}
