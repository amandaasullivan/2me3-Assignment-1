package Service;
import java.util.ArrayList;

public class Company {
	
	public ArrayList<Car> list_of_cars = new ArrayList<Car>();
	
	public ArrayList<Vacation> list_of_vacations = new ArrayList<Vacation>();
	
	public ArrayList<Booking> list_of_bookings = new ArrayList<Booking>();

	public ArrayList<Bike> list_of_bikes = new ArrayList<Bike>();
	
	public double revenue;
	
	public void addCar(Car new_car) {
		this.list_of_cars.add(new_car);
	}

	public void addVacation(Vacation new_vacation) {
		this.list_of_vacations.add(new_vacation);
	}
		public void addBike(Bike new_bike) {
		this.list_of_bikes.add(new_bike);
	}

	public void addBooking(Booking new_booking) {
		this.list_of_bookings.add(new_booking);
	}
	
	public double getCostfromBookingID(int booking_id) {
		for (int i = 0; i < list_of_bookings.size(); i ++)
			if (list_of_bookings.get(i).getBookingID() == booking_id) {
				return list_of_bookings.get(i).getCost();
			}
		return 0;
	}
}