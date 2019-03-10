package at.nacs.bew3.configuration;

import at.nacs.bew3.domain.Move;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@ConfigurationProperties("game")
public class MovesConfiguration {
    @Setter
    private List<Move> moves;

    @Bean
    List<Move> available() {
        return moves;
    }
}
