import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4j2Usage {
  private static final Logger logger = LogManager.getLogger(Log4jUsage.class.getName());
  public static void main(String[] args) {
    logger.info("Info: Log4j2 Usage");
    logger.debug("Debug: Program has finished successfully");
    logger.error("Error: Program has errors");
  }
}
