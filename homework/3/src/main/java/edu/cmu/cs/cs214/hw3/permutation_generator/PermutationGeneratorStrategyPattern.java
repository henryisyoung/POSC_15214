package edu.cmu.cs.cs214.hw3.permutation_generator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 */
public class PermutationGeneratorStrategyPattern {
    private Algorithm algorithm;
    private List<Integer> digits;

    /**
     * @param algorithm
     */
    public PermutationGeneratorStrategyPattern(Algorithm algorithm){
        this.algorithm = algorithm;
        this.digits = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));
    }

    /**
     * @param size
     * @return
     */
    public List<List<Integer>> getPermutation(int size) {
        List<List<Integer>> result = new ArrayList<>();
        List<List<Integer>> combinations = getCombination(size);
        for (List<Integer> combiation : combinations) {
            result.addAll(algorithm.permutate(combiation));
        }
        return result;
    }

    private List<List<Integer>> getCombination(int size) {
        List<List<Integer>> result = new ArrayList<>();
        dfsFindAllCombinations(result, size, 0, new ArrayList<>());
        return result;
    }

    private void dfsFindAllCombinations(List<List<Integer>> result, int size, int pos, List<Integer> list) {
        if (size == 0) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = pos; i < digits.size(); i++) {
            list.add(digits.get(i));
            dfsFindAllCombinations(result, size - 1, pos + 1, list);
            list.remove(list.size() - 1);
        }
    }
}
