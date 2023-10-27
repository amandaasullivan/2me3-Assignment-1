package Service;

public class Bike {

	private String license_plate;

	private int year;

	private String make;

	private double price;
	
	private int bike_id;
	
	public Bike(String license_plate, int year, String make, double price, int bike_id) {
		this.license_plate = license_plate;
		this.year = year;
		this.make = make;
		this.price = price;
        this.bike_id = bike_id;
	}
	
	public String toString() {
		return "license plate: " + this.license_plate + "\tyear: " + this.year + "\tmake: " + this.make  + "\tprice: " + this.price + "\tid: " + bike_id;
	}
	
	public int getMotorcycleID (){
		return this.bike_id;
	}
    public int getBikeID (){
		return this.bike_id;
	}
	
	public double getPrice (){
		return this.price;
	}

}