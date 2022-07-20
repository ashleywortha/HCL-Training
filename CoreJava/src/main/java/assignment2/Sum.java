package assignment2;

import java.util.Scanner;

public class Sum {
	public static boolean sumTwoEqualThree(int a, int b, int c) {
		int sum = a+b;
		if(sum == c) {
			return true;
		} else {return false;}
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("This function calculates the sum of two integer, a + b and determines if they equal a third integer c.");
		System.out.println("Enter the value for a: ");
		
		while(!s.hasNextInt()) {
			System.out.println("That's not an Integer! Please try again.");
			s.next();
		}
		int a = s.nextInt();
		
		System.out.println("Enter the value for b: ");
		while(!s.hasNextInt()) {
			System.out.println("That's not an Integer! Please try again.");
			s.next();
		}
		int b = s.nextInt();
		
		System.out.println("Enter the value for c: ");
		while(!s.hasNextInt()) {
			System.out.println("That's not an Integer! Please try again.");
			s.next();
		}
		int c = s.nextInt();
		s.close();
		
		boolean result = sumTwoEqualThree(a, b, c);
		System.out.println("Does " + a + " + " + b + " = " + c + "?: " + result);
	}
	
	

}
