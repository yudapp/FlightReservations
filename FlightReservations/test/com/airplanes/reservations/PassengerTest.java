package com.airplanes.reservations;


import static org.junit.Assert.*;

import org.junit.Test;

public class PassengerTest {

	@Test
	public void testPassenger() {
		 Passenger p = new Passenger();
		 String result = p.getName();
		 assertEquals("unknown_name", result);
	}

	@Test
	public void testSetName() {
		Passenger p2 = new Passenger();
		p2.setName("testName");
		assertEquals("testName", p2.getName());
	}

}
