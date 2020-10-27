import java.util.Scanner;

public class WhileLoops {
	static Scanner in = new Scanner(System.in);
	
	public void between() {
		System.out.println("Enter the minimum:");
		int a = in.nextInt();
		
		System.out.println("Enter the maxiumum:");
		int b = in.nextInt();
		
		int i = Math.min(a, b);
		while (i <= Math.max(a, b)) {
			System.out.println(i);
			i++;
		}
	}
	
	public void first6() {
		System.out.println("Enter the coefficient:");
		double a = in.nextDouble();
		
		System.out.println("Enter the base:");
		double b = in.nextDouble();
		
		int x = 0;
		while (x <= 5) {
			System.out.println(a*Math.pow(b, x));
			x++;
		}
	}
	
	public void perfectsquare() {
		System.out.println("Enter a number:");
		int a = in.nextInt();
		
		int i = 1;
		while (i <= a) {
			if ((i*i)==a) {
				System.out.println("The square root of " + a + " is " + i + ".");
				break;
			}
			i++;
		}
		
		if (i*i != a) {
			System.out.println("There is no square root.");
		}
	}
	
	public static void main(String []args) {
		WhileLoops runner = new WhileLoops();
		
		boolean error = true;
		
		while (error) {
			System.out.println("Please press one of the following keys:"
					  + "\n b - prints numbers between two inputs"
					  + "\n f - prints first 6 terms of exponential sequence"
					  + "\n p - prints out the square root of perfect squares"
					  + "\n x - exit program");
			
			String key = in.next();
			
			if (key.equals("b")) {
				runner.between();
			}
			else if (key.equals("f")) {
				runner.first6();
			}
			else if (key.equals("p")) {
				runner.perfectsquare();
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