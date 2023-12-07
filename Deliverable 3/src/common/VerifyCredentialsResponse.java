// VerifyCredentialsResponse.java
// Ethan Curtis

package common;

/**
 * Represents a response for verifying credentials containing a verification status and user information.
 */
public class VerifyCredentialsResponse {
    public boolean verified;
    public User user;

    /**
     * Constructs a VerifyCredentialsResponse with the verification status and user information.
     *
     * @param verified The boolean indicating whether the credentials are verified.
     * @param user     The User object associated with the verification.
     */
    public VerifyCredentialsResponse(boolean verified, User user) {
        this.verified = verified;
        this.user = user;
    }
}
