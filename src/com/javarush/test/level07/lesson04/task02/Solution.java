package com.javarush.test.level07.lesson04.task02;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Массив из строчек в обратном порядке
1. Создать массив на 10 строчек.
2. Ввести с клавиатуры 8 строчек и сохранить их в массив.
3. Вывести содержимое всего массива (10 элементов) на экран в обратном порядке. Каждый элемент - с новой строки.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //Напишите тут ваш код
        String[] stroka=new String[10];
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < stroka.length; i++)
        {
            stroka[i]=reader.readLine();
        }

        for (int i = stroka.length-1; 0<=i; i--)
        {
            System.out.println(stroka[i]);
        }

    }
}