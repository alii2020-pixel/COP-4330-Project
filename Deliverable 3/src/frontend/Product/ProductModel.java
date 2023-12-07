package frontend.Product;

import common.*;

public class ProductModel {
    private Product product;
    private int productCount;
    private ShoppingCart shoppingCart;

    public ProductModel(Product product, ShoppingCart shoppingCart) {
    	this.product = product;
    	this.shoppingCart = shoppingCart;
    	productCount = shoppingCart.getCount(product);
    }

    public Product getProduct() {
    	return product;
    }
    
    public int getCount() {
    	return productCount;
    }
    
    /**
     * Increments product in cart.
     */
    public void incrementToCart() {
    	shoppingCart.incrementProduct(product);
    }
    
    /**
     * Decrements product in cart.
     */
    public void decrementFromCart() {
    	shoppingCart.decrementProduct(product);
    }
}
