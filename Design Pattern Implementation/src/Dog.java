package assignment5;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Dog extends Mammal  {
	
	private String type;
	
	private static int dog_count;
	


	public Dog(String name, int age, int id, String med_condition,
			String notes, String ready_adoption,Flight fly_power,FoodHabits food) throws HeadlessException {
		super(name, age, id, med_condition, notes, ready_adoption,fly_power,food);
		this.type="dog";
		dog_count++;
	}


	@Override
	public ArrayList draw() {
		
		ArrayList dog = new ArrayList();
		dog.add("Im a dog");
		System.out.println("Im a dog \n");
		return dog;
		
	}

	
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}


	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}




	 
	 
	 /* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		display(getName(), getType(), getReady_adoption(), getMed_condition(), getNotes());
		return "Animal Name" + name + "\t"+" type=" + type +
				"\n"+
				"Ready for Adoption:" + ready_adoption +"\t" + "Medical Condition: "+ med_condition+
				"\n"+
				"Notes"+notes +"";
	}


	public void display(String name, String type, String adopt, String med_cond, String Notes)
	 {
		 JFrame frame = new JFrame();
		   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		    Object rowData[][] = { { "Animal Name= "+ name, "Type= "+type},
		        { "Ready for Adoption= "+adopt, "Medical Condition=  " +med_cond},
		    	{ "Picture of the Animal= Dog", " " },
		    	{ "Notes= "+notes, " " }};
		    
		    Object columnNames[] = { "", "" };
		    
		    JTable table = new JTable(rowData, columnNames);


		    JScrollPane scrollPane = new JScrollPane(table);
		    frame.add(scrollPane, BorderLayout.CENTER);
		    frame.setSize(300, 150);
		    frame.setVisible(true);
	 }


	
}
