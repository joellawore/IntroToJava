package objects;
import java.util.Scanner;

public class BankAccount {
	static Scanner in = new Scanner(System.in);
	
	private String name;
	private double balance;
	
	public BankAccount(String name, double balance) {
		this.name = name;
		this.balance = balance;
	}
	public BankAccount(String name) {
		this.name = name;
		this.balance = 0;
	}

	public void deposit(double amount) {
		this.balance += amount;
	}
	public void withdraw(double amount) {
		this.balance -= amount;
	}
	
	public String getName() {
		return name;
	}
	public double getBalance() {
		return balance;
	}
	public String toString() {
		return "Name: " + name + "\nAccount Balance: " + balance;
	}
	public static void main(String[] args) {
		System.out.println("What is your name?");
		String name = in.next();
		
		BankAccount Account = new BankAccount(name);
		
		boolean running = true;
		
		while (running) {
			System.out.println("What would you like to do?"
					  + "\n 1 - Deposit"
					  + "\n 2 - Withdraw"
					  + "\n 3 - View Account Info"
					  + "\n x - Quit");
			String pressed = in.next();
			if (pressed.equals("1")) {
				System.out.println("Enter deposit amount:");
				double amount = in.nextDouble();
				Account.deposit(amount);
				System.out.println("Done.");
			}
			else if (pressed.equals("2")) {
				System.out.println("Enter withdrawal amount:");
				double amount = in.nextDouble();
				Account.withdraw(amount);
				System.out.println("Done.");
			}
			else if (pressed.equals("3")) {
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
