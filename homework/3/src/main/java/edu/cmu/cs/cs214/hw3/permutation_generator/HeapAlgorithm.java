package edu.cmu.cs.cs214.hw3.permutation_generator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 */
public class HeapAlgorithm implements Algorithm {
    /**
     * @param value
     * @return
     */
    @Override
    public List<List<Integer>> permutate(List<Integer> value) {
        List<List<Integer>> result = new ArrayList<>();
        permute(value, value.size(), result);
        return result;
    }

    /**
     * @param v
     * @param i
     * @param j
     */
    private static void swap(List<Integer> v, int i, int j) {
        int t = v.get(i);
        v.set(i, v.get(j));
        v.set(j, t);
    }

    /**
     * @param v
     * @param n
     * @param result
     */
    private void permute(List<Integer> v, int n, List<List<Integer>> result) {
        if (n == 1) {
            result.add(new ArrayList<>(v));
        } else {
            for (int i = 0; i < n; i++) {
                permute(v, n - 1, result);
                if (n % 2 == 1) {
                    swap(v, 0, n - 1);
                } else {
                    swap(v, i, n - 1);
                }
            }
        }
    }
}
