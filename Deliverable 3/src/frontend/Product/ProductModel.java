package frontend.Product;

// public class ProductModel {

// }

import java.util.ArrayList;
import java.util.List;

public class ProductModel {

    private List<String> products;

    public ProductModel() {
        this.products = new ArrayList<>();
        // Edit this to add specific products or product info 
        products.add("Product 1");
        products.add("Product 2");
        products.add("Product 3");
    }

    public List<String> getProducts() {
        return products;
    }
}
