package com.javarush.test.level08.lesson08.task01;

import java.util.HashSet;
import java.util.Set;

/* 20 слов на букву «Л»
Создать множество строк (Set<String>), занести в него 20 слов на букву «Л».
*/

public class Solution
{
    public static HashSet<String> createSet()
    {
        //Напишите тут ваш код
        Set<String> set=new HashSet<String>();
        for (int i = 0; 20 > i; i++)
        {
            set.add("Л"+i);
        }
        return (HashSet)set;

    }

    public static void main(String[] args)
    {
        //
    }
}
