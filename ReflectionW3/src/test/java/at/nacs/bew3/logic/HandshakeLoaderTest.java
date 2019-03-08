package at.nacs.bew3.logic;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class HandshakeLoaderTest {

    @Autowired
    HandshakeLoader loader;

    @Test
    void testShakeSize() {
        Map<Integer, String> shake = loader.getShake();

        assertEquals(5,shake.size());

    }

    @ParameterizedTest
    @CsvSource({
        "2, thumb touches back",
        "3, little finger grab",
        "5, tickles over palm",
        "6, bro knock",
        "9, thousand knuckles"
    })
    void testIndividualShake(Integer number, String move) {
        Map<Integer, String> actualShakes = loader.getShake();
        System.out.println(actualShakes);
        Set<Integer> numbers = actualShakes.keySet();
        Collection<String> moves = actualShakes.values();

        assertTrue(numbers.contains(number));
        assertTrue(moves.contains(move));
    }
}