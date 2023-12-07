// ProductSellerModel.java
// Ethan Curtis

package frontend.ProductSeller;

import common.Product;

public class ProductSellerModel {
	private Product product;
	
	public ProductSellerModel(Product product) {
		this.product = product;
	}
	
	public Product getProduct() {
		return product;
	}
}
