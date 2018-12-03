package DesignPatterns.BuilderDesignPattern;

public class Phone {
	
	private String Os;
	private String processor;
	private double screensize;
	private int battery;
	private int cameraPix;
	
	public Phone(String os, String processor, double screensize, int battery, int cameraPix) {
		super();
		Os = os;
		this.processor = processor;
		this.screensize = screensize;
		this.battery = battery;
		this.cameraPix = cameraPix;
	}

	@Override
	public String toString() {
		return "Phone [Os=" + Os + ", processor=" + processor + ", screensize=" + screensize + ", battery=" + battery
				+ ", cameraPix=" + cameraPix + "]";
	}
	
	

}
