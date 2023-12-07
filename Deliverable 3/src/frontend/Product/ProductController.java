package frontend.Product;
import java.util.HashMap;
import java.util.Map;


public class ProductController {
    private Map<ProductModel, Integer> cart;
    private ProductModel productModel;
    private ProductView productView;
    public ProductController() {
        this.cart = new HashMap<>();
        this.productModel = new ProductModel("", 0.0);
        this.productView = new ProductView();
    }
    public void addToCart(ProductModel product, int quantity) {
        if (cart.containsKey(product)) {
            int currentQuantity = cart.get(product);
            cart.put(product, currentQuantity + quantity);
        } else {
            cart.put(product, quantity);
        }
    }
    public void removeFromCart(ProductModel product) {
        if (cart.containsKey(product)) {
            cart.remove(product);
        }
    }
    public void incrementQuantity(ProductModel product) {
        if (cart.containsKey(product)) {
            int currentQuantity = cart.get(product);
            cart.put(product, currentQuantity + 1);
        }
    }
    public void decrementQuantity(ProductModel product) {
        if (cart.containsKey(product)) {
            int currentQuantity = cart.get(product);
            if (currentQuantity > 1) {
                cart.put(product, currentQuantity - 1);
            } else {
                cart.remove(product);
            }
        }
    }
    public void printCartContents() {
        productView.printCartContents(cart);
    }
    public static void main(String[] args) {
        ProductController productController = new ProductController();
        ProductModel product1 = new ProductModel("Product 1", 10.99);
        ProductModel product2 = new ProductModel("Product 2", 19.99);
        productController.addToCart(product1, 2);
        productController.addToCart(product2, 1);
        productController.printCartContents();
        productController.incrementQuantity(product1);
        productController.printCartContents();
        productController.decrementQuantity(product2);
        productController.printCartContents();
    }
}



