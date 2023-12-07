package common;

public class VerifyCredentialsResponse {
	public enum UserType {
		None,
		Customer,
		Seller
	}
	
	public boolean verified;
	public UserType userType;
	
	public VerifyCredentialsResponse(boolean verified, UserType userType) {
		this.verified = verified;
		this.userType = userType;
	}
}
