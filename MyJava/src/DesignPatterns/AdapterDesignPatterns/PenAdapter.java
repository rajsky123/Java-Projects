package DesignPatterns.AdapterDesignPatterns;

public class PenAdapter implements Pen{

	PilotPen p=new PilotPen();
	
	public void write(String str) {
		p.mark(str);
	}

}
