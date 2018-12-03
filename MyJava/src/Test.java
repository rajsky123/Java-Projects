import java.util.HashMap;
import java.util.Map;

public class Test {
	public static void main(String[] args) {
	
		String s="abc bbb abc bbb";
		
		char ch[]=s.toCharArray();	
		String temp="";
		Map<String, Integer> m=new HashMap<>();
		for(int i=0;i<ch.length;i++)
		{
			if(ch[i]!=' ')
			{
				temp+=ch[i];
				
			}
			
			if(ch[i]==' ' || i==ch.length-1)
			{  
				if(!m.containsKey(temp))
				{
					m.put(temp, 1);
					
				}
				else
				{
				   m.put(temp, m.get(temp)+1);	
				}
				temp="";
			}
			
		}
		System.out.println(m);
		
	}
	
}