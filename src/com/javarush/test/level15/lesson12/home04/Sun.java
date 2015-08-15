package com.javarush.test.level15.lesson12.home04;

/**
 * Created by smu-68 on 23.04.2015.
 */
public final class Sun implements Planet {

    private static Sun instance=null;

    private Sun(){
    }

    public static synchronized Sun getInstance() {
        if (null==instance){
            instance=new Sun();
        }
        return instance;
    }
}
