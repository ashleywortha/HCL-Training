package com.hcl;

public class Student {
	
	public static String average(int t1, int t2, int t3) {
		int avg = (t1+t2+t3)/3;
		if(avg > 50) {
			return("This student has passed :)");
		} else {
			return("This student has failed :(");
		}
		
	}
	
	public static String input(String name) {
		return("Student's name is: " + name);
	}
	
	public static void main(String[] args) {
		System.out.println("Welcome to the Student class");

	}

}
