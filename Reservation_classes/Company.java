package Reservation_classes;

import java.util.ArrayList;

public class Company {
	
	public ArrayList<Car> list_of_cars = new ArrayList<Car>();
	
	public ArrayList<Vacation> list_of_vacations;
	
	public ArrayList<Booking> list_of_bookings;
	
	public double revenue;
	
	

	
	public void addCar(Car new_car) {
		this.list_of_cars.add(new_car);
	}
	

	public void addVacation(Vacation new_vacation) {
		this.list_of_vacations.add(new_vacation);
	}
	

	public void addBooking(Booking new_booking) {
		this.list_of_bookings.add(new_booking);
	}
	

}
