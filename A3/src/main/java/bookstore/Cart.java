package bookstore;

import java.util.HashSet;
import java.util.Set;

public class Cart {
	Set<Item> myCart;
	public Cart(int id) {
		int cid = id;
		myCart = new HashSet<>();
	}
	
	public void addToCart(Item item) {
		myCart.add(item);
		System.out.println(item.itemName + " has been added to your cart");
		
	}
	
	public void removeFromCart(Item item) {
		myCart.remove(item);
		System.out.println(item.itemName + " has been removed from your cart");
		
	}
	
	public void checkout() {
		double total = 0.00;
		for(Item item: myCart) {
			System.out.println(item.itemName + ": " + item.price);
			total = total + item.price;
		}
		System.out.println("------------------------");
		System.out.println("Total Cost: " + total);
		System.out.println("Do you want to check out?");
		
	}

}
