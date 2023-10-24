package Reservation_classes;

import java.time.LocalDate;


public class Client implements MembershipDiscount {

	private int client_id;

	private String name;

	private LocalDate birthdate;

	private String contact_info;

	private MembershipType membership;


	/**
	 * @see Service Reservation Application.MembershipDiscount#apply_discount(Service Reservation Application.MembershipType, int)
	 */
	public void apply_discount(MembershipType membership, int cost) {

	}

}
