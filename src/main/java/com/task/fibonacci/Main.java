package com.task.fibonacci;

import com.task.fibonacci.console.ConsoleFormatter;
import com.task.fibonacci.parser.CommandLineParser;
import com.task.fibonacci.parser.InputParameter;
import com.task.fibonacci.performance.PerformanceTestResult;
import com.task.fibonacci.performance.PerformanceTesterImpl;
import com.task.fibonacci.task.FibTask;

public class Main {
    public static void main(String[] args) {
        CommandLineParser.parse(args)
                .map(Main::execute)
                .map(ConsoleFormatter::new)
                .peek(System.out::println)
                .peekLeft(System.out::println);
    }

    private static PerformanceTestResult execute(InputParameter inputParameter) {
        return new PerformanceTesterImpl().runPerformanceTest(
                new FibTask(inputParameter.n()),
                inputParameter.calculationCount(),
                inputParameter.threadPoolSize()
        );
    }
}