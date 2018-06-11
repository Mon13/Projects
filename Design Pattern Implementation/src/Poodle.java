package assignment5;

import java.awt.HeadlessException;
import java.util.ArrayList;

public class Poodle extends Dog {

	private String breed;
	private static int poo_count;
	
	
	/**
	 * @return the breed
	 */
	public String getBreed() {
		return breed;
	}
	/**
	 * @param breed the breed to set
	 */
	public void setBreed(String breed) {
		this.breed = breed;
	}
	
	public Poodle(String name, int age, int id, String med_condition,
			String notes, String ready_adoption, Flight flight,FoodHabits food)
			throws HeadlessException {
		super(name, age, id, med_condition, notes, ready_adoption,flight,food);
		this.breed="Poodle";
		poo_count++;
	}
	/**
	 * @return the poo_count
	 */
	public static int getPoo_count() {
		return poo_count;
	}
	/**
	 * @param poo_count the poo_count to set
	 */
	public void setPoo_count(int poo_count) {
		this.poo_count = poo_count;
	}

	@Override
	public ArrayList draw() {
		
		ArrayList dog_poo = new ArrayList();
		dog_poo.add("Im a dog-poodle and my name is "+getName());
		System.out.println("Im a dog-poodle and my name is "+getName());
		return dog_poo;
	}

	
}
