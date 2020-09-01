/**
 * Data class 
 * Seat.java
 * @author Yudhi
 */

package com.airplanes.reservations;

public class Seat {

	private int seatNumber;

	//constructors
	public Seat() {
		 seatNumber = 10; //maximum seats is 10, this will tell us if it is correctly set.
	}
	
	public Seat(int seatnumber) {
		this.seatNumber = seatnumber;
	}

	//toString method
	@Override
	public String toString() {
		return "Seat: " + getSeatNumber();
	}
	
	//getters and setters
	public int getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(int seatNumber) {
		this.seatNumber = seatNumber;
	}

}
