package nobelbiocare.com.ldap.util;

import com.sap.tc.logging.Location;
import com.sap.tc.logging.Category;
import com.sap.tc.logging.Severity;
import com.sap.tc.logging.SimpleLogger;

/**
 * Class for logging and tracing
 * @author pedro.jimenez
 *
 */
public class Log {	
	
	/**
	 * Publish info message
	 * @param message
	 * @param location
	 */
	public static void info(String message, Location loc) {
	        SimpleLogger.log(Severity.INFO, Category.SYS_SERVER, loc, "", message);
	}
	
	/**
	 * Publish error message
	 * @param message
	 * @param location
	 */
	public static void error(String message, Location loc){
		SimpleLogger.log(Severity.ERROR, Category.SYS_SERVER, loc, "", message);
	}
	
	/**
	 * Publish error message with exception
	 * @param message
	 * @param exception
	 * @param location
	 */
	public static void error(String message, Exception e, Location loc){
		SimpleLogger.log(Severity.ERROR, Category.SYS_SERVER, loc, "", message,e);
	}

}
