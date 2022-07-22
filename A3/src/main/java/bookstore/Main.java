package bookstore;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
/*Implementation with user input is not finished but the logic is done
 * existing users will log in, new users will create a new account that creates a new user object */

public class Main {
	boolean loggedIn;
	User curUser;
	Set<User> users = new HashSet<>();
	Set<Item> items = new HashSet<>();
	
	public Main() {
		loggedIn = false;
		curUser = null;
	}
	
	public void logOn(String user, String pass) {
		for(User u: users) {
			if(u.userName.equals(user) && (u.password.equals(pass))) {
				curUser = u;
				loggedIn = true;
				return;
			}
		} 
		System.out.println("Username and Password do not match OR you do not have an account");
		return;
		
	}
	
	public void logOff() {
		loggedIn = false;
		System.out.println("You have logged out");
		return;
		
	}
	
	public void addFakedata() {
		//Test Users
		User u1 = new User("janedoe", "ilovebookstore", "Jane", "Doe");
		User u2 = new User("ash", "123", "Ashley", "Wortham");
		
		users.add(u1);
		users.add(u2);
				
		//Items in store
		Item b1 = new Book("Of Mice and Men", 8.99, "John Steinbeck", 1937);
		Item b2 = new Book("Dune", 11.99, "John Schoenherr", 1965);
				
		Item cd1 = new CD("Mirror Might Steal Your Charm", 7.99, "The Garden", 2018, "Epitaph");
		Item cd2 = new CD("Harry's House", 12.99, "Harry Styles", 2022, "Columbia");
				
		Item s1 = new Software("Adobe Creative Suite 2022", 120.99, 5, 2023);
		Item s2 = new Software("Unity", 50.99, 3, 2023);
				
		items.add(b1);
		items.add(b2);
		items.add(cd1);
		items.add(cd2);
		items.add(s1);
		items.add(s2);
	}
	
	public void search(String lookingFor) {
		for(Item item : items) {
			System.out.println(item.itemName.equals(lookingFor));
			if(item.itemName.equals(lookingFor)) {
				System.out.println(item.itemName + " " + item.price);
				return;
			}
		}
		
		System.out.println("No results found :(");
		return;
	}
	
	
	public static void main(String[] args) {
		Main m = new Main();
		m.addFakedata();
		Scanner s = new Scanner(System.in);
		while(!m.loggedIn) {
			System.out.println("Welcome to the book store! Type a Command to continue");
			System.out.println("Login: LOGIN, Create new account: NEW");
			String input = s.next();
			
			if(input.equals("LOGIN")) {
				System.out.println("Username: ");
				String user = s.next();
				System.out.println("Password: ");
				String pass = s.next();
				m.logOn(user, pass);
				
			} else if(input.equals("NEW")) {
				System.out.println("Create Your New Account");
				System.out.println("Username: ");
				String nUser = s.next();
				
				System.out.println("Password: ");
				String nPass = s.next();
				
				System.out.println("First Name: ");
				String fn = s.next();
				
				System.out.println("Last Name: ");
				String ln = s.next();
				User newUser = new User(nUser, nPass, fn, ln);
				m.users.add(newUser);
				m.curUser = newUser;
				m.loggedIn = true;
				
			} else {
				System.out.println("Invalid Command, please try again.");
			}
			
		}
		
		System.out.println("You are now logged in! Enter a command to continue");
		while(m.loggedIn) {
			System.out.println("Search: SEARCH, View Books: VB, Checkout: C, Add to Cart: ADD, Remove from Cart: RM, Logout: LOGOUT");
			
			String in = s.next();
			
			switch(in){
				case "SEARCH":
					System.out.println("Enter the name of the item you are looking for");
					String uItem = s.next();
					m.search(uItem);
					break;
				case "VB":
					break;
				case "C":
					m.curUser.uCart.checkout();
					break;
				case "ADD":
					m.curUser.uCart.addToCart(null);
					break;
				case "RM":
					m.curUser.uCart.removeFromCart(null);
					break;
				case "LOGOUT":
					m.logOff();
					break;
				
			}
		}
		
		System.out.println("Thank you for visiting the bookstore!");
		

	}

}
