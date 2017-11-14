package nobelbiocare.com.ldap.common;

import java.io.UnsupportedEncodingException;
import java.util.List;
import javax.ejb.Stateless;
import javax.jws.WebParam;
import javax.jws.WebService;

import nobelbiocare.com.ldap.util.DNConstants;
import nobelbiocare.com.ldap.util.Log;
import nobelbiocare.com.ldap.util.Operations;

import com.novell.ldap.LDAPConnection;
import com.novell.ldap.LDAPException;
import com.sap.tc.logging.Location;


/**
 * Session Bean implementation class LDAPUpdateEJBBean
 */
@WebService(endpointInterface = "nobelbiocare.com.ldap.common.LDAPUpdateEJBBeanLocal", portName = "LDAPUpdateEJBBeanPort", serviceName = "LDAPUpdateEJBService", targetNamespace = "http://nobelbiocare.com/ldap/common")
@Stateless (name="LDAPUpdateEJBBean")
public class LDAPUpdateEJBBean implements LDAPUpdateEJBBeanLocal {
	
	final static Location _loc = Location.getLocation(LDAPUpdateEJBBean.class);

    /**
     * Default constructor. 
     */
    public LDAPUpdateEJBBean() {
    }
    
    /**
     * Update user's groups 
     */
    public Response updateUsers (@WebParam(name = "loginDn", header = true) String loginDn, @WebParam(name = "password", header = true) String password, @WebParam(name = "host", header = true) String host, @WebParam(name = "operation") String operation, @WebParam(name = "users") List<User> users){
    	
    	Response resp = null;
    	//Setup connection
    	int ldapPort = LDAPConnection.DEFAULT_PORT;
	    int ldapVersion  = LDAPConnection.LDAP_V3;
	    Operations op;

	    LDAPConnection lc = new LDAPConnection();
	    
	    try {
	    	Log.info("LDAP starting connection...", _loc);
	    	// connect to the server
			lc.connect( host, ldapPort );
			
			// bind to the server
            lc.bind( ldapVersion, loginDn, password.getBytes("UTF8") );
			
            
            op = new Operations(users,lc);
            
            if(operation.equals(DNConstants.delete.toUpperCase())){
            	Log.info("LDAP delete...", _loc);
            	op.searchForDeletion(lc);
            	op.deleteValues(lc);
            }
            
            op.addValues(lc);
            resp = op.response(operation,users);
            
			
		} catch (LDAPException e) {
			Log.error("LDAP Error in connection...", e, _loc);
			op = new Operations();
			return op.responseError(operation, users, e.toString());

		} catch (UnsupportedEncodingException e) {
			Log.error("LDAP Error in connection...", e, _loc);
			op = new Operations();
			return op.responseError(operation, users, e.toString());
		} catch (Exception e){
			Log.error("LDAP Error....." + e.toString(), e, _loc);
			op = new Operations();
			return op.responseError(operation, users, e.toString());
			
		} finally {
			try {
				lc.disconnect();
			} catch (LDAPException e) {
				Log.error("LDAP Error ending connection...", e, _loc);
			}
		}
    	
    	return resp;
    	
    }
    

}
