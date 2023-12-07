// SignUpController.java
// Ethan Curtis

package frontend.SignUp;

import javax.swing.SwingUtilities;

import frontend.MainWindow;
import frontend.Login.*;
import frontend.LogoutWrapper.*;
import frontend.MainScreenCustomer.*;
import frontend.MainScreenSeller.*;
import common.*;

/**
 * Controller responsible for handling the sign-up process, creating user accounts,
 * and managing the view interactions for signing up.
 */
public class SignUpController {
    SignUpModel model;
    SignUpView view;

    /**
     * Constructs a SignUpController with the associated SignUpModel and SignUpView.
     * Registers listeners for sign-up and login actions in the provided view.
     *
     * @param model The SignUpModel associated with this controller.
     * @param view  The SignUpView associated with this controller.
     */
    public SignUpController(SignUpModel model, SignUpView view) {
        this.model = model;
        this.view = view;

        view.addSignUpButtonListener(e -> onSignUpButtonClick());
        
        view.addLoginButtonListener(e -> onLoginButtonClick());
    }

    /**
     * Action to be performed when the sign-up button is clicked.
     * Initiates the sign-up process, creating a user account based on the provided information.
     * Completes the sign-up action asynchronously and switches to the appropriate main screen upon success.
     */
    private void onSignUpButtonClick() {
        view.showBuffering();
        User user = view.getUserType().equals("Customer") ? 
        		new Customer(view.getUsername(), view.getPassword()) : 
        		new Seller(view.getUsername(), view.getPassword());
        
        model.register(user)
            .whenComplete((response, throwable) -> {
                SwingUtilities.invokeLater(() -> {
                    if (response.verified) {
                        System.out.println("Successfully signed up!");
                        
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
							MainScreenCustomerView mscView = new MainScreenCustomerView();
							MainScreenCustomerModel mscModel = new MainScreenCustomerModel((Customer) user);
							MainScreenCustomerController mscController = new MainScreenCustomerController(mscView, mscModel);
							
							lgwController.changeMVC(mscModel, mscView, mscController);
						} else {
							// Seller
							Seller seller = (Seller) user;
							seller.addProduct(new Product("test 1", "lol", 0.0));
							seller.addProduct(new Product("test 2", "lol", 10.0));
							seller.addProduct(new Product("test 3", "lol", 20.0));
							seller.addProduct(new Product("test 4", "lol", 30.0));
							
							MainScreenSellerView mssView = new MainScreenSellerView();
							MainScreenSellerModel mssModel = new MainScreenSellerModel(seller);
							MainScreenSellerController mssController = new MainScreenSellerController(mssView, mssModel);
							
							lgwController.changeMVC(mssView, mssView, mssController);
						}
						
						MainWindow.Instance.changeMVC(lgwModel, lgwView, lgwController);
                    } else {
                        System.out.println("Failed to sign up!");
                        if (throwable != null)
                            view.displaySignUpFailure(throwable.toString());
                        else 
                            view.displaySignUpFailure("Failed to sign up!");
                    }
                    view.hideBuffering();
                });
            });
    }
    
    /**
     * Action to be performed when the login button is clicked.
     * Navigates the user to the login view to sign in after attempting to sign up.
     */
    private void onLoginButtonClick() {
    	// navigate to Login
    	LoginView loginView = new LoginView();
    	LoginModel loginModel = new LoginModel();
    	LoginController loginController = new LoginController(loginModel, loginView);
    			
    	MainWindow.Instance.changeMVC(loginModel, loginView, loginController);
    }
}
