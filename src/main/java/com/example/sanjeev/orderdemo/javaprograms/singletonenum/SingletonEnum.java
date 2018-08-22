package com.example.sanjeev.orderdemo.javaprograms.singletonenum;

/**
 * Enum Singletons handled Serialization by themselves
 * Threadsafe
 */
public enum SingletonEnum {

    INSTANCE;

    int value;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
