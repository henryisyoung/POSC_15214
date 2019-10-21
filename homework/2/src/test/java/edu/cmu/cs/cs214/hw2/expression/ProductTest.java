package edu.cmu.cs.cs214.hw2.expression;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class ProductTest {
    private Expression prodTest;
    private final double number1 = 1.0;
    private final double number2 = 2.0;
    private final double number3 = 2.0;
    private Expression addend1 = new NumberExpression(number1);
    private Expression addend2 = new NumberExpression(number2);

    /**
     * Set up to test the constructor.
     */
    @Before
    public void setup() {
        prodTest = new ProductExpression(addend1, addend2);
    }

    /**
     * Test for toString method.
     */
    @Test
    public void testToString() {
        assertEquals("(" + addend1.toString() + " * " + addend2.toString() + ")", prodTest.toString());
    }

    /**
     * Test for eval method to the value returned.
     */
    @Test
    public void testEval() {
        assertEquals(BigDecimal.valueOf(number3), BigDecimal.valueOf(prodTest.eval()));
    }
}
