package edu.cmu.cs.cs214.hw3.permutation_generator;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class PermutationGeneratorStrategyPattern {
    private Algorithm algorithm;

    /**
     * @param algorithm
     */
    public PermutationGeneratorStrategyPattern(Algorithm algorithm){
        this.algorithm = algorithm;
    }

    /**
     * @param string
     * @return
     */
    public List<Integer> getPermutation(String string) {
        return algorithm.permutate(string);
    }
}
