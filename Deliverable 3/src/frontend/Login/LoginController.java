// LoginController.java
// Ethan Curtis

package frontend.Login;

import javax.swing.SwingUtilities;
import frontend.MainWindow;
import frontend.LogoutWrapper.*;
import frontend.MainScreenCustomer.*;
import frontend.MainScreenSeller.*;
import frontend.SignUp.*;
import common.VerifyCredentialsResponse;

public class LoginController {
	LoginModel model;
	LoginView view;
	
	public LoginController(LoginModel model, LoginView view) {
		this.model = model;
		this.view = view;
		
		view.addLoginButtonListener(e -> onLoginButtonClick());
		view.addSignUpButtonListener(e -> onSignUpButtonClick());
	}
	
	private void onLoginButtonClick() {
		view.showBuffering();
		model.verifyCredentials(view.getUsername(), view.getPassword())
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
						
						if (response.userType == VerifyCredentialsResponse.UserType.Customer) {
							// Customer
							MainScreenCustomerView mscView = new MainScreenCustomerView();
							MainScreenCustomerModel mscModel = new MainScreenCustomerModel();
							MainScreenCustomerController mscController = new MainScreenCustomerController(mscView, mscModel);
							
							lgwController.changeMVC(mscModel, mscView, mscController);
						} else {
							// Seller
							MainScreenSellerView mssView = new MainScreenSellerView();
							MainScreenSellerModel mssModel = new MainScreenSellerModel();
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
	
	private void onSignUpButtonClick() {
		// navigate to SignUpView
		SignUpView signUpView = new SignUpView();
		SignUpModel signUpModel = new SignUpModel();
		SignUpController signUpController = new SignUpController(signUpModel, signUpView);
		
		MainWindow.Instance.changeMVC(signUpModel, signUpView, signUpController);
	}
}
