package com.javarush.test.level12.lesson12.home04;

/* Что это? «Кот», «Тигр», «Лев», «Бык», «хз»
Напиши метод, который определяет, какой объект передали в него.
Программа должна выводить на экран одну из надписей:
«Кот», «Тигр», «Лев», «Бык», «хз».
*/

import java.util.Objects;

public class Solution
{
    public static void main(String[] args)
    {
        System.out.println(getObjectType(new Cat()));
        System.out.println(getObjectType(new Tiger()));
        System.out.println(getObjectType(new Lion()));
        System.out.println(getObjectType(new Bull()));
        System.out.println(getObjectType(new Pig()));
    }

    public static String getObjectType(Object o)
    {
        //Напишите тут ваш код
        if (o instanceof Object){
            return o.toString();
        }

//        return "хз";
//        if (o instanceof Cat)
//            return "Кот";
//        else if (o instanceof  Tiger)
//            return "Тигр";
//        else if (o instanceof Lion)
//            return "Лев";
//        else if (o instanceof Bull)
//            return "Бык";
//        else
//
            return "хз";
    }

    public static class Cat
    {
        public String toString(){
            return "Кот";
        }
    }

    public static class Tiger
    {
        public String toString(){
            return "Тигр";
        }
    }

    public static class Lion
    {
        public String toString(){
            return "Лев";
        }
    }

    public static class Bull
    {
        public String toString(){
            return "Бык";
        }
    }

    public static class Pig
    {
        public String toString(){
            return "хз";
        }
    }
}
