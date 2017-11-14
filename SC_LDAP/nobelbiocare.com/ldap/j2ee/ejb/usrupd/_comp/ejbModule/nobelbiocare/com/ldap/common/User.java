package nobelbiocare.com.ldap.common;

import java.util.List;

/**
 * Represents an user and all its new groups to assign in LDAP
 * @author pedro.jimenez
 *
 */
public class User {
	
	private String id;
	private String email;
	private List<String> group;
	
	public User(){
	}
	
	/**
	 * Constructor
	 * @param id
	 * @param email
	 * @param group
	 */
	public User(String id, String email, List<String> group){
		this.id = id;
		this.email = email;
		this.group = group;
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
	 * @return user email
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
	 * List of groups
	 * @return list of groups
	 */
	public List<String> getGroup() {
		return group;
	}
	
	/**
	 * List of groups
	 * @param list of groups
	 */
	public void setGroup(List<String> group) {
		this.group = group;
	}

	

}
