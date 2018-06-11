package assignment5;

public class AnimalTypeFactory {
	
	private static AnimalTypeFactory factory_singleton = new  AnimalTypeFactory();
	
	public AbstractFactory getAnimalType(String type) {
		if ("mammal".equalsIgnoreCase(type)) {
			
			return MammalFactory.getInstance();
		} else if ("bird".equalsIgnoreCase(type)) {
			
			return BirdFactory.getInstance();
		}
		else
		{ return null;}
	}


	private AnimalTypeFactory() {	
	}
	
	public static AnimalTypeFactory getInstance() {
	    return factory_singleton;
	  }

}
