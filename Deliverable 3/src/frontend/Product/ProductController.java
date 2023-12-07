package frontend.Product;

public class ProductController {

    private ProductView view;
    private ProductModel model;

    public ProductController(ProductView view, ProductModel model) {
        this.view = view;
        this.model = model;
    }
}
