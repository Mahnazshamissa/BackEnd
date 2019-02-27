package at.nacs.ex5thecalculator.controller.operation;


import at.nacs.ex5thecalculator.model.Expression;

public class Subtraction implements Operation {

    @Override
    public boolean matches(Expression expression) {
        return expression.getSymbol().equals("-");
    }

    @Override
    public Double apply(Expression expression) {
        return expression.getNumber1() - expression.getNumber2();
    }
}
