package project.entities;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class UserInfo {
	
	@NotNull(message="Username cannot be empty")
	@Size(min=5, max= 20, message="Username must be between 8 and 20 characters long")
	@Pattern(regexp="^\\w{5,}$", message = "Username can only consist of alphanumeric characters")
	private String userName;
	
	@NotNull(message="Password cannot be empty")
	@Pattern(regexp="\\S+", message="Your password cannot contain blank spaces")
	@Size(min=8, max=20, message="Password must be between 8 and 20 characters long")
	private String password;
	
	// empty constructor 
	public UserInfo() {
	}

	// getters and setters
	
	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPassword() {
		return password;
	}

	public String getUserName() {
		return userName;
	}
}
