package story;

public class TrapDoor extends Control {

	public static void trapDoorIntro() {
		write("You poke your head into the gloomy space above the trapdoor.");
		write("It seems to be an attic of some sort.");
		stall();
		write("You pull yourself up the rest of the way, coughing as you disturb the thick layer of dust that coats the floor.");
		stall();
		write("The air is heavy with floating sawdust - it's probably highly flammable.");
		stall();
		write("In front of you, you see a staircase ascending into darkness.");
		stall();
		write("You try to pull your ladder up after you but it doesn't fit into the small space.");
		inventory.remove("Ladder");
		printInventory();
		stall();
		choices();
	}
	
	public static void choices() {
		promptUser();
		String choice = read();
		
		if (checkInput(choice, "use dagger")) {
			if (inventory.contains("Dagger")) {
				write("There is nothing on which to use the dagger but yourself.");
				write("Continue? [Y/N]");
				Intro.useDagger();
				choices();
			} else {
				write("You do not have a dagger!");
				choices();
			}
		} else if (checkInput(choice, "eat chocolate") || checkInput(choice, "eat chocolate bar")) {
			if (inventory.contains("Chocolate bar")) {
				Endings.chocolateEnd();
			} else {
				write("You haven't picked up any chocolate bars!");
				choices();
			}
		} else if (checkInput(choice, "use flashlight")) {
			write("You flick your flashlight on, but it flickers and dies almost immediately. It seems the batteries finally died.");
			choices();
		} else if (checkInput(choice, "use torch")) {
			if (inventory.contains("Torch")) {
				Endings.burnEnd();
			} else {
				write("You don't have a torch!");
			}
			choices();
		} else {
			badInput(choice);
			choices();
		}
	}
	
}
