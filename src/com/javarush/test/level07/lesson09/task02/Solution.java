package com.javarush.test.level07.lesson09.task02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 5 слов в обратном порядке
Введи с клавиатуры 5 слов в список строк. Выведи их в обратном порядке.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //Напишите тут ваш код
        ArrayList<String> list=new ArrayList<String>();
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; 5 > i; i++)
        {
            list.add(reader.readLine());
        }
        for (int i = list.size()-1; 0 <= i; i--)
        {
            System.out.println(list.get(i));
        }

    }
}
