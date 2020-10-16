import java.util.Scanner;

public class AdventureProject {

	/* -- INSTANCE VARIABLES -- */
	private String name;
	private String tName = "MacDonald";
	private Scanner in = new Scanner(System.in);
	private boolean error = true;
	
	/* -- SHORTCUT METHODS -- */
	public void gameover() { // displays game over message
		System.out.println("  - GAME OVER -  ");
	}
	public void winner() { // displays winner message
		System.out.println("  - YOU WIN -  ");
	}
	public void loading(String var, int x) { //prints a string three times with time pauses in between
		
		System.out.print(var);
		sleep(x);
		System.out.print(var);
		sleep(x);
		System.out.println(var);
		
	}	
	public void loading() { // default if no values entered
		loading(".", 200);
	}	
	public void sleep(int x) { // pauses time for x milliseconds
		try { Thread.sleep(x); }
		catch (Exception ex) {}
	}

	// 0 - starts the game, leads to goodTemp or highTemp
	public void intro() {
		System.out.println("Mr." + tName + ": Welcome to St. Mark's! Name Please? ");
		
		name = in.next();
		
		System.out.println("Mr." + tName + ": What is your temperature this morning? ");
	
		double temp = in.nextDouble();
		
		if (temp >= 97 || temp <= 99) {
			goodTemp();
		}
		else {
			highTemp();
		}
		
	}
	
	// 1 - goodTemp path, leads to breakfast or bed
	public void goodTemp() {
		System.out.println("Mr." + tName + ": All set, here's your wristband.");
		sleep(300);
		System.out.println("\n **You've now accessed the freedom to move around on campus, but classes don't start for another 30 minutes. Where do you want to go?**");
		sleep(150);
		System.out.println("A - Breakfast \n" + "B - Go back for bed for a bit");
		
		error = true;
		while (error) {
			String choice = in.next();
			if (choice.equals("A") || choice.equals("a")) {
				breakfast();
				error = false;
			}
			else if (choice.equals("B") || choice.equals("b")) {
				bed();
				error = false;
			}
			else {
				System.out.println("Invalid input, enter again.");	
			}
		}
		
	}
	
	// 2 - breakfast path, leads to oatmeal, eggs, or cereal
	public void breakfast() {
		loading();
		System.out.println("Chef: What would like to eat? \n" + "A - Oatmeal \n" + "B - Egg & Sausage \n" + "C - Cereal");
		
		error = true;
		while (error) {
			String choice = in.next();
			if (choice.equals("A") || choice.equals("a")) {
				oatmeal();
				error = false;
			}
			else if (choice.equals("B") || choice.equals("b")) {
				egg();
				error = false;
			}
			else if (choice.equals("C") || choice.equals("c")) {
				cereal();
				error = false;
			}
			else {
				System.out.println("Invalid input, enter again.");	
			}
		}
	}
	
	// 3 - oatmeal path, leads to bathroom or study
	public void oatmeal() {
		System.out.println("Chef: 'Good choice, here you go.'");
		sleep(150);
		loading("CHOMP", 150);
		sleep(300);
		System.out.println("\n **You've finish eating breakfast, and you have a test in your next class in 10 minutes.**");
		sleep(300);
		System.out.println("\n **You have a decision to make.");
		sleep(150);
		System.out.println("\nA - Use the bathroom then go to class" + "\nB - Skip the bathroom and crank a 5 minute power study session.");
		
		error = true;
		while (error) {
			String choice = in.next();
			if (choice.equals("A") || choice.equals("a")) {
				bathroom();
				error = false;
			}
			else if (choice.equals("B") || choice.equals("b")) {
				study();
				error = false;
			}
			else {
				System.out.println("Invalid input, enter again.");	
			}
		}
	}
	
	// 4 - bathroom path, leads to glance or guess
	public void bathroom() {
		loading(".", 300)
		System.out.println("\n **You're taking the test, and come up to a 20-point question. Your brain completely blank out.**"
						 + "\n **You need this question to improve your grade in this class which is a 75.**");
		sleep(300);
		System.out.println("\nA- Glance over at the smart kid's test" + "\nB - Guess a random answer");
		
		error = true;
		while (error) {
			String choice = in.next();
			if (choice.equals("A") || choice.equals("a")) {
				glance();
				error = false;
			}
			else if (choice.equals("B") || choice.equals("b")) {
				guess();
				error = false;
			}
			else {
				System.out.println("Invalid input, enter again.");	
			}
		}
	}
	
	// 5 - glance path, game ender
	public void glance() {
		loading();
		System.out.println("Mr. " + tName + ": What are you doing, " + name + "??");
		sleep(300);
		System.out.println("\n **The teacher takes your test, gives you a zero and sends you to the office.**");
		gameover();
	}
	
	// 5 - guess path, game ender
	public void guess() {
		loading();
		System.out.println("\n **You get your grade back and it's a 50. You ended up getting the question wrong.**"
						 + "\n **You're now failing the class as it was a major assessment.**");
		gameover();
	}
	
	// 4 - study path, leads to high or not
	public void study() {
		loading(".", 300);
		System.out.println("\n **You're taking the test, and come up to a 20-point question. Your have to pick one answer.**"
						 + "\n **If you get his question right, it nearly guarantees you high honor roll for the year as it's the only class you currently have an A- in.**"
						 + "\n **What answer do you pick?**");
		
		sleep(300);
		System.out.println("\nA - First Answer" + "\nB - Second Answer" + "\nC - Third Answer");
		
		error = true;
		while (error) {
			String choice = in.next();
			if (choice.equals("A") || choice.equals("a")) || choice.equals("C") || choice.equals("c")) {
				not();
				error = false;
			}
			else if (choice.equals("B") || choice.equals("b")) {
				high();
				error = false;
			}
			else {
				System.out.println("Invalid input, enter again.");	
			}
		}
	}
	
	// 5 - high path, game ender
	public void high() {
		System.out.println("Congrats, you got high honors!");
		winner();
	}
	
	// 5 - not path, game ender
	public void not() {
		System.out.println("Sorry, you didn't get high honors...");
		gameover();
	}
	
	// 3 - egg path, leads to cl or hs
	public void egg() {
		System.out.println("Chef: 'Alright, here you go.'");
		sleep(150);
		loading("CHOMP", 150);
		sleep(300);
		System.out.println(" **After eating the eggs, you quickly realize that you don't feel so good, but try to carry on regardless.**");
		sleep(300);
		System.out.println(" **Few minutes later and you realize that you still feel nauseous. You have class in a few minutes and need to make a decision:**");
		sleep(300);
		System.out.println("A - Go to class anyway" + "\nB - Go to health services");
		
		error = true;
		while (error) {
			String choice = in.next();
			if (choice.equals("A") || choice.equals("a")) {
				cl();
				error = false;
			}
			else if (choice.equals("B") || choice.equals("b")) {
				hs();
				error = false;
			}
			else {
				System.out.println("Invalid input, enter again.");	
			}
		}
	}
	
	
	// 4 - cl path, game ender
	
	// 4 - cl path, game ender
	public void cl() {
		System.out.println(" **You have to take a test in chemistry today. Halfway through, as your trying to answer a question, you throw up.**");
		sleep(300);
		System.out.println(" **You immediately go to health services, who tell you that you have food poisoning, which means you have to go to the hospital ASAP.**");
		sleep(300);
		gameover();
	}
	
	// 4 - hs path, leads to lay or study (4)
	
	// 4 - hs path, leads to lay or study
	public void hs() {
		System.out.println(" **You go to health services, who let you know it's only a stomach bug and give medicine to help alleviate pain.");
		sleep(300);
		System.out.println("\nNurse: Alright honey, do you want to lay down in health services for a bit or head back to class now?");
		sleep(300);
		System.out.println("\nA - Lay down in health services" + "\nB - Head back to class");
		
		error = true;
		while (error) {
			String choice = in.next();
			if (choice.equals("A") || choice.equals("a")) {
				lay();
				error = false;
			}
			else if (choice.equals("B") || choice.equals("b")) {
				study();
				error = false;
			}
			else {
				System.out.println("Invalid input, enter again.");	
			}
		}
	}

	// 5 - lay path, game ender
	
	// 5 - lay path, game ender
	public void lay() {
		System.out.println("\n **Later that day your hardo teacher is upset about how you missed class. After health services told him that you were indeed fine after taking medicine, he took it upon himself to report it as an absence.**"
						 + "\n **It is now your 8th one and you're going to be sent home.**");
		gameover();
	}
		
	// 3 - cereal path, game ender
	public void cereal() {
		System.out.println("Chef: 'Over there please.'");
		sleep(300);
		System.out.println("\n **As you walk over to where the cereal are, you slip on grease on the floor and fall headfirst.**");
		gameover();
		
	}
	
	// 2 - bed path, leads to truth or excuse
	
	// 2 - bed path, leads to truth or excuse
	public void bed() {
		loading("Z...", 200);
		loading("BEEP! ", 400);
		
		System.out.println("\n **You wake up to the sound of your alarm, in shock as the time on your phone says 11am.**");
		sleep(500);
		System.out.println("\n **It's nearly midday and you've missed more than half of your classes for the day...not a good look considering it's the 8th time.**");
		sleep(500);
		System.out.println("\n **Ms. LaFreniere emailed you to come to her office ASAP. You now have to make a decision:**");
		sleep(150);
		System.out.println("\nA - Tell her the truth" + "\nB - Make an excuse");
		error = true;
		while (error) {
			String choice = in.next();
			if (choice.equals("A") || choice.equals("a")) {
				truth();
				error = false;
			}
			else if (choice.equals("B") || choice.equals("b")) {
				excuse();
				error = false;
			}
			else {
				System.out.println("Invalid input, enter again.");	
			}
		}
	}
	
	// 3 - truth path, game ender
	
	// 3 - truth path, game ender
	public void truth() {
		System.out.println("You: Sorry Ms. LaFreniere, I set my alarm too late.");
		sleep(300);
		System.out.println("\nMs. LaFreniere: " + name + ", I'm so sorry, but this is your 8th absence. \nI warned you last time that one more and we would have to ask you to leave the school...and I'm afraid I am going to have to do so right now.");
		sleep(300);
		System.out.println("\n **You were kicked out of school**");
		gameover();
	}
	
	// 3 - excuse path, game ender
	
	// 3 - excuse path, game ender
	public void excuse() {
		System.out.println("You: Hey Ms. LaFreniere, I was feeling very sick this morning...");
		sleep(300);
		System.out.println("\nMs. LaFreniere: "  + name + ", sick or not, this is your 8th absence. \nI warned you last time that one more and we would have to ask you to leave the school...and I'm afraid I am going to have to do so right now.");
		sleep(300);
		System.out.println("\n **You were kicked out of school**");
		gameover();
	}
	
	// 1 - highTemp path, leads to quarantineRoom or quarantineHealth
	
	// 1 - highTemp, leads to quarantineRoom or quarantineHealth
	public void highTemp() {
		System.out.println("Mr." + tName + ": Uh oh...you're temperature is pretty high...we could do one two things. \n"
				+ "A - Quarantine in your room for 2-4 days whilst you get tested and wait for the results \n" + "B - Do the same thing but in health services");
		
		error = true;
		while (error) {
			String choice = in.next();
			if (choice.equals("A") || choice.equals("a")) {
				quarantineRoom();
				error = false;
			}
			else if (choice.equals("B") || choice.equals("b")) {
				quarantineHealth();
				error = false;
			}
			else {
				System.out.println("Invalid input, enter again.");	
			}
		}
		
	}
	
	// 2 - quaratineRoom path, game ender

	// 2 - quaratineRoom path, game ender
	public void quarantineRoom() {
		System.out.println("\n **You get your test results back and you are positive for coronavirus. You are now being sent home.**");
		gameover();
	}
	
	// 2 -
	
	// 2 - quarantineHealth, game ender
	public void quarantineHealth() {
		System.out.println("\n **You get your test results back and you are positive for coronavirus. You are now being sent home.**");
		gameover();
	}
	
	public static void main(String args[]) {
		// starts game
		
		AdventureProject run = new AdventureProject();
		
		run.intro();
		
		
	}
	
}
