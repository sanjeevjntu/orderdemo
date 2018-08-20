package com.example.sanjeev.orderdemo.javaprograms.singletonimmutable;

import java.util.Date;

public final class Contact { //1. make the class as final so that you can't override the constructor

    private final String name; //2. All the fields should be private. No access from outside
    private final String mobile;//3 variables are final so that it can"t be changed anywhere within the class
    private final Date date; //mutable object is Date

    //4. assign the values using allargsconstructor
    public  Contact(String name, String mobile, Date date) {
        this.name = name;
        this.mobile = mobile;
        this.date = new Date(date.getTime()); //5. Deep copy of the mutable object
    }

    //6. No setters

    public String getName() {
        return name;
    }

    public String getMobile() {
        return mobile;
    }

    //7. return a deep copy of thr object.
    public Date getDate() {
        return new Date(date.getTime());
    }
}
