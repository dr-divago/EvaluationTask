package com.task.fibonacci.core;


public class FibCalcImpl implements FibCalc {
    private final int n;
    public FibCalcImpl(int n) {
        this.n = n;
    }

    public long run() {
        return fib(n);
    }
}
