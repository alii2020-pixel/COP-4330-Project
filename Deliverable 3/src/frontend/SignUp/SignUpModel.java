// SignUpModel.java
// Ethan Curtis

package frontend.SignUp;

import java.util.concurrent.CompletableFuture;
import common.*;

public class SignUpModel {
	/**
	 * Registers the provided user asynchronously.
	 *
	 * @param user The User object containing username and password to be registered.
	 * @return A CompletableFuture<VerifyCredentialsResponse> representing the asynchronous registration process.
	 *         The CompletableFuture will complete with a VerifyCredentialsResponse indicating success or failure.
	 */
	public CompletableFuture<VerifyCredentialsResponse> register(User user) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                // Simulating a delay for connection and verification
                Thread.sleep(2000);
                return new VerifyCredentialsResponse(true, user);
            } catch (InterruptedException e) {
                e.printStackTrace();
                return new VerifyCredentialsResponse(false, user);
            }
        });
    }
}