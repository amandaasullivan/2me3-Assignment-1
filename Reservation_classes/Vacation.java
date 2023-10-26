package Reservation_classes;

public class Vacation {

	private String country;

	private String city;

	private String season;

	private double price;
	
	private int vacation_id;
	
	public Vacation(String country, String city, String season, double price, int vacation_id) {
		this.country = country;
		this.city = city;
		this.season = season;
	}
	
	public int getVacationID() {
		return this.vacation_id;
	}
	
	public double getPrice() {
		return this.price;
	}
	
	public String toString() {
		return "country: " + this.country + "\tcity: " + this.city + "\tseason " + this.season + "\tprice: " + this.price + "\tid: " + vacation_id;
	}

}
