package at.nacs.ex5thecalculator.controller;

import at.nacs.ex5thecalculator.controller.operation.Operation;
import at.nacs.ex5thecalculator.model.Expression;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
@RequiredArgsConstructor
public class Calculator {

    private final Set<Operation> operations;

    public double calculate(Expression expression) throws IllegalArgumentException {

        return operations.stream()
                .filter(e -> e.matches(expression))
                .map(e -> e.apply(expression))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);

       /* for (Operation operation: operations) {
            if(operation.matches(expression)){
                return  operation.apply(expression);
            }
        }
        throw new IllegalArgumentException();*/

    }
}
