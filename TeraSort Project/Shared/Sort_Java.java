
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;


public class Sort_Java {

	static int commandLine;
	static String file_name;
	static double value;


	public static void main(String args[]) throws InterruptedException, IOException {

		String out = ("output_sorted");
		Scanner console = new Scanner (System.in);
		System.out.print("Please enter input file name to be sorted");
		file_name = console.next();
		RandomAccessFile randomFile = new RandomAccessFile(file_name, "rw");

		System.out.print("Please enter the number of threads [1, 2, 4 or 8] ");
		commandLine = console.nextInt();
		File_ReadNSort[] run = new File_ReadNSort[commandLine];

		value = (randomFile.length()/commandLine);

		double start = System.nanoTime();
		for(int i=0;i<commandLine;i++)  
		{
			long from=(long) (i*value);
			long to=(long) (from+value);
			int c=0;
			run[i] = new File_ReadNSort(from, to, file_name,c);
			run[i].run();
		}

		for (int v = 0; v < commandLine; v++) 
			run[v].join();


		mergeFiles(File_ReadNSort.files_finallist,out,File_ReadNSort.string_Comparator);

		double Total = (System.nanoTime()-start)/1000000000.0;
		System.out.println("Time Taken is "+(Total)+" sec");
		double result_throughput=(randomFile.length()/1073741824)/Total;
		System.out.println("Throughput is "+ result_throughput + " GB/sec");
	}



	public static void mergeFiles(List<File> file_List, String outputfile, final Comparator<String> comp) throws IOException {

		Buffer binaryBuffer ;

		PriorityQueue<Buffer> buffer_pq = new PriorityQueue<Buffer>(11, 
				new Comparator<Buffer>() {
			public int compare(Buffer i, Buffer j) {
				return comp.compare(i.peek(), j.peek());
			}
		}
				);

		for (File file_name : file_List) {
			buffer_pq.add(new Buffer(file_name));
		}

		File output_file=new File(outputfile);
		BufferedWriter buffWriter = new BufferedWriter(new FileWriter(output_file));
		int flag = 0;
		try {
			while(buffer_pq.size()>0) {

				Buffer buff = buffer_pq.poll();
				String result = buff.pop();
				buffWriter.write(result);
				buffWriter.newLine();
				++flag;

				if(buff.isEmpty()) {
					buff.buffReader.close();
					buff.initialFile.delete();
				} else {
					buffer_pq.add(buff); 
				}
			}
		} finally {  
			buffWriter.close();
			for(Buffer bfb : buffer_pq ) 
				bfb.close();
		}

	}




}

class Buffer  {
	public static int buff_size = 2048;
	public BufferedReader buffReader;
	public File initialFile;
	private String temp;
	private boolean isEmpty;

	public Buffer(File f) throws IOException {
		this.initialFile = f;
		this.buffReader = new BufferedReader(new FileReader(f), buff_size);
		reload();
	}

	public boolean isEmpty() {
		return isEmpty;
	}

	private void reload() throws IOException {
		try {
			if((this.temp = buffReader.readLine()) == null){
				isEmpty = true;
				temp = null;
			}
			else{
				isEmpty = false;
			}
		} catch(EOFException e) {
			isEmpty = true;
			temp = null;
		}
	}

	public void close() throws IOException {
		buffReader.close();
	}


	public String peek() {
		if(isEmpty()) return null;
		return temp.toString();
	}
	public String pop() throws IOException {
		String value = peek();
		reload();
		return value;
	} 
}
