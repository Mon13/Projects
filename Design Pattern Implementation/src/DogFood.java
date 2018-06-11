package assignment5;

public class DogFood implements FoodHabits {
	
String dog_food = "";
	
	@Override
	public String food() {
		dog_food = "I eat biscuits and meat and drink milk ";
		System.out.println("I eat biscuits and meat and drink milk");
		return dog_food;

}
}