package com.example.sanjeev.orderdemo.javaprograms.singletonimmutable;

//Perfect immutable class
public final class ImmuatbleStudent {

    private final String name;
    private final  int id;
    private final Age age;

    public ImmuatbleStudent(String name, int id, Age age) {
        this.name = name;
        this.id = id;
        Age cloneAge = new Age();
        cloneAge.setDay(age.getDay());
        cloneAge.setMonth(age.getMonth());
        cloneAge.setYear(age.getYear());
        this.age = cloneAge;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }


    public Age getAge() {

        Age cloneAge = new Age();
        cloneAge.setDay(this.age.getDay());
        cloneAge.setMonth(this.age.getMonth());
        cloneAge.setYear(this.age.getYear());

        return cloneAge;
    }
}
