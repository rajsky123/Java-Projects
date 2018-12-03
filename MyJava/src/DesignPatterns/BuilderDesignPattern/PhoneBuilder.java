package DesignPatterns.BuilderDesignPattern;

public class PhoneBuilder {

	private String Os;
	private String processor;
	private double screensize;
	private int battery;
	private int cameraPix;
	public PhoneBuilder setOs(String os) {
		Os = os;
		return this;
	}
	public PhoneBuilder setProcessor(String processor) {
		this.processor = processor;
		return this;
	}
	public PhoneBuilder setScreensize(double screensize) {
		this.screensize = screensize;
		return this;
	}
	public PhoneBuilder setBattery(int battery) {
		this.battery = battery;
		return this;
	}
	public PhoneBuilder setCameraPix(int cameraPix) {
		this.cameraPix = cameraPix;
		return this;
	}
	
	public Phone getPhone() {
		
		return new Phone(Os, processor, screensize, battery, cameraPix);
	}
}
