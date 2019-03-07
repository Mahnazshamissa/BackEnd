package at.nacs.ex5thecalculator.controller;

import at.nacs.ex5thecalculator.model.Expression;
import org.springframework.stereotype.Component;

@Component
public class Expressions {

    public Expression from(String input) throws IllegalArgumentException {
        String[] inputs = input.split(" ");
        if (inputs.length != 3) {
            throw new IllegalArgumentException();
        }

        return Expression.builder()
                .number1(Double.valueOf(inputs[0]))
                .symbol(inputs[1])
                .number2(Double.valueOf(inputs[2]))
                .build();
    }
}
