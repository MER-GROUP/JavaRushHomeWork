package com.javarush.test.level07.lesson06.task05;

/* Удали последнюю строку и вставь её в начало
1. Создай список строк.
2. Добавь в него 5 строчек с клавиатуры.
3. Удали последнюю строку и вставь её в начало. Повторить 13 раз.
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
        for (int i = 0; 13 > i; i++)
        {
            for (int j = 0; j < list.size(); j++)
            {
                if (j==(list.size()-1))
                {
//                    String s=list.get(j);
//                    list.remove(j);
//                    list.add(0,s);
                    list.add(0,list.get(j));
                    list.remove(j+1);
                }
            }
        }
        for (int i = 0; i < list.size(); i++)
        {
            System.out.println(list.get(i));
        }

    }
}
