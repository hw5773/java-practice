import java.lang.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class Sample {
  final static Log logger = LogFactory.getLog(Sample.class);
  
  public static void main(String[] args) {
    logger.debug("main start");
    System.out.println("Hello Hyunwoo!");
    logger.debug("main end");
  }
}
