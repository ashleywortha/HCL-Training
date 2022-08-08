package com.ashley.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="emp_july")
public class Employee {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int empId;
	private String name;
	private String designation;
	private double salary;
	
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}
	
	public void setName(String nName) {
		name = nName;
	}
	
	public void setDesignation(String nDes) {
		designation = nDes;
	}
	
	public String getDesignation() {
		return designation;
	}
	

}
