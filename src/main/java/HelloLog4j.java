import org.apache.log4j.Logger;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HelloLog4j {
    public static void main(String[] args) {
        H1Template h1 = new H1Template("zh_CN", "B004IJO7K8", new H1Template.Tags("/{desc}/{pageId}/"));
        log.error("This is debug message.");
        log.error(h1.toString());
    }
}
