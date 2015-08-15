package com.javarush.test.level13.lesson02.task05;

/* 4 ошибки
Исправь 4 ошибки в программе, чтобы она компилировалась.
*/

public class Solution
{

    public static void main(String[] args) throws Exception
    {

        System.out.println(Dream.HOBBIE.toString());//4
        System.out.println(new Hobbie().toString());

    }

        interface Desire
        {
        }

        interface Dream
        {
            public static Hobbie HOBBIE = new Hobbie();//3
        }

        static class Hobbie implements Desire, Dream //1
        {
//            public static Hobbie HOBBIE = new Hobbie();//4
            static int INDEX = 1;//2

            @Override
            public String toString()
            {
                INDEX++;
                return "" + INDEX;
            }
        }

}
