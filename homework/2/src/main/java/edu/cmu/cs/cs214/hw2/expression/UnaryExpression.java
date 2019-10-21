package edu.cmu.cs.cs214.hw2.expression;

import edu.cmu.cs.cs214.hw2.operator.BinaryOperator;
import edu.cmu.cs.cs214.hw2.operator.UnaryOperator;

/**
 *
 */
public class UnaryExpression implements Expression {
    private UnaryOperator operator;
    private Expression expression1;

    /**
     * @param expression1
     * @param operator
     */
    public UnaryExpression(Expression expression1,UnaryOperator operator) {
        this.expression1 = expression1;
        this.operator = operator;
    }

    /**
     * @return
     */
    @Override
    public double eval() {
        return operator.apply(expression1.eval());
    }

    @Override
    public String toString() {
        return operator.toString() + expression1.toString();
    }
}
