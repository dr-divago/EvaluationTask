package com.task.fibonacci.parser;

import io.vavr.control.Either;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class CommandLineParserTest {
    @Test
    void when_parse_less_3_parameter_return_error() {
        String[] args = {"100", "4"};
        Either<String, InputParameter> res = CommandLineParser.parse(args);
        Assertions.assertTrue(res.isLeft());
        Assertions.assertEquals("Usage: java -jar performance-test-{version}.jar <n> <calculationCount> <threadPoolSize>", res.getLeft());
    }

    @Test
    void when_parse_3_parameter_return_parsed_value() {
        String[] args = {"100", "2", "4"};
        Either<String, InputParameter> res = CommandLineParser.parse(args);
        Assertions.assertTrue(res.isRight());
        Assertions.assertEquals(100, res.get().n());
        Assertions.assertEquals(2, res.get().calculationCount());
        Assertions.assertEquals(4, res.get().threadPoolSize());
    }
    @Test
    void when_parse_n_less_than_0_return_error() {
        String[] args = {"0", "2", "4"};
        Either<String, InputParameter> res = CommandLineParser.parse(args);
        Assertions.assertTrue(res.isLeft());
        Assertions.assertEquals("Invalid argument format. Please provide value for parameter > 0.", res.getLeft());
    }
    @Test
    void when_parse_count_less_than_0_return_error() {
        String[] args = {"100", "0", "4"};
        Either<String, InputParameter> res = CommandLineParser.parse(args);
        Assertions.assertTrue(res.isLeft());
        Assertions.assertEquals("Invalid argument format. Please provide value for parameter > 0.", res.getLeft());
    }

    @Test
    void when_parse_threadCount_less_than_0_return_error_message() {
        String[] args = {"100", "1", "0"};
        Either<String, InputParameter> res = CommandLineParser.parse(args);
        Assertions.assertTrue(res.isLeft());
        Assertions.assertEquals("Invalid argument format. Please provide value for parameter > 0.", res.getLeft());
    }
}