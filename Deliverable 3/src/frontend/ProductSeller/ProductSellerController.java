// ProductSellerController.java
// Ethan Curtis

package frontend.ProductSeller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProductSellerController {
	private ProductSellerView view;
	private ProductSellerModel model;
	
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
			public void keyPressed(KeyEvent e) {
				onDescriptionFieldEdit();
			}
			@Override
			public void keyReleased(KeyEvent e) {}
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
	
	private void onTitleFieldEdit() {
		model.getProduct().setName(view.getTitleFieldText());
	}
	
	private void onDescriptionFieldEdit() {
		model.getProduct().setName(view.getDescriptionFieldText());
	}
	
	private void onPriceFieldEdit() {
		double price = extractFloatingNumber(view.getPriceFieldText());
		model.getProduct().setPrice(price);
	}
	
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
