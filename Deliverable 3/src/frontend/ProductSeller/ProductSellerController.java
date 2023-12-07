// ProductSellerController.java
// Ethan Curtis

package frontend.ProductSeller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Controls the interaction between the ProductSellerView and ProductSellerModel.
 * Handles user input from the view and updates the model accordingly.
 */
public class ProductSellerController {
	private ProductSellerView view;
	private ProductSellerModel model;
	
	/**
     * Constructs a ProductSellerController object.
     *
     * @param view  The ProductSellerView associated with this controller.
     * @param model The ProductSellerModel associated with this controller.
     */
	public ProductSellerController(ProductSellerView view, ProductSellerModel model) {
		this.view = view;
		this.model = model;
		
		view.addTitleFieldListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {}
			@Override
			public void keyPressed(KeyEvent e) {
				onTitleFieldEdit();
			}
			@Override
			public void keyReleased(KeyEvent e) {}
		});
		view.addDescriptionFieldListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {}
			@Override
			public void keyPressed(KeyEvent e) {}
			@Override
			public void keyReleased(KeyEvent e) {
				onDescriptionFieldEdit();
			}
		});
		view.addPriceFieldListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {}
			@Override
			public void keyPressed(KeyEvent e) {}
			@Override
			public void keyReleased(KeyEvent e) {
				onPriceFieldEdit(); // i have no idea why it needs to be here but it does
			}
		});
	}
	
	/**
     * Updates the product name in the model when the title field is edited.
     */
	private void onTitleFieldEdit() {
		model.getProduct().setName(view.getTitleFieldText());
	}
	
	/**
     * Updates the product description in the model when the description field is edited.
     */
	private void onDescriptionFieldEdit() {
		model.getProduct().setDescription(view.getDescriptionFieldText());
	}
	
	/**
     * Updates the product price in the model when the price field is edited.
     */
	private void onPriceFieldEdit() {
		double price = extractFloatingNumber(view.getPriceFieldText());
		model.getProduct().setPrice(price);
	}
	
	/**
     * Extracts a floating-point number from the given input string.
     *
     * @param input The input string from which the number is extracted.
     * @return The extracted floating-point number.
     */
	private double extractFloatingNumber(String input) {
        // Regular expression to match a floating-point number pattern
        Pattern pattern = Pattern.compile("^\\d*\\.\\d+|\\d+\\.\\d*$");
        Matcher matcher = pattern.matcher(input);

        if (matcher.find()) {
            String numberStr = matcher.group(); // Get the matched number string
            return Double.parseDouble(numberStr); // Convert the string to a double
        }

        // Return a default value (or throw an exception) if no floating number found
        return 0.0; // Or throw an exception indicating no floating number found
    }
}
