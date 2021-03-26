package objects;

import java.util.Scanner;

public class Deck {
	private Card[] deck;
	
	public Deck() {
		deck = new Card[52];
		int ind = 0;
		for (int i = 1; i <= 13; i++) {
			String s = "";
			for (int j = 0; j < 4; j++) {
				if (j == 0) {
					s = "clubs";
				}
				else if (j == 1) {
					s = "hearts";
				}
				else if (j == 2) {
					s = "diamonds";
				}
				else {
					s = "spades";
				}
				deck[ind] = new Card(s, i);
				ind++;
			}
		}
	}
	
	public String toString() {
		for (int i = 0; i < deck.length; i++) {
			return deck[i].toString() + "\n";
		}
		return "";
	}
	
	public void display() {
		for (int i = 0; i < deck.length; i++) {
			System.out.println(deck[i].toString());
		}
	}

	public Card getRandom() {
		return deck[(int)((Math.random() * 51 ) + 1)];
	}
	
	public Card[] getFirstN(int n) {
		Card[] deckFirstN = new Card[n];
		for (int i = 0; i < deckFirstN.length; i++) {
			deckFirstN[i] = deck[i];
		}
		return deckFirstN;
	}

	public void shuffle() {
		for (int i = 0; i < deck.length-1; i++) {
			int r = (int)((Math.random() * 51 ) + 1);
			Card temp = deck[i];
			deck[i] = deck[r];
			deck[r] = temp;
		}
	}

	public void sort() {
		for (int i = 0; i < deck.length-1; i++) {
			for (int j = i+1; j < deck.length; j++) {
				Card temp;
				if (deck[i].getNum() > deck[j].getNum())
				{
					temp = deck[i];
					deck[i] = deck[j];
					deck[j] = temp;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Deck deck = new Deck();
		while (true) {
			System.out.println("Type 'sort', 'shuffle', 'first', 'random', or 'quit'");
			String choice = in.next();
			switch (choice) {
			case ("sort"):
				deck.sort();
				deck.display();
				break;
			case("shuffle"):
				deck.shuffle();
				deck.display();
				break;
			case("first"): 
				System.out.println("Enter how many cards you want from the top");
				int n = in.nextInt();
				for (Card c: deck.getFirstN(n))
					c.print();
				break;
			case("random"):
				deck.getRandom().print();
				break;
			case("quit"):
				return;
			}
		}
	}
}
