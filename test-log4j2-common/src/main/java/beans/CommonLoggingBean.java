package beans;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class CommonLoggingBean {

	private static Logger logger = LoggerFactory.getLogger(CommonLoggingBean.class);
	
    public static void logMessage(String message) {
    	logger.info(message);
    }
    
}
