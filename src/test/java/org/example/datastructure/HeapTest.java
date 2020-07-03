package org.example.datastructure;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HeapTest {
    private Heap heap;
    @Before
    public void setUp() throws Exception {
        heap = new Heap();
    }

    @After
    public void tearDown() throws Exception {
        heap = null;
    }

    @Test
    public void add() {
        int[] a = {107,80,48,50,32,30,36,85,55};
        for (int i:a){
            heap.add(i);
        }
        String b = "12";
        String c  ="s";

        System.out.println(heap.getMin());
        heap.removeMin();
        System.out.println(heap.getMin());
    }
}