package story;

public class Hallway extends Control{

	public static void hallwayIntro() {
		write("... and find yourself in a looooong hallway.");
		stall();
		write("The hallway extends as far as you can see in either direction.");
		write("The walls are made of stone, and are illuminated by intermittently-placed fiery torches on either side of the hall.");
		stall();
		write("You hear a *click* behind you and turn around to see that the door swung closed on it own.");
		write("You try turning the knob, but it's locked.");
		stall();
		write("Looks like you've gotta choose, [left] or [right]...");
		leftOrRight();
	}
	
	public static void leftOrRight() {
		promptUser();
		String choice = read();
		if (checkInput(choice, "take torch")) {
			if (inventory.contains("Torch")) {
				write("You already have a torch in your inventory!");
				leftOrRight();
			}
			else {
				inventory.add("Torch");
				write("You took a torch from the wall.");
				printInventory();
				leftOrRight();
			}
		}
		else if (checkInput(choice, "left") ) {
			write("You've got a feeling that left is the right choice, so you confidently set off to the left.");
			turnLeft();
		}
		else if (checkInput(choice, "right") ) {
			write("Right's always right, right? You set off to the right, completely confident in your flawless logic.");
			turnRight();
		}
		else if (checkInput(choice, "use dagger")) {
			if (inventory.contains("Dagger")) {
				write("There is nothing on which to use the dagger but yourself.");
				write("Continue? [Y/N]");
				Intro.useDagger();
				leftOrRight();
			}
			else {
				write("You do not have a dagger!");
				leftOrRight();
			}
		}
		else if (checkInput(choice, "eat chocolate") || checkInput(choice, "eat chocolate bar")) {
			if (inventory.contains("Chocolate bar")) {
				Endings.chocolateEnd();
			}
			else {
				write("You haven't picked up any chocolate bars!");
				leftOrRight();
			}
		}
		else {
			badInput(choice);
			leftOrRight();
		}
	}
	
	public static void turnLeft() {
		write("There aren't any doors on either side of the hallway for as far as you can see.");
		stall();
		write("You set off down the hallway at a jog, planning on entering the first door you find.");
		stall();
		write("After a solid 30 minutes of running, you finally find a wooden door. At the same time, you spot a trapdoor in the roof.");
		stall();
		write("The roof is too high for you to reach on your own." +
				"\nHint: try [inspect], [open], [use], etc. You can also [go back].");
		leftChoices();
	}
	
	public static void leftChoices() {
		promptUser();
		String choice = read();
		if (checkInput(choice, "use dagger")) {
			if (inventory.contains("Dagger")) {
				write("There is nothing on which to use the dagger but yourself.");
				write("Continue? [Y/N]");
				Intro.useDagger();
				leftChoices();
			} else {
				write("You do not have a dagger!");
				leftChoices();
			}
		}
		else if (checkInput(choice, "open trapdoor") || checkInput(choice, "open trap-door")) {
			write("The trapdoor is too high for you to reach. If only you had a stepladder or something...");
			leftChoices();
		}
		else if (checkInput(choice, "open door")) {
			write("You attempt to turn the handle, but the door is locked. So much for the easy way.");
			leftChoices();
		}
		else if (checkInput(choice, "eat chocolate") || checkInput(choice, "eat chocolate bar")) {
			if (inventory.contains("Chocolate bar")) {
				Endings.chocolateEnd();
			} else {
				write("You haven't picked up any chocolate bars!");
				leftChoices();
			}
		}
		else if (checkInput(choice, "inspect door")) {
			write("The door is made of pretty solid wood, but it looks like it hasn't been used it a long time.");
			write("The laquer is fading and the wood is very dry...");
			leftChoices();
		}
		else if (checkInput(choice, "inspect trap-door") || checkInput(choice, "inspect trapdoor")) {
			write("The trapdoor is too high for you to reach without assistance.");
			write("However, you can tell that there is no lock - if you could reach it, you could open it pretty easily.");
			leftChoices();
		}
		else if (checkInput(choice, "use flashlight")) {
			write("You have no need for a flashlight right now - and you want to save the batteries for when you need it.");
			leftChoices();
		}
		else if (checkInput(choice, "use torch")) {
			if (inventory.contains("Torch")) {
				write("You get the brilliant idea to burn the door down.");
				stall();
				write("I guess if you can't open it, you've gotta destroy it!");
				stall();
				write("The dry wood catches fire quickly and the whole door burns to ashes within minutes.");
				stall();
				write("Unfortunately you got scared when you set the door on fire and dropped your torch.");
				inventory.remove("Torch");
				printInventory();
				stall();
				write("Once the flames die out, you walk through the doorframe and enter the next room.");
				LeftRoom.leftRoomIntro();
			} else {
				write("You haven't picked up a torch!");
				leftChoices();
			}
		}
		else if (checkInput(choice, "use ladder")) {
			if (inventory.contains("ladder")) {
				write("You pull your ladder out of your inventory and set it up under the trapdoor.");
				stall();
				write("Once it is in place, you start climbing up the rungs until you reach the door and push it open.");
				stall();
				TrapDoor.trapDoorIntro();
			} else {
				write("That would be a great idea - if you had a ladder!");
				stall();
				write("Were you trying to pull a sneak on me and use a ladder before you collected it?");
				stall();
				write("Well, it won't work. Nice try.");
				leftChoices();
			}
		}
		else if (checkInput(choice, "take torch")) {
			if (inventory.contains("Torch")) {
				write("You already have a torch in your inventory!");
				leftChoices();
			} else {
				inventory.add("Torch");
				write("You grab a fiery torch from the wall.");
				printInventory();
				leftChoices();
			}
		}
		else if (checkInput(choice, "go back") || checkInput(choice, "go right")) {
			write("You run back to where you started and go down the right side of the hallway.");
			turnRight();
		}
		else {
			badInput(choice);
			leftChoices();
		}
	}
	
	public static void leftChoicesNoRiddles() {
		promptUser();
		String choice = read();
		
		if (checkInput(choice, "use dagger")) {
			if (inventory.contains("Dagger")) {
				write("There is nothing on which to use the dagger but yourself.");
				write("Continue? [Y/N]");
				Intro.useDagger();
				leftChoicesNoRiddles();
			} else {
				write("You do not have a dagger!");
				leftChoicesNoRiddles();
			}
		}
		else if (checkInput(choice, "open trapdoor") || checkInput(choice, "open trap-door")) {
			write("The trapdoor is too high for you to reach. If only you had a stepladder or something...");
			leftChoicesNoRiddles();
		}
		else if (checkInput(choice, "open door")) {
			write("You attempt to turn the handle, but the door is locked. So much for the easy way.");
			leftChoicesNoRiddles();
		}
		else if (checkInput(choice, "eat chocolate") || checkInput(choice, "eat chocolate bar")) {
			if (inventory.contains("Chocolate bar")) {
				Endings.chocolateEnd();
			} else {
				write("You haven't picked up any chocolate bars!");
				leftChoicesNoRiddles();
			}
		}
		else if (checkInput(choice, "inspect door")) {
			write("The door used to be a really nice door, before you burned it down and caved in the opening.");
			write("There's no way you're getting in there now...");
			leftChoicesNoRiddles();
		}
		else if (checkInput(choice, "inspect trap-door") || checkInput(choice, "inspect trapdoor")) {
			write("The trapdoor is too high for you to reach without assistance.");
			write("However, you can tell that there is no lock - if you could reach it, you could open it pretty easily.");
			leftChoicesNoRiddles();
		}
		else if (checkInput(choice, "use flashlight")) {
			write("You have no need for a flashlight right now - and you want to save the batteries for when you need it.");
			leftChoicesNoRiddles();
		}
		else if (checkInput(choice, "use torch")) {
			if (inventory.contains("Torch")) {
				write("You don't need a torch here.");
			} else {
				write("You don't have a torch!");
			}
			leftChoicesNoRiddles();
		}
		else if (checkInput(choice, "use ladder")) {
			if (inventory.contains("ladder")) {
				write("You pull your ladder out of your inventory and set it up under the trapdoor.");
				stall();
				write("Once it is in place, you start climbing up the rungs until you reach the door and push it open.");
				stall();
				TrapDoor.trapDoorIntro();
			} else {
				write("That would be a great idea - if you had a ladder!");
				stall();
				write("Were you trying to pull a sneak on me and use a ladder before you collected it?");
				stall();
				write("Well, it won't work. Nice try.");
				leftChoicesNoRiddles();
			}
		}
		else if (checkInput(choice, "take torch")) {
			if (inventory.contains("Torch")) {
				write("You already have a torch in your inventory!");
				leftChoicesNoRiddles();
			} else {
				inventory.add("Torch");
				write("You grab a fiery torch from the wall.");
				printInventory();
				leftChoicesNoRiddles();
			}
		}
		else if (checkInput(choice, "go back") || checkInput(choice, "go right")) {
			write("You run back to where you started and then proceed down the right side of the hallway.");
			turnRight();
		}
		else {
			badInput(choice);
			leftChoicesNoRiddles();
		}
	}
	
	public static void turnRight() {
		write("There are lots of doors to the right, spaced out evenly and located across from each other on either side of the hall.");
		stall();
		write("Not exactly sure what to do, you try the first door you pass. It is locked.");
		stall();
		write("You continue down the hallway, trying each door as you pass it. Eventually, you reach a door that is unlocked.");
		write("What would you like to do? \nHint: you can [go back] to return to the left path.");
		rightChoices();
	}
	
	public static void rightChoices() {
		promptUser();
		String choice = read();
		
		if (checkInput(choice, "open door")) {
			write("You twist the doorknob and enter the room.");
			stall();
			RightRoom.rightRoomIntro();
		}
		else if (checkInput(choice, "inspect door")) {
			write("The door is made of wood, and relatively sturdy. If it hadn't been unlocked, you wouldn't have been able to force it open.");
			rightChoices();
		}
		else if (checkInput(choice, "use dagger")) {
			if (inventory.contains("Dagger")) {
				write("There is nothing on which to use the dagger but yourself.");
				write("Continue? [Y/N]");
				Intro.useDagger();
				rightChoices();
			} else {
				write("You do not have a dagger!");
				rightChoices();
			}
		}
		else if (checkInput(choice, "go back") || checkInput(choice, "go left")) {
			write("You return to the room where you started and turn left instead.");
			turnLeft();
		}
		else {
			badInput(choice);
			rightChoices();
		}
		
	}
	
}






