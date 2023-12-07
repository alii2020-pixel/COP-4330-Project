// LoginController.java
// Ethan Curtis

package frontend.Login;

import javax.swing.SwingUtilities;
import frontend.MainWindow;
import frontend.LogoutWrapper.*;
import frontend.MainScreenCustomer.*;
import frontend.MainScreenSeller.*;
import frontend.SignUp.*;
import common.*;

/**
 * Controls the login functionality, handling interactions between the LoginView and LoginModel.
 */
public class LoginController {
	LoginModel model;
	LoginView view;
	
	/**
     * Constructs a LoginController with the associated LoginModel and LoginView.
     *
     * @param model The model containing login-related functionality and data.
     * @param view  The view responsible for displaying the login interface.
     */
	public LoginController(LoginModel model, LoginView view) {
		this.model = model;
		this.view = view;
		
		view.addLoginButtonListener(e -> onLoginButtonClick());
		view.addSignUpButtonListener(e -> onSignUpButtonClick());
	}
	
	/**
     * Handles the action when the login button is clicked.
     * Performs login verification, switches views based on user type, and handles the login process.
     */
	private void onLoginButtonClick() {
		view.showBuffering();
		User user = view.getUserType().equals("Customer") ? 
        		new Customer(view.getUsername(), view.getPassword()) : 
        		new Seller(view.getUsername(), view.getPassword());
		
		model.verifyCredentials(user)
			.whenComplete((response, throwable) -> {
				SwingUtilities.invokeLater(() -> {
					if (response.verified) {
						System.out.println("Successfully logged in!");
						
						// TODO:
						//	- Create LogoutWrapper
						//	- Get user type from Model, then create either:
						//		- MainScreenCustomer
						//		- MainScreenSeller
						//	- Switch window using MainWindow.changeMVC
						LogoutWrapperView lgwView = new LogoutWrapperView();
						LogoutWrapperModel lgwModel = new LogoutWrapperModel();
						LogoutWrapperController lgwController = new LogoutWrapperController(lgwView, lgwModel);
						
						if (response.user.getClass() == Customer.class) {
							// Customer
							Customer customer = (Customer) user;
							
							MainScreenCustomerView mscView = new MainScreenCustomerView();
							MainScreenCustomerModel mscModel = new MainScreenCustomerModel(customer);
							MainScreenCustomerController mscController = new MainScreenCustomerController(mscView, mscModel);
							
							lgwController.changeMVC(mscModel, mscView, mscController);
						} else {
							// Seller
							Seller seller = (Seller) user;
							
							MainScreenSellerView mssView = new MainScreenSellerView();
							MainScreenSellerModel mssModel = new MainScreenSellerModel(seller);
							MainScreenSellerController mssController = new MainScreenSellerController(mssView, mssModel);
							
							lgwController.changeMVC(mssView, mssView, mssController);
						}
						
						MainWindow.Instance.changeMVC(lgwModel, lgwView, lgwController);
						
					} else {
						System.out.println("Failed to login!");
						if (throwable != null)
							view.displayLoginFailure(throwable.toString());
						else 
							view.displayLoginFailure("Failed to login!");
					}
					view.hideBuffering();
				});
			});
	}
	
	/**
     * Handles the action when the sign-up button is clicked.
     * Navigates to the sign-up view for user registration.
     */
	private void onSignUpButtonClick() {
		// navigate to SignUpView
		SignUpView signUpView = new SignUpView();
		SignUpModel signUpModel = new SignUpModel();
		SignUpController signUpController = new SignUpController(signUpModel, signUpView);
		
		MainWindow.Instance.changeMVC(signUpModel, signUpView, signUpController);
	}
}
