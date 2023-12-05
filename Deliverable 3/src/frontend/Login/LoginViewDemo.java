//LoginViewDemo.java
//This testing class needs to be deleted (does not follow MVC architecture) - basilicon

package frontend.Login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Arrays;

public class LoginViewDemo {
    private static final HashMap<String, String> userCredentials = new HashMap<>();

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Login Demo");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            LoginView loginView = new LoginView();

            loginView.addLoginButtonListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    loginView.displayLoginFailure("Invalid username or password");
                }
            });

            frame.getContentPane().add(loginView);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }

    // Helper method to simulate user authentication
    private static boolean isValidLogin(String username, char[] password) {
        String savedPassword = userCredentials.get(username);
        return savedPassword != null && Arrays.equals(password, savedPassword.toCharArray());
    }
}
