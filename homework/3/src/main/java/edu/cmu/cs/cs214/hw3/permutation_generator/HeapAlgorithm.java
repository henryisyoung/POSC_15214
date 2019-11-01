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
    public List<Integer> permutate(String value) {
        List<Integer> result = new ArrayList<>();
        permute(value.toCharArray(), value.length(), result);
        return result;
    }

    /**
     * @param v
     * @param i
     * @param j
     */
    private static void swap(char[] v, int i, int j) {
        char t = v[i];
        v[i] = v[j];
        v[j] = t;
    }

    /**
     * @param v
     * @param n
     * @param result
     */
    private void permute(char[] v, int n, List<Integer> result) {
        if (n == 1) {
            result.add(Integer.parseInt(Arrays.toString(v)));
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
