
package control;
import model.*;
import view.View;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Controller {
	private static CookBook cookbook;
	private static View view;
	private static Scanner kb;
	// DEFAULT_INPUT file is used when no file is provided via command line
	private static final String DEFAULT_INPUT = "res\\sampleInput.txt";
	private static final int QUIT = 7;
	
	
	// Default constructor takes in name of input file and creates a CookBook
	// Ideally, this file will be the same one from previous runs
	Controller(String filename){
		try {
			kb = new Scanner(System.in);
			cookbook = new CookBook(filename);
			view = new View();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static void main(String [] args) {
		if(args.length == 1)
			new Controller(args[0]);
		else
			new Controller(DEFAULT_INPUT);
		
		int choice;
		do {
			choice = view.controlMenu();
			switch(choice) {
			case 1:
				addRecipe();
				break;
			case 2:
				addRecipeFile();
				break;
			case 3:
				removeRecipe();
				break;
			case 4:
				modifyRecipe();
				break;
			case 5:
				viewRecipe();
				break;
			case 6:
				viewAllRecipe();
				break;
			}
			view.sopl("\n\n\n");
		}while(choice != QUIT);
		if(args.length == 1)
			exit(args[0]);
		else
			exit(DEFAULT_INPUT);
		
		
	}
	
	private static void exit(String fileName) {
		try {
			FileWriter fw = new FileWriter(fileName);
			fw.write(cookbook.toString());
			fw.close();
		}catch (IOException e) {
			view.sopl(GuacException.EXIT_SAVE);
		}
	}

	private static void viewAllRecipe() {
		for(String s : cookbook.getRecipeList())
			view.sopl(s);
	}
	private static void viewRecipe() {
		String name;
		view.sop("Enter the recipe name: ");
		name = kb.nextLine();
		do {
			try {
				String recipe = cookbook.getRecipe(name);
				view.sopl(recipe);
				break;
			}catch(Exception e) {
				view.sopl(e.getMessage() + view.TRY_AGAIN);
				String ch = kb.nextLine();
				if(!ch.equalsIgnoreCase("y")) 
					break;
			}
		}while(true);
		view.sopl("\n");
	}
	private static void modifyRecipe() {
		int choice;
		do {
			choice = view.modRecipe();
			if(choice == 3) {
				do {
					choice = view.modIngredient();
					switch(choice) {
					case 1: modAddIngr();
						break;
					case 2:
						break;
					case 3:
						break;
					}
				}while(choice != 4);
				switch(choice) {
				case 1:
					break;
				case 2:
					break;
				case 3:
					break;
				}
			}
			
		}while(choice != 4);
		view.sopl("\n");
	}

	// Modify recipe: Add Ingredient
	private static void modAddIngr() {
		String name, line;
		view.sop("Enter the recipe name: ");
		name = kb.nextLine();
		do {
			try {
				view.sopl("Enter your Ingredients in the format:");
				view.sopl("\n[quantity] [measurement [of]] [name]");
				view.sopl("Example: 4 cups of baking powder.");
				view.sop(">");
				line = kb.nextLine();
				cookbook.addIngredientToRecipe(name, new Ingredient(line));
				
			}catch (Exception e) {
				view.sopl(e.getMessage() + view.TRY_AGAIN);
				String ch = kb.nextLine();
				if(!ch.equalsIgnoreCase("y"))
					break;
			}
		}while(true);
	}


	private static void removeRecipe() {
		// Tries to remove a recipe, if it doens't exist, asks
		// the user to try again or give up
		String name;
		view.sop("Enter the recipe name: ");
		name = kb.nextLine();
		do {
			try {
				cookbook.deleteRecipe(name);
				break;
			}catch(Exception e) {
				view.sopl(e.getMessage() + view.TRY_AGAIN);
				String ch = kb.nextLine();
				if(!ch.equalsIgnoreCase("y"))
					break;
			}
		}while(true);
		view.sopl("\n");
	}
	private static void addRecipeFile() {
		//Tries to add a recipe to the cookbook from a file. If the syntax
		// is wrong at any point, doesn't add recipe and asks user to try again
		
		//cookbook.addRecipes()
		String filename;
		view.sop("Enter the file name: ");
		filename = kb.nextLine();
		
		do {
			try {
				cookbook.addRecipes(filename);
				break;
			}catch (Exception e) {
				view.sopl(e.getMessage() + " Would you like to try again (y|n)? ");
				String ch = kb.nextLine();
				if(!ch.equalsIgnoreCase("y"))
					break;
			}
			view.sopl("Enter the file name: ");
			filename = kb.nextLine();
		}while(true);
		view.sopl("\n");
		
	}
	private static void addRecipe() {
		// Collect recipe information from user and pass that to cookbook
		float serving;
		String name;
		ArrayList<Ingredient> ingredients = new ArrayList<>();
		
		view.sop("Enter name of recipe: ");
		name = kb.nextLine();
	
		do {
			view.sop("Enter serving size: ");
			if(kb.hasNextFloat()) {
				serving = kb.nextFloat();
				break;
			}
			kb.next();
		}while(true);
		
		view.sopl("\nEnter your Ingredients in the format:\n[quantity] [measurement [of]] [name]");
		view.sopl("Example: 4 cups of baking powder.\nType '!', 'done', or 'quit' to STOP\n");
		view.sop(">");
		kb.nextLine();
		String line = kb.nextLine();
		while(!line.equals("!") && !line.equalsIgnoreCase("done")
				&& !line.equalsIgnoreCase("quit")) {
			try {
				ingredients.add(new Ingredient(line));
			}catch(Exception e) {
				view.sopl(e.getMessage() + " Please try again.");
			}
			view.sop(">");
			line = kb.nextLine();
		}
		view.sopl("\n");
		cookbook.addRecipe(new Recipe(name, serving, ingredients));
	}
}
