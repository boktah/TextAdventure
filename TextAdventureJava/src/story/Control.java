package story;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Control {
	
	public static Scanner input; // scanner used to read player inputs
	public static String prompt; // jumps to a new line and inserts a prompt (>> ) for style
	public static String name;
	public static int maxDamage = 0;
	public static int health = 3;
	public static int maxHealth = 3;
	
	public static boolean firstFight = true;
	public static boolean tryAgain = false;

	public static List<String> inventory = new ArrayList<String>();
	
	public static void main(String[] args) {
		
		input = new Scanner(System.in);
		prompt = "\n>> ";
		name = "";

//		Intro.rules();
//		Intro.getUserName();
//		Intro.intro();
		// next step of the game goes here
		LeftRoom.leftRoomIntro();
	}

	/**
	 * Used to avoid incorrect interpretation by the game due to capitalization
	 */
	public static boolean checkInput(String input, String check) {
		input = input.toLowerCase();
		check = check.toLowerCase();
		
		if (input.equals(check))
			return true;
		else
			return false;
	}
	
	// these methods will be modified if the game is ported to GUI
	public static void write(String s) {
		System.out.println(s);
	}
	
	public static void write_s(String s) {
		System.out.print(s);
		stall();
	}
	
	public static void write_l(String s) {
		System.out.print(s);
	}
	
	public static String read() {
		return input.nextLine();
	}
	// end GUI mods
	
	public static void promptUser() {
		write_l(prompt);
	}
	
	/**
	 * Used to prevent large blocks of text from showing up at once.
	 * The User will read what pops up, then press enter to continue.
	 */
	public static void stall() {
		read();
	}

	public static void printInventory() {
		write("\n----- Your Inventory -----\n" + inventory);
	}
	
	public static void badInput(String s) {
		if (s.equals("")) {
			
		} else {
			write("The illusion of free choice has been broken; please enter an acceptable action.\n");
		}
	}

}
