package story;

public class LeftRoom extends Control {
	
	public static void leftRoomIntro() {
		write("A large pedestal sits in the center of the small room.");
		write("On top of the pedestal is a tablet computer.");
		stall();
		write("You lift the tablet, and read the words on the screen. You realize it's a series of riddles.");
		stall();
		write("You decide to give them a shot, but decide that you'll [give up] if the riddles are too hard.");
		stall();
		riddle1();
		stall();
		riddle2();
		stall();
		riddle3();
		stall();
		success();
	}
	
	public static void riddle1() {
		rite("", 30);
		rite("I have roads but no pavement,", 30);
		rite("rivers but no water,", 30);
		rite("and cities but no buildings.", 30);
		rite("What am I?", 30);
		rite("", 30);
		
		checkAnswer("map");
	}
	
	public static void riddle2() {
		rite("", 17);
		rite("What has hands", 17);
		rite("but cannot clap?", 17);
		rite("", 17);
		
		checkAnswer("clock");
	}
	
	public static void riddle3() {
		rite("", 38);
		rite("The one who made it didn't want it.", 38);
		rite("The one who bought it didn't need it.", 38);
		rite("The one who used it never saw it.", 38);
		rite("What is it?", 38);
		rite("", 38);
		
		checkAnswer("coffin");
	}
	
	public static void checkAnswer(String ans) {
		String guess = "";
		while (!checkInput(guess, ans) && !checkInput(guess, "a " + ans)) {
			promptUser();
			guess = read();
			
			if (checkInput(guess, "give up")) {
				giveUp();
			} else if (checkInput(guess, "") ) {
				
			} else if (!checkInput(guess, ans) && !checkInput(guess, "a " + ans)) {
				write("Incorrect");
			}
		}
		write("Correct!");
	}
	
	public static void giveUp() {
		write("You're having problems thinking of the answer to this riddle, so you decide to come back to it later.");
		stall();
		write("You set the tablet back down on the pedestal and walk out the gaping doorway.");
		stall();
		write("On your way out, you trip over a string that you had stepped over before.");
		write("As you stumble through the doorway, you hear a rumbling noise.");
		stall();
		write("A rush of rocks and small boulders cascade down from the ceiling and pile up in the doorway until the opening is completely blocked.");
		stall();
		write("So much for 'coming back to it later,' huh? I guess you'll never know what those riddles were for.");
		stall();
		write("You're now back in the long hallway, standing under the trapdoor.");
		Hallway.leftChoicesNoRiddles();
	}
	
	public static void leave() {
		write("Seeing the room is now empty, you head back through the doorway to the hallway.");
		stall();
		write("On your way out, you trip over a string that you had stepped over before.");
		write("As you stumble through the doorway, you hear a rumbling noise.");
		stall();
		write("A rush of rocks and small boulders cascade down from the ceiling and pile up in the doorway until the opening is completely blocked.");
		stall();
		write("Good thing you didn't give up.");
		stall();
		write("You're now back in the long hallway, standing under the trapdoor.");
		Hallway.leftChoicesNoRiddles();
	}
	
	public static void success() {
		write("You did it! You completed three riddles without giving up!");
		stall();
		write("I'll be honest, I have no idea if you asked a friend or used Google to find the answers.");
		stall();
		write("But if we can't trust each other, then who can we trust?");
		stall();
		write("After all, it's possible that you've already attempted to play through this game and ended up dying in some " +
				"ridiculous way I programmed in for fun.");
		stall();
		write("So let's just call it even and continue the adventure.");
		stall();
		write("The pedestal in the center of the room begins to sink into the floor, revealing...");
		stall();
		write("A really cool sword. Like super cool. I can't even think of a cool enough sword, so let's call it a blend between the " +
				"Infinity Blade and Dawnbreaker from Skyrim. And it's flaming too.");
		stall();
		write("You reach out and grasp the epic blade by its hilt, pulling it out of its sheath and stuffing it into your inventory.");
		inventory.add("Infinitybreaker");
		maxDamage = 50;
		printInventory();
		write("Your max damage is now " + maxDamage);
		stall();
		leave();
	}
	
	public static void rite(String s, int l) {
		System.out.printf("\t| %-" + l + "S" + "|\n", s);
	}
	
}
