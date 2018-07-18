package com.example.sanjeev.orderdemo.javaprograms.customstreams;

import com.example.sanjeev.orderdemo.javaprograms.collections.Person;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.Supplier;

/**
 * 1. How do you merge two maps
 * 2.
 */
@Slf4j
public class CustomCollectorTest {

    private static List<Person> getPersons() {
        return Arrays.asList(Person.builder().name("sanjeev").age(37).build(),
                Person.builder().name("naisha").age(1).build(),
                Person.builder().name("keerti").age(23).build()
        );
    }

    public static void main(String[] args) {
        manageCollectors();

    }

    private static void manageCollectors() {

        Supplier<List<Person>> supplier = () -> getPersons();
        List<Person> personList = supplier.get();

        log.info("personList:{}", personList);

        BiConsumer<Person, List<Person>> accumulator = (person, people) -> people.add(person);

       /* BinaryOperator<List<Person>> combiner = (people1, people2) ->
             people1.addAll(people2);
*/

        long noOfPersons = personList.stream()
                .filter(Objects::nonNull)
                .map(person -> person.getName())
                .distinct()
                .count();


    }

}
