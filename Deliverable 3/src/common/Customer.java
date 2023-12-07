// Customer.java
// Ethan Curtis

package common;

public class Customer extends User {
	public Customer(String username, String password) {
		super(username, password);
		
		cart = new ShoppingCart(); // in reality, would load from server.
	}

	private ShoppingCart cart;
	
	public ShoppingCart getShoppingCart() {
		return cart;
	}
}
