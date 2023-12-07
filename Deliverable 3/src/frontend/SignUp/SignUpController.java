package frontend.SignUp;

import javax.swing.SwingUtilities;

import frontend.MainWindow;
import frontend.Login.*;
import frontend.LogoutWrapper.*;
import frontend.MainScreenCustomer.*;
import frontend.MainScreenSeller.*;
import common.*;

public class SignUpController {
    SignUpModel model;
    SignUpView view;

    public SignUpController(SignUpModel model, SignUpView view) {
        this.model = model;
        this.view = view;

        view.addSignUpButtonListener(e -> onSignUpButtonClick());
        
        view.addLoginButtonListener(e -> onLoginButtonClick());
    }

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
							MainScreenSellerView mssView = new MainScreenSellerView();
							MainScreenSellerModel mssModel = new MainScreenSellerModel((Seller) user);
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
    
    private void onLoginButtonClick() {
    	// navigate to Login
    	LoginView loginView = new LoginView();
    	LoginModel loginModel = new LoginModel();
    	LoginController loginController = new LoginController(loginModel, loginView);
    			
    	MainWindow.Instance.changeMVC(loginModel, loginView, loginController);
    }
}
