package com.javarush.test.level12.lesson12.home05;

/* Что это? «Кот», «Тигр», «Лев», «Бык», «Корова», «Животное»
Напиши метод, который определяет, какой объект передали в него.
Программа должна выводить на экран одну из надписей:
«Кот», «Тигр», «Лев», «Бык», «Корова», «Животное».
Замечание: постарайся определять тип животного как можно более точно.
*/

public class Solution
{
    public static void main(String[] args)
    {
        System.out.println(getObjectType(new Cat()));
        System.out.println(getObjectType(new Tiger()));
        System.out.println(getObjectType(new Lion()));
        System.out.println(getObjectType(new Bull()));
        System.out.println(getObjectType(new Cow()));
        System.out.println(getObjectType(new Animal()));
    }

    public static String getObjectType(Object o)
    {
        //Напишите тут ваш код
        if (o instanceof Object){
            return o.toString();
        }

        return "Животное";
    }

    public static class Cat  extends Animal   //<--Классы наследуются!!
    {
        public String toString(){
            return "Кот";
        }
    }

    public static class Tiger  extends Cat
    {
        public String toString(){
            return "Тигр";
        }
    }

    public static class Lion  extends Cat
    {
        public String toString(){
            return "Лев";
        }
    }

    public static class Bull  extends Animal
    {
        public String toString(){
            return "Бык";
        }
    }

    public static class Cow  extends Animal
    {
        public String toString(){
            return "Корова";
        }
    }

    public static class Animal
    {
        public String toString(){
            return "Животное";
        }
    }
}
