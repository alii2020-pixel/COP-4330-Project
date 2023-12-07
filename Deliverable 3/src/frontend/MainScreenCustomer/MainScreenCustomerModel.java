// MainScreenCustomerModel.java
// Ethan Curtis

package frontend.MainScreenCustomer;

import java.util.*;
import common.*;

public class MainScreenCustomerModel {
	ShoppingCart shoppingCart;
	
	public MainScreenCustomerModel() {
		shoppingCart = new ShoppingCart(); // TODO: SWITCH TO LOADING FROM SERVER?
	}
	
	public ShoppingCart getShoppingCart() {
		return shoppingCart;
	}
	
	public List<Product> getProducts() {
		return new LinkedList<Product>(Arrays.asList(
			new Product("Item 1", "An item you can buy", 100.00),
			new Product("Item 2", "Another item you can buy", 200.00),
			new Product("Item 3", "Last item you can buy", 300.00)
		));
	}
}


