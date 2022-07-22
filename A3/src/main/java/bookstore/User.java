package bookstore;

public class User {
	static int id = 0;
	int uid;
	String userName;
	String password;
	String firstName;
	String lastName;
	String billingAddr;
	String shippingAddr;
	Cart uCart;
	
	public User(String user, String pass, String first, String last) {
		uid = id;
		userName = user;
		password = pass;
		firstName = first;
		lastName = last;
		billingAddr = "No Billing Address Added Yet";
		shippingAddr = "No Shipping Address Added Yet";
		uCart = new Cart(uid);
		id++;
	}

}

/*Other Additions that could be added later
 * 1. creating a class Admin that extends user. those with the admin class
 * distinction would be able to add or remove items from the store's inventory
 *  */
