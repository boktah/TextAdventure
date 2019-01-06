package story;

import java.util.Random;

public class Combat extends Control {
	
	static Random r = new Random();
	
	static boolean isAttacking = true;
	static boolean isEAttacking = true;
	
	static String eName, pName;
	static int eHP, eDmg, pHP, pDmg;
	
	static int attack, defense;
	static int eAttack, eDefense;
	static int damageDone = 0;
	
	static boolean cont = true;
	
	public static void firstTimeExplanation() {
		write("You are about to engage in your first battle!");
		write_s("Here's a quick guide as to how combat works in this game.");
		write_s("Based on the weapon you are holding, you will have a maximum damage.");
		write_s("Everyone's defense is permanently fixed at 20 max.");
		write_s("An attack or defense stat will be randomly chosen after you decide on your move.");
		write_s("Whoever gets the better stat will knock 1 HP off the opponent's total health.");
		write_s("If the attacker rolls max damage, they will attack for 2 HP rather than 1 "
				+ "and will land their attack regardless of the defender's roll.");
		write_s("Good luck and may the best virtual character win!");
	}
	
	public static void setupFight(String enemy, int enemyHP, int enemyDmg, int playerHP, int playerDmg) {
		
		if (firstFight)	 {
			firstTimeExplanation();
			firstFight = false;
		}
		
		tryAgain = false;
		cont = true;
		
		isAttacking = r.nextBoolean();
		isEAttacking = r.nextBoolean();
		
		eName = enemy.toUpperCase();
		pName = name.toUpperCase();
		eHP = enemyHP; eDmg = enemyDmg;
		pHP = playerHP; pDmg = playerDmg;
		
		write("\n\n---------- PREPARE FOR COMBAT! ----------");
		write("\n\n" + eName + ": " + "STATS");
		write("Health: " + eHP + "\nMax Damage: " + eDmg);
		write("\n" + pName + ": " + "STATS");
		write_s("Health: " + pHP + "\nMax Damage: " + pDmg);
		write("\n\n------------ BEGIN COMBAT!!! ------------");
		fight();
	}
	
	public static void fight() {
		
		write("Would you like to ATTACK or DEFEND?");
		promptUser();
		String choice = read();
		
		if (checkInput(choice, "attack") || (checkInput(choice, "a"))) {
			write("You choose to ATTACK!");
			isAttacking = true;
		}
		else if (checkInput(choice, "defend") || (checkInput(choice, "d"))) {
			write("You choose to DEFEND!");
			isAttacking = false;
		}
		else {
			write("Please choose a valid move!");
			fight();
		}
		
		isEAttacking = r.nextBoolean();
		
		if (isAttacking) {
			write(pName + " is attacking!");
			write_s("[enter] to attack");
			attack = r.nextInt(pDmg + 1);
			write(pName + " deals " + attack + " damage!");
		}
		else {
			write(pName + " is defending!");
			write_s("[enter] to block");
			defense = r.nextInt(21);
			write_s(pName + " gets " + defense + " defense!\n");
		}
		
		if (isEAttacking) {
			write_s(eName + " is attacking!");
			eAttack = r.nextInt(eDmg + 1);
			write_s(eName + " deals " + eAttack + " damage!");
		}
		else {
			write_s(eName + " is defending!");
			eDefense = r.nextInt(21);
			write_s(eName + " gets " + eDefense + " defense!\n");
		}
		
		if (isAttacking && isEAttacking) { 			// both attacking
			write_s(pName + " and " + eName + " both attacked at the same time!");
			if (attack > eAttack) {
				write(name + " dealt more damage than " + eName + "!");
				eHP--;
				stall();
			}
			else {
				write(eName + " dealt more damage than " + name + "!");
				pHP--;
				stall();
			}
		}
		else if (isAttacking && !isEAttacking) {		// player attacking
			if (attack > eDefense) {
				write(name + " overcame the defense of " + eName + "!");
				eHP--;
				stall();
			}
			else {
				write_s(eName + " succesfully defended against " + name + "!");
			}
		}
		else if (!isAttacking && isEAttacking) {		// player defending
			if (eAttack > defense) {
				write(eName + " overcame the defense of " + name + "!");
				pHP--;
				stall();
			}
			else {
				write_s(pName + " succesfully defended against " + eName + "!");
			}
		}
		else if (!isAttacking && !isEAttacking) {	// both defending
			write_s(pName + " and " + eName + " both blocked at the same time! They stand there looking dumb.");
		}
		else { 										// error, should not occur
			write_s("The game just broke, sorry about that. Hopefully it won't keep breaking but it's always a possibility.");
			write_s("Hey, if you have to restart, then you just get to play again, right? Win-win!");
		}
		
		write(name + ": " + pHP + "HP\n" + eName + ": " + eHP + "HP"); // display health stats
		
		// re-spawn/end system
		if (pHP <= 0) {
			cont = false;
			write_s("It looks like you've run out of health points.");
			write_s("Unfortunately, in the gamer universe, that means you've dropped dead.");
			write("Now, I know what you're going to say: ");
			write_s("'omg that was completely luck-based no skill involved this game sux'");
			write_s("Well lucky for you, if you die during combat, you get the option to respawn.");
			write("Do you want to try again?");
			tryAgain();
		}
		if (eHP <= 0) {
			cont = false;
			tryAgain = false;
			write("Congrats, you won the fight against " + eName + "!\n\n");
			health = pHP;
			stall();
		}
		
		if (cont) {
			fight();
		}		
	}
	
	public static void tryAgain() {
		promptUser();
		String choice = read();
		if (checkInput(choice, "yes") || checkInput(choice, "y")) {
			tryAgain = true;
			write_s("Your time-traveling device activates and takes you back to before the fight.");
		}
		else if (checkInput(choice, "no") || checkInput(choice, "n")) {
			tryAgain = false;
			Endings.declineRespawnEnd();
		}
		else {
			badInput(choice);
			tryAgain();
		}
	}
	
}
