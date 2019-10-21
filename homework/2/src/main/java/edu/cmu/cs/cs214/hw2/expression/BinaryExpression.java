package edu.cmu.cs.cs214.hw2.expression;

import edu.cmu.cs.cs214.hw2.operator.BinaryOperator;

/**
 *
 */
public class BinaryExpression implements Expression {
    private BinaryOperator operator;
    private Expression expression1;
    private Expression expression2;

    /**
     * @param expression1
     * @param expression2
     * @param operator
     */
    public BinaryExpression(Expression expression1, Expression expression2, BinaryOperator operator) {
        this.expression1 = expression1;
        this.expression2 = expression2;
        this.operator = operator;
    }

    /**
     * @return
     */
    @Override
    public double eval() {
        return operator.apply(expression1.eval(), expression2.eval());
    }

    @Override
    public String toString() {
        return "(" + expression1.toString() + operator.toString() + expression2.toString() +")";
    }
}
