package DesignPatterns.BuilderDesignPattern;

public class PhoneShop {

	public static void main(String[] args) {

		Phone p=new PhoneBuilder().setOs("Android").setBattery(4000).getPhone();
		System.out.println(p);
		
	}

}
