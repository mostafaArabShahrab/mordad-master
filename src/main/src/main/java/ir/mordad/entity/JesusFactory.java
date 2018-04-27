package ir.mordad.entity;

/**
 * Created by Asus on 4/27/2018.
 */
public class JesusFactory {

    public SingletonJesus getJesus(){
        return SingletonJesus.getInstance();
    }
}
