package com.springbootcourse.cruddemo.StreamExercise;


import javax.xml.transform.stream.StreamSource;

public class Exercise1 {
    public static void main(String[] args) {

        //Question 1: Print all numbers in the integerNumberStream

        System.out.println("Question 1: ");
        streamSources.integerNumbersStream().forEach(System.out::println);

        //Question 2: Print numbers from integerNumberStream that are less than 5

        System.out.println("Question 2: ");

        streamSources.integerNumbersStream().filter(number ->number <5)
                .forEach(number -> System.out.println(number));


        //Question 3: Print the second and third numbers from integerNumberStream that are greater than 5


        System.out.println("Question 3: ");

        streamSources.integerNumbersStream().filter(number -> number >5)
                .skip(1)
                .limit(2)
                .forEach(number -> System.out.println(number));

        //Question 4: Print the first number in intNumberStream that is greater than 5
        // if nothing is found, print -1

        System.out.println("Question 4: ");

        Integer value = streamSources.integerNumbersStream().filter(number -> number >5)
                .findFirst()
                .orElse(-1);

        System.out.println(value);

        //Question 5: Print first names of all users in userStream

        System.out.println("Question 5: ");

        streamSources.userStream().forEach(user -> System.out.println(user.getFirstName()));

        //Question 6: Print first names from userStreams for users that have IDs from number stream

        System.out.println("Question 6: ");
        streamSources.integerNumbersStream()
                .flatMap(id -> streamSources.userStream().filter(user -> user.getId() ==id))
                .forEach(user -> System.out.println(user.getFirstName()));

        System.out.println("Another Solution");

        streamSources.userStream()
                .filter(user ->streamSources.integerNumbersStream().anyMatch(i-> i == user.getId())).forEach(user -> System.out.println(user.getFirstName()));

    }


}
