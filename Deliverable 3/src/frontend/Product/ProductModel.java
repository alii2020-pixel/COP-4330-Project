// ProductModel.java
// Ethan Curtis

package frontend.Product;

import common.Product;

public class ProductModel {
    private Product product;

    public ProductModel(Product product) {
    	this.product = product;
    }

    public Product getProduct() {
    	return product;
    }
    
    /**
     * Adds this product to the shopping cart.
     */
    public void addToCart() {
    	// Adds this product to the cart
    }
}
