package frontend.SignUp;

import javax.swing.SwingUtilities;

public class SignUpController {
    SignUpModel model;
    SignUpView view;

    public SignUpController(SignUpModel model, SignUpView view) {
        this.model = model;
        this.view = view;

        view.addSignUpButtonListener(e -> onSignUpButtonClick());
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
}
