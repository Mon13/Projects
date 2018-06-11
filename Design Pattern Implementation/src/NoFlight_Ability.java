package assignment5;

import java.util.ArrayList;

public class NoFlight_Ability implements Flight {
	
	String no_flight;
	
	@Override
	public String fly() {
		no_flight ="I cant fly";
		System.out.println("I cant fly");
		return no_flight;
	}

}
