package assignment5;

import java.util.ArrayList;

public class LongDistanceFlight_Ability implements Flight {

	String long_flight = "";
	
	@Override
	public String fly() {
		long_flight = "I can fly for long time and distance";
		System.out.println("I can fly for long time and distance");
		return long_flight;
	}

}
