package edu.cmu.cs.cs214.hw2.expression;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class NewtonsTest {
    private double approxZero = Math.sqrt(2.0);
    private final double tolerance = 1e-7;
    private VariableExpression xUndefined = new VariableExpression("x");
    private Expression x = xUndefined;
    private Expression xSquare = new ProductExpression(x, x);
    private Expression y = new NumberExpression(2.0);
    private Expression xTest = new DifferenceExpression(xSquare, y);

    /**
     * Test for zero method by generating an Expression xTest "x * x - 2"
     * and a variable xUndefined with name "x" with initial estimate 1.0.
     */
    @Test
    public void testZero() {
        NewtonsMethod newtonsTest = new NewtonsMethod();
        xUndefined.store(1.0);
        double result = newtonsTest.zero(xTest, xUndefined, approxZero, tolerance);
        assertTrue(Math.abs(result - approxZero) < tolerance);
    }
}
