package edu.cmu.cs.cs214.hw3;

import hw2.expression.Variable;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class WordExpressionTest {
    private Map<Character, Variable> variableMap = new HashMap<>();
    private String string = "ABC";
    private Double DELTA = 0.00001;

    /**
     * Set up to test the constructor and generate a named variable list.
     */
    @Before
    public void setup() {
        for (char c : string.toCharArray()) {
            variableMap.put(c, new Variable(Character.toString(c)));
        }
    }
    /**
     * Test for the toString method to get the right output for Expression.
     */
    @Test
    public void testToString() {
        WordExpression wordExpression = new WordExpression(string, variableMap);
        assertEquals(wordExpression.toString(), "ABC");
    }

    @Test
    public void testEval() {
        Map<String, Integer> num = new HashMap<>();
        num.put("A", 1);
        num.put("B", 2);
        num.put("C", 3);
        for (Variable v : variableMap.values()) {
            v.store(num.get(v.name()));
        }

        WordExpression wordExpression = new WordExpression(string, variableMap);
        assertTrue(Math.abs(wordExpression.eval() - 123.0) < DELTA);
    }
}
