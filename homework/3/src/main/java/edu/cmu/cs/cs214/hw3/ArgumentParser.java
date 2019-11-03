package edu.cmu.cs.cs214.hw3;

import hw2.expression.*;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;

public class ArgumentParser {
    private List<String> strings;
    private Set<String> opers;
    private List<Variable> variables;
    private Map<Character, Variable> variablesMap;

    public ArgumentParser(String[] args) {
        this.strings = Arrays.asList(args);
        this.opers = new ConcurrentSkipListSet<>();
        opers.add("+");
        opers.add("-");
        opers.add("*");
        opers.add("=");
        this.variablesMap = new ConcurrentHashMap<>();
        createVariables();
    }

    public Map<Character, Variable> getVariablesMap() {
        return variablesMap;
    }

    private void createVariables()  {
        Set<Variable> result = new HashSet<>();

        for (String str : strings) {
            if (opers.contains(str)) continue;
            for (char c : str.toCharArray()) {
                Variable variable = new Variable(Character.toString(c));
                result.add(variable);
                variablesMap.put(c, variable);
            }
        }
        variables = new ArrayList<>(result);
    }

    public List<Variable> getVariables() throws NotValidCryptarithmException {
        if (variables.size() > 10) {
            throw new NotValidCryptarithmException("Variables size is greater than 10");
        }
        return variables;
    }

    public List<Expression> getExpressions() throws NotValidCryptarithmException {
        List<Expression> expressions = new ArrayList<>();
        Expression temp = null;
        String prevOper = "";

        for (String word : strings) {
            if (word.equals("=")) {
                if (temp == null) {
                    throw new NotValidCryptarithmException("Not a valid expression equation");
                } else {
                    expressions.add(temp);
                    temp = null;
                    prevOper = "";
                }
            } else {
                if (opers.contains(word)) {
                    prevOper = word;
                } else {
                    switch (prevOper) {
                        case ("+"):
                            temp = new SumExpression(temp, new WordExpression(word, variables));
                            break;
                        case ("-"):
                            temp = new DifferenceExpression(temp, new WordExpression(word, variables));
                            break;
                        case ("*"):
                            temp = new ProductExpression(temp, new WordExpression(word, variables));
                            break;
                        case (""):
                            temp = new WordExpression(word, variables);
                            break;
                    }
                }
            }
        }
        expressions.add(temp);

        return expressions;
    }
}
