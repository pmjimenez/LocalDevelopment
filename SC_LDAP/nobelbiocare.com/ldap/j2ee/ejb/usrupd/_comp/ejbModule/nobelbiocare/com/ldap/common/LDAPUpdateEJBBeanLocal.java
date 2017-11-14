package nobelbiocare.com.ldap.common;
import javax.ejb.Local;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;


/**
 * Interface for LDAP operations
 * @author pedro.jimenez
 *
 */
@WebService(name = "LDAPUpdateEJBBeanLocal", targetNamespace = "http://nobelbiocare.com/ldap/common")
@Local
public interface LDAPUpdateEJBBeanLocal {

	@WebMethod(operationName = "updateUsers")
	public Response updateUsers (@WebParam(name = "loginDn", header = true) String loginDn, @WebParam(name = "password", header = true) String password, @WebParam(name = "host", header = true) String host, @WebParam(name = "operation") String operation, @WebParam(name = "users") List<User> users);

}
