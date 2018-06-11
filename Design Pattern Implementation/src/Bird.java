package assignment5;


import java.awt.HeadlessException;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public abstract class Bird extends Observable implements Animal{
	
	protected String name;
	protected  int age;
	protected int id;
	protected  String med_condition;
	protected String notes;
	protected String ready_adoption;
	private Flight flight;
	private FoodHabits food;
	private ArrayList<Observer> animal_observers = new ArrayList<Observer>();
	
	/**
	 * @return the food
	 */
	public FoodHabits getFood() {
		return food;
	}

	/**
	 * @param food the food to set
	 */
	public void setFood(FoodHabits food) {
		this.food = food;
	}

	/**
	 * @return the flight
	 */
	public Flight getFlight() {
		return flight;
	}

	/**
	 * @param flight the flight to set
	 */
	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	@Override
	public abstract ArrayList draw() ;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the med_condition
	 */
	public String getMed_condition() {
		return med_condition;
	}

	/**
	 * @param med_condition the med_condition to set
	 */
	public void setMed_condition(String med_condition) {
		this.med_condition = med_condition;
	}

	/**
	 * @return the notes
	 */
	public String getNotes() {
		return notes;
	}

	/**
	 * @param notes the notes to set
	 */
	public void setNotes(String notes) {
		this.notes = notes;
	}

	/**
	 * @return the ready_adoption
	 */
	public String getReady_adoption() {
		return ready_adoption;
	}

	/**
	 * @param ready_adoption the ready_adoption to set
	 */
	public void setReady_adoption(String ready_adoption) {
		if(! (this.ready_adoption == ready_adoption) )
		{
			this.ready_adoption = ready_adoption;
			setChanged();
			notifyObserver(this,ready_adoption);
			
		}
		//this.ready_adoption = ready_adoption;
	}
	


	/**
	 * @return the animal_observers
	 */
	public ArrayList getAnimal_observers() {
		return animal_observers;
	}

	/**
	 * @param animal_observers the animal_observers to set
	 */
	public void setAnimal_observers(ArrayList animal_observers) {
		this.animal_observers = animal_observers;
	}

	public Bird(String name, int age, int id, String med_condition,
			String notes, String ready_adoption,Flight flight,FoodHabits food) throws HeadlessException {
		super();
		this.name = name;
		this.age = age;
		this.id = id;
		this.med_condition = med_condition;
		this.notes = notes;
		this.ready_adoption = ready_adoption;
		this.flight = flight;
		this.food=food;
	}

	
	public void registerObserver(Observer observer) {
		animal_observers.add(observer);
	}

	public void unRegisterObserver(Observer observer) {
		animal_observers.remove(observer);
	}

	public void notifyObserver(Observable observeration, String ready_Adopt) {

		
			for (Observer observer : animal_observers) {
				
				observer.update(observeration,this.ready_adoption);
			}
		}

	
}
