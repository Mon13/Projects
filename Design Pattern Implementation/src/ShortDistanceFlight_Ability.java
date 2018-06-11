package assignment5;

import java.util.ArrayList;

public class ShortDistanceFlight_Ability implements Flight {

	String short_flight ;
	
	@Override
	public String fly() {
		short_flight = "I can fly for short time and distance";
		System.out.println("I can fly for short time and distance ");
		return short_flight;
	}

}
