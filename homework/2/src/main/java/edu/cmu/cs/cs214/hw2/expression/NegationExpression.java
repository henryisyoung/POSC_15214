package edu.cmu.cs.cs214.hw2.expression;

public class NegationExpression implements Expression {
    final private Expression val;

    public NegationExpression(Expression val) {
        this.val = val;
    }

    @Override
    public double eval() {
        return -1 * val.eval();
    }

    /**
     * toString method that returns the Expression with an contrary sign.	 *
     */
    @Override
    public String toString() {
        return "-(" + val.toString() + ")";
    }
}
