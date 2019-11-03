package edu.cmu.cs.cs214.hw3;

import hw2.expression.Expression;
import hw2.expression.Variable;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class ArgumentParserTest {
    private String[] args;
    private String[] args2;
    private ArgumentParser parser;
    private ArgumentParser parser2;
    private List<Character> characters;

    @Before
    public void setup() {
        this.args = new String[]{"SEND", "+",  "MORE", "=", "MONEY"};
        this.args2 = new String[]{"SEND", "+",  "MORE", "-", "DUDE", "=", "MONEY", "*", "NIKE",};
        this.parser = new ArgumentParser(args);
        this.parser2 = new ArgumentParser(args2);
        characters = Arrays.asList('N', 'O' , 'R' , 'S' , 'D' , 'E' , 'Y' , 'M');
        Collections.sort(characters);
    }

    @Test
    public void testGetVariables() throws NotValidCryptarithmException {
        List<Variable> variables = parser.getVariables();
        assertTrue(variables.size() == 8);
    }

    @Test
    public void testGetVariablesMap() {
        Map<Character, Variable> variableMap = parser.getVariablesMap();
        assertTrue(variableMap.size() == 8);
        List<Character> keys = new ArrayList<>(variableMap.keySet());
        Collections.sort(keys);
        assertEquals(characters, keys);
    }

    @Test
    public void testGetExpressionsSum() throws NotValidCryptarithmException {
        List<Expression> expressions = parser.getExpressions();
        for (Expression expression : expressions) {
            System.out.println(expression.eval());
        }
        assertTrue(expressions.size() == 2);
        assertTrue(expressions.get(0).toString().equals("(SEND+MORE)"));
        assertTrue(expressions.get(1).toString().equals("MONEY"));
    }

    @Test
    public void testGetExpressionsSumWithValue() throws NotValidCryptarithmException {
        List<Expression> expressions = parser.getExpressions();
        assertTrue(expressions.size() == 2);
        assertTrue(expressions.get(0).toString().equals("(SEND+MORE)"));
        assertTrue(expressions.get(1).toString().equals("MONEY"));
    }

    @Test
    public void testGetExpressionsMix() throws NotValidCryptarithmException {
        List<Expression> expressions = parser2.getExpressions();
        assertTrue(expressions.size() == 2);
        System.out.println(expressions.get(0).toString());
        System.out.println(expressions.get(1).toString());
        assertTrue(expressions.get(0).toString().equals("((SEND+MORE)-DUDE)"));
        assertTrue(expressions.get(1).toString().equals("(MONEY*NIKE)"));
    }
}
