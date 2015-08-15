package com.javarush.test.level07.lesson06.task03;

/* 5 строчек в обратном порядке
1. Создай список строк.
2. Считай с клавиатуры 5 строк и добавь в него.
3. Расположи их в обратном порядке.
4. Используя цикл выведи содержимое на экран, каждое значение с новой строки.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

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

        for (int i = 0; i < list.size(); i++)
        {
            System.out.println(list.get(list.size()-i-1));
        }

    }
}
