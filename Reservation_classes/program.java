package Reservation_classes;

import java.util.*;
import java.util.ArrayList;

public class program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner input = new Scanner(System.in);
		
		
		//create company object
		Company company = new Company();
		
		
		
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
				
				Car new_car = new Car(license_plate, year, make, num_doors, price);
				
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
				
				Vacation new_vacation = new Vacation(country, city, season, price); 
				
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
