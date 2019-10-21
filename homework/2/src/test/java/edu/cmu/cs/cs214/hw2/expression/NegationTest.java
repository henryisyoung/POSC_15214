package edu.cmu.cs.cs214.hw2.expression;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

/**
 * Class to test the class AbsoluteValueExpression
 * @author zhilinh
 *
 */
public class NegationTest {

    private Expression negationTest;
    private final double number1 = 1.0;
    private final double number2 = -1.0;
    private Expression addend1 = new NumberExpression(number1);

    /**
     * Set up to test the constructor.
     */
    @Before
    public void setup() {
        negationTest = new NegationExpression(addend1);
    }

    /**
     * Test for toString method.
     */
    @Test
    public void testToString() {
        assertEquals("-(" + addend1.toString() + ")", negationTest.toString());
    }

    /**
     * Test for eval method to the value returned.
     */
    @Test
    public void testEval() {
        assertEquals(BigDecimal.valueOf(number2), BigDecimal.valueOf(negationTest.eval()));
    }

}
