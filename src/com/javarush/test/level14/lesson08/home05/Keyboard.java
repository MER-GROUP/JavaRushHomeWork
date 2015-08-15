package com.javarush.test.level14.lesson08.home05;

/**
 * Created by smu-68 on 17.04.2015.
 */
public class Keyboard implements CompItem
{
    public String getName(){
//        return "Keyboard";
        return new Keyboard().getClass().getSimpleName();
    }
}
