package com.hcl;

abstract class Vehicle {
	static int id = 0;
	String model;
	String mannu;
	String color;
	int vid;
	public Vehicle (String carMod, String manu, String col) {
		vid = id;
		model = carMod;
		mannu = manu;
		color = col;	
		id++;
	}
	

}

public class Truck extends Vehicle {
	int loadCapacity;

	public Truck(String carMod, String manu, String col) {
		super(carMod, manu, col);
		vid = id;
		model = carMod;
		mannu = manu;
		color = col;
		loadCapacity = 100;
		id++;
		
	}
	
	public void changeLoading(int newSize) {
		this.loadCapacity = newSize;
		System.out.println("load size updated!");
		System.out.println("Updated Truck Details:");
		System.out.println("Vehicle id: " + this.id);
		System.out.println("Model: " + this.model);
		System.out.println("Color: " + this.model);
		System.out.println("Load Capacity: " + this.loadCapacity);
		return;
		
	}
	
	public void changeColor(String newColor) {
		this.color = newColor;
		System.out.println("Color Updated!");
		System.out.println("Updated Truck Details:");
		System.out.println("Vehicle id: " + this.id);
		System.out.println("Model: " + this.model);
		System.out.println("Color: " + this.model);
		System.out.println("Load Capacity: " + this.loadCapacity);
		return;
		
	}
	
	public static void main(String[] args) {
		Truck t1 = new Truck("modelName", "mannufactureType", "red");
		t1.changeColor("blue");
		t1.changeLoading(200);
		
	}
	
	
}