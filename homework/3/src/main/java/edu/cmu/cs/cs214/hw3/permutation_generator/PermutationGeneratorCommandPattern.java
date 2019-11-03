package edu.cmu.cs.cs214.hw3.permutation_generator;

import java.util.ArrayList;
import java.util.Arrays;
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
     * @param size
     * @return
     */
    public List<List<Integer>> getPermutation(int size) {
        List<List<Integer>> result = new ArrayList<>();
        List<List<Integer>> combinations = getCombination(size);
        for (List<Integer> combination : combinations) {
            result.addAll(algorithm.permutate(combination));
        }
        return result;
    }

    public List<List<Integer>> getCombination(int size) {
        List<List<Integer>> result = new ArrayList<>();
        dfsFindAllCombinations(result, size, 0, new ArrayList<>());
        return result;
    }

    private void dfsFindAllCombinations(List<List<Integer>> result, int size, int pos, List<Integer> list) {
        if (size == list.size()) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = pos; i < 10; i++) {
            list.add(i);
            dfsFindAllCombinations(result, size, i + 1, list);
            list.remove(list.size() - 1);
        }
    }
}
