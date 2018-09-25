import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import org.apache.commons.lang.builder.CompareToBuilder;

class Emp 
{
	int id;
    String name;
	public Emp(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	@Override
	public String toString() {
		return "Emp [id=" + id + ", name=" + name + "]";
	}
}

class Idcomp implements Comparator<Emp>
{

	@Override
	public int compare(Emp e1, Emp e2) {
		
		return e1.id-e2.id;
	}
}
class Namecomp implements Comparator<Emp>
{

	@Override
	public int compare(Emp e1, Emp e2) {
		
		
		return e1.name.compareTo(e2.name);
	}

}	

class Mycomp implements Comparator<Emp>
{

	List<Comparator<Emp>> empList;
	
	@SafeVarargs
	public Mycomp(Comparator<Emp>...empList) {
		
		this.empList=Arrays.asList(empList);
	}
	
	@Override
	public int compare(Emp e1, Emp e2) {
		
		
		
		for (Comparator<Emp> comparator : empList) {
			int result= comparator.compare(e1, e2);
			if(result!=0)
				return result;
		}
		return 0;
	}
}

class ApacheCommonsApi implements Comparator<Emp>{

	@Override
	public int compare(Emp e1, Emp e2) {
		return new CompareToBuilder()
				.append(e2.id, e1.id)
				.append(e1.name, e2.name).toComparison();
				
	}
	
	
}

public class ComparatorUsingMultipleFields {
	
	
	public static void main(String[] args) {
		
		Emp e[]=new Emp[3];
		e[0]=new Emp(3, "sakira");
		e[1]=new Emp(7, "rakshita");
		e[2]=new Emp(1, "aksha");
		//Arrays.sort(e, new Mycomp(new Idcomp(),new Namecomp()));
		Arrays.sort(e, new ApacheCommonsApi());
		for (Emp emp : e) {
			System.out.println(emp);
		}
		
		
	
		
	}
}