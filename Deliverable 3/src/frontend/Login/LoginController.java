package frontend.Login;

import javax.swing.SwingUtilities;

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
			.whenComplete((verified, throwable) -> {
				SwingUtilities.invokeLater(() -> {
					if (verified) {
						// TODO:
						//	- Create LogoutWrapper
						//	- Get user type from Model, then create either:
						//		- MainScreenCustomer
						//		- MainScreenSeller
						//	- Switch window using MainWindow.changeMVC
					} else {
						view.displayLoginFailure(throwable.toString());
					}
					view.hideBuffering();
				});
			});
	}
	
	private void onSignUpButtonClick() {
		
	}
}
