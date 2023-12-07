// Seller.java
// Ethan Curtis

package common;

import java.util.List;
import java.util.LinkedList;

/**
 * Represents a Seller, extending the User class, who manages a list of products.
 */
public class Seller extends User {
    private List<Product> products;

    /**
     * Constructs a Seller with the provided username and password.
     *
     * @param username The username for the Seller.
     * @param password The password for the Seller.
     */
    public Seller(String username, String password) {
        super(username, password);
        products = new LinkedList<>();
    }

    /**
     * Adds a product to the Seller's list of products.
     *
     * @param product The product to be added.
     */
    public void addProduct(Product product) {
        products.add(product);
    }

    /**
     * Removes a product from the Seller's list of products.
     *
     * @param product The product to be removed.
     */
    public void removeProduct(Product product) {
        products.remove(product);
    }

    /**
     * Retrieves the list of products managed by the Seller.
     *
     * @return The list of products managed by the Seller.
     */
    public List<Product> getProducts() {
        return products;
    }
}
