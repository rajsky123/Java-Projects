package beans;

import java.util.*;

public class Utility {
	private Vector fruits;
	private HashSet cars;
	private Hashtable countrysCapitals;

	public void setFruits(Vector fruits) {
		this.fruits = fruits;
	}

	public void setCars(HashSet cars) {
		this.cars = cars;
	}

	public void setCountrysCapitals(Hashtable countrysCapitals) {
		this.countrysCapitals = countrysCapitals;
	}

	public void print() {
		System.out.println("--------------fruits---------------");
		fruits.forEach(fr -> System.out.println(fr));
		System.out.println("--------------cars---------------");
		cars.forEach(System.out::println);
		System.out.println("--------------countryCapitals---------------");
        countrysCapitals.forEach((key,value)->System.out.println("Country= "+key+"  Capital= "+value));
	}

}
