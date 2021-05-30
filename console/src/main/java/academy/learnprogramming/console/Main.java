package academy.learnprogramming.console;

import academy.learnprogramming.config.AppConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    private final static Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        log.info("Guess The Number Game");

        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        context.close();
    }
}
