package com.javarush.test.level14.lesson08.home05;

/**
 * Created by smu-68 on 17.04.2015.
 */
public class Mouse implements CompItem
{
    public String getName(){
//        return "Mouse";
        return new Mouse().getClass().getSimpleName();
    }
}
