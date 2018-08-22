package com.example.sanjeev.orderdemo.javaprograms.singletonmultithreaded;

/**
 * Make Singleton thread safe using synchronized
 * But:
 *
 * Slow performance because of locking overhead.
 * Unnecessary synchronization that is not required once the instance variable is initialized
 */
public class LazySynchronisedSingleTon {

    private static  LazySynchronisedSingleTon lazySynchronisedSingleTon;

    private LazySynchronisedSingleTon(){

        if(lazySynchronisedSingleTon !=null){
            throw new RuntimeException("Use getInstance() method to get the single instance of this class");
        }
    }

    public synchronized static LazySynchronisedSingleTon getInstance(){
    //    public  static LazySynchronisedSingleTon getInstance(){

        if(lazySynchronisedSingleTon ==null) {
            lazySynchronisedSingleTon = new LazySynchronisedSingleTon();
        }

        return lazySynchronisedSingleTon;

    }


}
