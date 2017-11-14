package nobelbiocare.com.ldap.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.novell.ldap.LDAPAttribute;
import com.novell.ldap.LDAPConnection;
import com.novell.ldap.LDAPEntry;
import com.novell.ldap.LDAPException;
import com.novell.ldap.LDAPModification;
import com.novell.ldap.LDAPSearchResults;
import com.sap.tc.logging.Location;

import nobelbiocare.com.ldap.common.Response;
import nobelbiocare.com.ldap.common.User;
import nobelbiocare.com.ldap.common.UserResp;

/**
 * Implements all operations over LDAD server
 * @author pedro.jimenez
 *
 */

public class Operations {
	
	private HashMap<String, String[]> status;//Stores user operation status <user email in dn format, array with user id, status and original email>
	private HashMap<String,List<String>> update;//Stores all groups where users must be deleted <group in dn format, email list to update in dn format>
	private HashMap<String,List<String>> delete;//Stores all groups where users must be deleted <group in dn format, email list to delete in dn format>
	
	final static Location _loc = Location.getLocation(Operations.class);
	
	/**
	 * Default constructor
	 */
	public Operations(){
		
	}
	
	/**
	 * Constructor
	 * @param users
	 * @param LDAP connection
	 */
	public Operations(List<User> users, LDAPConnection lc){
		
		
		List<String> groupList;
		status = new HashMap<String,String[]>();
		update = new HashMap<String,List<String>>();//All users by group
		boolean updateUser;
		String emailDn = "";
		
		 for(Iterator<User> i = users.iterator(); i.hasNext(); ) {			 	
	            User item = i.next();
	            updateUser = true;
	            String statusValues[] = new String[3];
	            emailDn = getEmailDN(item.getEmail());
	            //Check user exists
	            try {	            	
	            	statusValues[0] = item.getId();//Set user id
	            	statusValues[2] = item.getEmail();//Set user original mail
					if (userSearch(lc, item.getEmail())){						
					    statusValues[1] = "";//Set status empty
						status.put( emailDn, statusValues);
					}else {
						updateUser = false;
						statusValues[1] = "error: user could not be found";//Set status error
						status.put( emailDn,statusValues);
					}
				} catch (LDAPException e) {
					updateUser = false;
					statusValues[1] = "error: exception searching user";//Set status error
					status.put( emailDn, statusValues );
					Log.error("Error searching user...", e, _loc); 					
				}
	           
			   //Add to update map just if user exists and there are groups to update
	           if (updateUser && item.getGroup() != null){
	            for(Iterator<String> g = item.getGroup().iterator(); g.hasNext(); ) {
	            	String group = getGroupDN(g.next());
	            	
	            	if (update.containsKey(group)){
	            		update.get(group).add(emailDn);
	            	}else{
	            		groupList = new ArrayList<String>();
	            		groupList.add(emailDn);
	            		update.put(group,groupList);
	            	}
	            	
	            }
	           }
	            
	        }
	}

	
	/**
	 * Search all groups where users must be unassigned
	 * @param LDAD connection
	 * @throws LDAPException
	 */
	public void searchForDeletion (LDAPConnection lc) throws LDAPException{
		
		delete = new HashMap<String,List<String>>();;
        String[] attrs =  new String[1];
        attrs[0] = LDAPConnection.NO_ATTRS;
        
        String searchBase = DNConstants.groupOrgUnit + "," + DNConstants.rootDn; 
        int searchScope = LDAPConnection.SCOPE_ONE;
        String searchFilter = "";
        String mail = "";
        
        LDAPSearchResults searchResults = null;
        List<String> mailList;
        
        for(Map.Entry<String, String[]> entry : status.entrySet()) {

          if(entry.getValue()[1].equals("")){//If user has been found....
            mail = entry.getValue()[2];
            searchFilter = "(&(objectClass=groupOfUniqueNames)(uniqueMember=" + getEmailDN(mail) + "))";
            
            searchResults =
            	lc.search(  searchBase, searchScope, searchFilter,attrs ,false);
                       
            //Search all groups for an user
            while ( searchResults.hasMore()) {
                LDAPEntry nextEntry = null;

                try {

                    nextEntry = searchResults.next();

                }

                catch(LDAPException e) {

                	Log.error("Error while searching users...", e, _loc);                  
                   // Exception is thrown, go for next entry


                    if(e.getResultCode() == LDAPException.LDAP_TIMEOUT || e.getResultCode() == LDAPException.CONNECT_ERROR)

                       break;

                    else

                       continue;

                }

                String dn =  nextEntry.getDN();
                
                //Skip groups that are not allowed for deletion
	            if(dn.startsWith(DNConstants.groupTypeDeletion)){
	                
	                if (delete.containsKey(dn)){
	                	delete.get(dn).add(entry.getKey());
	                }else{
	                	mailList = new ArrayList<String>();
	                	mailList.add(entry.getKey());
	                	delete.put(dn, mailList);
	                }
                }
            }
         }
        }
        
        
		
        
		
	}
	
	/**
	 * Search if user exists
	 * @param LDAP connection
	 * @param mail
	 * @return true if exists
	 * @throws LDAPException
	 */
	public boolean userSearch(LDAPConnection lc, String mail) throws LDAPException{
		
        String[] attrs =  new String[1];
        attrs[0] = LDAPConnection.NO_ATTRS;
        
        String searchBase = DNConstants.userOrgUnit + "," + DNConstants.rootDn; 
        int searchScope = LDAPConnection.SCOPE_ONE;
        String searchFilter = "";
        
        LDAPSearchResults searchResults = null;
        
        searchFilter = "(&(objectClass=inetOrgPerson)(cn="+ mail + "))";
        Log.info("search filter: " + searchFilter, _loc);
        searchResults = lc.search(  searchBase, searchScope, searchFilter,attrs ,false);
                       
        return searchResults.hasMore();

	}	
	
	
	/**
	 * Delete all entry values for each group
	 * @param LDAP connection
	 */
    public void deleteValues(LDAPConnection lc){
    	
        //Delete employee from existing groups
        String attValues[] = null;
        String group;
        LDAPAttribute attribute;
        LDAPModification[] modsdel;
        
        
        //Deletes all entry values from each group
        for(Map.Entry<String, List<String>> entry : delete.entrySet()) {
            group = entry.getKey();
            attValues = new String[entry.getValue().size()];
            attValues = entry.getValue().toArray(attValues);
            attribute = new LDAPAttribute("uniqueMember",attValues);
            modsdel = new LDAPModification[1];
            modsdel[0] = new LDAPModification(LDAPModification.DELETE, attribute);
            
            try {
				lc.modify(group, modsdel);
			} catch (LDAPException e) {
				Log.error("Error while deleting users in group: " + group, e, _loc);
				Log.error(e.toString(), _loc);
				//If an error occurs during deletion add error to status map
				
				for(Iterator<String> m = entry.getValue().iterator(); m.hasNext(); ) {

					String mail = m.next();
					String values[] = status.get(mail);
					if(!values[1].equals("")){
						values[1] = status.get(mail)[1].concat(";error: trying to delete user from group: " + group);
						status.put(mail, values);
					}else{
						values[1] = "error: trying to delete user from group: " + group;
						status.put(mail, values);
					}
				}
			}
        }

        
    	
    }
    
    
    /**
     * Add new entry values for each group
     * @param LDAP connection
     */
    public void addValues(LDAPConnection lc){
    	
    	String attValues[] = null;
        String group;
        LDAPAttribute attribute;
        LDAPModification[] modsmod;
        
        //Add all entry values from each group
        for(Map.Entry<String, List<String>> entry : update.entrySet()) {
            group = entry.getKey();
            attValues = new String[entry.getValue().size()];
            attValues = entry.getValue().toArray(attValues);
            attribute = new LDAPAttribute("uniqueMember",attValues);
            modsmod = new LDAPModification[1];
            modsmod[0] = new LDAPModification(LDAPModification.ADD, attribute);
            
            try {
				lc.modify(group, modsmod);
				
			} catch (LDAPException e) {
				Log.error("Error while adding users in group: " + group, e, _loc);
				Log.error(e.toString(), _loc);
				//If an error occurs during operation add error to status map
				for(Iterator<String> m = entry.getValue().iterator(); m.hasNext(); ) {

					String mail = m.next();
					String values[] = status.get(mail);
					if(!values[1].equals("")){
						values[1] = status.get(mail)[1].concat(";error: trying to update user to group: " + group);
						status.put(mail, values);
					}else{
						values[1] = "error: trying to update user to group: " + group;
						status.put(mail,values);
					}
				}
			}
        }
        
    }
    
    /**
     * Generate response with operations result
     * @param operation
     * @param users
     * @return response
     */
    public Response response(String operation, List<User> users){
    	
    	Response resp = new Response();
    	List<UserResp> userList = new ArrayList<UserResp>();
    	resp.setOperation(operation);
    	UserResp userResp;
    	String values[];
    	
    	for(Iterator<User> i = users.iterator(); i.hasNext(); ) {
    		User item = i.next();
    		userResp = new UserResp();
    		if(status.containsKey(getEmailDN(item.getEmail()))){
    			
    			values = status.get(getEmailDN(item.getEmail()));
        		userResp.setEmail(item.getEmail());
        		userResp.setId(item.getId());
        		
        		if(!(values[1].equals(""))){
        			userResp.setStatus(values[1]);
        		}else{
        			userResp.setStatus("success");
        		}
    			
    		} else{
    			userResp.setEmail(item.getEmail());
    			userResp.setId(item.getId());
    			userResp.setStatus("error: user not found!");
    		}
    				
    		userList.add(userResp);
    		
    	}          
    	
    	resp.setUserResp(userList);
    	
    	return resp;
    	
    }
    
    
    /**
     * Response error
     * @param operation
     * @param users
     * @return response
     */
    public Response responseError(String operation, List<User> users, String message){
    	
    	Response resp = new Response();
    	List<UserResp> userList = new ArrayList<UserResp>();
    	resp.setOperation(operation);
    	UserResp userResp;
    	
    	for(Iterator<User> i = users.iterator(); i.hasNext(); ) {
    		User item = i.next();
    		userResp = new UserResp();
    			
        	userResp.setEmail(item.getEmail());
        	userResp.setId(item.getId());
    		userResp.setStatus(message);	
    		userList.add(userResp);
    		
    	}          
    	
    	resp.setUserResp(userList);
    	
    	return resp;
    	
    }    
    
    /**
     * Returns a string value with LDAD format
     * @param group
     * @return group in LDAP format
     */
    public String getGroupDN(String group){
    	return "cn=" + group + "," + DNConstants.groupOrgUnit + "," + DNConstants.rootDn;
    }
    
    /**
     * Returns a string value with LDAP format
     * @param email
     * @return email in LDAP format
     */
    public String getEmailDN(String email){
    	return "cn="+ email + "," + DNConstants.userOrgUnit + "," + DNConstants.rootDn;
    }

    /**
     * Returns all status
     * @return status
     */
	public HashMap<String, String[]> getStatus() {
		return status;
	}


	/**
	 * Returns all groups to update
	 * @return groups to update
	 */
	public HashMap<String, List<String>> getUpdate() {
		return update;
	}

	/**
	 * Returns all groups where users must be unassigned
	 * @return groups
	 */
	public HashMap<String, List<String>> getDelete() {
		return delete;
	}
    
    

}
