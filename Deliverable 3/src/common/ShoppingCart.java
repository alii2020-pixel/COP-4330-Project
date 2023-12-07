// ShoppingCart.java
// Ethan Curtis

package common;

import java.awt.event.ActionListener;
import java.util.*;

/**
 * Represents a shopping cart that holds products and their quantities.
 */
public class ShoppingCart {
	private List<Product> products;
	private List<Integer> counts;
	private List<ActionListener> cartUpdatedListeners;
	
	/**
     * Constructs an empty ShoppingCart.
     */
	public ShoppingCart() {
		products = new LinkedList<>();
		counts = new LinkedList<>();
		cartUpdatedListeners = new LinkedList<>();
	}
	
	/**
     * Constructs a ShoppingCart with initial items and their quantities.
     *
     * @param items A map containing products as keys and their quantities as values.
     */
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
	
	/**
     * Constructs a ShoppingCart with given lists of products and their quantities.
     *
     * @param products The list of products.
     * @param counts   The list of corresponding quantities.
     */
	public ShoppingCart(List<Product> products, List<Integer> counts) {
		this.products = products;
		this.counts = counts;
		cartUpdatedListeners = new LinkedList<>();
	}

	/**
     * Checks if the ShoppingCart contains a particular product.
     *
     * @param product The product to check for existence.
     * @return True if the product exists in the cart, otherwise false.
     */
	public boolean contains(Product product) {
		return products.contains(product);
	}
	
	/**
     * Increments the quantity of a product in the ShoppingCart.
     * If the product is not present, it adds it to the cart.
     *
     * @param product The product to increment in the cart.
     */
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
	
	/**
     * Decrements the quantity of a product in the ShoppingCart.
     * If the quantity becomes zero, it removes the product from the cart.
     *
     * @param product The product to decrement in the cart.
     */
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
	
	/**
     * Retrieves the product at a specified index in the ShoppingCart.
     *
     * @param index The index of the product to retrieve.
     * @return The product at the specified index.
     */
	public Product getProduct(int index) {
		return products.get(index);
	}
	
	/**
     * Retrieves the list of products in the ShoppingCart.
     *
     * @return The list of products in the ShoppingCart.
     */
	public List<Product> getProducts() {
		return products;
	}
	
	/**
     * Retrieves the quantity of a product at a specified index in the ShoppingCart.
     *
     * @param index The index of the product to retrieve the quantity for.
     * @return The quantity of the product at the specified index.
     */
	public Integer getCount(int index) {
		return counts.get(index);
	}
	
	/**
     * Retrieves the quantity of a specified product in the ShoppingCart.
     *
     * @param product The product to retrieve the quantity for.
     * @return The quantity of the specified product in the ShoppingCart.
     */
	public Integer getCount(Product product) {
		int productIndex = products.indexOf(product);
		
		if (productIndex == -1) return 0;
		return counts.get(productIndex);
	}
	
	/**
     * Calculates the total price of all products in the ShoppingCart.
     *
     * @return The total price of all products in the ShoppingCart.
     */
	public double getCartTotal() {
		double total = 0;
		
		for (int i = 0; i < products.size(); i++) {
			total += products.get(i).getPrice() * counts.get(i);
 		}
		
		return total;
	}
	
	/**
     * Notifies listeners that the cart has been updated.
     * Triggers an action event for each registered listener.
     */
	private void cartUpdatedEvent() {
		for (ActionListener listener : cartUpdatedListeners) {
			if (listener == null) {
				cartUpdatedListeners.remove(listener);
				continue;
			}
			
			listener.actionPerformed(null);
		}
	}
	
	/**
     * Adds a listener for cart updated events.
     *
     * @param listener The ActionListener to be added as a listener.
     */
	public void addCartUpdatedListener(ActionListener listener) {
		cartUpdatedListeners.add(listener);
	}
	
	/**
     * Removes a listener for cart updated events.
     *
     * @param listener The ActionListener to be removed as a listener.
     */
	public void removeCartUpdatedListener(ActionListener listener) {
		cartUpdatedListeners.remove(listener);
	}
	
	/**
     * Removes all products from the ShoppingCart.
     */
	public void removeAllProducts() {
		products = new LinkedList<>();
		counts = new LinkedList<>();
	}
}
