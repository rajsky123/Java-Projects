package com.hib.java;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="student_detail")
public class Student {
	
	@Id
    @GenericGenerator(name="ii",strategy="com.hib.java.PKHQL")
	@GeneratedValue(generator="ii")
	private int id;
	private String name;
	private double perc;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPerc() {
		return perc;
	}
	public void setPerc(double perc) {
		this.perc = perc;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", perc=" + perc + "]";
	}
	

}
