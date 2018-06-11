 
	
	


import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

import java.util.Scanner;



public class DiskTask_ReadnWrite extends Thread{
	
	  static Thread thread_numb; 
	  static int commandLine;
	  private static String inputFile = "largeFile.txt";
	  private static String copiedFile = "Result.db";
	  static File fileName = new File(inputFile);
	  static double new_file_size;
	  static int count;
	  static double time_taken ;
	  static double sum;
	  static double sUM_TT;
	  
	public static void main(String args[]) throws InterruptedException {
		
		DiskTask_ReadnWrite[] run = new DiskTask_ReadnWrite[8];
		 Scanner console = new Scanner (System.in);
	      while (true) {
	         System.out.print("Please enter the blocksize[8b, 80b, 8M , 80Mb and 0-quit] ");
	         
	         commandLine = console.nextInt();
	         if (commandLine == 0)  {
	             break; 
	         }
	    
			  System.out.println("\n" + commandLine + " is the Block Size");

			 
       int[] threadCount={1,2,4,8};
       for(int a=0;a<threadCount.length;a++){
       	{
      
       		int no_of_thread=threadCount[a];
       	System.out.println("No of threads running is "+no_of_thread);
     
       	double file_Size = fileName.length();
       	
       	 new_file_size=file_Size/no_of_thread;
       
       	count=0;
       	sum=0;
       	time_taken=0;
       	sUM_TT=0;
       	
       for(int i=0;i<(no_of_thread);i++){

       	run[i] = new DiskTask_ReadnWrite(); 
       	run[i].start();
       	 count=i;
       	
       }
       for(int c=0;c<(no_of_thread);c++)
 		  run[c].join();
       
 	  sum=sUM_TT;
		if (commandLine == 8)
		{
			System.out.println("sum for final"+sum); 
			sum=sum/1000000.0;
			double result_latency=(sum/file_Size);
   	System.out.println("Latency for Read and Write : "+ result_latency + " ms");
		}
		else
		{
			
			sum=sum/1000000000.0;
			 
			double result_throughput=(file_Size/1048576)/sum;
			System.out.println("Throughput for Read and Write  :"+ result_throughput + " MB/sec");
		}
			
       
       	}
	}
	      }
}
	
	
	
	
	 
	 

	 public  void read_write(double file_size, int counter, int block_size) throws IOException
		{
			
			RandomAccessFile rafIN = new RandomAccessFile(inputFile, "rw");
			RandomAccessFile rafout = new RandomAccessFile(copiedFile, "rw");
			byte[] byteArray = new byte[block_size];
			rafIN.seek((long) (file_size*counter));
			int value=(int)file_size/block_size;
			
			double start = System.nanoTime();
			for (int i = 0; i < value; i++) {
				int currentPosition = (int)rafIN.getFilePointer();
			    rafIN.read(byteArray);
			    rafout.seek(currentPosition);
			    rafout.write(byteArray);
			    
			}
			time_taken = System.nanoTime()- start;
			
			
			sUM_TT +=time_taken;
			rafIN.close();
			rafout.close();
		}





	@Override
	public void run()  {
		
			try {
				//System.out.println("Disk Metrics Calculations for"+ commandLine + "bytes");
				read_write(new_file_size,count,commandLine);
			} catch (IOException e) {
			
				e.printStackTrace();
			}
		}
	
	
}