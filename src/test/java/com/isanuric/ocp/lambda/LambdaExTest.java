package com.isanuric.ocp.lambda;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@Component
class Lmbd {

    public static int sumWithCondition(List<Integer> numbers, Predicate<Integer> predicate) {
        return numbers.parallelStream()
                .filter(predicate)
                .mapToInt(i -> i)
                .sum();
    }
}

class LambdaExTest  {

    @Autowired
    Lmbd lmbd;

    @Test
    void a() {
        final List<Integer> numbers = Arrays.asList(10, 20, 25, 30, 35, 40);
        //sum of all numbers
        System.out.println(lmbd.sumWithCondition(numbers, n -> true));
        //sum of all even numbers
        System.out.println(lmbd.sumWithCondition(numbers, i -> i%2==0));
        //sum of all numbers greater than 5
        System.out.println(lmbd.sumWithCondition(numbers, i -> i>30));
    }

    @Test
    void b() {
        final List<Integer> numbers = Arrays.asList(10, 20, 25, 30, 35, 40);

        final var sum = numbers.stream()
                .filter(i -> i > 10)
                .mapToInt(i -> i)
                .sum();
        System.out.println(sum);
    }

    @Test
    void c() {
        IntStream
                .range(1, 10)
                .skip(4) // 4 elements
                .forEach(System.out::print); // 56789

        System.out.println();
        // same
        IntStream
                .range(1, 10)
                .skip(4) // 4 elements
                .forEach(x -> System.out.print(x)); // 56789
    }

    @Test
    void d() {
        final int sum = IntStream.range(1, 3)
                .skip(1) // 4 elements
                .sum();

        System.out.println(sum); // 2

    }

    @Test
    void e() {
        Stream.of("z", "e", "f", "a")
                .sorted()
                .findFirst()
                .ifPresent(System.out::print); // a
    }

    @Test
    void f() {
        String []str = {"ziel", "einmaligkeit", "ei","er", "eins", "erleben", "air", "erlangen"};
        Arrays.stream(str)
                .filter(v -> v.startsWith("e"))
                .filter(w -> w.length() > 6)
                .sorted()
                .forEach(System.out::println);
    }
}