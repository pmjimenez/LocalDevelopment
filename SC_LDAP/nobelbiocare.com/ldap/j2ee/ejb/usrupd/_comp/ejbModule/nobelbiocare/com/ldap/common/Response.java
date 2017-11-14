package nobelbiocare.com.ldap.common;

import java.util.List;
/**
 * Response for updateUser operation
 * @author pedro.jimenez
 *
 */
public class Response {
	
	private String operation;//Executed operation
	private List<UserResp> userResp;//Operation result for each user
	
	public Response(){
	}
	
	/**
	 * Get operation
	 * @return operation
	 */
	public String getOperation() {
		return operation;
	}
	
	/**
	 * Set operation
	 * @param operation
	 */
	public void setOperation(String operation) {
		this.operation = operation;
	}
	
	/**
	 * Get operation result for each user
	 * @return userResp
	 */
	public List<UserResp> getUserResp() {
		return userResp;
	}
	
	
	/**
	 * Set operation result for each user
	 * @param userResp
	 */
	public void setUserResp(List<UserResp> userResp) {
		this.userResp = userResp;
	}
	
}
