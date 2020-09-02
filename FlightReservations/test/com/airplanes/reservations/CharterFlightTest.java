package com.airplanes.reservations;

import static org.junit.Assert.*;

import org.junit.Test;

public class CharterFlightTest {

	@Test
	public void testCharterFlight() {
		CharterFlight charter1 = new CharterFlight(6010, "San Diego", "San Francisco", "2016-07-15T09:30");
		assertEquals(6010, charter1.getFlightNumber());
		assertEquals("2016-07-15T09:30", charter1.getDepartureDateTime().toString());
		
	}

}
