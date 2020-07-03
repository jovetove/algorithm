package org.example.algorithm;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class InsertArrayTest {
    private InsertArray insertArray;
    @Before
    public void setUp() throws Exception {
        int[] arr = {1,2,3,4,5};
        insertArray = new InsertArray(arr);
    }

    @After
    public void tearDown() throws Exception {
        insertArray = null;
    }

    @Test
    public void insertToIndex() {
        insertArray.insertToIndex(3,11);
        System.out.println(insertArray.toString());
    }
}