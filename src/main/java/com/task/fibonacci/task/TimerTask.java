package com.task.fibonacci.task;

import java.util.function.Supplier;

public class TimerTask implements Supplier<Long> {
    private final Runnable r;
    public TimerTask(Runnable r) {
        this.r = r;
    }

    @Override
    public Long get() {
        long begin = System.nanoTime();
        r.run();
        return System.nanoTime() - begin;
    }
}
