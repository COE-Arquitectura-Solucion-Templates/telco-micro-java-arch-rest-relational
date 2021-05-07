package ${groupId}.ws.ui.model.response;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserRest {
	private String firstName;
	private String lastName;
	private String email;
	
	@Id
	private String userId;
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	// Creating toString 
    @Override
    public String toString() 
    { 
        return "User [userId="
            + userId 
            + ", firstName="
            + firstName 
            + ", lastName="
            + ", email  "+ email+ "]"; 
    } 
}
