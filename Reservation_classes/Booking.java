package Reservation_classes;

import java.time.LocalDate;
import java.util.ArrayList;

public class Booking {

	//attributes
	private LocalDate start_date;

	private LocalDate end_date;

	private int booking_id;
	
	private  ArrayList<Integer> product_ids = new ArrayList<Integer>();
	
	private double cost;


	
	
	//constructor
	public Booking (LocalDate start_date, LocalDate end_date, int booking_id, double cost, ArrayList<Integer> product_ids) {
		this.start_date = start_date;
		this.end_date = end_date;
		this.booking_id = booking_id;
		this.product_ids = product_ids;
		this.cost =  cost;
	}
	
	public int getBookingID() {
		return this.booking_id;
	}
	
	public String getStartDate() {
		return this.start_date.toString();
	}
	
	public String getEndDate() {
		return this.end_date.toString();
	}
	
	public double getCost() {
		return this.cost;
	}
	
	public ArrayList<Integer> getProductIDs() {
		return this.product_ids;
		
	}
	public String toString () {
		return "start date: " + this.start_date.toString() + "\tend date: " + this.end_date.toString() + "\tbooking ID: " + this.booking_id + "\tproduct ID: " + this.product_ids.toString();
	}
	
	
	

}
