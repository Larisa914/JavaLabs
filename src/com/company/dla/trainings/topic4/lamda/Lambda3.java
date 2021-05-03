package com.company.dla.trainings.topic4.lamda;

import java.security.SecureRandom;
import java.util.Comparator;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Lambda3 {

    @FunctionalInterface
    interface Fun {
        void foo();
    }

    public static void main(String[] args) throws Exception {

        // Predicates

        Predicate<String> predicate = s -> s.length() > 0;

        predicate.test("foo");              // true
        predicate.negate().test("foo");     // false

        Predicate<String> nonNull = Objects::nonNull;
        Predicate<String> nonNull2 = a -> Objects.nonNull(a);

        Predicate<Object> isNull = Objects::isNull;

        Predicate<String> isEmpty = String::isEmpty;
        Predicate<String> isNotEmpty = isEmpty.negate();


        // Functions

        Function<String, Integer> toInteger = Integer::valueOf;
        Function<String, String> backToString = toInteger
                .andThen(x -> x + 1)
                .andThen(String::valueOf);


        Integer intg = toInteger.apply("222");

        String apply = backToString.apply("123");// "124"
        backToString.andThen(s -> s.substring(1)).apply("123"); // 24


        // Suppliers

        Supplier<Person> personSupplier = Person::new;
        personSupplier.get();   // new Person


        // Consumers

        Consumer<Person> greeter = (p) -> System.out.println("Hello, " + p.firstName);
        greeter.accept(new Person("Luke", "Skywalker"));



        // Comparators

        Comparator<Person> comparator = (p1, p2) -> p1.firstName.compareTo(p2.firstName);

        Person p1 = new Person("John", "Doe");
        Person p2 = new Person("Alice", "Wonderland");

        comparator.compare(p1, p2);             // > 0
        comparator.reversed().compare(p1, p2);  // < 0


        // Runnables

        Runnable runnable = () -> System.out.println(UUID.randomUUID());
        runnable.run();


        // Callables

        Callable<UUID> callable = UUID::randomUUID;
        /*Callable<UUID> callable2 = () -> {
            SecureRandom ng = UUID.Holder.numberGenerator;
            byte[] randomBytes = new byte[16];
            ng.nextBytes(randomBytes);
            randomBytes[6]  &= 0x0f;  *//* clear version        *//*
            randomBytes[6]  |= 0x40;  *//* set to version 4     *//*
            randomBytes[8]  &= 0x3f;  *//* clear variant        *//*
            randomBytes[8]  |= 0x80;  *//* set to IETF variant  *//*
            return new UUID(randomBytes);
        };*/
        //100000 strings of code
        UUID uuid = callable.call();
    }

}
