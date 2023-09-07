package com.task.fibonacci.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class FibCalcImplTest {

    private static FibCalc fibCalc;
    @BeforeAll
    public static void setup() {
        fibCalc = new FibCalcImpl();
    }
    @Test
    void when_fibCalc_1_then_return_1() {
        Assertions.assertEquals(1,fibCalc.fib(1));
    }

    @Test
    void when_fibCalc_2_then_return_1() {
        Assertions.assertEquals(1,fibCalc.fib(2));
    }

    @Test
    void when_fibCalc_3_then_return_2() {
        Assertions.assertEquals(2,fibCalc.fib(3));
    }

    @Test
    void when_fibCalc_4_then_return_3() {
        Assertions.assertEquals(3,fibCalc.fib(4));
    }


    @Test
    void when_fibCalc_5_then_return_5() {
        Assertions.assertEquals(5,fibCalc.fib(5));
    }
}