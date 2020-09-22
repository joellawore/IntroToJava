
public class OperationsWorkSheet {
	
	private String numString = "";

	public void intToChar(int num) {
		System.out.println((char)num);
	}
	
	public void lastDigit(int num) {
		numString = Integer.toString(num);
		System.out.println(numString.substring(numString.length()-1));
	}
	
	public void intAverage(double num1, double num2) {
		System.out.println((num1+num2)/2);
	}
	
	public static void main(String args[]) {
		OperationsWorkSheet runner = new OperationsWorkSheet();
		runner.intToChar(74);
		runner.lastDigit(342352);
		runner.intAverage(5.0, 7.0);
	}
}
