package com.hcl;

import java.util.Scanner;

public class Washingmachine {
	boolean IO;
	boolean hasClothes;
	boolean hasDetergent; 
	
	public Washingmachine() {
		IO = false;
		hasClothes = false;
		hasDetergent = false;
		
	}
	
	public static void switchOn(Washingmachine w) {
		if(w.IO) {
			System.out.println("Washing Machine is already on!");
			return;
		} else if (!w.hasClothes) {
			System.out.println("You do not have any clothes loaded");
			return;
		} else if(!w.hasDetergent) {System.out.println("You do not have any detergent in!"); return;}
		w.IO = true;
		System.out.println("Washing Machine is now on");
		return;
	}
	
	public static void switchOff(Washingmachine w) {
		if(!w.IO) {
			System.out.println("Washing Machine is already off!");
		}
		System.out.println("Washing Machine has been turned off");
		w.IO = false;
		return;
	}
	
	public static void loadClothes(Washingmachine w, int num) {
		if(w.IO) {
			System.out.println("Can't put in clothes, washing machine is already on!");
			return;
		}
		if(w.hasClothes) {
			System.out.println("The washing machine is already full");
			return;
		}
		w.hasClothes = true;
		System.out.println( num + " clothes have been added to the machine");
		return;
	}
	
	public static void addDetergent(Washingmachine w) {
		if(w.hasDetergent) {
			System.out.println("You already have put detergent in!");
			return;
		}
		w.hasDetergent = true;
		System.out.println("Detergent has been added to the machine");
		return;
		
	}
	
	
	public static void main(String[] args) {
		System.out.println("Welcome to the laundromat! What would you like to do today?");
		
		Scanner s = new Scanner(System.in);
		Washingmachine w1 = new Washingmachine();
		
		String input = "none";
		
		while(!(input.equals("Exit"))) {
			System.out.println("Type in one of the following commands to continue");
			System.out.println("Load Clothes: LOAD, Add Detergent: ADD, Turn On Machine: ON,Turn Off Machine: OFF, Exit: Exit");
			
			input = s.next();

			switch(input) {
			case "LOAD":
				System.out.println("How many articles of clothing would you like to add?");
				int num = s.nextInt();
				loadClothes(w1, num);
				break;
			case "ADD":
				addDetergent(w1);
				break;
			case "ON":
				switchOn(w1);
				break;
			case "OFF":
				switchOff(w1);
				break;
			case "Exit":
				break;
			default: 
				System.out.println("Command not found, try again.");
			}
		}
		s.close();
		System.out.println("Thanks for visiting the laundromat!");
	}

}
