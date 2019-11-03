package edu.cmu.cs.cs214.hw3;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class CryptarithmTest {
    private String[] args = new String[]{"SEND", "+",  "MORE", "=", "MONEY"};
    private String[] args2 = new String[]{"NORTH", "*", "WEST", "=", "SOUTH", "*", "EAST"};
    private String[] args3 = new String[]{"WINTER","+","IS","+","WINDIER","+","SUMMER","+","IS","=","SUNNIER"};
    private String[] args4 = new String[]{"JEDER", "+",  "LIEBT", "=", "BERLIN"};
    private String[] args5 = new String[]{"I", "+",  "CANT", "+",  "GET","=", "NO" , "+",  "SATISFACTION",};

    private PlayCryptarithm player;

    @Before
    public void setup(){
        this.player = new PlayCryptarithm();
    }

    @Test
    public void testPlayCryptarithmSum() {
        List<String> result = player.cryptarithmSolutions(args);
        assertEquals(result.size(), 1);
        assertEquals(result.get(0), "{N=6, O=0, R=8, S=9, D=7, E=5, Y=2, M=1}");
    }

    @Test
    public void testPlayCryptarithmProduct() {
        List<String> result = player.cryptarithmSolutions(args2);
        assertEquals(result.size(), 1);
        assertEquals(result.get(0), "{N=5, O=1, A=2, R=3, S=6, T=0, E=7, U=9, W=8, H=4}");
    }

    @Test
    public void testPlayCryptarithmManyArgs() {
        List<String> result = player.cryptarithmSolutions(args3);
        assertEquals(result.size(), 1);
        assertEquals(result.get(0), "{N=0, R=1, S=9, T=2, D=4, E=8, U=3, W=7, I=6, M=5}");
    }

    @Test
    public void testPlayCryptarithmMoreSolution() {
        List<String> result = player.cryptarithmSolutions(args4);
        assertEquals(result.size(), 2);
        assertEquals(result.get(0), "{N=0, R=8, B=1, D=4, T=2, E=3, I=5, J=6, L=7}");
        assertEquals(result.get(1), "{N=0, R=8, B=1, D=6, T=2, E=3, I=5, J=4, L=9}");
    }

    @Test
    public void testPlayCryptarithmMoreRightArgs() {
        List<String> result = player.cryptarithmSolutions(args5);
        assertEquals(result.size(), 0);
    }
}
