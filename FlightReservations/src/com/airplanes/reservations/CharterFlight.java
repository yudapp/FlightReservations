/**
 * CharterFlight.java
 * A subclass that extends the Flight class
 * @author Yudhi
 */
package com.airplanes.reservations;

import java.time.LocalDateTime;

public class CharterFlight extends Flight {
	
	//field
	private LocalDateTime departureDateTime;

	//constructor
	public CharterFlight(int flightNumber, String departureCity, String arrivalCity, String departureDateTime) {
	super(flightNumber, departureCity, arrivalCity);
	setDepartureDateTime(departureDateTime);
	}
	
	
	public LocalDateTime getDepartureDateTime() {
		return departureDateTime;
	}

	public void setDepartureDateTime(String departureDateTime) {
		this.departureDateTime = LocalDateTime.parse(departureDateTime);
	}
	
	
	public String toString() {
		return this.getFlightNumber()+" "+this.getDepartureCity()+" - "+this.getArrivalCity()+" departing "+this.getDepartureDateTime().toLocalDate()
				+" at "+this.getDepartureDateTime().toLocalTime();
	}

}
