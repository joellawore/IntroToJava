import java.util.Scanner;
public class MoreLoops {
	static Scanner in = new Scanner(System.in);
	
	public void easy1(int n) {
		System.out.println("Guess a number:");
		int guess = in.nextInt();
		while (n != guess) {
			System.out.println("Incorrect, guess again:");
			guess = in.nextInt();
		}
		System.out.println("Congrats, you guessed the number!");
	}
	public void easy2() {
		System.out.println("Enter a number:");
		int n = in.nextInt();
		int i = 0 - n;
		while(i <= n) {
			System.out.println(i);
			i++;
		}
	}
	public void easy3() {
		System.out.println("Enter a number:");
		int n = in.nextInt();
		int i = 0;
		while(i <= n) {
			System.out.println("Hi ");
			i++;
		}
	}
	
	public void medium1() {
		System.out.println("Enter a number:");
		int n = in.nextInt();
		int i = n;
		while(i >= 1) {
			System.out.println(i + "*");
			i--;
		}
		System.out.println("1");
	}
	public void medium2() {
		System.out.println("Do you want to keep playing?");
		String a = in.next();
		while(a.equals("yes") || a.equals("Yes")) {
			System.out.println("Do you want to keep playing?");
			a = in.next();
		}
		System.out.println("Game Over");
	}
	public void medium3() {
		System.out.println("Enter a number:");
		int n = in.nextInt();
		int i = n;
		while(i >= 0) {
			if (n % i != 0)
				continue;
			System.out.println(i);
			i--;
		}
		System.out.println("1");
	}
	
	public void hard1() {
		System.out.println("Enter two numbers:");
		int a = in.nextInt();
		int b = in.nextInt();
		int i = Math.min(a, b);
		while(i >= 0) {
			if (a % i == 0 && b % i == 0) {
				System.out.println("The greatest common divisor is " + i + ".");
				break;
			}
			i--;
		}
	}
	public void hard2() {
		System.out.println("Enter two numbers:");
		int a = in.nextInt();
		int b = in.nextInt();
		int i = Math.max(a, b);
		while(i % a != 0 || i % b != 0) {
			i++;
		}
		System.out.println("The least common mulitple is " + i + ".");
	}
	public void hard3() {
		System.out.println("Enter a  number:");
		int a = in.nextInt();
		int i = a - 1;
		boolean prime = true;
	
		while(i >= 1) {
			if (a % i == 0)
				prime = false;
			i--;
		}
		
		if(prime) {
			System.out.println("This number is prime.");
		}
		else {
			System.out.println("This number is not prime.");
		}
		
	}	
	
	public void challenge() {
		
	}
	
	public static void main(String []args) {
		MoreLoops runner = new MoreLoops();
		
		boolean error = true;
		
		while (error) {
			System.out.println("Please press one of the following keys:"
					  + "\n e1 - easy1"
					  + "\n e2 - easy2"
					  + "\n e3 - easy3"
					  + "\n m1 - medium1"
					  + "\n m2 - medium2"
					  + "\n m3 - medium3"
					  + "\n h1 - hard1"
					  + "\n h2 - hard2"
					  + "\n h3 - hard3"
					  + "\n x - exit program");
			
			String key = in.next();
			
			if (key.equals("e1")) {
				runner.easy1(6);
			}
			else if (key.equals("e2")) {
				runner.easy2();
			}
			else if (key.equals("e3")) {
				runner.easy3();
			}
			else if (key.equals("m1")) {
				runner.medium1();
			}
			else if (key.equals("m2")) {
				runner.medium2();
			}
			else if (key.equals("m3")) {
				runner.medium3();
			}
			else if (key.equals("h1")) {
				runner.hard1();
			}
			else if (key.equals("h2")) {
				runner.hard2();
			}
			else if (key.equals("h3")) {
				runner.hard3();
			}
			else if (key.equals("x")) {
				error = false;
			}
			else {
				System.out.println("Invalid Response.");
			}
		}
	}
}
