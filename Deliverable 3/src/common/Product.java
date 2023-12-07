// Product.java
// Ethan Curtis

package common;

/**
 * Represents a product with a name, description, and price.
 */
public class Product {
    private String name;
    private String description;
    private double price;

    /**
     * Constructs a default Product with empty name, description, and price set to 0.
     */
    public Product() {
        name = "";
        description = "";
        price = 0;
    }

    /**
     * Constructs a Product with the specified name, description, and price.
     *
     * @param name        The name of the product.
     * @param description The description of the product.
     * @param price       The price of the product.
     */
    public Product(String name, String description, double price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    /**
     * Retrieves the name of the product.
     *
     * @return The name of the product.
     */
    public String getName() {
        return name;
    }

    /**
     * Retrieves the description of the product.
     *
     * @return The description of the product.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Retrieves the price of the product.
     *
     * @return The price of the product.
     */
    public double getPrice() {
        return price;
    }

    /**
     * Sets the name of the product.
     *
     * @param name The name to be set for the product.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the description of the product.
     *
     * @param description The description to be set for the product.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Sets the price of the product.
     *
     * @param price The price to be set for the product.
     */
    public void setPrice(double price) {
        this.price = price;
    }
}
