package com.example.sanjeev.orderdemo.javaprograms.singletonimmutable;

import java.util.Date;

/**
 *
 Benefits of Immutable Classes in Java
 As I said earlier Immutable classes offers several benefits, here are few to mention:

 1) Immutable objects are by default thread safe, can be shared without synchronization in concurrent environment.
 2) Immutable object simplifies development, because its easier to share between multiple threads without external synchronization.

 3) Immutable object boost performance of Java application by reducing synchronization in code.

 4) Another important benefit of Immutable objects is reusability, you can cache Immutable object and reuse them, much like String literals and Integers.  You can use static factory methods to provide methods like valueOf(), which can return an existing Immutable object from cache, instead of creating a new one.
 **/
public class ImmutableTest {

 /*   public ImmutableTest(String name, String mobile) {
        super(name, mobile);
    }*/

    //If you do not make the Contact class as final, you can change the object
    public static void main(String[] args) {

        Contact contact = new Contact("Sanjeev", "1234567890", new Date());

        String s= "Sanjeev";
        s.substring(0,2);
        System.out.println(s);

        contact = new Contact("ABH", "1234567890", new Date());
        //contact = new ImmutableTest("Suresh", "12345667");
        final String mobile = contact.getMobile();
        final String name = contact.getName();

        System.out.println(name);
        System.out.println(mobile);

        // Test Lombok class
        //PersonLombokImmutable personLombokImmutable = new PersonLombokImmutable();//cant do
        PersonLombokImmutable personLombokImmutable = PersonLombokImmutable.builder()
                .age(20).name("sanjeev").city("ADB").car("HONDACRV").build();

        personLombokImmutable= personLombokImmutable.builder()
                .age(25).name("chiru").city("MIT").car("CAMRY").build();

       // System.out.println(personLombokImmutable.getCar());

        Feature immutableFeature =  new Feature("RTTI", "RTTI_001");

        immutableFeature = new Feature("PAAK", "PAAK_001");

      //  System.out.println(immutableFeature.getFeatureCode());

    }

}
