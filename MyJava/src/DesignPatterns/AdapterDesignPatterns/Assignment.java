package DesignPatterns.AdapterDesignPatterns;

public class Assignment {
	
	private Pen p;

	public void setP(Pen p) {
		this.p = p;
	}

	public void writeAssignment(String str)
	{
		p.write(str);
	}

}
