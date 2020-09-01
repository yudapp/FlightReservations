package com.airplanes.reservations;

import java.time.LocalDate;

public class Ticket {
	
	//fields
	private LocalDate departureDate;
	private Passenger passenger;
	private Flight flight;
	private Seat seat;
	
	//constructor
	public Ticket() {
		departureDate = LocalDate.now();
	}
	
	//toString method
	public String toString() {
		return "Ticket: "+getPassenger().getName()+
				" departing on flight "+getFlight().getFlightNumber()+
				" from "+getFlight().getDepartureCity()+
				" to "+getFlight().getArrivalCity()+
				" on "+ getDepartureDate()+" in seat "+
				getSeat().getSeatNumber();
	}

	//getters and setters
	public LocalDate getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(LocalDate departureDate) {
		this.departureDate = departureDate;
	}

	public Passenger getPassenger() {
		return passenger;
	}

	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	public Seat getSeat() {
		return seat;
	}

	public void setSeat(Seat seat) {
		this.seat = seat;
	}

}
