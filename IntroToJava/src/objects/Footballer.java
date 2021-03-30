package objects;

public class Footballer {
	private String surname;
	private String foot;
	private double height;
	private boolean playing;

	public Footballer(String surname, String foot, double height, boolean playing) {
		this.surname = surname;
		this.foot = foot;
		this.height = height;
		this.playing = playing;
	}
	
	public String toString() {
		return surname +"\n"+ foot + " Footed\n" + height + " ft";
	}
	
	public String getSurname() {
		return surname;
	}
	
	public String getFoot() {
		return foot;
	}
	
	public double getHeight() {
		return height;
	}
	
	public void retire() {
		playing = false;
	}
}
