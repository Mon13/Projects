package assignment5;

public class CatFood implements FoodHabits{

	String cat_food = "";
	
	@Override
	public String food() {
		cat_food = "I drink milk ";
		System.out.println("I drink milk");
		return cat_food;

}
}
