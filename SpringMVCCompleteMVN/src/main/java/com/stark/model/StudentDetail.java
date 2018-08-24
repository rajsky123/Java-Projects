package com.stark.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class StudentDetail {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer rollno;
	private String name;
	private String password;
	private String graduationType;
	private String stream;
	
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGraduationType() {
		return graduationType;
	}
	public void setGraduationType(String graduationType) {
		this.graduationType = graduationType;
	}
	public String getStream() {
		return stream;
	}
	public void setStream(String stream) {
		this.stream = stream;
	}
	public Integer getRollno() {
		return rollno;
	}
	public void setRollno(Integer rollno) {
		this.rollno = rollno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	

}
