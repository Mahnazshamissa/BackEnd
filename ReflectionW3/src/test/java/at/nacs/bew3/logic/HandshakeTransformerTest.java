package at.nacs.bew3.logic;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class HandshakeTransformerTest {

    @Autowired
    HandshakeTransformer transformer;


    @ParameterizedTest
    @CsvSource({
            "2, thumb touches back",
            "3, little finger grab",
            "5, tickles over palm",
            "6, bro knock",
            "9, thousand knuckles"
    })
    void testIndividualShake(Integer number, String expected) {
        List<String> actualShakes = transformer.transforme(number);
        String collect = actualShakes.stream().collect(Collectors.joining());
        System.out.println(actualShakes);
        assertEquals(expected, collect);
    }
}