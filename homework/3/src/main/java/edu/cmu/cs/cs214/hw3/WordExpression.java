package edu.cmu.cs.cs214.hw3;

import hw2.expression.Expression;
import hw2.expression.Variable;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class WordExpression implements Expression {
    private List<Variable> variables = new ArrayList<>();

    /**
     * Construct an Expression with variables assigned names.
     * @param w the string to convert.
     * @param words the variable to initialize.
     */
    public WordExpression(String w, List<Variable> words) {
        char[] chars = w.toCharArray();
        for (char c : chars) {
            for (Variable v : words) {
                if (v.name().equals(Character.toString(c))) {
                    variables.add(v);
                    break;
                }
            }
        }
    }

    /**
     * toString method to combine all names of variables to make the string.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Variable v : variables) {
            sb.append(v.name());
        }
        return sb.toString();
    }

    /**
     * Method to get the value of the Expression as a written number.
     */
    @Override
    public double eval() {
        double sum = 0;
        if (variables.size() != 1 && variables.get(0).eval() == 0) {				//If the number gets more than one digit
            return -1.1;													//and the first character values 0,
        }																	//we should discard this solution because
        for (int i = 0; i < variables.size(); i++) {							//it is illegal.
            sum += variables.get(i).eval() * Math.pow(10, variables.size() - i - 1);
        }
        return sum;
    }
}
