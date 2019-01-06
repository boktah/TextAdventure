package story;

import java.util.Timer;

public class Endings extends Control {
	
	public static Timer timer;
	
	public static void main(String[] args) {
		timer = new Timer();
	}
	
	public static void sleepEnd() {
		write_s("You choose to go back to sleep.");
		write_s("It's not your job to control your life, is it?");
		write_s("Whatever happens, will happen. Why interfere with destiny?");
		write_s("So you lie back down, close your eyes, and sink back into the blissfully unaware clutches of unconciousness.");
		endCredits();
	}
	
	public static void chocolateEnd() {
		write_s("You decide to the eat the chocolate bar in your inventory.");
		write_s("As you bite into it you realize that, hidden within the gooey deliciousness of the slighty melted bar, the chocolate has a slightly odd taste.");
		write("The last thought that crosses your mind before you collapse is:");
		write_s("'Why would someone poison a perfectly good chocolate bar!?'");
		write_s("You die with the unsatisfying knowledge that you'll never know what you were doing in that strange building.");
		endCredits();
	}
	
	public static void daggerEnd() {
		write_s("You decide that when confronted with a problem that might require more than an iota of brainpower, the best way out is to off yourself.");
		write_s("Following that train of thought, you raise the dagger and don't hesitate.");
		write_s("Can you really be blamed for your death? Was it fate, some strange destiny?");
		write_s("Or perhaps just the hasty actions of a lazy fool...");
		endCredits();
	}
	
	public static void noDaggerEnd() {
		write_s("Unfortunately, you have no weapon with which to fight!");
		write_s("You remember seeing the dagger on the table when you woke up, and wish you had grabbed it.");
		write_s("Ah well. You know what they say... hindsight is 20/20.");
		write_s("How were you supposed to know that you might need a weapon/utility in this unknown mysterious location?");
		write_s("The man in the uniform approaches you with his sword, without a trace of mercy in his eyes...");
		endCredits();
	}
	
	public static void declineRespawnEnd() {
		write_s("You had the option to bring yourself back to life, but decided instead to remain dead.");
		write_s("Maybe you want to keep this story as realistic as possible - which I can respect.");
		write_s("Maybe your mom is calling you to lunch and you can't play anymore.");
		write_s("I can sort of respect that too.");
		write_s("Whatever the reason, you choose to stay dead, which is almost like dying twice, if you think about it.");
		endCredits();
	}
	
	public static void glitchEnd() {
		write_s("I'll be honest, this shouldn't be possible and no one should ever be reading this dialog.");
		write_s("But hey, I guess you beat me, and it's only fair that your hard work is paid off.");
		write_s("Good job breaking the game, you win!");
		endCredits();
	}
	
	public static void rightHallwayEnd() {
		write_s("You decide to continue down the right side of the hallway. Maybe you have a long-lasting grudge against lefties.");
		write_s("Some sort of tragic accident with a left-handed man in your youth? Perhaps.");
		write_s("In any case, you continue down the right side of the hallway, testing each door as you pass it.");
		write_s("You lose track of how long you spend walking. Minutes, hours, days...");
		write_s("At some point you drop to the floor, exhausted. Your legs are unable to support you. You try to lift yourself up but your arms refuse to move.");
		write_s("You die slowly over the next 24 hours, and your body decays even slower over the next 10 years...");
		endCredits();
	}
	
	public static void burnEnd() {
		write_s("You take your torch out in an attempt to brighten the room.");
		write_s("You must not have read the bit above that mentioned the highly flammable sawdust.");
		write_s("Or maybe you did see it, and this is your idea of a good time.");
		write_s("I was considering just knocking off a couple of your health points, but then I thought - why not go the extra mile?");
		write_s("I can't let people think I'm going soft.");
		write_s("So, here's what happens - you pull your lit torch out of your inventory.");
		write_s("It comes in contact with the sawdust immediately.");
		write_s("You don't even have time to realize your mistake before the whole room lights up, instantly turning you into a charred skeleton.");
		write_s("There might be some sort of lesson this ending is meant to teach you, but you're too dead to learn it.");
		endCredits();
	}
	
	public static void endCredits() {
		write("\n\n\n");
		delayPrint("--------------- THE END ---------------");
		delayPrint("Thanks for playing TAHA'S TEXT ADVENTURE!");
		delayPrint("Story by: Taha");
		delayPrint("Code by: Taha");
		delayPrint("Everything else by: Taha");
		stall();
		System.exit(0);
	}
	
	private static void delayPrint(String text) {
		try {
			Thread.sleep(1000);
			write(text);
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
