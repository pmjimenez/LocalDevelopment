package nobelbiocare.com.ldap.util;
/**
 * Defines constant values for dc and cn used in object search
 * @author pedro.jimenez
 *
 */
public class DNConstants {
	
	public final static String rootDn = "dc=nobelbiocare,dc=com";
	public final static String userOrgUnit = "ou=users";
	public final static String groupOrgUnit = "ou=groups";
	public final static String groupTypeDeletion = "cn=CUG_";//Group prefix for deletion
	
	
/*  Operations */
	public final static String delete = "DELETE";

}
