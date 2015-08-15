package com.javarush.test.level15.lesson12.home04;

/**
 * Created by smu-68 on 23.04.2015.
 */
public final class Moon implements Planet {

    private static Moon instance=null;

    private Moon() {
    }

    public static synchronized Moon getInstance() {
        if (null==instance){
            return instance=new Moon();
        }
        return instance;
    }
}
