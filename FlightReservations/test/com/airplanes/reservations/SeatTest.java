package com.airplanes.reservations;


import static org.junit.Assert.*;

import org.junit.Test;


public class SeatTest {

	@Test
	public void test() {
		 Seat testSeat = new Seat();
		 assertEquals(10,testSeat.getSeatNumber());
	}
	
	@Test
	public void testSetSeatNumber() {
		Seat testSeat2 = new Seat();
		testSeat2.setSeatNumber(14);
		assertEquals(14, testSeat2.getSeatNumber());
	}

}
