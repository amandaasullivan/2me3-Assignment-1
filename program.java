package Reservation_classes;

import java.util.*;

public class program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner input = new Scanner(System.in);
		
		boolean repeat = true;
		
		while (repeat) {
			
			//get action
			System.out.println("What would you like to do today? Type the number associated with request. "
					+ "\n\t1. Create new car"
					+ "\n\t2. Create new vacation"
					+ " \n\t3. List items "
					+ "\n\t4. Cancel booking "
					+ "\n\t5. List bookings "
					+ "\n\tList bookings in the following format: \n\t\t6. Booking ID \n\t\t7. Items in booking \n\t\t8. From-to \n\t\t9. Price "
					+ "\n\t10. Show revenue of the business");
			
			int action = input.nextInt();
			
			//create new item
			if (action == 1){
				
				System.out.println("Enter license plate: ");
				String license_plate = input.next();
				
				System.out.println("Enter license year: ");
				int license_year = input.nextInt();
				
				System.out.println("Enter license make: ");
				String make = input.next();
				
				System.out.println("Enter license number of doors: ");
				int num_doors = input.nextInt();
				
				//what if more than one car is made?? it would need a new name
				Car new_car = new Car(license_plate, license_year, make, num_doors,0);				
			}
			
			repeat = false;
			
				
		}
	}

}
