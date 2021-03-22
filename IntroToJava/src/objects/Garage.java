package objects;

public class Garage {
	private Cars[] vehicles;
	
	public Garage(int n) {
		vehicles = new Cars[n];
	}
	
	public void addCar(String name, int year, double mileage, int i) {
		vehicles[i] = new Cars(name, year, mileage);
	}

	public double garageValue() {
		int val = 0;
		for (Cars c : vehicles) {
			if (c != null) {
				val += c.appraisal();
			}
		}
		return val;
	}

	public double avgMileage() {
		double avg = 0;
		int count = 0;
		for (Cars c : vehicles) {
			if (c != null) {
				avg += c.getMileage();
				count++;
			}
		}
		avg /= count;
		return avg;
	}
	
	public static void main(String[] args) {
		Garage threeCar = new Garage(3);
		threeCar.addCar("Mercedes", 2004, 7461.3, 0);
		threeCar.addCar("Lamborghini", 2007, 10182.5, 1);
		threeCar.addCar("Telsa", 2018, 2734.2, 2);
		
		System.out.println("Garage Value: $" + threeCar.garageValue() + "\nAverage Garage Mileage: " + threeCar.avgMileage());
	}
}
