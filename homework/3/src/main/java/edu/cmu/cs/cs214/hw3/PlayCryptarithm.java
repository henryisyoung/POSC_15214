package edu.cmu.cs.cs214.hw3;

import hw2.expression.Expression;
import hw2.expression.Variable;

import java.util.ArrayList;
import java.util.List;

public class PlayCryptarithm {
    public static void main(String[] args) {

    }

    public List<String> cryptarithmSolutions(String[] args) {
        ArgumentParser parser = new ArgumentParser(args);
        List<String> result = new ArrayList<>();
        try {
            List<Variable> variables = parser.getVariables();
            List<Expression> expressions = parser.getExpressions();
            CryptarithmSolver solver = new CryptarithmSolver(variables, expressions);
            result = solver.getVariablesList();

        } catch (NotValidCryptarithmException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

}
