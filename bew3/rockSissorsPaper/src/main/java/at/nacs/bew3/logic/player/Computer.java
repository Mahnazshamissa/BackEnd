package at.nacs.bew3.logic.player;

import at.nacs.bew3.domain.Move;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Random;

@RequiredArgsConstructor
public class Computer implements Player {

    private final List<Move> moves;
    private Random random = new Random();

    @Override
    public Move play() {
        int choice = random.nextInt(moves.size());
        return moves.get(choice);
    }

    @Override
    public boolean wantsToPlayAgain() {
        return true;
    }
}
