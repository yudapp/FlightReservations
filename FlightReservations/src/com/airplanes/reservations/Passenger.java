package com.airplanes.reservations;
/**
 * Passenger.java
 * @author yudhi
 *
 */
public class Passenger {
	
	private String name; //passenger name
	
	//constructors
	public Passenger() {
		name = "unknown_name";
	}
	
	public Passenger(String name) {
		setName(name);
	}
	
	
	//overriding toString
	@Override
	public String toString() {
		return "Passenger: "+ this.getName();
		
	}
	//getters and setters
	public String getName(){
		return name;
	}
	
	public void setName(String pName){
		name = pName;
	}
}
