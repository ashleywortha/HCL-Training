package assignment2;

import java.util.Scanner;

public class Reverse {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter a word to reverse it");
		
		while(!s.hasNext()) {
			System.out.println("That's not a word! Please try again.");
			s.next();
		}
		s.close();
		String word = s.next();
		char[] charWord = word.toCharArray();
		char[] newWord = new char[word.length()];
		
		int k = 0;
		for(int i=word.length()-1; i>=0; i--) {
			newWord[k] = charWord[i];
			k++;
		}
		String result = String.valueOf(newWord);
		System.out.println("Reversed word is: " + result);
	}

}
