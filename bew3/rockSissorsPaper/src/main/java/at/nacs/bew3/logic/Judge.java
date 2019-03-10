package at.nacs.bew3.logic;

import at.nacs.bew3.domain.Move;
import org.springframework.stereotype.Component;

@Component
public class Judge {

    public String judge(Move move1, Move move2) {
        if (move1.equals(move2)) {
            return "Nobody wins.";
        }
        if (move1.getDefeats().contains(move2.getName())) {
            return "Player 1 wins.";
        }
        return "Player 2 wins.";
    }
}
