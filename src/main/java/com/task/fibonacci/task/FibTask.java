package com.task.fibonacci.task;

import com.task.fibonacci.core.FibCalcImpl;

public class FibTask implements Runnable{
    private final FibCalcImpl fibCalc;
    public FibTask(int n) {
        this.fibCalc = new FibCalcImpl(n);
    }
    @Override
    public void run() {
        fibCalc.run();
    }
}
