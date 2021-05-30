package academy.learnprogramming.config;

import academy.learnprogramming.Game;
import academy.learnprogramming.GameImpl;
import academy.learnprogramming.NumberGenerator;
import academy.learnprogramming.NumberGeneratorImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(GameConfig.class)
@ComponentScan(basePackages = "academy")
public class AppConfig {

    @Bean
    public NumberGenerator numberGenerator(){
        return new NumberGeneratorImpl();
    }

    @Bean
    public Game game(){
        return new GameImpl();
    }
}
