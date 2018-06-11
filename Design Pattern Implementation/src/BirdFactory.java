package assignment5;

public class BirdFactory extends AbstractFactory{

	private static BirdFactory birdfactory_singleton = new  BirdFactory();
	  
	private BirdFactory() {
		
	}
	
	public static BirdFactory getInstance() {
	    return birdfactory_singleton;
	  }

	@Override
	public Animal getAnimal(String type,String name,int age,int id,String med_condition,String notes, String ready_adoption, Flight flight,FoodHabits food) {
		if ("sparrow".equalsIgnoreCase(type)) {
			return new Sparrow(name, age, id, med_condition, notes, ready_adoption, flight, food);
		} 
		else if ("chicken".equalsIgnoreCase(type)) {
			return new Chicken(name, age, id, med_condition, notes, ready_adoption, flight, food);
		} 
		
		else
		{
			return null;
		}
	}
}
