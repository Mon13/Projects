package assignment5;

import java.awt.HeadlessException;
import java.util.ArrayList;

public class Dalmatian extends Dog {
	
	private String breed;
	private static int dal_count;
	/**
	 * @return the dal_count
	 */
	public static int getDal_count() {
		return dal_count;
	}

	/**
	 * @param dal_count the dal_count to set
	 */
	public void setDal_count(int dal_count) {
		this.dal_count = dal_count;
	}

	

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

	public Dalmatian(String name, int age, int id, String med_condition,
			String notes, String ready_adoption, Flight flight,FoodHabits food)
			throws HeadlessException {
		super(name, age, id, med_condition, notes, ready_adoption, flight,food);
		this.breed="Dalmatian";
		dal_count++;
	}

	@Override
	public ArrayList draw() {
		
		ArrayList dog_dal = new ArrayList();
		dog_dal.add("Im a Dog - Dalmatian and my name is "+getName());
		System.out.println("Im a Dog-Dalmatian and my name is "+getName());
		return dog_dal;
	}


}
