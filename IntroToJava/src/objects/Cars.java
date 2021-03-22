package objects;

public class Cars {
	private int currentYear = 2021;
	private String name;
	private int year;
	private double mileage;
	
	public Cars(String name, int year, double mileage) {
		this.name = name;
		this.year = year;
		this.mileage = mileage;
	}
	
	public String getName() {
		return this.name;
	}
	public int getYear() {
		return this.year;
	}
	public double getMileage() {
		return this.mileage;
	}
	
	public void drive(int distance) {
		this.mileage += distance;
	}
	public double appraisal() {
		return ((double)(currentYear - year) * mileage);
	}

}
