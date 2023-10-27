package Service;

import java.util.*;
import java.time.LocalDate;

public class program {
	static Scanner input = new Scanner(System.in);

	public static void errorInt(int x, String question){

		boolean c = false;
		while (!c){
			try {
				System.out.println(question);
				x = input.nextInt();
				c = true;
			}
			catch (InputMismatchException e){
				System.out.println("\nSorry, not a valid user ID\n");
				input.next();
			}
		}
	}
	public static void errorDouble(double x, String question){

		boolean c = false;
		while (!c){
			try {
				System.out.println(question);
				x = input.nextInt();
				c = true;
			}
			catch (InputMismatchException e){
				System.out.println("\nSorry, not a valid user ID\n");
				input.next();
			}
		}
	}
	public static void errorDate(double x, String question){

		boolean c = false;
		while (!c){
			try {
				System.out.println(question);
				x = input.nextInt();
				c = true;
			}
			catch (InputMismatchException e){
				System.out.println("\nSorry, not a valid user ID\n");
				input.next();
			}
		}
	}

	public static void main(String[] args) {

		//Scanner input = new Scanner(System.in);
		
		//create company object
		Company company = new Company();
		
		//booking ID generator
		int booking_id = 1000;
		
		//car ID generator (all car IDs will be odd)
		int car_id = 1;
				
		//vacation ID generator (all vacation IDs will be even)
		int vacation_id = 0;

		//motorcycle ID
		int bike_id = 500;

		//default client ID
		int client_id = 0;
		
		//REPL program
		boolean repeat = true;
		while (repeat) {
			
			//main menu
			System.out.println("\nWhat would you like to do today? Type the number associated with request. \n"
					+ "\nClient Options"
					+ "\n--------------"
					+ "\n\t1. Enter user ID"
					+ "\nEmployee Options"
					+ "\n----------------"
					+ "\n\t2. Create a car"
					+ "\n\t3. Create a vacation"
					+"\n\t4. Create a motorcyle"
					+ "\n\t5. List Company Bookings"
					+ "\n\t6. Review Company revenue"
					+ "\n\t-------------------------"
					+ "\n\t7. Exit"
				);
			int action = 0;
			try {
				action = input.nextInt();
			}

			catch (InputMismatchException e){
				System.out.println("\nSorry, not a valid input\n");
				input.next();
			}
		
			//enter user ID
			while (action == 1) {
				errorInt(client_id,"Create your user ID (as an integer that is not 0");
				System.out.println("Enter your name:");
				String name = input.next();
				System.out.println("\nEnter year of birthday (as an integer): ");
				int birth_year = input.nextInt();
				System.out.println("\nEnter month of birthday (as an integer): ");
				int birth_month = input.nextInt();
				System.out.println("\nEnter day of birthday date (as an integer): ");
				int birth_day = input.nextInt();
				LocalDate birthdate = LocalDate.of(birth_year, birth_month, birth_day);
				System.out.println("Enter your email address: ");
				String client_email = input.next();
				System.out.println("Do you have a Regular (R), Silver (S), Gold (G)");
				String client_membership = input.next();
				Client client = new Client(client_id, name, birthdate, client_email, client_membership);
	
	
				//client options
				System.out.println(
							"\n\t1. List items available for booking "
						+ "\n\t2. Create a booking "
						+ "\n\t3. Cancel a booking "
						+ "\n\t4. List bookings "
						+ "\n\t5. Exit to Main Menu");
				int userAction = 0;				
				try {
					userAction = input.nextInt();
				}
				catch (InputMismatchException e){
					System.out.println("\nSorry, not a valid input\n");
					input.next();
				}

				//list items available for booking
				if (userAction == 1) {
					
					System.out.println("List of cars:");
					for (int i = 0; i < company.list_of_cars.size(); i ++) {
						System.out.println("\t" + company.list_of_cars.get(i).toString());
					}
					
					System.out.println("List of vacations:");
					for (int i = 0; i < company.list_of_vacations.size(); i ++) {
						System.out.println("\t" + company.list_of_vacations.get(i).toString());
					}
				}
				
				//create a booking
				if (userAction == 2) {
					
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
					
					//product ID
					ArrayList<Integer> product_ids = new ArrayList<Integer>();
					double cost_of_booking = 0;
					System.out.println("Choose an options: \n1. car\n2. vacation\n3. motorcycle\n4. car and vacation"
					+ "\n5. car and motorcycle\n6. vacation and motorcycle\n7. car,vacation,and motorcycle");
					int booking_choice = input.nextInt();
					
					if (booking_choice == 1) {
						System.out.println("Enter the product ID of the car you would like to book:");
						int product_id = input.nextInt();
						product_ids.add(product_id);
						
						//get price of item based on product id
						for (int i = 0; i < company.list_of_cars.size(); i ++) {
							if(company.list_of_cars.get(i).getCarID() == product_id) {
								cost_of_booking = cost_of_booking + company.list_of_cars.get(i).getPrice();
							}
						}
					}
					else if (booking_choice == 2) {
						System.out.println("Enter the product ID of the vacation you would like to book:");
						int product_id = input.nextInt();
						product_ids.add(product_id);
						
						//get price of item based on product id
						for (int i = 0; i < company.list_of_vacations.size(); i ++) {
							if(company.list_of_vacations.get(i).getVacationID() == product_id) {
								cost_of_booking = cost_of_booking + company.list_of_vacations.get(i).getPrice();
							}
						}
					}
					else if (booking_choice == 3){ 
						System.out.println("Enter the product ID of the motorcycle you would like to book:");
						int product_id = input.nextInt();
						product_ids.add(product_id);
						
						//get price of item based on product id
						for (int i = 0; i < company.list_of_bikes.size(); i ++) {
							if(company.list_of_bikes.get(i).getBikeID() == product_id) {
								cost_of_booking = cost_of_booking + company.list_of_bikes.get(i).getPrice();
							}
						}
					}
					else if (booking_choice == 4){ 
						System.out.println("Enter the product ID of the car you would like to book:");
						int product_id = input.nextInt();
						product_ids.add(product_id);
						
						//get price of item based on product id
						for (int i = 0; i < company.list_of_cars.size(); i ++) {
							if(company.list_of_cars.get(i).getCarID() == product_id) {
								cost_of_booking = cost_of_booking + company.list_of_cars.get(i).getPrice();
							}
						}
						System.out.println("Enter the product ID of the vacation you would like to book:");
						int product_id2 = input.nextInt();
						product_ids.add(product_id2);
						
						//get price of item based on product id
						for (int i = 0; i < company.list_of_vacations.size(); i ++) {
							if(company.list_of_vacations.get(i).getVacationID() == product_id) {
								cost_of_booking = cost_of_booking + company.list_of_vacations.get(i).getPrice();
							}
						}
					}
					else if (booking_choice == 5){ 
						System.out.println("Enter the product ID of the car you would like to book:");
						int product_id = input.nextInt();
						product_ids.add(product_id);
						
						//get price of item based on product id
						for (int i = 0; i < company.list_of_cars.size(); i ++) {
							if(company.list_of_cars.get(i).getCarID() == product_id) {
								cost_of_booking = cost_of_booking + company.list_of_cars.get(i).getPrice();
							}
						}
						System.out.println("Enter the product ID of the motorcycle you would like to book:");
						int product_id2 = input.nextInt();
						product_ids.add(product_id2);
						
						//get price of item based on product id
						for (int i = 0; i < company.list_of_bikes.size(); i ++) {
							if(company.list_of_bikes.get(i).getBikeID() == product_id) {
								cost_of_booking = cost_of_booking + company.list_of_bikes.get(i).getPrice();
							}
						}
					}
					else if (booking_choice == 6){ 
						System.out.println("Enter the product ID of the vacation you would like to book:");
						int product_id = input.nextInt();
						product_ids.add(product_id);
						
						//get price of item based on product id
						for (int i = 0; i < company.list_of_vacations.size(); i ++) {
							if(company.list_of_vacations.get(i).getVacationID() == product_id) {
								cost_of_booking = cost_of_booking + company.list_of_vacations.get(i).getPrice();
							}
						}
						System.out.println("Enter the product ID of the motorcycle you would like to book:");
						int product_id2 = input.nextInt();
						product_ids.add(product_id2);
						
						//get price of item based on product id
						for (int i = 0; i < company.list_of_bikes.size(); i ++) {
							if(company.list_of_bikes.get(i).getBikeID() == product_id) {
								cost_of_booking = cost_of_booking + company.list_of_bikes.get(i).getPrice();
							}
						}
					}
					else if (booking_choice == 7){ 
						System.out.println("Enter the product ID of the car you would like to book:");
						int product_id = input.nextInt();
						product_ids.add(product_id);
						
						//get price of item based on product id
						for (int i = 0; i < company.list_of_cars.size(); i ++) {
							if(company.list_of_cars.get(i).getCarID() == product_id) {
								cost_of_booking = cost_of_booking + company.list_of_cars.get(i).getPrice();
							}
						}
						System.out.println("Enter the product ID of the vacation you would like to book:");
						int product_id2 = input.nextInt();
						product_ids.add(product_id2);
						
						//get price of item based on product id
						for (int i = 0; i < company.list_of_vacations.size(); i ++) {
							if(company.list_of_vacations.get(i).getVacationID() == product_id) {
								cost_of_booking = cost_of_booking + company.list_of_vacations.get(i).getPrice();
							}
						}
						System.out.println("Enter the product ID of the bike you would like to book:");
						int product_id3 = input.nextInt();
						product_ids.add(product_id3);
						
						//get price of item based on product id
						for (int i = 0; i < company.list_of_bikes.size(); i ++) {
							if(company.list_of_bikes.get(i).getBikeID() == product_id) {
								cost_of_booking = cost_of_booking + company.list_of_bikes.get(i).getPrice();
							}
						}						
					}
					
					//Apply membership discount to cost
					cost_of_booking = client.apply_discount(client.getMembership(), cost_of_booking);
					company.revenue +=  cost_of_booking;
					
					//Generate booking ID
					booking_id = booking_id + 2;
					System.out.println("\nThank you, your booking id is:  " + booking_id);
					
					//Create new booking object and add it to the company's and user's booking list
					Booking new_booking = new Booking (start_date, end_date, booking_id, cost_of_booking, product_ids);
					company.list_of_bookings.add(new_booking);
					client.client_list_of_bookings.add(new_booking);
				}
						
				//Cancel a booking
				if (userAction == 3) {
					
					if (client.get_client_list_of_bookings().isEmpty()){
						System.out.println("\nYou currently have no bookings\n");
					}
					else {
						//ask user for booking id
						System.out.println("\nEnter booking id of booking you wish to cancel: ");
						String book_id = input.next();
	
						for (int i = 0; i < company.list_of_bookings.size(); i++) {
							if (String.valueOf(company.list_of_bookings.get(i).getBookingID()).equals(book_id)) {
								System.out.println("Booking found and cancelled");
								company.list_of_bookings.remove(i);
							}
						}
					}	
				}
				
				//list user bookings
				if (userAction == 4) {
					if (client.get_client_list_of_bookings().isEmpty()){
						System.out.println("\nYou currently have no bookings\n");
					}
					else {
						String output = "";
		
						for (int i = 0; i < client.get_client_list_of_bookings().size(); i ++) {
							Booking current_book = client.get_client_list_of_bookings().get(i);
							
							String item = "";
							
							//* ADD MOTORCYCLE GET ITEM IMPLEMENTATION */
							//get item
							for (int j = 0; j < current_book.getProductIDs().size(); j ++){
								for (int k = 0; k < company.list_of_vacations.size(); k ++) {
									if (company.list_of_vacations.get(k).getVacationID() == current_book.getProductIDs().get(j) ) {
										item = item + "\t" + company.list_of_vacations.get(k).toString();
										break;
									}
								}
								for (int k = 0; k < company.list_of_cars.size(); k ++) {
									if (company.list_of_cars.get(k).getCarID() == current_book.getProductIDs().get(j) ) {
										item = item + "\t" + company.list_of_cars.get(k).toString();
										break;
									}
								}
								for (int k = 0; k < company.list_of_bikes.size(); k ++) {
									if (company.list_of_bikes.get(k).getBikeID() == current_book.getProductIDs().get(j) ) {
										item = item + "\t" + company.list_of_bikes.get(k).toString();
										break;
									}
								}																
							}
							
							//generate output
							output = output + "\n | BookingID: " + current_book.getBookingID() +  " | Items in booking: " + item 
							+  "| From " + current_book.getStartDate() + "to " + current_book.getEndDate() + " | Cost: $" + current_book.getCost() + "|";
							
						}
					}
				}
				
				//Exit to main menu
				if (userAction == 5) {
					//the following is considering, the next booking is done by a new client
					
					break;
				}

				else{
					System.out.println("\nSorry, that is not a valid option.\n");
					continue;
				}		
			}

			//create new car in company
			if (action == 2){
				
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
			if (action == 3) {

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

			//* CREATE MOTORCYCLE  */
			if (action == 4){

				System.out.println("Enter license plate: ");
				String license_plate = input.next();
				
				System.out.println("Enter year: ");
				int year = input.nextInt();
				
				System.out.println("Enter make: ");
				String make = input.next();
				
				System.out.println("Enter price: ");
				double price = input.nextDouble();
				
				Bike new_bike = new Bike(license_plate, year, make, price, bike_id);
				
				//generate new car ID for the next bike that is made
				bike_id = bike_id + 500;
				
				company.list_of_bikes.add(new_bike);
			}
			
			//list bookings
			if (action == 5) {
				
				System.out.println("List of bookings:");
				
				for (int i = 0; i < company.list_of_bookings.size(); i ++) {
					System.out.println("\t" + company.list_of_bookings.get(i).toString());
				}
			}
	
			//company revenue
			if (action == 6){
				System.out.println("Our Company's Revenue is:");
				System.out.println("$" + company.revenue);
			}

			//exit
			if (action == 7){
				System.out.println("Thank you for visiting our company!");
				repeat = false;
			}
			
			else { 
				continue;	
			}
		} 
	}
}
