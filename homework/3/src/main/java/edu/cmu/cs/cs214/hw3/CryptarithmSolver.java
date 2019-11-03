package edu.cmu.cs.cs214.hw3;

import edu.cmu.cs.cs214.hw3.permutation_generator.Algorithm;
import edu.cmu.cs.cs214.hw3.permutation_generator.HeapAlgorithm;
import edu.cmu.cs.cs214.hw3.permutation_generator.PermutationGeneratorCommandPattern;
import hw2.expression.Expression;
import hw2.expression.Variable;

import java.util.*;

public class CryptarithmSolver {
    private List<Variable> variables;
    private List<Expression> expressions;
    private Algorithm algorithm;
    private List<List<Integer>> permutations;

    public CryptarithmSolver(List<Variable> variables, List<Expression> expressions) {
        this.algorithm = new HeapAlgorithm();
        this.variables = variables;
        this.expressions = expressions;
        permutations = new PermutationGeneratorCommandPattern(algorithm).getPermutation(variables.size());
    }

    public CryptarithmSolver(List<Variable> variables, List<Expression> expressions, Algorithm algorithm) {
        this.algorithm = algorithm;
        this.variables = variables;
        this.expressions = expressions;
        permutations = new PermutationGeneratorCommandPattern(algorithm).getPermutation(variables.size());
    }

    public List<List<Integer>> getAllPermutations() {
        return permutations;
    }

    public List<String> getVariablesList() throws NotValidCryptarithmException {
        List<String> result = new ArrayList<>();

        for (List<Integer> permutation : permutations) {

            for (int i = 0; i < permutation.size(); i++) {
                variables.get(i).store(new Double(permutation.get(i)));
            }

            if (Math.abs(expressions.get(0).eval() - expressions.get(1).eval()) < 0.001 && permutation.size() != 0) {
                String solution = "{";
                for (Variable j : variables) {
                    solution += j.name() + "=" + (int) j.eval() + ", ";
                }
                solution = solution.substring(0, solution.length() - 2);
                solution += "}";
                result.add(solution);
            }
        }
        if (result.size() == 0) throw new NotValidCryptarithmException("No Valid Solution");
        return result;
    }
}
