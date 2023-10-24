package Reservation_classes;

public class Car {

	private String license_plate;

	private int year;

	private String make;

	private int number_of_doors;

	private double price;
	
	private int car_id;
	
	public Car(String license_plate, int year, String make, int number_of_doors, double price, int car_id) {
		this.license_plate = license_plate;
		this.year = year;
		this.make = make;
		this.number_of_doors = number_of_doors;
		this.price = price;
	}
	
	public String toString() {
		return "license plate: " + this.license_plate + "\tyear: " + this.year + "\tmake: " + this.make + "\tnumber of doors: " + this.number_of_doors + "\tprice: " + this.price + "\tid: " + car_id;
	}
	

}
