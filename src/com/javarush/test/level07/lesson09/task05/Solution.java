package com.javarush.test.level07.lesson09.task05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Удвой слова
1. Введи с клавиатуры 10 слов в список строк.
2. Метод doubleValues должен удваивать слова по принципу a,b,c -> a,a,b,b,c,c.
3. Используя цикл for выведи результат на экран, каждое значение с новой строки.
*/

public class Solution
{
    public static void main(String[] args) throws Exception {
        //read strings and init ArrayList list here - считать строки с консоли и объявить ArrayList list тут
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list=new ArrayList<String>();
        for (int i = 0; 10 > i; i++)
        {
            list.add(reader.readLine());
        }

        ArrayList<String> result = doubleValues(list);

        //print result - вывести на экран result
        for (String x:list) System.out.println(x);
    }

    public static ArrayList<String> doubleValues(ArrayList<String> list) {
        // add your code here - добавь код тут
        for (int i = 0; i < list.size(); i++)
        {
            list.add(i,list.get(i));
            i++;
        }
        return list;
    }
}
