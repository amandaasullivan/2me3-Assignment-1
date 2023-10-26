package Reservation_classes;

import java.time.LocalDate;
import java.util.ArrayList;


public class Client implements MembershipDiscount {

	private int client_id;

	private String name;

	private LocalDate birthdate;

	private String contact_info;
	
	public ArrayList<Booking> client_list_of_bookings = new ArrayList<Booking>();

	private MembershipType membership;

	
	public Client(int client_id, String name, LocalDate birthdate, String contact_info, String membership) {
		
		this.client_id = client_id;
		this.name = name;
		this.birthdate = birthdate;
		this.contact_info = contact_info;
		
		if (membership == "R") {
			this.membership = MembershipType.Regular;
		}
		else if (membership == "S" ) {
			this.membership = MembershipType.Silver;
		}
		else {
			this.membership = MembershipType.Gold;
		}
	}

	/**
	 * @see Service Reservation Application.MembershipDiscount#apply_discount(Service Reservation Application.MembershipType, int)
	 */
	public double apply_discount(MembershipType membership, double cost) {
		if (membership == MembershipType.Regular) {
			return cost;
		}
		else if (membership == MembershipType.Silver) {
			return cost*0.9;
		}
		else {
			return cost*0.8;
		}
	}
		
	
	public void addBooking(Booking new_booking) {
		this.client_list_of_bookings.add(new_booking);
	}
	
	public ArrayList<Booking> get_client_list_of_bookings(){
		return this.client_list_of_bookings;
	}
	
	public MembershipType getMembership() {
		return this.membership;
	}
	

}
