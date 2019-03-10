package at.nacs.bew3.logic.player;

import at.nacs.bew3.domain.Move;

public interface Player {
    Move play();

    boolean wantsToPlayAgain();

}
