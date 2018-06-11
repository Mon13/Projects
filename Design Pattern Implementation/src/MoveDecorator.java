package assignment5;

import java.util.ArrayList;

public class MoveDecorator extends AnimalDecorator {

	ArrayList move_deco = new ArrayList();
	
	public MoveDecorator(Animal animal) {
		super(animal);
		
	}

	@Override
	public ArrayList draw() {
		move_deco = animal.draw();
		System.out.println("Decorating the Animal\n");
		System.out.println("I have legs \n");
		move_deco.add("Decorating the Animal");
		move_deco.add("I have legs");
	
		walk();
		return move_deco;
	}
	
	public void walk() {
		move_deco.add("I can walk on the ground.");
		System.out.println("I can walk on the ground.\n");
	}

}
