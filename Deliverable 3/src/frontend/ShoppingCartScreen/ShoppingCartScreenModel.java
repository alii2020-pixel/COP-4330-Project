// ShoppingCartScreenModel.java
// Ethan Curtis

package frontend.ShoppingCartScreen;

import common.*;

/**
 * Manages the shopping cart data for the ShoppingCartScreen.
 * Stores the customer's shopping cart information.
 */
public class ShoppingCartScreenModel {
    private Customer customer;

    /**
     * Constructs a ShoppingCartScreenModel.
     *
     * @param customer The customer whose shopping cart is being managed.
     */
    public ShoppingCartScreenModel(Customer customer) {
        this.customer = customer;
    }

    /**
     * Retrieves the customer associated with this shopping cart.
     *
     * @return The customer object.
     */
    public Customer getCustomer() {
        return customer;
    }
}
