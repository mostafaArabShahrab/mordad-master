package ir.mordad.entity;

/**
 * Created by Asus on 4/27/2018.
 */
public class SingletonJesus {
    private static SingletonJesus singletonJesus;

    private SingletonJesus(){

    }

    static SingletonJesus getInstance(){
        if(singletonJesus == null)
            singletonJesus = new SingletonJesus();

        return singletonJesus;
    }
}
