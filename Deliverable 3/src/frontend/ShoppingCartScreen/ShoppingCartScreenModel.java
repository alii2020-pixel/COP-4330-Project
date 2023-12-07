// ShoppingCartScreenModel.java
// Ethan Curtis

package frontend.ShoppingCartScreen;

import common.*;

public class ShoppingCartScreenModel {
	ShoppingCart shoppingCart;
	
	public ShoppingCartScreenModel(ShoppingCart shoppingCart) {
		this.shoppingCart = shoppingCart;
	}
	
	public ShoppingCart getShoppingCart() {
		return shoppingCart;
	}
}
