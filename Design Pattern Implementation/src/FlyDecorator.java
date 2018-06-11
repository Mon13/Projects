package assignment5;

import java.util.ArrayList;

public class FlyDecorator extends AnimalDecorator {

	ArrayList fly_deco = new ArrayList();
	public FlyDecorator(Animal animal) {
		super(animal);
		
	}

	@Override
	public ArrayList draw() {
		fly_deco = animal.draw();
		fly_deco.add("Decorating the Animal");
		fly_deco.add("I have legs and Wings.");
		System.out.println("Decorating the Animal");
		System.out.println("I have legs and Wings.");
		fly_movement();
		return fly_deco;
	}
	
	public void fly_movement() {
		fly_deco.add("I can fly and walk on the ground.\n");
		System.out.println("I can fly and walk on the ground.\n");
	}

}

