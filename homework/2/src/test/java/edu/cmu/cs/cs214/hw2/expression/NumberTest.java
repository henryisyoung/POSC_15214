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
public class NumberTest {

    private Expression value;
    private final double number = 1.0;

    /**
     * Set up to test the constructor.
     */
    @Before
    public void setup() {
        value = new NumberExpression(number);
    }

    /**
     * Test for toString method.
     */
    @Test
    public void testToString() {
        assertEquals(value.toString(), Double.toString(number));
    }

    /**
     * Test for eval method to the value returned.
     */
    @Test
    public void testEval() {
        assertEquals(BigDecimal.valueOf(value.eval()), BigDecimal.valueOf(number));
    }

}
