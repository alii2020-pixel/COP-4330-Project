package frontend.Product;

public class ProductController {

    private ProductView view;
    private ProductModel model;

    public ProductController(ProductView view, ProductModel model) {
        this.view = view;
        this.model = model;
        
        view.addIncrementButtonListener(e -> onIncrementButtonClicked());
        view.addDecrementButtonListener(e -> onDecrementButtonClicked());
    }
    
    private void onIncrementButtonClicked() {
    	model.incrementToCart();
    	updateCountLabel();
    }
    
    private void onDecrementButtonClicked() {
    	model.decrementFromCart();
    	updateCountLabel();
    }
    
    private void updateCountLabel() {
    	view.setCountLabelText(Integer.toString(model.getCount()) + " item(s) in cart.");
    }
}
