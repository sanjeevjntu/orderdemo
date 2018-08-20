package com.example.sanjeev.orderdemo.javaprograms.singletonimmutable;

public class ImmuatbleStudentTest {

    public static void main(String[] args) {

        Age age = new Age();
        age.setDay(13);
        age.setMonth(4);
        age.setYear(2017);

        ImmuatbleStudent naisha = new ImmuatbleStudent("Naisha",111, age);

        age.setYear(2018);

        System.out.println(naisha.getAge().getYear());

        naisha.getAge().setYear(2010); //fixed by modifyimg getAge()
        System.out.println(naisha.getAge().getYear());

    }
}
