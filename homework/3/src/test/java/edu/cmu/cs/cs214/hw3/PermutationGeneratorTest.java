package edu.cmu.cs.cs214.hw3;

import edu.cmu.cs.cs214.hw3.permutation_generator.HeapAlgorithm;
import edu.cmu.cs.cs214.hw3.permutation_generator.PermutationGeneratorCommandPattern;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class PermutationGeneratorTest {
    private PermutationGeneratorCommandPattern generator;
    private HeapAlgorithm algorithm;

    @Before
    public void setup() {
        algorithm = new HeapAlgorithm();
        generator = new PermutationGeneratorCommandPattern(algorithm);
    }

    @Test
    public void testGetCombination() {
        int size = 8;
        List<List<Integer>> combinations = generator.getCombination(size);
        assertEquals(combinations.size(), new HashSet<>(combinations).size());
        assertEquals(combinations.size(), 45);
    }

    @Test
    public void testGetPermutatation() {
        List<List<Integer>> permutations = generator.getPermutation(10);
        assertEquals(permutations.size(), factorial(10));
        assertEquals(permutations.size(), new HashSet<>(permutations).size());
    }

    private int factorial(int n){
        if (n == 0)
            return 1;
        else
            return(n * factorial(n-1));
    }

    @Test
    public void testGetPermutatationPart() {
        List<List<Integer>> permutations = generator.getPermutation(2);
        assertEquals(permutations.size(), 90);
        assertEquals(permutations.size(), new HashSet<>(permutations).size());
    }
}
