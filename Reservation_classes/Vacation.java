package Reservation_classes;

public class Vacation {

	private String country;

	private String city;

	private String season;

	private double price;
	
	public Vacation(String country, String city, String season, double price) {
		this.country = country;
		this.city = city;
		this.season = season;
	}
	
	public String toString() {
		return "country: " + this.country + "\tcity: " + this.city + "\tseason " + this.season + "\tprice: " + this.price;
	}

}
