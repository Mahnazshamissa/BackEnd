package at.nacs.bew3.configuration;

import at.nacs.bew3.domain.Move;
import at.nacs.bew3.logic.Moves;
import at.nacs.bew3.logic.player.Computer;
import at.nacs.bew3.logic.player.Human;
import at.nacs.bew3.logic.player.Player;
import at.nacs.bew3.ui.Host;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class PlayerConfiguration {

    @Bean
    Player player1(Moves moves, Host host) {
        return new Human(moves, host);
    }

    @Bean
    Player player2(List<Move> moves) {
        return new Computer(moves);
    }

}

