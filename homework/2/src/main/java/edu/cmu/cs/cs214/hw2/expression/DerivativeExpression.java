package edu.cmu.cs.cs214.hw2.expression;

public class DerivativeExpression implements Expression {
    private final double deltaX = 1e-9;
    private Expression fn;
    private VariableExpression independentVar;
    private double fnVal;

    /**
     * Creates an expression representing the derivative of the specified
     * function with respect to the specified variable.
     *
     * @param fn the function whose derivative this expression represents
     * @param independent the variable with respect to which we're
     * differentiating
     */
    public DerivativeExpression(Expression fn, VariableExpression independent) {
        fnVal = fn.eval();
        this.fn = fn;
        this.independentVar = independent;
    }

    /**
     * Method that returns the derivative of the Expression.
     *
     * @return returns the value of the Expression.
     */
    @Override
    public double eval() {
        independentVar.store(independentVar.eval() + deltaX); // Add a very small value deltaX to variable x.
        return (fn.eval() - fnVal) / deltaX; // Compute the value according to the derivative function.
    }
}
