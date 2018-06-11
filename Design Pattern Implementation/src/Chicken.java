package assignment5;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Chicken extends Bird {

	
	
	private static int chicken_count;
	
	
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

	private String type;


	


	public Chicken(String name, int age, int id, String med_condition,
			String notes, String ready_adoption, Flight flight,FoodHabits food) throws HeadlessException {
		super(name, age, id, med_condition, notes, ready_adoption,flight,food);
		this.type="Chicken";
		chicken_count++;
	}

	/**
	 * @return the chicken_count
	 */
	public static int getChicken_count() {
		return chicken_count;
	}

	/**
	 * @param chicken_count the chicken_count to set
	 */
	public void setChicken_count(int chicken_count) {
		this.chicken_count = chicken_count;
	}

	@Override
	public ArrayList draw() {
	
	     	ArrayList chicken = new ArrayList();
			chicken.add("Im a chicken and my name is "+getName());
			System.out.println("Im a chicken and my name is "+getName());
			return chicken;
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
		        { "Ready for Adoption = "+adopt, "Medical Condition = " +med_cond},
		    	{ "Picture of the Animal= Chicken", " " },
		    	{ "Notes= "+notes, " " }};
		    
		    Object columnNames[] = { "", "" };
		    
		    JTable table = new JTable(rowData, columnNames);


		    JScrollPane scrollPane = new JScrollPane(table);
		    frame.add(scrollPane, BorderLayout.CENTER);
		    frame.setSize(300, 150);
		    frame.setVisible(true);
	 }
	  
}
