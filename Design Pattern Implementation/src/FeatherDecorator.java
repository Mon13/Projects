package assignment5;

import java.util.ArrayList;

public class FeatherDecorator extends AnimalDecorator{
	ArrayList feather_deco = new ArrayList();
	
	public FeatherDecorator(Animal animal) {
		super(animal);
	}

	@Override
	public ArrayList draw() {
		feather_deco = animal.draw();
		
		feather_deco.add("Decorating the Animal");
		feather_deco.add("I have feathers");
		System.out.println("Decorating the Animal");
		System.out.println("I have feathers");
		return feather_deco;
		
	}

}
