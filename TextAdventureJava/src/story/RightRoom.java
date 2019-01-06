package story;

public class RightRoom extends Control {
	
	public static void rightRoomIntro() {
		write_s("It takes your eyes a second to adjust to the relative gloominess of the room.");
		write_s("Once you can see, you have a minor panic attack.");
		write_s("A man wearing a uniform was sitting in the room! When you walked in, he jumped up in surprise.");
		write_s("The man draws a sword from his belt and approaches you in fighting stance without saying a word.");
		if (inventory.contains("Dagger")) {
			write("Good thing you found that dagger when you woke up!");
			fight();
		}
		else {
			Endings.noDaggerEnd();
		}
	}
	
	public static void fight() {
		write_s("You pull out the dagger and get ready to fight.");
		Combat.setupFight("Guard", 2, 20, health, maxDamage);
		if (tryAgain) {
			fight();
		}
		else {
			afterFight();
		}
	}
	
	public static void afterFight() {
		write_s("Breathing hard, you stick your dagger back into your virtual inventory.");
		write_s("The guard's dead body lies in front of you, his sword dangling from his limp arm.");
		write_s("In the gloom behind him, you can see the vague outline of a treasure chest.");
		write("What would you like to do?");
		afterFightChoices();
	}
	
	public static void afterFightChoices() {
		promptUser();
		String choice = read();
		
		if (checkInput(choice, "take sword")) {
			if (inventory.contains("Sword")) {
				write("You already have a sword in your inventory!");
				afterFightChoices();
			}
			else {
				inventory.add("Sword");
				write("You picked up the guard's sword.");
				maxDamage = 20;
				printInventory();
				write("Your max damage is now " + maxDamage);
				afterFightChoices();
			}
		}
		else if (checkInput(choice, "inspect chest") || checkInput(choice, "inspect treasure chest") ||
					checkInput(choice, "look at chest") || checkInput(choice, "look at treasure chest") ||
					checkInput(choice, "search chest") || checkInput(choice, "search treasure chest") ||
					checkInput(choice, "open chest") || checkInput(choice, "open treasure chest") || checkInput(choice, "chest")) {
			write("You approach the treasure chest, hoping to find a vast amount of gold or jewels.");
			if (inventory.contains("Sword")) {
				write("You pry the chest open with your sword, a greedy glint in your eyes.");
			} else if (inventory.contains("Dagger")) {
				write("You pry the chest open with your dagger, a greedy glint in your eyes.");
			} else {
				write("Somehow, you beat the fight with the guard without a weapon.");
				Endings.glitchEnd();
			}
			stall();
			write_s("What you see in the chest stops you short.");
			write_s("Out of all the things you expected, you never imagined the chest could contain...");
			write_s("A ladder?!");
			write("Well, you never know when a ladder can come in handy, so you heft it out of the chest and put it in your virtual " +
					"inventory of undefined size and location (don't worry about it).");
			inventory.add("Ladder");
			stall();
			maxHealth++;
			health = maxHealth;
			write_s("Under the ladder, you see a red drink in a bottle. You've played enough video games to recognize it - " +
					"while you chug it down, you see " + health + " red hearts hovering above your head!");
			write_s("You're fully healed and have gained an extra health point. Congrats!");
			write("Now that you've got the ladder you feel like you can [leave] the room without missing much.");
			
			afterFightChoices();
		}
		else if(checkInput(choice, "use dagger")) {
			if (inventory.contains("Dagger")) {
				write("There is nothing on which to use the dagger but yourself.");
				write("Continue? [Y/N]");
				Intro.useDagger();
				afterFightChoices();
			}
			else {
				write("You do not have a dagger!");
				afterFightChoices();
			}
		}
		else if(checkInput(choice, "leave") || checkInput(choice, "leave room")) {
			write("You exit the room and re-enter the long hallway.");
			write("You are faced with another choice: continue going [right] or go back and investigate the [left] side?");
			chooseDirection();
		}
		else {
			badInput(choice);
			afterFightChoices();
		}
		
	}
	
	public static void chooseDirection() {
		promptUser();
		String choice = read();
		
		if (checkInput(choice, "left")) {
			write_s("You decide to follow typical video game logic. You found something important on the right side, now you need to find something on the left side, right?");
			write_s("You set off down the hallway until you reach your starting point, and gaze down the left side of the hallway.");
			Hallway.turnLeft();
		}
		else if(checkInput(choice, "right")) {
			Endings.rightHallwayEnd();
		}
		else {
			badInput(choice);
			chooseDirection();
		}
	}
	
}
