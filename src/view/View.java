package view;

import java.util.Scanner;

public class View {
	private Scanner kb;
	public final String TRY_AGAIN = " Would you like to try again (y|n)? ";

	public View() {
		kb = new Scanner(System.in);
	}

	// sopl and sop are short methods to make printing easier
	public void sopl(Object o) {
		System.out.println(o);
	}

	public void sop(Object o) {
		System.out.print(o);
	}

	// Menu method just returns the user's menu selection. Input validation loop
	// is implemented to protect against all sorts of inputs that are not int.

	public int controlMenu() {
		int choice = -1;
		kb = new Scanner(System.in);
		sopl("Welcome to the Cook Book Application!" + "\nPlease select an option below:\n");
		sopl("1. Add a new recipe");
		sopl("2. Add recipes from file");
		sopl("3. Remove a recipe");
		sopl("4. Modify a recipe");
		sopl("5. View a recipe");
		sopl("6. View all recipes");
		sopl("7. Exit\n");

		do {
			sop("Select an option (1-7): ");
			if (kb.hasNextInt())
				choice = kb.nextInt();
			else {
				kb.next(); // ignore the incorrect input and go to the next one
				continue;
			}
		} while (choice < 1 || choice > 7);
		kb.nextLine();
		return choice;
	}
	
	public int modRecipe() {
		int choice = -1;
		kb = new Scanner(System.in);
		sopl("Please select an option below:\n");
		sopl("1. Modify recipe name");
		sopl("2. Modify recipe serving size");
		sopl("3. Modify Ingredients");
		sopl("4. Exit\n");

		do {
			sop("Select an option (1-4): ");
			if (kb.hasNextInt())
				choice = kb.nextInt();
			else {
				kb.next(); // ignore the incorrect input and go to the next one
				continue;
			}
		} while (choice < 1 || choice > 4);
		kb.nextLine();
		return choice;
	}
	
	public int modIngredient() {
		int choice = -1;
		kb = new Scanner(System.in);
		sopl("Please select an option below:\n");
		sopl("1. Add a new ingredient");
		sopl("2. Modify ingredient name");
		sopl("3. Modify ingredient quantity");
		sopl("4. Exit\n");

		do {
			sop("Select an option (1-4): ");
			if (kb.hasNextInt())
				choice = kb.nextInt();
			else {
				kb.next(); // ignore the incorrect input and go to the next one
				continue;
			}
		} while (choice < 1 || choice > 4);
		kb.nextLine();
		return choice;
	}
}
