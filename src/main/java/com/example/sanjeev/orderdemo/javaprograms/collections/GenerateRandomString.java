package com.example.sanjeev.orderdemo.javaprograms.collections;

import lombok.extern.slf4j.Slf4j;

import javax.validation.constraints.PositiveOrZero;
import java.util.*;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

import static java.lang.String.valueOf;
import static java.util.stream.Collectors.*;

@Slf4j
public class GenerateRandomString {

    public  static void main(String[] args) {

        List<Person> personList = getPeople();

        Map<@PositiveOrZero Integer, List<Person>> toImmutableMap = getCollect(personList);

        log.info("toImmutableMap:{}", toImmutableMap);

        ConcurrentMap<@PositiveOrZero Integer, Long> personsByAgesAndCount = getPersonsByAgesAndCount(personList);
        log.info("personsByAgesAndCount:{}", personsByAgesAndCount);
        Map<Boolean, List<Person>> partitionedPersons = partitioningPersonsbasedOnAge(personList);

        List<List<Person>> majors = partitionedPersons.entrySet()
                .stream()
                .filter(GenerateRandomString::test)
                .map(Map.Entry::getValue)
                .collect(toList());

        log.info("majors: {}", majors);

        String sequenceNames = personList.stream()
                .map(Person::getName)
                .collect(joining(","));

        TreeSet<String> collect = personList.stream()
                .map(Person::getName)
                .collect(toCollection(TreeSet::new));

        log.info("collect:{}", collect);

        log.info("sequenceNames: {}", sequenceNames);

        OptionalInt ageMax =
                personList.stream()
                        .mapToInt(Person::getAge)
                        .reduce(Integer::min);

        ageMax.orElseGet(null);
        getYoungestPerson(personList);

        String oldestPersonName = getOldestPerson(personList);

        log.info("oldestPersonName: {}", oldestPersonName);

        log.info("<< Find the average age>>>>.");

        Double averageAge = getAverageAge(personList);

        log.info("Average age: {}", averageAge);

    }

    private static List<Person> getPeople() {
        return Arrays.asList(Person.builder().name("sanjeev").age(37).build(),
                    Person.builder().name("naisha").age(1).build(),
                    Person.builder().name("keerti").age(23).build(),
                    Person.builder().name("rehansh").age(1).build(),
                    Person.builder().name("amruth").age(37).build(),
                    Person.builder().name("reddy").age(23).build(),
                    Person.builder().name("Suman").age(23).build(),
                    Person.builder().name("SSSS").age(1).build(),
                    Person.builder().name("Mahendar").age(37).build(),
                    Person.builder().name("Tipuu").age(23).build()
            );
    }

    private static Map<@PositiveOrZero Integer, List<Person>> getCollect(List<Person> personList) {
        return personList.stream()
                .collect(
                        Collectors.collectingAndThen(
                                Collectors.groupingBy(Person::getAge),
                                Collections::unmodifiableMap)
                );
    }


    private static ConcurrentMap<@PositiveOrZero Integer, Long> getPersonsByAgesAndCount(List<Person> personList) {
        return personList.stream()
                .filter(Objects::nonNull)
                .collect(groupingByConcurrent(Person::getAge, counting()));
    }

    private static void groupByAges(List<Person> personList) {
        Map<@PositiveOrZero Integer, List<Person>> groupByAges = personList.stream()
                .filter(Objects::nonNull)
                .collect(groupingBy(Person::getAge));

        log.info("gropuByAges: {}", groupByAges);
    }

    private static Map<Boolean, List<Person>> partitioningPersonsbasedOnAge(List<Person> personList) {
        return personList.stream()
                .collect(partitioningBy(element -> element.getAge() > 21));


    }

    private static void getYoungestPerson(List<Person> personList) {
        Optional<Person> youngestPerson = personList
                .stream()
                .filter(Objects::nonNull)
                .min(Comparator.comparing(Person::getAge));

        Person person = youngestPerson.orElse(null);
        log.info(valueOf(person));
    }

    private static Double getAverageAge(List<Person> personList) {
        return personList.stream()
                .collect(averagingInt(Person::getAge));
    }

    private static String getOldestPerson(List<Person> personList) {
        return personList.stream()
                .filter(Objects::nonNull)
                .max(Comparator.comparingInt(Person::getAge))
                .map(Person::getName)
                .orElse(null);
    }

    private static boolean test(Map.Entry<Boolean, List<Person>> booleanListEntry) {
        return booleanListEntry.getKey().equals(true);
    }
}
