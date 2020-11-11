import java.util.Scanner;

public class ForLoops {

	static Scanner in = new Scanner(System.in);
	
	public void AtoZ() {
		char chr = 'A';
		while (chr <= 'Z') {
			System.out.println(chr + " ");
			chr++;
		}
	}
	
	public void sum(int x) {
		int s = 0;
		for (int i = 1; i <= x; i++) {
			s += i;
		}
		System.out.println(s);
	}
	
	public void riddle() {
		boolean error = true;
		
		System.out.println("What is so fragile that saying its name breaks it?"
				  			+ "\n Answer:");
		
		while (error) {
			
			String key = in.next();
			
			if ( key.equals("silence") || key.equals("Silence") ) {
				System.out.println("Right answer!");
				error = false;
			}
			else if (key.equals("x")) {
				error = false;
			}
			else {
				System.out.println("Incorrect. Try again:"
							+ "\n - enter 'x' to exit program");
			}
		}
	}
	
	public void multiplicationTable() {
		for (int a = 1; a <= 12; a++) {
			for (int b = 1; b <= 12; b++) {
				System.out.print(a*b + " ");
			}
			System.out.println();
		}
	}
	
	public void ifPrime(int a) {
		boolean prime = true;
		for (int c = a-1; c > 1; c--) {
			if (a % c == 0)
				prime = false;
		}
		if (prime)
			System.out.println(a);
	}
	public void primeNumbers(int x) {
		for (int i = 1; i <= x; i++) {
			ifPrime(i);
		}
	}
	
	public static void main(String args[]) {
		ForLoops run = new ForLoops();
		
		boolean go = true;
		
		while (go) {
			System.out.println("Please press one of the following keys:"
					  + "\n 1 - prints out all letters in the alphabet from A to Z."
					  + "\n 2 - prints out the sum of all numbers from 1 to x"
					  + "\n 3 - asks a riddle, continues untill guessed the solution."
					  + "\n 4 - prints out the multiplication table for 1-12."
					  + "\n 5 - prints out all prime numbers from 1 to x."
					  + "\n x - exit program");
			
			String key = in.next();
			
			if (key.equals("1")) {
				run.AtoZ();
			}
			else if (key.equals("2")) {
				System.out.println("Enter a number:");
				int x = in.nextInt();
				run.sum(x);
			}
			else if (key.equals("3")) {
				run.riddle();
			}
			else if (key.equals("4")) {
				run.multiplicationTable();
			}
			else if (key.equals("5")) {
				System.out.println("Enter a number:");
				int x = in.nextInt();
				run.primeNumbers(x);
			}
			else if (key.equals("x")) {
				go = false;
			}
			else {
				System.out.println("Invalid Response.");
			}
		}
	}
}
