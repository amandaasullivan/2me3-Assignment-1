package Reservation_classes;

public interface MembershipDiscount {

	public abstract double apply_discount(MembershipType membership, double cost);

}
