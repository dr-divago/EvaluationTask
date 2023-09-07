package com.task.fibonacci.console;

import com.task.fibonacci.performance.PerformanceTestResult;

import java.time.Duration;

public class ConsoleFormatter {
    private final PerformanceTestResult performanceTestResult;
    public ConsoleFormatter(PerformanceTestResult performanceTestResult) {
        this.performanceTestResult = performanceTestResult;
    }

    private long toSeconds(long t) {
        return Duration.ofNanos(t).getSeconds();
    }
    private long toNanos(long t) {
        return Duration.ofNanos(t).getNano();
    }

    @Override
    public String toString() {
        return "Total time: " +
                toSeconds(performanceTestResult.getTotalTime())+ " seconds and " +
                toNanos(performanceTestResult.getTotalTime()) + " nanos\n" +
                "Min time: " +
                toSeconds(performanceTestResult.getMinTime()) + " seconds and " +
                toNanos(performanceTestResult.getMinTime()) + " nanos\n" +
                "Max time: " +
                toSeconds(performanceTestResult.getMaxTime()) + " seconds and " +
                toNanos(performanceTestResult.getMaxTime()) + " nanos\n";
    }
}
