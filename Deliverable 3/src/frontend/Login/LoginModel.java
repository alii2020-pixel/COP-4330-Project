// LoginModel.java
// Ethan Curtis

package frontend.Login;

import java.util.concurrent.CompletableFuture;

public class LoginModel {
	
	/**
	 * Verifies the provided username and password by initiating a connection to the server asynchronously.
	 *
	 * @param username The username to be verified.
	 * @param password The password (as a char array) associated with the username.
	 * @return A CompletableFuture<Boolean> representing the asynchronous verification process.
	 *         The CompletableFuture completes with a boolean value:
	 *         - True if the credentials are verified successfully.
	 *         - False if the verification fails or encounters an error.
	 *         Use CompletableFuture's methods for handling completion, exceptions, or combining further operations.
	 *
	 * @implNote This method simulates a connection and verification process. Replace the logic with the actual
	 *           implementation to connect to a server and verify the provided username and password.
	 *           The completion of the CompletableFuture indicates the result of the verification process.
	 */
	public CompletableFuture<VerifyCredentialsResponse> verifyCredentials(String username, String password) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                // Simulating a delay for connection and verification
                Thread.sleep(2000);
                return new VerifyCredentialsResponse(true, UserType.Customer);
            } catch (InterruptedException e) {
                e.printStackTrace();
                return new VerifyCredentialsResponse(false, UserType.None);
            }
        });
    }
	
	public enum UserType {
		None,
		Customer,
		Seller
	}

	public class VerifyCredentialsResponse {
		public boolean verified;
		public UserType userType;
		
		public VerifyCredentialsResponse(boolean verified, UserType userType) {
			this.verified = verified;
			this.userType = userType;
		}
	}
}
