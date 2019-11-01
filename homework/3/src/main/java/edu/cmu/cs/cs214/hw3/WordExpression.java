package edu.cmu.cs.cs214.hw3;

import hw2.expression.Expression;
import hw2.expression.Variable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 */
public class WordExpression implements Expression {

    private String str;
    private Map<Character, Variable> variableMap;
    private List<Variable> variableList;

    /**
     * @param string
     * @param variableMap
     */
    public WordExpression(String string, Map<Character, Variable> variableMap) {
        this.str = string;
        this.variableMap = variableMap;
        this.variableList = new ArrayList<>();
        buildVariableList();
    }

    /**
     *
     */
    private void buildVariableList() {
        for (char c : str.toCharArray()) {
            if (variableMap.containsKey(c)) {
                variableList.add(variableMap.get(c));
            }
        }
    }

    /**
     * @return
     */
    @Override
    public double eval() {
        if (variableList.size() != 1 && variableList.get(0).eval() == 0) {
            return -1.1;
        }
        double result = 0;
        for (Variable v : variableList) {
            result = result * 10 + v.eval();
        }
        return result;
    }

    /**
     * @return
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Variable v : variableList) {
            sb.append(v.name());
        }
        return sb.toString();
    }
}
