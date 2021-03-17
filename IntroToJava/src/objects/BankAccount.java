package objects;
import java.util.Scanner;

public class BankAccount {
	static Scanner in = new Scanner(System.in);
	
	private String name;
	private int balance;
	private double interestRate;
	
	public BankAccount(String name, int balance, double interestRate) {
		this.name = name;
		this.balance = balance;
		this.interestRate = interestRate;
	}
	public BankAccount(String name, double interestRate) {
		this.name = name;
		this.balance = 0;
		this.interestRate = interestRate;
	}

	public void deposit(int amount) {
		this.balance += amount;
	}
	public void withdraw(int amount) {
		this.balance -= amount;
	}
	public void addInterest() {
		this.balance *= (1+interestRate);
	}
	public String toString() {
		return "Name: " + name + "\nAccount Balance: " + balance + "\nInterest Rate: " + interestRate;
	}
	public static void main(String[] args) {
		System.out.println("What is your name?");
		String name = in.next();
		System.out.println("What is your interest rate?");
		
		double interestRate = in.nextDouble();
		BankAccount Account = new BankAccount(name, interestRate);
		
		boolean running = true;
		
		while (running) {
			System.out.println("What would you like to do?"
					  + "\n 1 - Deposit"
					  + "\n 2 - Withdraw"
					  + "\n 3 - Add Interest"
					  + "\n 4 - View Account Info"
					  + "\n x - Quit");
			String pressed = in.next();
			if (pressed.equals("1")) {
				System.out.println("Enter deposit amount:");
				int amount = in.nextInt();
				Account.deposit(amount);
				System.out.println("Done.");
			}
			else if (pressed.equals("2")) {
				System.out.println("Enter withdrawal amount:");
				int amount = in.nextInt();
				Account.withdraw(amount);
				System.out.println("Done.");
			}
			else if (pressed.equals("3")) {
				Account.addInterest();
				System.out.println("Done.");
			}
			else if (pressed.equals("4")) {
				System.out.println(Account);
			}
			else if (pressed.equals("x")) {
				running = false;
			}
			else {
				System.out.println("Invalid Response.");
			}
		}
	}
}
