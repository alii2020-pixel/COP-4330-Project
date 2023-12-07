// Customer.java
// Ethan Curtis

package common;

public class Customer extends User {
	public Customer(String username) {
		super(username);
	}

	public ShoppingCart cart;
}
