package com.javarush.test.level15.lesson12.home04;

/**
 * Created by smu-68 on 23.04.2015.
 */
public final class Earth implements Planet {

    private static Earth instance=null;

    private Earth() {
    }

    public static synchronized Earth getInstance() {
        if (null==instance){
            instance=new Earth();
        }
        return instance;
    }
}
