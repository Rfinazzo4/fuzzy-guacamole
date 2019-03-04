package control;
import model.CookBook;
import model.Ingredient;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Controller {
	private static CookBook cookbook;
	private static Scanner kb;
	// DEFAULT_INPUT file is used when no file is provided via command line
	private static final String DEFAULT_INPUT = "sampleInput.txt";
	private static final int QUIT = 7;
	
	// sopl and sop are short methods to make printing easier
	private static void sopl(Object o) {
		System.out.println(o);
	}
	private static void sop(Object o) {
		System.out.print(o);
	}
	
	// Default constructor takes in name of input file and creates a CookBook
	// Ideally, this file will be the same one from previous runs
	Controller(String filename) throws FileNotFoundException{
		cookbook = new CookBook(filename);
	}
	
	// Menu method just returns the user's menu selection. Input validation loop
	// is implemented to protect against all sorts of inputs that are not int.
	public static int menu() {
		int choice = -1;
		kb = new Scanner(System.in);
		sopl("Welcome to the Cook Book Application!"
				+ "\nPlease select an option below:\n");
		sopl("1. Add a new recipe");
		sopl("2. Add recipes from file");
		sopl("3. Remove a recipe");
		sopl("4. Modify a recipe");
		sopl("5. View a recipe");
		sopl("6. View all recipes");
		sopl("7. Exit\n");
		
		do {
			sop("Select an option (1-7): ");
			if(kb.hasNextInt())
				choice = kb.nextInt();
			else {
				kb.next(); // ignore the incorrect input and go to the next one
				continue;
			}
		}while(choice < 1 || choice > 7);
		kb.nextLine();
		return choice;
	}
	
	public static void main(String [] args) throws FileNotFoundException {
		if(args.length == 1)
			new Controller(args[0]);
		else
			new Controller(DEFAULT_INPUT);
		
		int choice;
		do {
			choice = menu();
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
		}while(choice != QUIT);
		
	}
	private static void viewAllRecipe() {
//		for(String s : cookbook.getRecipeList())
//			sopl(s);
	}
	private static void viewRecipe() {
		String name;
		sop("Enter the recipe name: ");
		name = kb.nextLine();
		do {
			try {
				//String recipe = cookbook.getRecipe(name);
				//sopl(recipe);
				break;
			}catch(Exception e) {
				sopl(e.getMessage() + " Would you like to try again (y|n)? "); 
				String ch = kb.nextLine();
				if(!ch.equalsIgnoreCase("y")) 
					break;
			}
		}while(true);
		sopl("\n");
	}
	private static void modifyRecipe() {
		String name;
		sop("Enter the recipe name: ");
		name = kb.nextLine();
		do {
			try {
				//cookbook.modifyRecipe(name);
				break;
			}catch(Exception e) {
				sopl(e.getMessage() + " Would you like to try again (y|n)? ");
				String ch = kb.nextLine();
				if(!ch.equalsIgnoreCase("y"))
					break;
			}
		}while(true);
		sopl("\n");
	}
	private static void removeRecipe() {
		// Tries to remove a recipe, if it doens't exist, asks
		// the user to try again or give up
		String name;
		sop("Enter the recipe name: ");
		name = kb.nextLine();
		do {
			try {
				//cookbook.deleteRecipe(name);
				break;
			}catch(Exception e) {
				sopl(e.getMessage() + " Would you like to try again (y|n)? ");
				String ch = kb.nextLine();
				if(!ch.equalsIgnoreCase("y"))
					break;
			}
		}while(true);
		sopl("\n");
	}
	private static void addRecipeFile() {
		//Tries to add a recipe to the cookbook from a file. If the syntax
		// is wrong at any point, doesn't add recipe and asks user to try again
		
		//cookbook.addRecipes()
		String filename;
		sop("Enter the file name: ");
		filename = kb.nextLine();
		
		do {
			try {
				//cookbook.addRecipes(filename);
				break;
			}catch (Exception e) {
				sopl(e.getMessage() + " Would you like to try again (y|n)? ");
				String ch = kb.nextLine();
				if(!ch.equalsIgnoreCase("y"))
					break;
			}
			sopl("Enter the file name: ");
			filename = kb.nextLine();
		}while(true);
		sopl("\n");
		
	}
	private static void addRecipe() {
		// Collect recipe information from user and pass that to cookbook
		float serving;
		String name;
		ArrayList<Ingredient> ingredients = new ArrayList<>();
		
		sop("Enter name of recipe: ");
		name = kb.nextLine();
		//kb.next();
		do {
			sop("Enter serving size: ");
			if(kb.hasNextFloat()) {
				serving = kb.nextFloat();
				break;
			}
			kb.next();
		}while(true);
		
		sopl("\nEnter your Ingredients in the format:\n[quantity] [measurement [of]] [name]");
		sopl("Example: 4 cups of baking powder.\nType '!', 'done', or 'quit' to STOP\n");
		sop(">");
		kb.nextLine();
		String line = kb.nextLine();
		while(!line.equals("!") && !line.equalsIgnoreCase("done")
				&& !line.equalsIgnoreCase("quit")) {
			try {
				ingredients.add(new Ingredient(line));
			}catch(Exception e) {
				sopl(e.getMessage() + " Please try again.");
			}
			sop(">");
			line = kb.nextLine();
		}
		sopl("\n");
		//cookbook.addRecipe(name, ingredients, serving);
		
	}
}
