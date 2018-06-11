package assignment5;


import java.awt.*;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Cat extends Mammal {
	
	private String type;
	
	private static int cat_count;

	public Cat(String name, int age, int id, String med_condition,
			String notes, String ready_adoption, Flight flight,FoodHabits food)
			throws HeadlessException {
		super(name, age, id, med_condition, notes, ready_adoption,flight,food);
		this.type = "Cat";
		cat_count++;
	}


	/**
	 * @return the cat_count
	 */
	public static int getCat_count() {
		return cat_count;
	}


	/**
	 * @param cat_count the cat_count to set
	 */
	public void setCat_count(int cat_count) {
		this.cat_count = cat_count;
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


	@Override
	public ArrayList draw() {
		ArrayList cat = new ArrayList();
		cat.add("Im a cat and my name is "+getName());
		System.out.println("Im a cat and my name is "+getName());
		return cat;
	}

	 /* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			display(getName(), getType(), getReady_adoption(), getMed_condition(), getNotes());
			return "Animal Name= " + name + "\t"+" type= " + type +
					"\n"+
					"Ready for Adoption= " + ready_adoption +"\t" + "Medical Condition= "+ med_condition+
					"\n"+
					"Notes= "+notes +"";
		}


		public void display(String name, String type, String adopt, String med_cond, String Notes)
		 {
			 JFrame frame = new JFrame();
			   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			    Object rowData[][] = { { "Animal Name= "+ name, "Type= "+type},
			        { "Ready for Adoption= "+adopt, "Medical Condition= " +med_cond},
			    	{ "Picture of the Animal= Cat", " " },
			    	{ "Notes= "+notes, " " }};
			    
			    Object columnNames[] = { "", "" };
			    
			    JTable table = new JTable(rowData, columnNames);


			    JScrollPane scrollPane = new JScrollPane(table);
			    frame.add(scrollPane, BorderLayout.CENTER);
			    frame.setSize(300, 150);
			    frame.setVisible(true);
		 }


	

}
