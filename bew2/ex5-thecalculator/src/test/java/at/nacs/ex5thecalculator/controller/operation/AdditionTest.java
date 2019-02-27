package at.nacs.ex5thecalculator.controller.operation;

import at.nacs.ex5thecalculator.model.Expression;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class AdditionTest {

    @Autowired
    Operation addition;

    @ParameterizedTest
    @CsvSource({
            "true, +",
            "false, -",
            "false, *",
            "false, /",
    })
    void matches(boolean expected, String symbol) {
        Expression expression = Expression.builder()
                .symbol(symbol)
                .build();

        boolean result = addition.matches(expression);

        assertEquals(expected, result);
    }

    @ParameterizedTest
    @CsvSource({
            "1, 0, 1",
            "2, 1, 1",
            "9, 6, 3",
    })
    void apply(double expected, double number1, double number2) {
        Expression expression = Expression.builder()
                .number1(number1)
                .number2(number2)
                .build();

        double result = addition.apply(expression);

        assertEquals(expected, result);
    }

}
