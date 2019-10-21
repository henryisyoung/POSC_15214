package edu.cmu.cs.cs214.hw2.expression;

public class SumExpression implements Expression {
    final private Expression val1;
    final private Expression val2;

    /**
     * @param val1
     * @param add2
     */
    public SumExpression(Expression val1, Expression add2) {
        this.val1 = val1;
        this.val2 = add2;
    }

    /**
     * @return
     */
    @Override
    public double eval() {
        return val1.eval() + val2.eval();
    }

    /**
     * @return
     */
    @Override
    public String toString() {
        return "(" + val1.toString() + " + " + val2.toString() + ")";
    }
}
