/**
 * Console.java
 * @author Yudhi
 * Book a ticket: Run this class in the console or create a jar file to run in the terminal
 * TODO: implement methods to advise user when there is no more ticket left.
 */

package com.airplanes.reservations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.ArrayList;

  
public class Console {

	public static void main(String[] args) {
		// initialise database, console, loop and ask for passenger name (add to db), show flights and show available seats, create ticket and repeat.
		
		Database prodDB = new Database();
		prodDB.bootstrap();
		
		boolean always = true;
		BufferedReader screenInput = new BufferedReader(new InputStreamReader(System.in));
		String passengerName = null;
		int flightNumber = 0;
		int seatNumber = 0;
		LocalDate departureDate = LocalDate.now();
		
		while(always) {
			//ask passenger name and add
			System.out.print("Enter passenger: ");
			try {
				passengerName = screenInput.readLine();
			} catch (IOException e) {
				System.out.println("Oops something went wrong!" );
			}
			boolean result = prodDB.addPassenger(passengerName);
			if(result) {
				System.out.println("Welcome back "+passengerName);
			} else {
				System.out.println("Welcome "+passengerName);

			}
			
			//show flights and ask for flight
			System.out.println("\nHere are the available flights");
			 
			
			for(Flight item: prodDB.getFlights()) {
				System.out.println(item);
			}
			System.out.println("Enter the flight number to book");
			try {
				flightNumber = Integer.parseInt(screenInput.readLine().trim());
			} catch (IOException e) {
				System.out.println("Enter a flight number");
			} catch( NumberFormatException e) {
				System.out.println("You did not enter a number");
			}
			
			//check for seats
			System.out.println("\nAssuming you are flying today");
			System.out.println("Here are the avvailable seats on the flight: ");
			ArrayList<Seat> openSeats = prodDB.getOpenSeats(departureDate, flightNumber);
			for(int i = 0; i < openSeats.size(); i++) {
				if(i == openSeats.size() -1) {
					System.out.print(openSeats.get(i).getSeatNumber());
				} else {
					System.out.print(openSeats.get(i).getSeatNumber() +" , ");
				}
			}
			System.out.println("\nEnter the seat you want: ");
			try {
				seatNumber = Integer.parseInt(screenInput.readLine().trim());
			}catch (IOException e) {
				System.out.println("Enter a seat number");
			} catch( NumberFormatException e) {
				System.out.println("You did not enter a number");
			}
			
			//create ticket
			String ticketInfo = prodDB.addTicket(departureDate, passengerName, flightNumber, seatNumber);
			System.out.print("\nReservation Successful. The details are: ");
			System.out.print(ticketInfo +"\n");

 		}

	}

}
