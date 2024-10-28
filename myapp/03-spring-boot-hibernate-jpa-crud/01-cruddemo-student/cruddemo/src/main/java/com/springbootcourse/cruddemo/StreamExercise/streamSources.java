package com.springbootcourse.cruddemo.StreamExercise;

import java.util.stream.Stream;

public class streamSources {

    public static Stream<String> stringNumbersStream(){
        return Stream.of("one", "two","three", "four", "five", "six", "seven", "eight", "nine");
    }

    public static Stream<Integer> integerNumbersStream(){
        return Stream.iterate(0, i -> i +2)
                .limit(10);
    }

    public static Stream<User> userStream(){
        return Stream.of(
                new User(1, "John", "Doe"),
                new User(2, "Jane", "Doe"),
                new User(3, "Jack", "Doe"),
                new User(4, "Jason", "Doe"),
                new User(5, "Jim", "Doe"),
                new User(6, "Janette", "Doe")
        );
    }
}
