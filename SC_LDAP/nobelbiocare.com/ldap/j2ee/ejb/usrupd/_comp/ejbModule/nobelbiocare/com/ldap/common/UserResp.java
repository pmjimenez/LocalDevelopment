package nobelbiocare.com.ldap.common;

/**
 * Represents the requested operations result over an user
 * @author pedro.jimenez
 *
 */
public class UserResp {
	
	private String id;
	private String email;
	private String status;
	
	
	/**
	 * Constructor
	 */
	public UserResp(){
	}
	
	
	/**
	 * Constructor
	 * @param user id
	 * @param user email
	 * @param operations result
	 */
	public UserResp(String id, String email, String status){
		this.id = id;
		this.email = email;
		this.status = status;
	}
	
	
	/**
	 * Get user id
	 * @return user id
	 */
	public String getId() {
		return id;
	}
	
	/**
	 * Set user id
	 * @param user id
	 */
	public void setId(String id) {
		this.id = id;
	}
	
	/**
	 * Get user email
	 * @return email
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * Set user email
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Get operations status
	 * @return operations status
	 */
	public String getStatus() {
		return status;
	}

	
	/**
	 * Set operations status
	 * @param status
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	

}
