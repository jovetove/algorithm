package org.example.algorithm;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TopKTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void findKthLargest() {
        int[] nums = {3,2,1,5,6,4};
        int k = 4;
        int num = TopK.findKthLargest(nums,4);
        assertEquals(3,num);
    }
}