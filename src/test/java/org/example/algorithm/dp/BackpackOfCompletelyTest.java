package org.example.algorithm.dp;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BackpackOfCompletelyTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getNum() {
        int amount = 5;
        int[] coins = {1, 2, 5};
        int totle = BackpackOfCompletely.getNum(amount,coins);
        System.out.println(totle);
    }

    @Test
    public void getNum2() {
        int amount = 5;
        int[] coins = {1, 2, 5};
        int totle = BackpackOfCompletely.getNum2(amount,coins);
        System.out.println(totle);
    }
}