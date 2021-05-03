package com.company.dla.trainings.topic4.lamda;

import java.io.PrintStream;
import java.util.Optional;

public class OptionalExample {

    public static final PrintStream out = System.out;

    public static void main(String[] args) {
        Optional<String> valuedOptional = Optional.of("Some Value");
        Optional<String> emptyOptional = Optional.empty();
//        Optional<String> emptyOptional = Optional.ofNullable(null);

        out.println();
        out.println("======================================");
        out.println("isPresent()");
        out.printf("non-empty: %s%n", valuedOptional.isPresent());
        out.printf("empty: %s%n", emptyOptional.isPresent());

        out.println();
        out.println("======================================");
        out.println(".get()");
        if (valuedOptional.isPresent()) {
            out.println(valuedOptional.get());
        }
        if (emptyOptional.isPresent()) {
            out.println(emptyOptional.get());
        }

        out.println();
        out.println("======================================");
        out.println(".orElse(\"Default value\")");
        out.printf("non-empty: %s%n", valuedOptional.orElse("Default value"));
        out.printf("empty: %s%n", emptyOptional.orElse("Default value"));

        out.println();
        out.println("======================================");
        out.println(".map(s -> (\"Value: \\\"\" + s + \"\\\"\"))");
        out.printf("non-empty: %s%n", valuedOptional.map(s -> ("Value: \"" + s + "\"")));
        out.printf("empty: %s%n", emptyOptional.map(s -> ("Value: \"" + s + "\"")));

        out.println("======================================");
        out.println(".orElseThrow(RuntimeException::new)");
        out.printf("non-empty: %s%n", valuedOptional.orElseThrow(RuntimeException::new));
        out.printf("empty: %s%n", emptyOptional.orElseThrow(RuntimeException::new));

    }
}
