/**
 * Database.java
 * @author Main
 * This is the database access layer for creating and modifying data in the application
 */
package com.airplanes.reservations;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Database {

	private ArrayList<Seat> seats;
	private ArrayList<Passenger> passengers;
	private ArrayList<Flight> flights;
	private ArrayList<Ticket> tickets;
	//create logger and Database.setLogging(). Initialise in Console.java and use it in Database.addTicketMethod()
	//get package and class name if class moves.
	private static Logger databaseLog = Logger.getLogger(Database.class.getName());
	//create handler
	private static ConsoleHandler logScreen = new ConsoleHandler();
	

	public Database() {
		seats = new ArrayList<Seat>();
		passengers = new ArrayList<Passenger>();
		flights = new ArrayList<Flight>();
		tickets = new ArrayList<Ticket>();
	}
	
	public void setLogging() {
		databaseLog.addHandler(logScreen);
		databaseLog.setLevel(Level.OFF); //receive all messages of fine and above
		logScreen.setLevel(Level.OFF); // changed to finer to use line 111 below. then off
		databaseLog.setUseParentHandlers(false);
	}

	public ArrayList<Seat> getSeats() {
		return seats;
	}

	public ArrayList<Passenger> getPassengers() {
		return passengers;
	}

	public ArrayList<Flight> getFlights() {
		return flights;
	}

	public ArrayList<Ticket> getTickets() {
		return tickets;
	}

	public void addSeat(int seatNumber) {
		 seats.add(new Seat(seatNumber));
		
	}
	
	//check if passenger exists before adding to the list.
	public boolean addPassenger(String passengerName) {
		boolean passengerExists = false;
		for(Passenger item: getPassengers()) {
			if(passengerName.equals(item.getName())){
				passengerExists = true;
			}
		}
		 if(passengerExists == false) {
			 passengers.add(new Passenger(passengerName));
		 }
		return passengerExists;
	}

	public void addFlight(int flightNumber, String departureCity, String arrivalCity) {
		 flights.add(new Flight(flightNumber, departureCity, arrivalCity));
		
	}
	
	//check for available seats
	public ArrayList<Seat> getOpenSeats(LocalDate departureDate, int flightNumber) {
		ArrayList<Seat> openSeats = getSeats();
		for(Ticket item: getTickets()) {
			if(departureDate.equals(item.getDepartureDate()) && flightNumber == item.getFlight().getFlightNumber()) {
				openSeats.remove(item.getSeat());
			}
		}
		return openSeats;
	}
	
	//add a ticket
	public String addTicket(LocalDate departureDate, String passengerName, int flightNumber, int seatNumber) {
		databaseLog.fine("Ticket creation initiated");
		//loop through and find passenger object
		Passenger ticketPassenger = null;
		for(Passenger item : getPassengers()) {
			if(passengerName.equals(item.getName())) {
				ticketPassenger = item;
			}
		}
		//find flight object
		Flight ticketFlight = null;
		for(Flight item: getFlights()) {
			databaseLog.finer("comparing "+flightNumber + " to flight "+item.getFlightNumber());
			if(flightNumber == item.getFlightNumber()) {
				ticketFlight = item;
			}
		}
		
		//find seat object
		Seat ticketSeat = null;
		for(Seat item : getSeats()) {
			if(seatNumber == item.getSeatNumber()) {
				ticketSeat = item;
			}
		}
		
		//create a ticket object
		Ticket tempTicket = new Ticket();
		tempTicket.setDepartureDate(departureDate);
		tempTicket.setPassenger(ticketPassenger);
		tempTicket.setFlight(ticketFlight);
		tempTicket.setSeat(ticketSeat);
		tickets.add(tempTicket);
		//
		databaseLog.info("Ticket created");
		
		return tempTicket.toString();
	}
	
	// Use external file for larger db
	public void bootstrap() {
		addSeat(1);
		addSeat(2);
		addSeat(3);
		addSeat(4);
		addSeat(5);
		addSeat(6);
		
		addFlight(1000, "Los Angeles", "Chicago");
		addFlight(1010, "Chicago", "New York");
		addFlight(2000, "New York", "Chicago");
		addFlight(2010, "Chicago", "New York");
		
	}
	
	//read flights information from csv file
	public void  bootStrapCSV() {
		try {
			BufferedReader flightImport = new BufferedReader(new FileReader("/Users/Main/git/FlightReservations/FlightReservations/import/flights.csv"));
			String flightLine = null;
			try {
				while((flightLine = flightImport.readLine()) != null) {
					System.out.println("Each Line: "+ flightLine);
				}
			} catch (IOException e1) {
				System.out.println("Cannot read file.");
			}
			try {
				flightImport.close();
			} catch (IOException e) {
				System.out.println("Cannot close file");
			}
		} catch (FileNotFoundException e) {
			System.out.println("File not found!");
		}
	}
	//export data to file
	public void exportSeats() {
		
		try {
			BufferedWriter seatsExport = new BufferedWriter(new FileWriter("/Users/Main/git/FlightReservations/FlightReservations/export/seats.csv"));
			for( Seat item: getSeats()) {
				seatsExport.write(item.toString() +"\n");
			}
			seatsExport.close();
			System.out.println("File Exported.");
		} catch (IOException e) {
			System.out.println("Cannot write to file");
		}  

		
	}

}
