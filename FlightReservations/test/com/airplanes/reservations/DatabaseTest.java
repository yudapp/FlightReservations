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

}
