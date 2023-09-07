package com.task.fibonacci.core;

/**
 * A fibonacci calculator.
 */
public interface FibCalc {

    /**
     * Calculates the given fibonacci number.
     * Examples:
     * fib(1) = 1    <br>
     * fib(2) = 1    <br>
     * fib(3) = 2    <br>
     * fib(4) = 3    <br>
     * fib(5) = 5    <br>
     */
    default long fib(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("Invalid input. n must be a positive integer.");
        }

        if (n == 1 || n == 2) {
            return 1;
        }

        long prev1 = 1;
        long prev2 = 1;
        long fibNumber = 0;

        for (int i = 3; i <= n; i++) {
            fibNumber = prev1 + prev2;
            prev1 = prev2;
            prev2 = fibNumber;
        }

        return fibNumber;
    }
}