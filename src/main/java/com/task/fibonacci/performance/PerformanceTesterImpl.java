package com.task.fibonacci.performance;

import com.task.fibonacci.task.TimerTask;

import java.util.List;
import java.util.concurrent.*;
import java.util.stream.IntStream;

public class PerformanceTesterImpl implements PerformanceTester{
    @Override
    public PerformanceTestResult runPerformanceTest(Runnable task, int executionCount, int threadPoolSize) {
        ExecutorService executorService = Executors.newFixedThreadPool(threadPoolSize);
        long beginTime = System.nanoTime();
        List<Long> results = IntStream.range(0, executionCount)
                    .mapToObj(i -> new TimerTask(task))
                    .map(timerTask -> CompletableFuture.supplyAsync(timerTask, executorService))
                    .map(f -> f.exceptionally(this::manageException))
                    .map(CompletableFuture::join)
                    .toList();

        shutdownAndAwaitTermination(executorService);
        return new PerformanceTestResult(
                System.nanoTime()-beginTime,
                results.stream().reduce(Long.MAX_VALUE, Long::min),
                results.stream().reduce(Long.MIN_VALUE, Long::max));
    }

    private Long manageException(Throwable ex) {
        if (ex instanceof InterruptedException) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Thread interrupted", ex);
        }
        throw new RuntimeException("Exception", ex.getCause());
    }

    void shutdownAndAwaitTermination(ExecutorService pool) {
        pool.shutdown();
        try {
            if (!pool.awaitTermination(60, TimeUnit.SECONDS)) {
                pool.shutdownNow();
                if (!pool.awaitTermination(60, TimeUnit.SECONDS))
                    System.err.println("Pool did not terminate");
            }
        } catch (InterruptedException ex) {
            pool.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}
