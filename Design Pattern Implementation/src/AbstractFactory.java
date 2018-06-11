package assignment5;

public abstract class AbstractFactory {
	public abstract Animal getAnimal(String type,String name,int age,int id,String med_condition,String notes, String ready_adoption, Flight flight,FoodHabits food);
}
