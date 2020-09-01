package com.airplanes.reservations;

import static org.junit.Assert.*;

import org.junit.Test;

public class TicketTest {

	@Test
	public void testSetPassenger() {
		 Ticket testTicket1 = new Ticket();
		 Passenger testPassenger1 = new Passenger("Boby");
		 testTicket1.setPassenger(testPassenger1);
		 assertEquals("Boby", testTicket1.getPassenger().getName());
		 
	}
	
	@Test
	public void testSetFlight() {
		Ticket testTicket2 = new Ticket();
		Flight testFlight1 = new Flight();
		testTicket2.setFlight(testFlight1);
		assertEquals("Unknown Departure City", testTicket2.getFlight().getDepartureCity());
		assertEquals("Unknown Arrival City", testTicket2.getFlight().getArrivalCity());
		assertEquals(100, testTicket2.getFlight().getFlightNumber());
		
	}
	
	@Test
	public void testSetSeat() {
		Ticket testTicket3 = new Ticket();
	    Seat testSeat3 = new Seat();
	    testTicket3.setSeat(testSeat3);
		assertEquals(10, testTicket3.getSeat().getSeatNumber());

		
	}
	@Test
	public void testToString() {
		Ticket testTicket4 = new Ticket();
		 Passenger testPassenger0 = new Passenger("Boby");
		Flight testFlight0 = new Flight(100, "London", "Paris");
	    Seat testSeat0 = new Seat(9);
	    testTicket4.setPassenger(testPassenger0);
	    testTicket4.setFlight(testFlight0);
	    testTicket4.setSeat(testSeat0);
	    String testString = "Ticket: Boby departing on flight 100 from London to Paris on 2020-08-31 in seat 9";
	    assertEquals(testString, testTicket4.toString());

	}

}
