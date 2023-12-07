package frontend.SignUp;

import javax.swing.SwingUtilities;

import frontend.MainWindow;
import frontend.Login.*;

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
        model.register(view.getUsername(), view.getPassword())
            .whenComplete((registered, throwable) -> {
                SwingUtilities.invokeLater(() -> {
                    if (registered) {
                        System.out.println("Successfully signed up!");
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
