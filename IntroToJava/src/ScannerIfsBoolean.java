import java.util.Scanner;

public class ScannerIfsBoolean {
	public void check(double x) {
		if (x % 2.0 == 0.0) {
			System.out.println("This number is even.");
		}
		else if (x % 2.0 == 1.0) {
			System.out.println("This number is odd.");
		}
		else {
			System.out.println("This number is not a whole number.");
		}
	}
	public void factor(double a, double b) {
		if (b % a == 0) {
			System.out.println(a + " is a factor of " + b);
		}
		else {
			System.out.println(a + " is not a factor of " + b);
		}
	}
	public void range3(double a, double b) {
		if(3 >= Math.abs(a-b)) {
			System.out.println(b + " is within 3 of " + a);
		}
		else {
			System.out.println(b + " is not within 3 of " + a);
		}
		
	}
	public void starter() {
		boolean error = true;
		
		Scanner in = new Scanner(System.in);
		
		while (error) {
			
			System.out.println("\nPlease enter a number:");
			double x = in.nextDouble();
			
			System.out.println("Please press one of the following keys:"
					  + "\n s - square root"
					  + "\n e - check whether even, odd, or not whole number"
					  + "\n d - check with another number is a factor"
					  + "\n w - check if another number is within 3 "
					  + "\n x - exit program");
			
			String key = in.next();
			if (key.equals("s")) {
				System.out.println(Math.sqrt(x));
			}
			else if (key.equals("e")) {
				check(x);
			}
			else if (key.equals("d")) {
				System.out.println("Please enter a second number: ");
				double x2 = in.nextDouble();
				factor(x2, x);
			}
			else if (key.equals("w")) {
				System.out.println("Please enter a second number: ");
				double x2 = in.nextDouble();
				range3(x, x2);
			}
			else if (key.equals("x")) {
				error = false;
			}
			else {
				System.out.println("Invalid Response.");
			}
		}
	}
	
	public static void main(String args[]) {
		ScannerIfsBoolean run = new ScannerIfsBoolean();
		
		run.starter();
		
	}
}
