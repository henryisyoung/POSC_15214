package edu.cmu.cs.cs214.hw2.expression;

public class DifferenceExpression implements Expression {
    final private Expression val1;
    final private Expression val2;

    public DifferenceExpression(Expression add1, Expression val2) {
        this.val1 = add1;
        this.val2 = val2;
    }

    @Override
    public double eval() {
        return val1.eval() - val2.eval();
    }

    @Override
    public String toString() {
        return "(" + val1.toString() + " - " + val2.toString() + ")";
    }
}
