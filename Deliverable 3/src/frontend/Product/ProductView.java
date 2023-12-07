//ProducView.java
//Brandon Christian

package frontend.Product;
import javax.swing.JComponent;
import java.util.Map;

public class ProductView extends JComponent {
    
    public void printCartContents(Map<ProductModel, Integer> cart) {
        System.out.println("Cart Contents:");
        for (Map.Entry<ProductModel, Integer> entry : cart.entrySet()) {
            ProductModel product = entry.getKey();
            int quantity = entry.getValue();
            System.out.println(product.getProductName() + " - Quantity: " + quantity);
        }
    }
}
