package assignment2;

import java.util.Scanner;

public class Prime {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		System.out.println("This program determines if an integer is prime");
		System.out.println("Enter an integer below");
		int num = s.nextInt();
		s.close();
		
		boolean isPrime = true;
		for(int i = 2; i<=num/2; i++) {
			if(num % i == 0) {
				isPrime = false;
				break;
			}
		}
		
		if(isPrime) {
			System.out.println(num + " is a prime number");
		} else {
			System.out.println(num + " is not a prime number");
		}
	}

}
