import org.apache.log4j.Logger;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HelloLog4j {
    public static void main(String[] args) {
        log.info("This is info message.");
        log.error("This is error message.");
    }
}
