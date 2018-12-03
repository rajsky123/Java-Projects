import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class ReadFileAndMap {
public static void main(String[] args) throws IOException {
	
	FileReader f=new FileReader("c:/Users/rajsky123/Desktop/Collection/project geeftu.txt");
	BufferedReader br=new BufferedReader(f);
	String s=null;
	Map<String, Integer> m=new LinkedHashMap<>();
	while((s=br.readLine())!=null)
	{
		s=s.replaceAll("\\s+"," ");
		String[] split = s.split("\\s|,|\\.");
		for (String st : split) {
			
			if(!m.containsKey(st))
			{
				m.put(st, 1);
				
			}
			else {
				
				m.put(st,m.get(st)+1);
			}
			
		}
		
	}
	
	m.forEach((k,v)->System.out.println(k+"="+v));		
	br.close();
}
}