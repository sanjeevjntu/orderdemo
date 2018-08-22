package com.example.sanjeev.orderdemo.javaprograms.singletonimmutable;

/**
 * 2. Lazy initialization:
 * Opposite to Eager initialization, here you are going to initialize new instance of the class in getInstance()
 * method it self. This method will check if there is any instance of that class is already created? If yes,
 * then our method (getInstance()) will return that old instance and if not then it creates a new instance of
 * the singleton class in JVM and returns that instance.
 * This approach is called as Lazy initialization.
 */
public class LazySingle {

    private static LazySingle lazySingle;

    private LazySingle(){}

    public static LazySingle getInstance(){
        if(lazySingle == null) {
            lazySingle = new LazySingle();
        }
        return lazySingle;
    }
}
