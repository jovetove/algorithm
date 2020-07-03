package org.example.algorithm;

import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest {

    @Test
    public void calculator1() {
        System.out.println(Calculator.calculator1("1+2+3-3-2"));
        System.out.println(Calculator.calculator1("1+2+3-3-20"));
    }
}