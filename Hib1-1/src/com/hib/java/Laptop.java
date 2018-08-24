package com.hib.java;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class Laptop {
    @Id
    @GenericGenerator(name="inc",strategy="increment")
    @GeneratedValue(generator="inc")
	private int lapId;
	private String lapName;
	@ManyToOne
	@JoinColumn(name="student_id")
	private Student st;
	public Student getSt() {
		return st;
	}
	public void setSt(Student st) {
		this.st = st;
	}
	public int getLapId() {
		return lapId;
	}
	public void setLapId(int lapId) {
		this.lapId = lapId;
	}
	public String getLapName() {
		return lapName;
	}
	public void setLapName(String lapName) {
		this.lapName = lapName;
	}
	
}
