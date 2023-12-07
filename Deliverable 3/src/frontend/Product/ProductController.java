// ProductController.java
// Ethan Curtis

package frontend.Product;

/**
 * Manages the interaction between the ProductView and ProductModel for an individual product in the application.
 * Handles user actions on the product view and updates the associated model accordingly.
 */
public class ProductController {
    private ProductView view;
    private ProductModel model;

    /**
     * Constructs a ProductController object with the associated ProductView and ProductModel.
     * Registers listeners for the view's increment and decrement buttons.
     *
     * @param view  The ProductView object associated with this controller.
     * @param model The ProductModel object associated with this controller.
     */
    public ProductController(ProductView view, ProductModel model) {
        this.view = view;
        this.model = model;
        
        view.addIncrementButtonListener(e -> onIncrementButtonClicked());
        view.addDecrementButtonListener(e -> onDecrementButtonClicked());
    }
    
    /**
     * Handles the action when the increment button is clicked.
     * Increments the product quantity in the cart through the model and updates the view.
     */
    private void onIncrementButtonClicked() {
    	model.incrementToCart();
    	updateCountLabel();
    }
    
    /**
     * Handles the action when the decrement button is clicked.
     * Decrements the product quantity in the cart through the model and updates the view.
     */
    private void onDecrementButtonClicked() {
    	model.decrementFromCart();
    	updateCountLabel();
    }
    
    /**
     * Updates the count label in the view to display the current quantity of the product in the cart.
     */
    private void updateCountLabel() {
    	view.setCountLabelText(Integer.toString(model.getCount()) + " item(s) in cart.");
    }
}
