// ShoppingCart.java
// Ethan Curtis

package common;

import java.awt.event.ActionListener;
import java.util.*;

public class ShoppingCart {
	private List<Product> products;
	private List<Integer> counts;
	private List<ActionListener> cartUpdatedListeners;
	
	public ShoppingCart() {
		products = new LinkedList<>();
		counts = new LinkedList<>();
		cartUpdatedListeners = new LinkedList<>();
	}
	
	public ShoppingCart(Map<Product, Integer> items) {
		products = new LinkedList<>();
		counts = new LinkedList<>();
		cartUpdatedListeners = new LinkedList<>();
		
		for (Product product : items.keySet()) {
			int count = items.get(product);
			if (count < 1) continue;
			
			products.add(product);
			counts.add(count);
		}
	}
	
	public ShoppingCart(List<Product> products, List<Integer> counts) {
		this.products = products;
		this.counts = counts;
		cartUpdatedListeners = new LinkedList<>();
	}

	public boolean contains(Product product) {
		return products.contains(product);
	}
	
	public void incrementProduct(Product product) {
		int productIndex = products.indexOf(product);
		
		if (productIndex != -1) {
			counts.set(productIndex, counts.get(productIndex) + 1);
		}
		else {
			products.add(product);
			counts.add(1);
		}
		
		cartUpdatedEvent();
	}
	
	public void decrementProduct(Product product) {
		int productIndex = products.indexOf(product);
		
		if (productIndex != -1) {
			int count = counts.get(productIndex) - 1;
			if (count < 1) {
				products.remove(productIndex);
				counts.remove(productIndex);
			}
			else {
				counts.set(productIndex, count);
			}
			
			cartUpdatedEvent();
		}
	}
	
	public Product getProduct(int index) {
		return products.get(index);
	}
	
	public List<Product> getProducts() {
		return products;
	}
	
	public Integer getCount(int index) {
		return counts.get(index);
	}
	
	public Integer getCount(Product product) {
		int productIndex = products.indexOf(product);
		
		if (productIndex == -1) return 0;
		return counts.get(productIndex);
	}
	
	public double getCartTotal() {
		double total = 0;
		
		for (int i = 0; i < products.size(); i++) {
			total += products.get(i).getPrice() * counts.get(i);
 		}
		
		return total;
	}
	
	private void cartUpdatedEvent() {
		for (ActionListener listener : cartUpdatedListeners) {
			if (listener == null) {
				cartUpdatedListeners.remove(listener);
				continue;
			}
			
			listener.actionPerformed(null);
		}
	}
	
	public void addCartUpdatedListener(ActionListener listener) {
		cartUpdatedListeners.add(listener);
	}
	
	public void removeCartUpdatedListener(ActionListener listener) {
		cartUpdatedListeners.remove(listener);
	}
}
