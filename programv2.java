import java.util.*;
import java.lang.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class program {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		company company = new company();
		boolean repeat = true;
		
		System.out.println("Enter a user ID");
		String userID = input.next(); //stored in client class
		
		//these new lists i made are irrelevant
		//list of current bookings
		List bookings = new ArrayList(); //list_of_bookings input is client interface
		for (int i = 0; i < company.list_of_bookings.size(); i ++) {
			bookings.add("\t" + company.list_of_bookings.get(i).toString());
		}
		
		//reference to: public ArrayList<car> list_of_cars = new ArrayList<car>();
		//list of cars available
		List cars_available = new ArrayList (); //list_of_cars input is company interface
		for (int i = 0; i < company.list_of_cars.size(); i ++) {
			cars_available.add("\t" + company.list_of_cars.get(i).toString());
		}
		
		do {
			//main menu
			System.out.println("What would you like to do today? Type the number associated with request. "
					+ "\n\t1. Rent a car"
					+ "\n\t2. Book a vacation"
					+ "\n\t3. Cancel a booking "
					+ "\n\t4. List bookings "
					+ "\n\t5. Check-out"
				);
			int action = input.nextInt();
			
			if (action == 1){ //rent a car
 				System.out.println("List of cars: "); //prints the list of cars and corresponding info
				for (int i = 0; i < company.list_of_cars.size(); i ++) {
					System.out.println("\t" + company.list_of_cars.get(i).toString());
				}
				
				//referencing the license plate via arrayList
				System.out.println("License plate:");
				String plate = input.next();
				
				//searching for car via license plate
				for (int i = 0; i < company.list_of_cars.size(); i ++) {
				    if (company.list_of_cars.get(i).getLicense_plate().equals(plate)) {
				        System.out.println("Car found:");
				        System.out.println(company.list_of_cars.get(i));
				        break;
				    }
				}
				
				//BOOKING INPUT
				//time formatter - should make a formatter method
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				//part of client interface 
				System.out.println("Start-date for rental (yyyy-MM-dd): ");
				String start_date = input.next();
	            LocalDate startDate = LocalDate.parse(start_date, formatter);
				System.out.println("End-date for rental (yyyy-MM-dd): ");
				String end_date = input.next();
	            LocalDate endDate = LocalDate.parse(end_date, formatter);
	            System.out.println("This date is not (yyyy-MM-dd)");
	            //part of company interface
				System.out.println("Booking id:");
				int booking_id = input.nextInt();	
				System.out.println("Product id:");
				String car_id = input.next();	
				System.out.println("cost:");
				double cost = input.nextDouble();
				System.out.println("license plate:");
				String license_plate = input.next();
				System.out.println("year:");
				String year = input.next();
				System.out.println("make:");
				String make = input.next();
				System.out.println("Number of doors:");
				int number_of_doors = input.nextInt();
				
				//ADDING TO BOOKING
				booking newBooking = new booking(startDate, endDate, booking_id, car_id, cost);
				company.addBooking(newBooking);
				
				continue; //return to beginning of do-while loop
			}
			
 			else if (action == 2){ //book a vacation
 				
 				System.out.println("List of vacations:"); //prints the list of vacations and corresponding info
				for (int i = 0; i < company.list_of_vacations.size(); i ++) {
					System.out.println("\t" + company.list_of_vacations.get(i).toString());
				}
				
				//referencing the city name via arrayList
				System.out.println("City: ");
				String city = input.next();
				
				//searching for car via license plate
				for (vacation availableVacations : company.list_of_vacations) {
				    if (availableVacations.getCity().equals(city)) {
				        System.out.println("City found:");
				        System.out.println(availableVacations.toString());
				        continue; //is break better?
				    }
				}
				
				//BOOKING INPUT
				//part of client interface (also refer to Amanada's code)
 				System.out.println("Start-date of vacation: ");
				String start_date = input.next();
				System.out.println("End-date of vacation: ");
				String end_date = input.next();
				//part of company interface
				// ... 
				continue;
 			}
 			else if (action == 3){ //CANCELLING A BOOKING
 				
 				System.out.println("List of bookings:"); //prints the list of bookings and corresponding info
				for (int i = 0; i < company.list_of_bookings.size(); i ++) {
					System.out.println("\t" + company.list_of_bookings.get(i).toString());
				}
				
 				System.out.println("Enter booking ID you want to "
 						+ "cancel or type EXIT to return to Main "
 						+ "Menu");
 				String book = input.next();
 				
				//searching for booking via booking ID
				for (int i = 0; i < company.list_of_bookings.size(); i++) {
				    if (String.valueOf(company.list_of_bookings.get(i).getBooking_id()).equals(book)) {
				        System.out.println("Booking found:");
				        System.out.println(company.list_of_bookings.get(i));
				        company.list_of_bookings.remove(i);
				        continue;
				    }
				    else {
				    	if (book.equals("EXIT")){
				    		continue;
				    	}
				    	else {
				    		System.out.println("That is not a valid input");
				    	}
				    }
				}
				
				System.out.println("Enter Y to confirm cancellation or N to discontinue: ");
				String remove = input.next();
				
				if (remove.equals("Y")) {
						//remove booking from bookings list
				}
				else if (remove.equals("N")) {
						//return to main menu
				}
				else {
					System.out.println("That is not a valid input");
				}
				continue;
 			}
 			else if (action == 4) { //List bookings
 				for (int i = 0; i < bookings.size(); i++) {
 					System.out.println(bookings.get(i));
 				}
 				continue;
 			}
			else if (action == 5) { //check-out
				if (bookings.isEmpty()){
					System.out.println("Your cart is empty"); 
					continue;
				}
				
				else {
					System.out.println("Which membership do you have? \n1. Regular \n2. "
							+ "Silver \n3. Gold \n Enter a number option");
					int membership = input.nextInt();
					
					//implement discounts to total cost
					
					//after calculating everything
					System.out.println("Your Bookings:");
					System.out.println(company.list_of_bookings);
					System.out.println("Your total cost is:");
					System.out.println("*cost* with *membership* applied");
				}
			}
			else { //main menu 
				System.out.println("Not a valid option");
				continue;
			}
 				
		} while (repeat != false);
	}
}
