// ShoppingCartScreenModel.java
// Ethan Curtis

package frontend.ShoppingCartScreen;

import common.*;

public class ShoppingCartScreenModel {
	Customer customer;
	
	public ShoppingCartScreenModel(Customer customer) {
		this.customer = customer;
	}
	
	public Customer getCustomer() {
		return customer;
	}
}
