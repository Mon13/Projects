package networksProject;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class MenuDisplay {

	static int src;
	public static void main(String[] args) throws FileNotFoundException {
	       
		Scanner value = new Scanner(System.in);
		
		int choice;
		System.out.println("Enter the network topology matrix data file with its file extension");
		String fileName=value.nextLine(); 
        int result[][]=MenuOperation.loadValues(fileName);
        
		
		
		for(int m=0; ;m++)
		{
		System.out.println("\n"+" Welcome to Link State Routing Simulator !! Select your choices from the MENU " + "\n"+
							"1.Create a Network Topology"+"\n"+
							"2.Build a Connection Table"+"\n"+
							"3.Shortest Path to Destination Router"+"\n"+
							"4.Modify a Topology"+"\n"+
							"5.Best Router for Broadcast"+"\n"+
							"6.Exit"); 
		
		
		choice = value.nextInt(); 


		
		if (choice == 1) 
		{
	        MenuOperation.displaymatrix(result);
	
		}
		else if (choice == 2) 
		{
			
			int resultNew[][]=MenuOperation.changematrix(result);
			
			System.out.println("Enter the source router - ");
			 src=Integer.parseInt(value.next());
			
			DijkstraAlgo.calc(resultNew,src);
			DijkstraAlgo.connectionTable(src);
			
		}
		
		
		else if (choice == 3) 
			
		{
			int resultNew[][]=MenuOperation.changematrix(result);
			
			System.out.println("Enter the destination router - ");
			int dest=Integer.parseInt(value.next());
			//DijkstraAlgo.calc(resultNew,src);
			DijkstraAlgo.CostNPath(src, dest);
			  
			
		}
		else if (choice == 4) 
			
		{
			int resultNew[][]=MenuOperation.changematrix(result);
			System.out.println("Enter the router to be deleted - ");
			int routerDel=Integer.parseInt(value.next());
			
			int ModifiedArray[][]=MenuOperation.RouterDeletedMatrix(resultNew,routerDel);
		    MenuOperation.displaymatrix(ModifiedArray);
			System.out.println("Enter the source router - ");
			int src1=Integer.parseInt(value.next());
			System.out.println("Enter the destination router - ");
			int dest=Integer.parseInt(value.next());
			DijkstraAlgo.calc(ModifiedArray,src1);
			DijkstraAlgo.CostNPath(src1, dest);
			  
			
		
		}
		
        else if (choice == 5) 
			
		{
			
			int resultNew[][]=MenuOperation.changematrix(result);
			DijkstraAlgo.bestRouter(resultNew);
			
		
		}
		else if (choice == 6) 
			
		{
			System.out.println("Program has been ended");
			break;	
		}

		else
		{
			System.out.println("Invalid Entry"); 
		}
	}
	
	
	}

}
