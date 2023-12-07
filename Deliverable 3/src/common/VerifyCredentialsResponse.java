package common;

public class VerifyCredentialsResponse {
	public boolean verified;
	public User user;
	
	public VerifyCredentialsResponse(boolean verified, User user) {
		this.verified = verified;
		this.user = user;
	}
}
