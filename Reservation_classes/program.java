package Reservation_classes;

import java.util.*;
import java.util.ArrayList;
import java.time.LocalDate;

public class program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner input = new Scanner(System.in);
		
		
		//create company object
		Company company = new Company();
		
		//booking ID generator
		int booking_id = 1000;
		
		//car ID generator (all car IDs will be odd)
		int car_id = 1;
				
		//vacation ID generator (all vacation IDs will be even)
		int vacation_id = 0;
		
		
		
		//REPL program
		boolean repeat = true;
		while (repeat) {
			
			//get action
			System.out.println("What would you like to do today? Type the number associated with request. "
					+ "\n\t1. Create new car"
					+ "\n\t2. Create new vacation"
					+ " \n\t3. List items "
					+ "\n\t4. Create new booking"
					+ "\n\t5. Cancel booking "
					+ "\n\t6. List bookings "
					+ "\n\tList bookings in the following format: \n\t\t7. Booking ID \n\t\t8. Items in booking \n\t\t9. From-to \n\t\t10. Price "
					+ "\n\t11. Show revenue of the business");
			
			int action = input.nextInt();
			
			
			
			//create new car in company
			if (action == 1){
				
				System.out.println("Enter license plate: ");
				String license_plate = input.next();
				
				System.out.println("Enter year: ");
				int year = input.nextInt();
				
				System.out.println("Enter make: ");
				String make = input.next();
				
				System.out.println("Enter number of doors: ");
				int num_doors = input.nextInt();
				
				System.out.println("Enter price: ");
				double price = input.nextDouble();
				
				Car new_car = new Car(license_plate, year, make, num_doors, price, car_id);
				
				//generate new car ID for the next car that is made
				car_id = car_id + 2;
				
				company.list_of_cars.add(new_car);
				
			}
			
			
			
			//create new vacation in company
			if (action == 2) {

				System.out.println("Enter country: ");
				String country = input.next();
				
				System.out.println("Enter city: ");
				String city = input.next();
				
				System.out.println("Enter season: ");
				String season = input.next();
				
				System.out.println("Enter price: ");
				double price = input.nextDouble();
				
				Vacation new_vacation = new Vacation(country, city, season, price, vacation_id); 
				
				//generate new vacation ID for the next vacation that is made
				vacation_id = vacation_id + 2;
				
				company.list_of_vacations.add(new_vacation);
				
			}
			
			
			
			if (action == 3) {
				
				System.out.println("List of cars:");
				
				for (int i = 0; i < company.list_of_cars.size(); i ++) {
					System.out.println("\t" + company.list_of_cars.get(i).toString());
				}
				
				System.out.println("List of vacations:");
				
				for (int i = 0; i < company.list_of_vacations.size(); i ++) {
					System.out.println("\t" + company.list_of_vacations.get(i).toString());
				}
			}
			
			
			
			if (action == 4) {
				
				//start date
				System.out.println("\nEnter year of start date (as an integer): ");
				int start_year = input.nextInt();
				System.out.println("\nEnter month of start date (as an integer): ");
				int start_month = input.nextInt();
				System.out.println("\nEnter day of start date (as an integer): ");
				int start_day = input.nextInt();
				LocalDate start_date = LocalDate.of(start_year, start_month, start_day);
				
				//end date
				System.out.println("\nEnter year of end date (as an integer): ");
				int end_year = input.nextInt();
				System.out.println("\nEnter month of end date (as an integer): ");
				int end_month = input.nextInt();
				System.out.println("\nEnter day of end date (as an integer): ");
				int end_day = input.nextInt();
				LocalDate end_date = LocalDate.of(end_year, end_month, end_day);
				
				//create user ID
				//**MAKE SURE IT DOESNT ALREADY EXIST
				System.out.println("\nNow, create your user id:");
				String client_id = input.next();
				
				//product ID
				System.out.println("\nNext, enter the product ID of the item you would like to book:");
				String product_id = input.next();
				
				//Generate booking ID
				booking_id = booking_id + 2;
				System.out.println("\nThank you, your booking id is:  " + booking_id);
				
				//Create new booking object and add it to the company's booking list
				Booking new_booking = new Booking (start_date, end_date, booking_id, product_id);
				company.list_of_bookings.add(new_booking);
				
				
			}
			
			if (action == 5) {
				
			}
			
			
			
			//list bookings
			if (action == 6) {
				
				System.out.println("List of bookings:");
				
				for (int i = 0; i < company.list_of_bookings.size(); i ++) {
					System.out.println("\t" + company.list_of_bookings.get(i).toString());
				}
			}
			
			
			
			//ask if user wants to continue
			System.out.println("\n\nType 'Y' if you would like to continue, 'N' if not");
			String cont = input.next();
			
			//** INCLUDE ERROR HANDLING 
			if (cont == "N") {
				repeat = false;
			}
			
				
		}
	}

}
