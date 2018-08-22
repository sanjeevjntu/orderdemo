package com.example.sanjeev.orderdemo.javaprograms.singletonmultithreaded;

/**
 * 2. Double check locking method: and Volatile good for mutlitthreaded environemnt
 * You can overcome this issue if you use Double check locking method to create the Singleton.
 *
 * In this, you will make the Singleton class in the synchronized block if the instance is null.
 * So, the synchronized block will be executed only when the sSoleInstance is null
 * and prevent unnecessary synchronization once the instance variable is initialize
 */
public class SynchronizedBlockSingleton {

    private static volatile SynchronizedBlockSingleton synchronizedBlockSingleton;

    private  SynchronizedBlockSingleton(){
        if(synchronizedBlockSingleton !=null){
            throw new RuntimeException("Use getInstance");
        }
    }


    public static SynchronizedBlockSingleton getInstance(){

        //Double check locking pattern
        if (synchronizedBlockSingleton == null) {////Check for the first time
            synchronized (SynchronizedBlockSingleton.class) {
                if (synchronizedBlockSingleton == null) { ////Check for the 2nd time
                    synchronizedBlockSingleton = new SynchronizedBlockSingleton();
                }
            }
        }

        return synchronizedBlockSingleton;
    }
}
