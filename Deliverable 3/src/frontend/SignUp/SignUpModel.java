// SignUpModel.java
// Ethan Curtis

package frontend.SignUp;

import java.util.concurrent.CompletableFuture;

import common.VerifyCredentialsResponse;
import common.VerifyCredentialsResponse.UserType;

public class SignUpModel {
    
    /**
     * Registers the provided username and password asynchronously.
     *
     * @param username The username to be registered.
     * @param password The password associated with the username.
     * @return A CompletableFuture<Boolean> representing the asynchronous registration process.
     */
	public CompletableFuture<VerifyCredentialsResponse> register(String username, String password, UserType userType) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                // Simulating a delay for connection and verification
                Thread.sleep(2000);
                return new VerifyCredentialsResponse(true, userType);
            } catch (InterruptedException e) {
                e.printStackTrace();
                return new VerifyCredentialsResponse(false, VerifyCredentialsResponse.UserType.None);
            }
        });
    }
}