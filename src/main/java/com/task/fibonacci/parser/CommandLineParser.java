package com.task.fibonacci.parser;

import io.vavr.control.Either;

public class CommandLineParser {
    public static Either<String, InputParameter> parse(String[] args) {
        return validateInputLength(args)
                .flatMap( arg -> validateInput(arg[0])
                .flatMap( n -> validateInput(arg[1])
                .flatMap( calculationCount -> validateInput(arg[2])
                .map( threadPoolSize -> new InputParameter(n, calculationCount, threadPoolSize)))));
    }

    private static Either<String, Integer> validateInput(String arg) {
        try {
            int n = Integer.parseInt(arg);
            return (n <= 0 )
                    ? Either.left("<"+arg +"> should be > 0")
                    : Either.right(n);
        } catch (NumberFormatException e) {
            return Either.left("<"+ arg + "> should be a number");
        }
    }

    private static Either<String, String[]> validateInputLength(String[] args) {
        return args.length != 3
                ? Either.left("Usage: java -jar performance-test-{version}.jar <n> <calculationCount> <threadPoolSize>")
                : Either.right(args);
    }
}
