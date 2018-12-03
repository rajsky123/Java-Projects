package DesignPatterns.AdapterDesignPatterns;

public class School {

	public static void main(String[] args) {

		Pen pa=new PenAdapter();
		Assignment a=new Assignment();
		a.setP(pa);
		a.writeAssignment("I am tired to write assignment");
	}

}
