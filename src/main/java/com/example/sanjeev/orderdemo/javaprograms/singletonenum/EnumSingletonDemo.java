package com.example.sanjeev.orderdemo.javaprograms.singletonenum;

/**
 *
 *  * Enum Singletons handled Serialization by themselves
 *  * Threadsafe
 *
 * Our ReflectionSingleton class is very simple and compact, but in real world applications,
 * Singleton classes will be much more complex. Preventing Reflection attacks are very difficult over there.
 *
 * To overcome this situation with Reflection, Joshua Bloch suggests the use of Enum
 * to implement Singleton design pattern as Java ensures that any enum value is instantiated only once in
 * a Java program.
 *
 *
 * Why Enum Is A Good Choice For Singleton Pattern, Why Not The Best?
 *
 * By now, you must have heard multiple times that Enums are the best choice for implementing Singleton DP.
 * Are they really?
 *
 * Well, in our first article we mentioned that every approach has its pros and cons and so do enum.
 * Here are some of the cons of Enum Singleton :
 *
 * enums do not support lazy loading.
 * If you are changing design of your application and now you want to convert your singleton class to multi-ton (class which can have multiple objects upto some limit),
 * then enum would not allow this.
 */
public class EnumSingletonDemo {

    public static void main(String[] args) {
        System.out.println(SingletonClEnum.INSTANCE);
    }
}

enum SingletonClEnum{

    INSTANCE;

     SingletonClEnum()
    {
        System.out.println("SingletonEnum Constructor ");
    }
}