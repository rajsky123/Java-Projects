package com.hib.java;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class Student {
	
	@Id
	@GenericGenerator(name="inc",strategy="increment")
    @GeneratedValue(generator="inc")
	private int StudId;
	private String studName;
	private double studPerc;
	@OneToMany(cascade=CascadeType.ALL,mappedBy="st")
	private List<Laptop> lp=new ArrayList<Laptop>();
	public int getStudId() {
		return StudId;
	}
	public void setStudId(int studId) {
		StudId = studId;
	}
	
	public String getStudName() {
		return studName;
	}
	public void setStudName(String studName) {
		this.studName = studName;
	}
	public double getStudPerc() {
		return studPerc;
	}
	public void setStudPerc(double studPerc) {
		this.studPerc = studPerc;
	}
	public List<Laptop> getLaptop() {
		return lp;
	}
	public void setLaptop(List<Laptop> lp) {
		this.lp = lp;
	}
	
		

}
