package com.javarush.test.level08.lesson11.home02;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* Множество всех животных
1. Внутри класса Solution создать public static классы Cat, Dog.
2. Реализовать метод createCats, котороый должен возвращать множество с 4 котами.
3. Реализовать метод createDogs, котороый должен возвращать множество с 3 собаками.
4. Реализовать метод join, котороый должен возвращать объединенное множество всех животных - всех котов и собак.
5. Реализовать метод removeCats, котороый должен удалять из множества pets всех котов, которые есть в множестве cats.
6. Реализовать метод printPets, котороый должен выводить на экран всех животных, которые в нем есть. Каждое животное с новой строки
*/

public class Solution
{
    public static void main(String[] args)
    {
        Set<Cat> cats = createCats();
        Set<Dog> dogs = createDogs();

        Set<Object> pets = join(cats, dogs);
        printPets(pets);
        System.out.println("---------------------------------");

        removeCats(pets, cats);
        printPets(pets);
    }

    public static Set<Cat> createCats()
    {
        HashSet<Cat> result = new HashSet<Cat>();

        //Написать тут ваш код
        for (int i = 0; 4 > i; i++)
        {
            result.add(new Cat());
        }

        return result;
    }

    public static Set<Dog> createDogs()
    {
        //Написать тут ваш код
        HashSet<Dog> set=new HashSet<Dog>();
        for (int i = 0; 3 > i; i++)
        {
            set.add(new Dog());
        }
        return set;
    }

    public static Set<Object> join(Set<Cat> cats, Set<Dog> dogs)
    {
        //Написать тут ваш код
        Set<Object> set=new HashSet<Object>();
        for (Cat i:cats) set.add(i);
        for (Dog i:dogs) set.add(i);
        return set;
    }

    public static void removeCats(Set<Object> pets, Set<Cat> cats)///////////////
    {
        //Написать тут ваш код
//        Set<Object> pets1=new HashSet<Object>(pets);
//        Set<Cat> cats1=new HashSet<Cat>(cats);
//
//        for (Object i_pets1:pets1)
//        {
//            for (Object i_cats1:cats1)
//            {
//                if (i_pets1.equals(i_cats1)) pets.remove(i_cats1);
//            }
//        }

//        for (Object i_cats:cats) pets.remove(i_cats);

        pets.removeAll(cats);
    }

    public static void printPets(Set<Object> pets)
    {
        //Написать тут ваш код
        for (Object i:pets) System.out.println(i);
    }

    //Написать тут ваш код
    public static class Cat {}
    public static class Dog {}

}
