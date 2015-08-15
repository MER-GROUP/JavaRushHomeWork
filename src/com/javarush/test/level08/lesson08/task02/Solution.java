package com.javarush.test.level08.lesson08.task02;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* Удалить все числа больше 10
Создать множество чисел(Set<Integer>), занести туда 20 различных чисел.
Удалить из множества все числа больше 10.
*/

public class Solution
{
    public static HashSet<Integer> createSet()
    {
        //Напишите тут ваш код
        Set<Integer> set=new HashSet<Integer>();
        for (int i = 0; 20 > i; i++)
        {
            set.add(i);
        }
        return (HashSet)set;

    }

    public static HashSet<Integer> removeAllNumbersMoreThan10(HashSet<Integer> set)
    {
        //Напишите тут ваш код
        Iterator<Integer> itr=set.iterator();
        while (itr.hasNext())
        {
            if (itr.next()>10) itr.remove();
        }
        return set;

    }

    public static void main(String[] args)
    {
        //
    }
}
