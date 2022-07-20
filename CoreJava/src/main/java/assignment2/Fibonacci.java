package assignment2;

import java.util.Scanner;

public class Fibonacci{
	static void fibonacci(int n) {
		int num1 = 0;
		int num2 = 1;
		int i = 0;
		
		System.out.println("The Fibonacci Series of " + n + " is: ");
		
		while (i < n) {
			System.out.print(num1 + ", ");
			
			int num3 = num2 + num1;
			num1 = num2;
			num2 = num3;
			i = i + 1;
		}
		 
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("This program returns the fibonacci series of an integer");
		System.out.println("Enter an integer: ");
		int n = s.nextInt();
		s.close();
		fibonacci(n);
	}
	
}