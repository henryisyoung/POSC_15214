package edu.cmu.cs.cs214.hw3.permutation_generator;

import java.util.List;

/**
 *
 */
public class PermutationGeneratorCommandPattern {
    private Algorithm algorithm;

    /**
     * @param algorithm
     */
    public PermutationGeneratorCommandPattern(Algorithm algorithm){
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
