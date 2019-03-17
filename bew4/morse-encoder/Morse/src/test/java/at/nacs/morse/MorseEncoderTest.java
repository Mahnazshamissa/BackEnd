package at.nacs.morse;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.*;

@SpringBootTest(webEnvironment = NONE)
class MorseEncoderTest {

    @Autowired
    MorseEncoder morseEncoder;

    @ParameterizedTest
    @CsvSource({
            "S, . . .",
            "H, . . . .",
            "A, . _",
            "M, _ _",
            "I, . . . .",
            "S, . . .",
            "S, . . .",
            "A, . _"
    })
    void encodeToMorse(String letter, String morseCode) {
        String actual = morseEncoder.encodeToMorse(letter);
        assertThat(actual).isEqualTo(morseCode);
    }

}