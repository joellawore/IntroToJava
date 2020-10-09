import java.util.Scanner;

public class HumanMethods {
	
	Scanner in = new Scanner(System.in);
	
	private int age;
	private char gender;
	private boolean suffrage;
	private boolean TTvacineDue;
	
	public void setAge() {
		System.out.println("What is your age?");
		age = in.nextInt();
	}
	
	public void setGender(char a) {
		if (a == 'g' || a == 'b') {
			gender = a;
		}	
	}
	
	public void canVote() {
		suffrage = (age >= 18);
		System.out.println(suffrage);
	}
	
	public void tetanusDue() {
		TTvacineDue = (age % 4 == 0);
		System.out.println(TTvacineDue);
	}
	
	public void toddler() {
		if (age < 4) {
			if (gender == 'b') {
				System.out.println("This toddler is a  boy.");
			}
			else {
				System.out.println("This toddler is a girl.");
			}		
		}
		else {
			System.out.println("This person is not a toddler.");
		}
	}
	
	public void movieDiscout() {
		System.out.println(age < 12 || age > 65);
	}
	
	public void teenager() {
		System.out.println(age >= 12 && age <= 18);
	}
	
	
	public static void main(String args[]) {
		
	}
}
