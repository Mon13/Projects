package assignment5;

public class MammalFactory extends AbstractFactory {

	private static  MammalFactory mammalfactory_singleton = new MammalFactory();
	  
	private MammalFactory() {
		
	}
	
	public static  MammalFactory getInstance() {
	    return mammalfactory_singleton;
	  }
	
	
	@Override
	public Animal getAnimal(String type,String name,int age,int id,String med_condition,String notes, String ready_adoption, Flight flight,FoodHabits food) {
		if ("dalmatian".equalsIgnoreCase(type)) {
			return new Dalmatian(name, age, id, med_condition, notes, ready_adoption, flight, food);
		} 
		else if ("poodle".equalsIgnoreCase(type)) {
			return new Poodle(name, age, id, med_condition, notes, ready_adoption, flight, food);
		} 
		
		else if ("cat".equalsIgnoreCase(type)) {
			return new Cat(name, age, id, med_condition, notes, ready_adoption, flight, food);
		}
		else
		{
			return null;
		}
	}

}
