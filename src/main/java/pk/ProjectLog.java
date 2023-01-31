package pk;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ProjectLog {

    public static Logger logger = LogManager.getLogger();

    public static boolean log_factor;

    public ProjectLog(){
        log_factor = false;

    }

    public static void insert_log_message(String message, String priority_lvl) {
        if(log_factor){
            switch (priority_lvl) {
                case "trace" -> logger.trace(message);
                case "info" -> logger.info(message);
                case "debug" -> logger.debug(message);
                case "warn" -> logger.warn(message);
            }
        }
    }

}
