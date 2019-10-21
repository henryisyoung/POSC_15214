package edu.cmu.cs.cs214.hw2.expression;

public class AbsoluteValueExpression implements Expression {
    final private Expression val;

    public AbsoluteValueExpression(Expression val) {
        this.val = val;
    }

    @Override
    public double eval() {
        return Math.abs(val.eval());
    }

    /**
     * toString method that returns the Expression with an contrary sign.	 *
     */
    @Override
    public String toString() {
        return val.eval() < 0 ? "-(" + val.toString() + ")" : val.toString();
    }
}
