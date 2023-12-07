// ProductSellerModel.java
// Ethan Curtis

package frontend.ProductSeller;

import common.Product;

/**
 * Represents the model for a product within the context of a seller.
 * Manages the product details for the seller's view.
 */
public class ProductSellerModel {
	private Product product;
	
	/**
     * Constructs a ProductSellerModel object.
     *
     * @param product The product associated with this model.
     */
	public ProductSellerModel(Product product) {
		this.product = product;
	}
	
	/**
     * Retrieves the product associated with this model.
     *
     * @return The product object.
     */
	public Product getProduct() {
		return product;
	}
}
