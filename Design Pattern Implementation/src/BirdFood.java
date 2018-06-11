package assignment5;

public class BirdFood implements FoodHabits {
	
	String bird_food = "";
	
	@Override
	public String food() {
		bird_food = "I eat grains and leaves ";
		System.out.println("I eat grains and leaves");
		return bird_food;
	}


}
