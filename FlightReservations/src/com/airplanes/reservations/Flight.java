/**
 * Flight.java
 * @author YA
 * 
 */
package com.airplanes.reservations;

public class Flight {

	// Fields
	private String departureCity;
	private String arrivalCity;
	private int flightNumber;

	//Constructors
	public Flight() {
		departureCity = "Unknown Departure City";
		arrivalCity = "Unknown Arrival City";
		flightNumber = 100;
	}
	
	public Flight(int flightNumber, String departureCity, String arrivalCity) {
		this.flightNumber = flightNumber;
		this.departureCity = departureCity;
		this.arrivalCity = arrivalCity;
	}

	//toString method
	@Override
	public String toString() {
		return flightNumber+" "+departureCity+" "+arrivalCity;
	}
	//Getters and Setters
	public String getDepartureCity() {
		return departureCity;
	}

	public void setDepartureCity(String departureCity) {
		this.departureCity = departureCity;
	}

	public String getArrivalCity() {
		return arrivalCity;
	}

	public void setArrivalCity(String arrivalCity) {
		this.arrivalCity = arrivalCity;
	}

	public int getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(int flightNumber) {
		this.flightNumber = flightNumber;
	}

}
