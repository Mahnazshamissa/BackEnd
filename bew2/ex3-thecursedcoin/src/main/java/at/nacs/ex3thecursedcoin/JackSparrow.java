package at.nacs.ex3thecursedcoin;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class JackSparrow {
    private final LegendaryCompass legendaryCompass;

    public String findCoin() {
        return "I found the " + legendaryCompass.findCursedCoin() + "!";
    }
}
