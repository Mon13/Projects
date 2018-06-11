package assignment5;

public abstract class AnimalDecorator implements Animal{
	
	Animal animal;

	public AnimalDecorator(Animal animal) {
		this.animal = animal;
	}
	
	public AnimalDecorator(Mammal m) {
		this.animal = m;
	}
	
	public AnimalDecorator(Bird m) {
		this.animal = m;
	}

}
