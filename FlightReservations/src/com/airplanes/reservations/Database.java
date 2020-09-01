/**
 * Database.java
 * @author Main
 * This is the access layer for creating and modifying data in the application
 */
package com.airplanes.reservations;

import java.util.ArrayList;

public class Database {

	private ArrayList<Seat> seats;
	private ArrayList<Passenger> passengers;
	private ArrayList<Flight> flights;
	private ArrayList<Ticket> tickets;

	public Database() {
		seats = new ArrayList<Seat>();
		passengers = new ArrayList<Passenger>();
		flights = new ArrayList<Flight>();
		tickets = new ArrayList<Ticket>();
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

}
