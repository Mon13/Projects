package assignment5;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Animal_Care_Centre{

	private static ArrayList<Animal> mammalList = new ArrayList<Animal>();
	private static ArrayList<Animal> birdList = new ArrayList<Animal>();
	
	private static ArrayList<Mammal_Lover> mammal_subscriber = new ArrayList<Mammal_Lover>();
	private static ArrayList<Bird_Lover> bird_subscriber = new ArrayList<Bird_Lover>();
	private static ArrayList<MammalAndBird_Lover> animal_subscriber = new ArrayList<MammalAndBird_Lover>();
	
	
	private static Bird_Lover subscriber1 = new Bird_Lover("Mary", "Owen");
	private static Bird_Lover subscriber2 = new Bird_Lover("King", "Chris");
	private static Bird_Lover subscriber3 = new Bird_Lover("Mouna", "Giri");
	private static Bird_Lover subscriber4 = new Bird_Lover("Monica", "Joseph");
	
	private static MammalAndBird_Lover subscriber5 = new MammalAndBird_Lover("Vikram", "Gavisiddeshwara");
	private static MammalAndBird_Lover subscriber6 = new MammalAndBird_Lover("Joey", "Singh");
	private static MammalAndBird_Lover subscriber7 = new MammalAndBird_Lover("Sak", "Jack");
	private static MammalAndBird_Lover subscriber8 = new MammalAndBird_Lover("Joseph", "Radon");
	private static MammalAndBird_Lover subscriber9 = new MammalAndBird_Lover("Jack", "Sparrow");
	
	private static Mammal_Lover subscriber10 = new Mammal_Lover("Angel", "Prince");
	private static Mammal_Lover subscriber11 = new Mammal_Lover("Joe", "Bill");
	private static Mammal_Lover subscriber12 = new Mammal_Lover("Rick", "Chandler");
	


	public static void main(String args[])  { 
	
		AnimalTypeFactory animal_generate = AnimalTypeFactory.getInstance();

		AbstractFactory abstractFactory_mammals = animal_generate.getAnimalType("mammal");
		Animal animal1 = abstractFactory_mammals.getAnimal("Dalmatian","johny",3,1,"good","aggresive dog","yes", new NoFlight_Ability(), new DogFood());
		Animal animal2 = abstractFactory_mammals.getAnimal("Dalmatian","bruno",4,2,"good","nice dog","yes", new NoFlight_Ability(),new DogFood());
		Animal animal3 = abstractFactory_mammals.getAnimal("Dalmatian","pinto",2,3,"bad","kind","no",new NoFlight_Ability(), new DogFood());

		Animal animal4 = abstractFactory_mammals.getAnimal("poodle","rubby",3,4,"good","lovable","yes",new NoFlight_Ability(), new DogFood());
		Animal animal5 = abstractFactory_mammals.getAnimal("poodle","welly",3,5,"good","aggresive","no",new NoFlight_Ability(), new DogFood());
		Animal animal6 = abstractFactory_mammals.getAnimal("poodle","yun",2,6,"bad","good dog","yes",new NoFlight_Ability(), new DogFood());
		Animal animal7 = abstractFactory_mammals.getAnimal("poodle","tommy",4,7,"good","kind dog","yes",new NoFlight_Ability(), new DogFood());

		Animal animal8 = abstractFactory_mammals.getAnimal("cat","oliver",1,8,"good","lovable cat","yes",new NoFlight_Ability(), new CatFood());
		Animal animal9 = abstractFactory_mammals.getAnimal("cat","Milo",2,9,"bad","good cat","no",new NoFlight_Ability(),new CatFood());
		Animal animal10 = abstractFactory_mammals.getAnimal("cat","jasper",3,10,"good","aggresive","yes",new NoFlight_Ability(),new CatFood());
		Animal animal11 = abstractFactory_mammals.getAnimal("cat","simon",1,11,"good","good cat","yes",new NoFlight_Ability(),new CatFood());

		AbstractFactory abstractFactory_birds = animal_generate.getAnimalType("bird");

		Animal animal12 = abstractFactory_birds.getAnimal("chicken","indy",2,12,"good","good","yes", new ShortDistanceFlight_Ability(), new BirdFood());
		Animal animal13 = abstractFactory_birds.getAnimal("chicken","elmo",1,13,"good","nice","yes",new ShortDistanceFlight_Ability(), new BirdFood());
		Animal animal14 = abstractFactory_birds.getAnimal("chicken","harley",3,14,"good","good","no",new ShortDistanceFlight_Ability(), new BirdFood());
		Animal animal15 = abstractFactory_birds.getAnimal("chicken","isabelle",2,15,"bad","nice","yes",new ShortDistanceFlight_Ability(), new BirdFood());

		Animal animal16 = abstractFactory_birds.getAnimal("sparrow","merlin",1,16,"good","nice","yes", new LongDistanceFlight_Ability(), new BirdFood());
		Animal animal17 = abstractFactory_birds.getAnimal("sparrow","paco",2,17,"good","good","no",new LongDistanceFlight_Ability(), new BirdFood());
		Animal animal18 = abstractFactory_birds.getAnimal("sparrow","Ricky",2,18,"bad","attractive","no",new LongDistanceFlight_Ability(), new BirdFood());
		Animal animal19 = abstractFactory_birds.getAnimal("sparrow","shygo",1,19,"good","nice","no",new LongDistanceFlight_Ability(), new BirdFood());

		mammalList.add(animal1);
		mammalList.add(animal2);
		mammalList.add(animal3);
		mammalList.add(animal4);
		mammalList.add(animal5);
		mammalList.add(animal6);
		mammalList.add(animal7);
		mammalList.add(animal8);
		mammalList.add(animal9);
		mammalList.add(animal10);
		mammalList.add(animal11);

		birdList.add(animal12);
		birdList.add(animal13);
		birdList.add(animal14);
		birdList.add(animal15);
		birdList.add(animal16);
		birdList.add(animal17);
		birdList.add(animal18);
		birdList.add(animal19);

		mammal_subscriber.add(subscriber10);
		mammal_subscriber.add(subscriber11);
		mammal_subscriber.add(subscriber12);
		
		animal_subscriber.add(subscriber5);
		animal_subscriber.add(subscriber6);
		animal_subscriber.add(subscriber7);
		animal_subscriber.add(subscriber8);
		animal_subscriber.add(subscriber9);
		
		bird_subscriber.add(subscriber1);
		bird_subscriber.add(subscriber2);
		bird_subscriber.add(subscriber3);
		bird_subscriber.add(subscriber4);

		paint_mammals();
		paint_birds();
		statistics();
		
		
		adding_observers_Mammals();
		adding_observers_Birds();
		adding_observers_Animal();


		((Bird)animal18).setMed_condition("good");
		((Mammal)animal9).setMed_condition("good");
		((Bird)animal18).setReady_adoption("yes");
		((Mammal)animal9).setReady_adoption("yes");
	}

	public static void adding_observers_Birds()
	{
		System.out.println("\nAdding the bird observers for all the birds in the centre");
		for (Animal animal_bird :birdList){
			for (Bird_Lover sub_bird :bird_subscriber){
			((Bird)animal_bird).registerObserver(sub_bird);
			}
		}

	}

	public static void adding_observers_Mammals()
	{
		System.out.println("\nAdding the mammal observers for all the mammals in the centre");
		for (Animal animal_mammal :mammalList){
			for (Mammal_Lover sub_mammal :mammal_subscriber){
				((Mammal)animal_mammal).registerObserver(sub_mammal);
				}
		}
	}
	
	public static void adding_observers_Animal()
	{
		System.out.println("\nAdding the animal observers for all the animals in the centre");
		for (Animal animal_mammal :mammalList){
			for (MammalAndBird_Lover sub_mammal : animal_subscriber){
				((Mammal)animal_mammal).registerObserver(sub_mammal);
				}
		}
		
		for (Animal animal_bird :birdList){
			for (MammalAndBird_Lover sub_bird : animal_subscriber){
			((Bird)animal_bird).registerObserver(sub_bird);
			}
		}
	}




	public static void paint_birds( )   {
		System.out.println("\nBirds in the center");
		for (Animal f1 :birdList){

			ArrayList result = new ArrayList();
			Animal birdie = new FlyDecorator(f1);
			result =  birdie.draw();
			result.add(((Bird) f1).getFlight().fly());
			result.add(((Bird) f1).getFood().food());
			JFrame frame = new JFrame("Birds");
			frame.setBounds(1000, 1000, 400, 300);

			JPanel jpan = new JPanel();
			frame.getContentPane().setBackground(Color.yellow);
			frame.add(jpan);
			for (int m =0; m < result.size();m++){
				JButton jbut = new JButton((String)result.get(m));
				jpan.add(jbut);
			}

			frame.setVisible(true);



		}
	}
	public static void paint_mammals( )   {
		System.out.println("\n Mammals in the centre");
		for ( Animal f : mammalList )
		{

			ArrayList result1 = new ArrayList();
			Animal animal = new MoveDecorator(f);
			result1 = animal.draw();
			result1.add(((Mammal) f).getFly_power().fly());
			result1.add(((Mammal) f).getFood().food());
			JFrame frame1 = new JFrame("Mammals");
			frame1.setBounds(00, 00, 300, 300);

			JPanel jpan1 = new JPanel();
			frame1.getContentPane().setBackground(Color.gray);
			frame1.add(jpan1);
			for (int m =0; m< result1.size();m++){
				JButton jbut = new JButton((String)result1.get(m));
				jpan1.add(jbut);
			} 

			frame1.setVisible(true);
		}
	}

	public static  void statistics()
	{
		System.out.println("\nThe DATA IN THE ANIMAL CARE CENTRE");
		System.out.println("Birds - Chicken :"+Chicken.getChicken_count());
		System.out.println("Cats - Cats :"+Cat.getCat_count());
		System.out.println("Dogs - Dalmatian:"+Dalmatian.getDal_count());
		System.out.println("Dogs - Poodle :"+Poodle.getPoo_count());
	}

}
