
public class simpleif {
/*  A method that takes as parameter an integer, and determines if it is positive. If positive, print "yes", otherwise print "no".
	A method that takes an integer as parameter, and determines if it is even or odd. (Use one of your 5 operators to do this easily)
	A method that takes a character as parameter, and determines if it is uppercase, lowercase, or neither. 
	A method that takes an integer as parameter, and determines if it is a multiple of 10.
	A method that takes three doubles as parameters, and prints out the biggest of the three (this is a maximum function). */
	
	private int d1;
	private double d2;
	public void checkPos(int a) {
		if (a > 0)
		{
			System.out.println("yes");
		}
		else {
			System.out.println("no");
		}
	}
	
	public void evenOrOdd(int a) {
		if (a % 2 == 1) {
			System.out.println("odd");
		}
		else {
			System.out.println("even");
		}
	}
	
	public void charCase(char a) {
		if (a >= 65 && a <= 90) {
			System.out.println("uppercase");
		}
		else if (a >= 97 && a <= 120) {
			System.out.println("lowercase");
		}
		else {
			System.out.println("neither");
		}
	}
	public void mult10(int a) {
		if (a % 10 == 0) {
			System.out.println("divisble");
		}
	}
	public void maximum(double a, double b, double c) {
		System.out.println(Math.max(Math.max(a, b), c));
	}
	
	public void wholeNum(double a) {
		d1 = (int)a;
		d2 = (double)d1;
		if (d2 == a) {
			System.out.println("Whole Number");
		}
		else {
			System.out.println("Not a Whole Number.");
		}
	}
	
	public static void main(String args[]) {
		simpleif test = new simpleif();
		
		test.maximum(3.0, 4.0, 5.0);
		test.wholeNum(3.0);
	}
}
