import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class File_ReadNSort extends Thread {

	public static List<File> files_finallist = new ArrayList<File>();
	private long from;
	private long to;
	private String fileName;
	int thread_count = Sort_Java.commandLine;
	int block_size = 1024/thread_count;
	int c ;

	public static Comparator<String> string_Comparator = new Comparator<String>() {

		public int compare(String string1, String string2){
			return string1.compareTo(string2);}};

			public File_ReadNSort(long from, long to, String fileName,int c) {
				super();
				this.from = from;
				this.to = to;
				this.fileName = fileName;
				this.c=c;
			}

			@Override
			public void run()
			{
				RandomAccessFile randomFile = null;
				FileReader fname;
				BufferedReader buffer_reader = null;
				String readLine = "";
				long max_divide_size = (long) (Sort_Java.value / block_size) ;
				long freeRuntimeMemory = Runtime.getRuntime().freeMemory();
				if( max_divide_size < freeRuntimeMemory/2)
					max_divide_size = freeRuntimeMemory/2;
				try {

					Sorted_LinkedList<String> reader = new Sorted_LinkedList<String>((int)max_divide_size);
				
					randomFile = new RandomAccessFile(fileName, "rw");
					fname = new FileReader(randomFile.getFD());
					buffer_reader = new BufferedReader(fname);
					randomFile.seek(this.from);
					
					
					while(readLine!= null )
					{
						long flag=0;
						if( c >= Sort_Java.value)
							break;
				
						while((flag <= max_divide_size) && (readLine = buffer_reader.readLine()) != null )
						{
							if( flag >= Sort_Java.value)
								break;
							
							flag+= readLine.length()+2;
							c+= readLine.length()+2;
							reader.add(readLine+" ");
						}
						files_finallist.add(write_To_File(reader));
						
						reader.clear();
						}
					

					


				} 
				catch (IOException e) {
					e.printStackTrace();
				}
				finally
				{
					try {
						buffer_reader.close();
						randomFile.close();
					} catch (IOException e) {

						e.printStackTrace();
					}

				}


			}

			public static File write_To_File(Sorted_LinkedList<String> sorted_list)
			{
				File temp_File = null;
				BufferedWriter file_writer = null;
				try {
					temp_File = File.createTempFile("Temp", ".tmp");
					file_writer = new BufferedWriter(new FileWriter(temp_File));

					for(String i : sorted_list) {
						file_writer.write(i);
						file_writer.newLine(); 
					}
					temp_File.deleteOnExit();
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					try{
						file_writer.close();
					}catch(Exception ex){}
				}

				return temp_File;
			}

}