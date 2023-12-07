// ProductModel.java
// Ethan Curtis

package frontend.Product;

import common.*;

/**
 * Manages the data and actions related to an individual product in the shopping cart.
 * Interacts with the ShoppingCart to modify the quantity of the associated product in the cart.
 */
public class ProductModel {
    private Product product;
    private ShoppingCart shoppingCart;

    /**
     * Constructs a ProductModel object with the associated Product and ShoppingCart.
     *
     * @param product      The Product object associated with this model.
     * @param shoppingCart The ShoppingCart object associated with this model.
     */
    public ProductModel(Product product, ShoppingCart shoppingCart) {
    	this.product = product;
    	this.shoppingCart = shoppingCart;
    }

    /**
     * Retrieves the Product associated with this model.
     *
     * @return The Product object associated with this model.
     */
    public Product getProduct() {
    	return product;
    }
    
    /**
     * Retrieves the count of the associated product in the shopping cart.
     *
     * @return The quantity of the product in the cart.
     */
    public int getCount() {
    	return shoppingCart.getCount(product);
    }
    
    /**
     * Increments the quantity of the associated product in the shopping cart.
     */
    public void incrementToCart() {
    	shoppingCart.incrementProduct(product);
    }
    
    /**
     * Decrements the quantity of the associated product in the shopping cart.
     */
    public void decrementFromCart() {
    	shoppingCart.decrementProduct(product);
    }
}
