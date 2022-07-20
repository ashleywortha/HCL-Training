package assignment2;

import java.util.Scanner;

public class Swap {
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("This program will swap two integer variables");
		System.out.println("Enter the value for variable 1, a: ");
		int a = s.nextInt();
		System.out.println("Enter the value for variable 2, b: ");
		int b = s.nextInt();
		s.close();
		
		int hold = a;
		a = b;
		b = hold;
		
		System.out.println("The variables have been swapped");
		System.out.println("The value of a is: " + a);
		System.out.println("The value of b is: " + b);
		
		
	}

}
