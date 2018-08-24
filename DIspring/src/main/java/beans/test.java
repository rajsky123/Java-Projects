package beans;

import java.util.*;

import org.springframework.beans.factory.annotation.Required;



public class test {
 private String carname;	
 private Engine engine;
 /*private Vector car;
 private TreeSet animals;
 private Hashtable cc;
 private Properties drivers;*/
 
 
 public void setCarname(String carname) {
	this.carname = carname;
}
 
 public void setEngine(Engine engine) {
	this.engine = engine;
}
   /*public void setCar(Vector car) {
	this.car = car;
}

   public void setAnimals(TreeSet animals) {
	this.animals = animals;
}
   
   public void setCc(Hashtable cc) {
	this.cc = cc;
}

public void setDrivers(Properties drivers) {
	this.drivers = drivers;
}
*/
	public void getName()
	{
		System.out.println("carname="+carname);
		System.out.println("modelyr="+engine.getModelyr());
		/*System.out.println("car-----------------------");
		for(Object c:car)
			System.out.println(c);
		System.out.println("animals---------------------");
		for(Object a:animals)
			System.out.println(a);
		System.out.println("country and capi-------------");
		Set keys=cc.keySet();
		for(Object k:keys )
			System.out.println("country:"+k+" capital:"+cc.get(k));
		
		System.out.println("Properties------------------");
		Set kk=drivers.keySet();
		for(Object k:kk )
			System.out.println(k+":"+drivers.get(k));*/
	}

}
