package com.airplanes.reservations;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DatabaseTest {

	@Test
	void testDatabase() {
		 Database testDB = new Database();
		 assertEquals(0, testDB.getSeats().size());
		 assertEquals(0, testDB.getPassengers().size());
		 assertEquals(0, testDB.getFlights().size());
		 assertEquals(0, testDB.getTickets().size());
	}

	@Test
	public void testAddSeat() {
		Database testDB2 = new Database();
		testDB2.addSeat(2);
		assertEquals(1, testDB2.getSeats().size());
		assertEquals(2, testDB2.getSeats().get(0).getSeatNumber());
	}
	
	@Test
	public void testAddPassenger() {
		Database testDB3 = new Database();
		testDB3.addPassenger("Yudhi");
		assertEquals(1, testDB3.getPassengers().size());
		assertEquals("Yudhi", testDB3.getPassengers().get(0).getName());
	}
	
	@Test
	public void testAddNewPassenger() {
		Database testDB8 = new Database();
		boolean result1 = testDB8.addPassenger("Yudhi");
		assertEquals(false, result1);
		boolean result2 = testDB8.addPassenger("Yudhi");
		assertEquals(true, result2);
	}
	
	@Test
	public void testAddFlight() {
		Database testDB4 = new Database();
		testDB4.addFlight(100,"Kattegat", "London");
		assertEquals(1,testDB4.getFlights().size());
 	}
	
	@Test
	public void testBootstrap() {
		Database testDB7 =  new Database();
		testDB7.bootstrap();
		assertEquals(6, testDB7.getSeats().size());
		assertEquals(4, testDB7.getFlights().size());
	}
	
 
}
