package com.example.sanjeev.orderdemo.javaprograms;

public class Bufferbuilder {

    public static void main(String[] args) {
        // A thread-safe, mutable sequence of characters. synchronized
        StringBuffer stringBuffer = new StringBuffer();

        String s= new String();

        // Not thread-safe, mutable sequence of characters. Not synchronized
        StringBuilder stringBuilder = new StringBuilder();

    }
}
