package at.nacs.bew3.configuration;

import at.nacs.bew3.logic.Game;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GameConfiguration {

    @Bean
    ApplicationRunner run(Game game) {
        return args -> game.play();
    }
}
