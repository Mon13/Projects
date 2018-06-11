package main;

import java.util.Scanner;
import fixed_values.GasPump_values;
public class Driver {
	public static void main(String[] args) {
		
	Create_GasPump create = Create_GasPump.getInstance();
	
	boolean flag = true;
	while(flag){
		Scanner input = new Scanner(System.in);
		int option= 0;
		
		System.out.println("WELCOME TO GAS PUMP PROJECT:");
		System.out.println("1. GasPump1");
		System.out.println("2. GasPump2");
		System.out.println("ENTER THE PARAMETER [1 or 2] :");
		
		try{
			option=input.nextInt();
		}catch(Exception e){
			System.out.println("Invalid parameter");
			continue;
		}
		switch(option){
		case 1: 
			create.assign(GasPump_values.GasPump1);
			break;
			
		case 2:
			create.assign(GasPump_values.GasPump2);
			break;
			
		default:
			System.out.println("Invalid");
			break;
		}
		
	}

}}