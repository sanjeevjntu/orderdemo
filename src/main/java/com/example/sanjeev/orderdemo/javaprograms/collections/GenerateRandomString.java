package com.example.sanjeev.orderdemo.javaprograms.collections;

import com.google.common.collect.ImmutableList;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.RandomStringUtils;

import java.util.*;

@Slf4j
public class GenerateRandomString {

    public static void main(String[] args){

        String s = RandomStringUtils.randomAlphanumeric(20);

        System.out.println(s);

        List<Person> personList = ImmutableList.of(Person.builder().name("sanjeev").age(37).build(),
                Person.builder().name("naisha").age(1).build(),
                Person.builder().name("keerti").age(21).build(),
                Person.builder().name("rehansh").age(2).build()
        );

        OptionalInt ageMax =
                personList.stream()
                .mapToInt(value -> value.getAge())
                .reduce(Integer::min);

        System.out.println(ageMax.getAsInt());

       // personList.add(Person.builder().build()); //UnsupportedOperationException

        Optional<Person> youngestPerson = personList
                .stream()
                .filter(Objects::nonNull)
                .min(Comparator.comparing(Person::getAge));
               // .collect(Collectors.maxBy((o1, o2) -> o1.getAge() - o2.getAge()))
                //.max(Comparator.comparingInt(Person::getAge));

        Person person = youngestPerson.orElse(null);

        System.out.println(person);

        String oldestPersonName = personList.stream()
                .filter(Objects::nonNull)
                .max(Comparator.comparingInt(Person::getAge))
                .map(Person::getName)
                .orElse(null);

        System.out.println("oldestPersonName: "+oldestPersonName);


    }
}
