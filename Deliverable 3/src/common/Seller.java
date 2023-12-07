// Seller.java
// Ethan Curtis

package common;

import java.util.*;

public class Seller extends User {
	private List<Product> products;
	
	public Seller(String username, String password) {
		super(username, password);
		products = new LinkedList<>();
	}
	
	public void addProduct(Product product) {
		products.add(product);
	}
	
	public void removeProduct(Product product) {
		products.remove(product);
	}
	
	public List<Product> getProducts() {
		return products;
	}
}
