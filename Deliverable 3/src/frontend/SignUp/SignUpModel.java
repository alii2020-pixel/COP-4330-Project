package frontend.SignUp;

import java.util.concurrent.CompletableFuture;

public class SignUpModel {
    
    /**
     * Registers the provided username and password asynchronously.
     *
     * @param username The username to be registered.
     * @param password The password associated with the username.
     * @return A CompletableFuture<Boolean> representing the asynchronous registration process.
     */
    public CompletableFuture<Boolean> register(String username, String password) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                // Simulating a delay for registration process
                Thread.sleep(2000);
                return true; // return true if registration is successful
            } catch (InterruptedException e) {
                e.printStackTrace();
                return false;
            }
        });
    }
}