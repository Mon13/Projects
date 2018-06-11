package networksProject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class MenuOperation {
	static int infinite = 10000;
	public static int[][] loadValues(String fileName)
	{
       
		String line = ""; 
      
        int rows=0;
        int col=0;
        
        try
        {
        	BufferedReader buff = new BufferedReader(new FileReader(fileName)); 
        	
        	
            while ((line = buff.readLine()) != null)
	      {
	    	rows++;
        	String [] info = line.split("\\s+");
        	col=info.length;

	      }
        }
        catch (IOException e)
        { 
            e.printStackTrace();
        }
          
            int matrix[][] = new int[rows][col];
            int i=0;
            
            try{
         	BufferedReader buff1 = new BufferedReader(new FileReader(fileName)); 
            while ((line = buff1.readLine()) != null)
  	      {
  	    	
          	String [] info = line.split("\\s+"); 
            for(int k=0;k<col;k++)
          	matrix[i][k]=Integer.parseInt(info[k]);
          	i++;
         
  	      }
       
            }
            catch (IOException e)
            { 
                e.printStackTrace();
            }
      
        return matrix; 
	}
	
	public static void displaymatrix(int[][] matrix)
	{
		int len=0;
		 System.out.println("The Original Topology Matrix is :");
		  for(int p=0;p<matrix.length;p++){
		len=matrix[p].length;
		  }
         for(int m=0;m<len;m++){
             for(int n=0;n<len;n++)
             {
                 System.out.print(matrix[m][n]+" ");
             }
             System.out.println();
         }
	}
	
	public static int[][] changematrix(int[][] matrix)
	{
		int len=0;
		 
		  for(int p=0;p<matrix.length;p++){
		len=matrix[p].length;
		  }
         for(int m=0;m<len;m++){
             for(int n=0;n<len;n++)
             {
            	 if(matrix[m][n] == -1)
            	 {
            		 matrix[m][n]=infinite;
            	 }
             }
             System.out.println();
         }
         return matrix;
	}
	
	
	public static int[][] RouterDeletedMatrix(int[][] resultNew,int router)
	    {
			int len=0;
			router=router-1;
			for(int p=0;p<resultNew.length;p++)
				{
				len=resultNew[p].length;
				}
			
	        int newArray[][] = new int[len-1][len-1];

	        int p = 0;
	        for( int i = 0; i < len; ++i)
	        {
	            if ( i == router)
	                continue;


	            int q = 0;
	            for( int j = 0; j < len; ++j)
	            {
	                if ( j == router)
	                    continue;

	                newArray[p][q] = resultNew[i][j];
	                ++q;
	            }

	            ++p;
	        }
	        return newArray;
	    }
	

}
