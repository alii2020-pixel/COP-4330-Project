// MainScreenCustomerModel.java
// Ethan Curtis

package frontend.MainScreenCustomer;

import java.util.*;
import common.*;

/**
 * Represents the model component for the main screen of a customer.
 */
public class MainScreenCustomerModel {
	private Customer customer;
	
	/**
     * Constructs a MainScreenCustomerModel with the associated Customer.
     *
     * @param customer The customer associated with the main screen.
     */
	public MainScreenCustomerModel(Customer customer) {
		this.customer = customer;
	}
	
	/**
     * Retrieves the customer associated with the main screen.
     *
     * @return The customer associated with the main screen.
     */
	public Customer getCustomer() {
		return customer;
	}
	
	/**
     * Retrieves a list of products available for display on the main screen.
     *
     * @return A list of products available for display.
     */
	public List<Product> getProducts() {
		// Would load from server
		
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


