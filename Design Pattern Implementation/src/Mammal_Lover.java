package assignment5;

import java.util.Observable;
import java.util.Observer;

public class Mammal_Lover implements Observer {
	
	String First_name;
	String Last_name;
	
	public Mammal_Lover(String first_name, String last_name) {
		super();
		First_name = first_name;
		Last_name = last_name;
	}


	/**
	 * @return the first_name
	 */
	public String getFirst_name() {
		return First_name;
	}


	/**
	 * @param first_name the first_name to set
	 */
	public void setFirst_name(String first_name) {
		First_name = first_name;
	}

	/**
	 * @return the last_name
	 */
	public String getLast_name() {
		return Last_name;
	}


	/**
	 * @param last_name the last_name to set
	 */
	public void setLast_name(String last_name) {
		Last_name = last_name;
	}


	@Override
	public void update(Observable arg0, Object arg1) {
		
		String person = First_name+ " " + Last_name;
		System.out.println("\nNEW UPDATE FOR "+ person );
		System.out.println("The Animal is \n " + arg0);
		
		
	}
	

	
	

}
