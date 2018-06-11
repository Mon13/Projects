
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Utili {




	
	public String printHtml(String file) {
		String result="";
		try
		{
	 		result = HtmlToString(file);
		}
		
		catch(IOException e)
		{
			e.printStackTrace();
		}
	
	return result;
	}
	
	public String HtmlToString(String  file) throws IOException{
		  BufferedReader br = new BufferedReader(new FileReader("/Users/mounagiri/softwares/apache-tomcat-7.0.34/webapps/csj/"+file)); 
    try {
        StringBuilder sb = new StringBuilder();
        String line = br.readLine();

        while (line != null) {
            sb.append(line);
            sb.append("\n");
            line = br.readLine();
        }
        return sb.toString();
    } 
	
	finally 
	{
        br.close();
    }
	}
}

