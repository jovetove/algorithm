package org.example.algorithm.dp;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BackpackOfZoreOneTest {
    private BackpackOfZoreOne backpackOfZoreOne;
    @Before
    public void setUp() throws Exception {
        backpackOfZoreOne = new BackpackOfZoreOne();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getMaxValue() {
        int W = 4;
        int[] weigth = {2,1,3};
        int[] value = {4,2,3};
        int max = BackpackOfZoreOne.getMaxValue(W,weigth,value);
        System.out.println(max);
    }

    @Test
    public void getMaxValue2() {
        int W = 4;
        int[] weigth = {2,1,3};
        int[] value = {4,2,3};
        int max = BackpackOfZoreOne.getMaxValue2(W,weigth,value);
        System.out.println(max);
    }
}