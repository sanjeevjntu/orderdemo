package com.example.sanjeev.orderdemo.javaprograms.streampatterns;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class StreamPattern {

    public static void main(String[] args) {

        List<Integer>  list = Arrays.asList(2,3,4,5,56,54,44);

//        list.stream().filter(isEvenFunction)
//                .collect(Collectors.toList());
    }

}

class Utility {

    public static boolean isEven(){
        Predicate<Integer> isEvenFunction =   integer -> integer %2==0;
        return false;
    }

}
