// Imports the required packages and classes for ProjectLog class
package pk;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// ProjectLog class will allow the main class: PiratenKarpen to optionally activate trace_mode and write log messages to log file based on CL argument
public class ProjectLog {
    public static Logger logger = LogManager.getLogger(ProjectLog.class);
    // create a Logger object and write lines to log4j2

    public static boolean log_factor = false;
    // boolean factor to determine if log messages should be


    // Will insert a log message based on if the log_factor is true
    // Method will help create different log messages with different priority levels
    public static void insert_log_message(String message, String priority_lvl) {
        if(log_factor){
            switch (priority_lvl) {
                case "trace" -> logger.trace(message);
                case "info" -> logger.info(message);
                case "warn" -> logger.warn(message);
            }
        }
    }

}
