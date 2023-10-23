package Reservation_classes;

public class Car {

	private String license_plate;

	private int year;

	private String make;

	private int number_of_doors;

	private double price;
	
	public Car(String license_plate, int year, String make, int number_of_doors, double price) {
		this.license_plate = license_plate;
		this.year = year;
		this.make = make;
		this.number_of_doors = number_of_doors;
		this.price = price;
	}

}
