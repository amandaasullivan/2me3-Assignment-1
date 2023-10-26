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
		
		do {
			//main menu
			System.out.println("What would you like to do today? Type the number associated with request. "
					+ "\nClient Options"
					+ "\n--------------"
					+ "\n\t1. Enter user ID"
					+ "\nEmployee Options"
					+ "\n----------------"
					+ "\n\t2. Create a car"
					+ "\n\t3. Create a vacation"
				);
			int action = input.nextInt();
			
			//idk where to initialize there for now
			double price = 0.0;
			int booking_id = 0;
			int car_id = 0;
			int vacation_id;
			boolean exit = false;
			String carID = null;
			
			while (action == 1 && exit == false){ //enter user ID
					System.out.println("Enter a user ID:");
					String client_id = input.next();
					
					System.out.println(
							  "\n\t1. Rent a car"
							+ "\n\t2. Book a vacation"
							+ "\n\t3. Cancel a booking "
							+ "\n\t4. List bookings "
							+ "\n\t5. Check-out"
							+ "\n\t6. Exit to Main Menu");
					int userAction = input.nextInt();
					if (userAction == 1){ //rent a car
		 				System.out.println("List of cars: "); //prints the list of cars and corresponding info
						for (int i = 0; i < company.list_of_cars.size(); i ++) {
							System.out.println("\t" + company.list_of_cars.get(i).toString());
						}
						
						//referencing the license plate via arrayList
						System.out.println("Car ID:");
						carID = input.next();
						
						//searching for car via license plate
						for (int i = 0; i < company.list_of_cars.size(); i ++) {
						    if (String.valueOf(company.list_of_cars.get(i).getCar_id()).equals(carID)) {
						        System.out.println("Car found:");
						        System.out.println(company.list_of_cars.get(i));
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
								
								//ADDING TO BOOKING
								booking newBooking = new booking(startDate, endDate, booking_id, company.list_of_cars.get(i).getCar_id(), company.list_of_cars.get(i).getCar_Price());
								company.addBooking(newBooking);
						        break;
						    }
						}
						
						continue; //return to beginning of do-while loop
					}
					
		 			else if (userAction == 2){ //book a vacation
		 				
		 				System.out.println("List of vacations:"); //prints the list of vacations and corresponding info
						for (int i = 0; i < company.list_of_vacations.size(); i ++) {
							System.out.println("\t" + company.list_of_vacations.get(i).toString());
						}
						
						//referencing the city name via arrayList
						System.out.println("Vacation ID: ");
						String vacationID = input.next();
						
						//searching for car via license plate
						for (vacation availableVacations : company.list_of_vacations) {
						    if (availableVacations.getCity().equals(vacationID)) {
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
		 			else if (userAction == 3){ //CANCELLING A BOOKING
		 				
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
						    		continue;
						    	}
						    }
						}
						continue;
		 			}
		 			else if (userAction == 4) { //List bookings
		 				for (int i = 0; i < company.list_of_bookings.size(); i++) {
		 					System.out.println(company.list_of_bookings.get(i));
		 				}
		 				continue;
		 			}
					else if (userAction == 5) { //check-out ~ w/ Johanna's code
						if (company.list_of_bookings.isEmpty()){
							System.out.println("Your cart is empty"); 
							continue;
						}
						else if (0 == 0){
						//else {
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
						
						/////////////////////////////////
						//show revenue of business, maybe make this a method in company and just call it here
						else if (action == 11) {
						    double total = 0.0;
						    for (int i = 0; i < company.list_of_bookings.size(); i++) {
						    	total += company.list_of_bookings.get(i).getBooking_Price();
						    }
						}
						
						boolean found = false;
						for (int i = 0; i < company.list_of_cars.size(); i++) {
							if (String.valueOf(company.list_of_cars.get(i).getCar_id()).equals(carID)) {
								car c = company.list_of_cars.get(i);
								found = true;
							}
							
						}
						if (found == false) {
							for (int i = 0; i < company.list_of_cars.size(); i++) {
								if (String.valueOf(company.list_of_cars.get(i).getVacation_id()).equals(carID)) {
									car c = company.list_of_cars.get(i);
								}
							}
						}
						
						car a = car.list_of_bookings.get(i).getBooking_Price();
						
//						for (int i = 0; i < company.list_of_bookings.size(); i++) {
//							double a = company.list_of_bookings.get(i).getBooking_Price();
//							int e = company.list_of_bookings.get(i).getBooking_id();
//							booking b = company.list_of_bookings.get(i);
//							LocalDate c = company.list_of_bookings.get(i).getStart_date();
//							LocalDate d = company.list_of_bookings.get(i).getEnd_date();
//							String f = String.format("Product id: %1$d | Items: %1$s , Dates: %1$t - %1$t |"
//									+ " Price: %1$f ",d, b, c, d, a);
//							System.out.println(f);
//						}
							
						continue;
					}
					else if (userAction == 6 ) {
						exit = true;
					}		
				}
			
			if (action == 2) { //create a car
	            //part of company interface
				System.out.println("Booking ID:");
				booking_id = input.nextInt();	
				System.out.println("Car ID:");
				car_id = input.nextInt();	
				System.out.println("cost:");
				double cost = input.nextDouble();
				System.out.println("license plate:");
				String license_plate = input.next();
				System.out.println("year:");
				int year = input.nextInt();
				System.out.println("make:");
				String make = input.next();
				System.out.println("Number of doors:");
				int number_of_doors = input.nextInt();
				System.out.println("Number of doors:");
				price = input.nextDouble();
				
				//ADDING TO CARS
				car newCar = new car(license_plate, year, make, number_of_doors, price, car_id);
				company.addCar(newCar);
			}
			else if (action == 3) { //create a vacation
	            //part of company interface
				System.out.println("Booking ID:");
				booking_id = input.nextInt();	
				System.out.println("Vacation ID:");
				vacation_id = input.nextInt();	
				System.out.println("Country:");
				String country = input.next();
				System.out.println("City:");
				String city = input.next();
				System.out.println("Season:");
				String season = input.next();
				System.out.println("Price:");
				price = input.nextDouble();	
				
				vacation newVacation = new vacation (country, city, season, price, vacation_id);
				company.addVacation(newVacation);
			}
			else { //main menu 
				System.out.println("Not a valid option");
				continue;
			}
 				
		} while (repeat != false);
	}
}
