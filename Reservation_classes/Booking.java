package Reservation_classes;

import java.time.LocalDate;

public class Booking {

	//attributes
	private LocalDate start_date;

	private LocalDate end_date;

	private int booking_id;
	
	private String product_id;


	
	
	//constructor
	public Booking (LocalDate start_date, LocalDate end_date, int booking_id, String product_id ) {
		this.start_date = start_date;
		this.end_date = end_date;
		this.booking_id = booking_id;
		this.product_id = product_id;
	}
	
	public String toString () {
		return "start date: " + this.start_date.toString() + "\tend date: " + this.end_date.toString() + "\tbooking ID: " + booking_id + "\tproduct ID: " + product_id;
	}
	
	

}
