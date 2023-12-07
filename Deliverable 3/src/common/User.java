// User.java
// Ethan Curtis

package common;

/**
 * Represents a User with a username and password.
 */
public class User {
	public String username;
	public String password;
	
	/**
     * Constructs a User with the provided username and password.
     *
     * @param username The username for the User.
     * @param password The password for the User.
     */
	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}
}
