// MainScreenCustomerModel.java
// Ethan Curtis

package frontend.MainScreenCustomer;

import java.util.*;
import common.*;

public class MainScreenCustomerModel {
	private Customer customer;
	
	public MainScreenCustomerModel(Customer customer) {
		this.customer = customer;
	}
	
	public Customer getCustomer() {
		return customer;
	}
	
	public List<Product> getProducts() {
		// TODO: LOAD ACTUAL LIST OF ALL PRODUCTS
		
		return new LinkedList<Product>(Arrays.asList(
			new Product("Item 1", "An item you can buy", 100.00),
			new Product("Item 2", "Another item you can buy", 200.00),
			new Product("Item 3", "Last item you can buy", 300.00),
			new Product("Item 4", "test", 35.125),
			new Product("Item 5", "test2", 11.35),
			new Product("Item 6", "test3", 78.46)
		));
	}
}


