package edu.cmu.cs.cs214.hw2.expression;

public class NumberExpression implements Expression {
    final private double val;

    public NumberExpression(double value) {
        this.val = value;
    }

    @Override
    public double eval() {
        return val;
    }

    /**
     * toString method that returns the Expression with an contrary sign.	 *
     */
    @Override
    public String toString() {
        return Double.toString(val);
    }
}
