package frontend.Product;

// public class ProductController {

// }

import javax.swing.SwingUtilities;

import frontend.MainScreenCustomer.MainScreenCustomerView;

public class ProductController {

    private ProductView view;
    private ProductModel model;

    public ProductController(ProductView view2, ProductModel model) {
        this.view = view2;
        this.model = model;
        view2.setController(this);
        updateView();
    }

    public ProductController(MainScreenCustomerView view2, ProductModel model2) {
    }

    public void updateView() {
        view.updateProduct(model.getProducts());
    }
}
