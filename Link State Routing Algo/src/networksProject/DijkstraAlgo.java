package networksProject;

import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;

public class DijkstraAlgo {
	
	static ArrayList <Integer> path =new ArrayList<Integer>();
	static ArrayList <Integer> path1 =new ArrayList<Integer>();
	static int len=0;
	static ArrayList<Integer> distance =new ArrayList<Integer>();
	static ArrayList<Integer> node =new ArrayList<Integer>();
	
	static int infinite = 10000;
	
	public static void calc(int matrix[][],int src)
	{
		
		src=src-1;
		//dest=dest-1;
		//path.clear();
		path.add(src);
		
		
		for(int p=0;p<matrix.length;p++)
		{
			len = matrix[p].length;
		}
		
		for(int a=0;a<len;a++)
		{
			
					distance.add(matrix[src][a]);
					
					
					if(a==src)
					{
					node.add(0);
					
					}
					else if(matrix[src][a] != infinite)
					{
						node.add(src);
					}
					else if(matrix[src][a]==infinite)
						node.add(infinite);
		
		
		}
		
		
		
		while(path.size() != len+1)
	  {
			
		int index=0;
		int minValue=99999;
		
	    for (int i = 0; i < distance.size(); i++)
	    {
	    	
	    	if(!path.contains(i))
	    	{
	    		
	    	
	        if (distance.get(i) < minValue) 
	        {
	            minValue = distance.get(i);
	            index=i;  
	            
	        }
	       
	    
	    	}  
	    }
	    
	    path.add(index);
		
	    for(int a=0;a<len;a++)
		{
	    	if(!path.contains(a))
	    	{
	    
				if(matrix[index][a] != infinite )
				{
					
					int val=Math.min(distance.get(a),distance.get(index)+matrix[index][a]);
					
					
					if((distance.get(a)) > (distance.get(index)+ matrix[index][a]))
					{
					node.set(a,index);
					}
					
					distance.set(a,val);
				}
		
	    	}
	    	
		}
	    
	    //CostNPath(src, dest);
		
	   }
		
	  
	
	}
	
	
	public static void connectionTable(int src)
	{
		System.out.println("Connection Table for the source "+src+" is:\n" );
		System.out.println("DESTINATION --- INTERFACE \n" );
	
		int a=0,b=0,c=0,d=0,e=0;
		
		src=src-1;
		for(int i =0;i<node.size();i++)
		{
			if(i==src)
			{
				e=i+1;
				System.out.println(e+"--- - \n");
			}
			else if(node.get(i)==src)
			{  a=i+1;
				System.out.println(a+"--- " +a+"\n");
			}
			else if(node.get(i)!=src)
			{c=i+1;
			
				b=node.get(i);
				while(node.get(b)!=src)
				{        b=node.get(b);
				  
				  
				}
				d=b+1;
				System.out.println(c+"--- " +d+"\n");
			}
	
		}
	}
	
	
	
	public static void CostNPath(int src,int dest)
	{
		src=src-1;
		dest=dest-1;
		
	int res2=distance.get(dest);
		
		System.out.println("Total cost for destination is "+res2);
		
		//for(int s=0;s<node.size();s++)
		//System.out.println(node.get(s)+"");

		ArrayList<Integer> shortpath =new ArrayList<Integer>();	
		int h=node.get(dest);

		while(h != src )
	  {
			shortpath.add(h);
			h=node.get(h);
	  }
	
     System.out.print("The Shortest Path is "+(src+1)+"--->");
     for(int s=shortpath.size()-1;s>=0;s--)
     {
    	 System.out.print((shortpath.get(s)+1)+"--->");
     }
     System.out.print(dest+1);
	}
	
	public static void bestRouter(int matrix[][])
	{
		int srcInt=1;
		
		int max=100000;
		int nodeValue=0;
		
		
		
		for(int p=0;p<matrix.length;p++)
		{
			len = matrix[p].length;
		}
		
		while(srcInt<=len)
		{
			int src=srcInt-1;
		
			path1.add(src);
			 ArrayList<Integer> distance1 =new ArrayList<Integer>();
		for(int a=0;a<len;a++)
		{
			
					distance1.add(matrix[src][a]);
	
		}
		
		
		
		while(path1.size() != len)
	  {
			
		int index=0;
		int minValue=99999;
		
	    for (int i = 0; i < distance1.size(); i++)
	    {
	    	
	    	if(!path1.contains(i))
	    	{
	    		
	    	
	        if (distance1.get(i) < minValue) 
	        {
	            minValue = distance1.get(i);
	            index=i;  
	            
	        }
	       
	    
	    	}  
	    }
	    
	    path1.add(index);
		
	    for(int a=0;a<len;a++)
		{
	    	if(!path1.contains(a))
	    	{
	    
				if(matrix[index][a] != infinite )
				{
					
					int val=Math.min(distance1.get(a),distance1.get(index)+matrix[index][a]);
					
					
					distance1.set(a,val);
				}
		
	    	}
	    	
		}
	    
	   
		
	   }
		
		int sum=0;
		for(int i=0;i<distance1.size();i++)
		{
			sum+=distance1.get(i);
		}
		if(sum<max)
		{   nodeValue=srcInt;
			max=sum;
		}
		
		srcInt=srcInt+1;
	}
		
		System.out.println("The Best router for broadcasting is :"+nodeValue+"\n");
		System.out.println("The sum of costs from this router is: "+max+"\n");
			
	}

}
