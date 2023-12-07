// Customer.java
// Ethan Curtis

package common;

/**
 * Represents a Customer, extending the User class, with specific functionalities.
 */
public class Customer extends User {

    /**
     * Constructs a Customer with the provided username and password.
     *
     * @param username The username for the Customer.
     * @param password The password for the Customer.
     */
    public Customer(String username, String password) {
        super(username, password);
        
        cart = new ShoppingCart(); // in reality, would load from server.
    }

    private ShoppingCart cart;

    /**
     * Retrieves the ShoppingCart associated with this Customer.
     *
     * @return The ShoppingCart object containing items for this Customer.
     */
    public ShoppingCart getShoppingCart() {
        return cart;
    }
}

