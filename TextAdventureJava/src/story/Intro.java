package story;

public class Intro extends Control {
	
	public static void rules() {
		write("This is a text adventure. \nYou will navigate the story by typing into the game's prompts.");
		write("Use [ENTER] to move through the story.");
		write("Words circled by [brackets] are typically actions you can make.");
		write("Sometimes there are actions that can be made that  will not be explicitly stated.");
		write_s("Good luck!");
	}
	
	/** Gets the player's name and welcomes them to the game. */
	public static void getUserName() {
		System.out.print("Hello, brave adventurer. What is your name?" + prompt);
		name = read();
		if (name.isEmpty()) {
			write("You must have a name! Well, if you won't tell me, I'll just call you... Steve.");
			name = "Steve";
		}
		write_s("Welcome, " + name + ", to TAHA'S TEXT ADVENTURE!");
	}
	
	/** Sets the stage and describes the first room. */
	public static void intro() {
		write_s("\n\nYou wake up to the sound of a bell chiming. \nA large bell. \nLike a clocktower bell.");
		write_s("You are in a strange, dark room. The sound of dripping water gives the room an eerie feeling.");
		write("\nThrough the gloom, you can just make out the shape of a table next to the bed you're lying on.");
		choice1();
	}
	
	/** Choose between looking at the table or going back to sleep. Sleep leads to death. */
	public static void choice1() {
		write_l("You debate whether you should [inspect] the table or go back to [sleep]." + prompt);
		String choice = read();
		if (checkInput(choice, "inspect")) {
			write("You choose to inspect the table.");
			inspectTable();
		}
		else if (checkInput(choice, "sleep")) {
			Endings.sleepEnd();
		}
		else {
			badInput(choice);
			choice1();
		}
	}
	
	/** Find a flashlight, dagger, and chocolate bar on the table. At this point, the dagger and chocolate bar lead to death. */
	public static void inspectTable() {
		write_s("It's a table. What's there to inspect?");
		write_s("Just kidding. On the table, you see a dagger, a flashlight, and a chocolate bar.");
		write_s("You can [take (insert object here)] to add objects to your inventory, and/or [get up] out of bed.");
		lootTable();
	}
	
	public static void inspectTableAgain() {
		write_s("Hey, this table looks familiar. Oh yeah, you were just looking at it.");
		write("Is there anything you still want to pick up? Otherwise, you can [finish] looting.");
		lootTable();
	}
	
	public static void lootTable() {
		promptUser();
		String choice = read();
		if (checkInput(choice, "take dagger")) {
			if (inventory.contains("Dagger")) {
				write("You already have a dagger in your inventory!");
				lootTable();
			}
			else {
				inventory.add("Dagger");
				write("You picked up the dagger.");
				maxDamage = 15;
				printInventory();
				write("Your max damage is now " + maxDamage);
				lootTable();
			}
		}
		else if (checkInput(choice, "take flashlight")) {
			if (inventory.contains("Flashlight")) {
				write("You already have a flashlight in your inventory!");
				lootTable();
			}
			else {
				inventory.add("Flashlight");
				write("You picked up the flashlight.");
				printInventory();
				lootTable();
			}
		}
		else if (checkInput(choice, "take chocolate bar") || checkInput(choice, "take chocolate")) {
			if (inventory.contains("Chocolate bar")) {
				write("You already have a chocolate bar in your inventory!");
				lootTable();
			}
			else {
				inventory.add("Chocolate bar");
				write("You picked up the chocolate bar.");
				printInventory();
				lootTable();
			}
		}
		else if (checkInput(choice, "take all")) {
			if (!inventory.contains("Chocolate bar")) {
				inventory.add("Chocolate bar");
			}
			if (!inventory.contains("Flashlight")) {
				inventory.add("Flashlight");
			}
			if (!inventory.contains("Dagger")) {
				inventory.add("Dagger");
				maxDamage = 15;
			}
			write("All the items have been added to your inventory.");
			printInventory();
			write("Your max damage is now " + maxDamage);
			lootTable();
		}
		else if (checkInput(choice, "get up")) {
			write_s("You get up and groan as you leave the warm embrace of the fuzzy blanket.");
			write("The room is dark, and you stay still next to the bed in fear of running into something.");
			write("(Hint: [use] and [eat] can be executed on inventory items at various points in the game.");
			outOfBed();
		}
		else if (checkInput(choice, "finish")) {
			write("You're finally done looting, it seems. You turn around and face the dark room again.");
			outOfBed();
		}
		else if (checkInput(choice, "eat chocolate") || checkInput(choice, "eat chocolate bar") || checkInput(choice, "use flashlight") || checkInput(choice, "use dagger")) {
			write("You should get out of bed first.");
			lootTable();
		}
		else {
			badInput(choice);
			lootTable();
		}
	}
	/** Choose to use any of the items you have picked up or leave the room. */
	public static void outOfBed() {
		promptUser();
		String choice = read();
		if (checkInput(choice, "use flashlight")) {
			write_s("You flick on the flashlight beam. It flickers a bit, then turns on. The batteries must be running low.");
			write_s("Now that you have a light, you can see that the room is rather small.\nThe only contents of the room are the bed, the table, and a door.");
			write_s("The roof is made of stone and you can see water dripping from a crack in the corner, suggesting that the room is underground.");
			write("You might try to [open door], [sleep], or [search table].");
			outOfBed();
		}
		else if (checkInput(choice, "use dagger")) {
			if (inventory.contains("Dagger")) {
				write("There is nothing on which to use the dagger but yourself.");
				write("Continue? [Y/N]");
				useDagger();
				outOfBed();
			}
			else {
				write("You do not have a dagger!");
				outOfBed();
			}
		}
		else if (checkInput(choice, "eat chocolate") || checkInput(choice, "eat chocolate bar")) {
			if (inventory.contains("Chocolate bar")) {
				Endings.chocolateEnd();
			}
			else {
				write("You haven't picked up any chocolate bars!");
				outOfBed();
			}
		}
		else if (checkInput(choice, "search table")) {
			write("You look back and decide to inspect the table.");
			inspectTableAgain();
		}
		else if (checkInput(choice, "sleep")) {
			Endings.sleepEnd();
		}
		else if (checkInput(choice, "open door") || checkInput(choice, "use door") || checkInput(choice, "try door")) {
			openDoor();
		}
		else {
			badInput(choice);
			outOfBed();
		}
	}
	
	/** Suicide */
	public static void useDagger() {
		promptUser();
		String choice = read();
		if (checkInput(choice, "y")) {
			Endings.daggerEnd();
		}
		else if (checkInput(choice, "n")) {
			write("Thankfully, you're not a suicidal maniac in this story. You put the dagger back in your inventory.");
			return;
		}
		else {
			badInput(choice);
			useDagger();
		}
	}
	
	/** Proceed through the door and continue the game. */
	public static void openDoor() {
		write_s("You walk across the small room and hesitate for a second before opening the door.");
		write_s("A building can be a lot more intimidating than a room, and you're not sure you want to leave the room, leave the safety of ignorance.");
		write_s("But you soon realize that there is no viable alternative, and you open the door...");
		Hallway.hallwayIntro();
	}
	
}



