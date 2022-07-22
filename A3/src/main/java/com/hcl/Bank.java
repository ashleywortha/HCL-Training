package com.hcl;

public class Bank {
	
	static int balance = 0;
	
	public static void withdrawl(int amount) {
		int test = balance - amount;
		if(test < 0) {
			System.out.println("You don't have enough money to make this withdrawl");
			System.out.println("Current Balance: " + balance);
			return;
		}
		balance = balance - amount;
		System.out.println("Your Balance is now " + balance);
		return;
	}
	
	public static void deposit(int amount) {
		balance = balance + amount;
		System.out.println("Your Balance is now " + balance);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
