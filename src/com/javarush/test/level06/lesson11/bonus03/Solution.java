package com.javarush.test.level06.lesson11.bonus03;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Задача по алгоритмам
Задача: Написать программу, которая вводит с клавиатуры 5 чисел и выводит их в возрастающем порядке.
Пример ввода:
3
2
15
6
17
Пример вывода:
2
3
6
15
17
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader  = new BufferedReader(new InputStreamReader(System.in));
        int[] mas=new int[5];
        for (int i=0;mas.length>i;i++)
        {
            mas[i]=Integer.parseInt(reader.readLine());
        }

        for (int i=0;mas.length>i;i++)
        {
            for (int j=i;mas.length>j;j++)
            {
                if (mas[i]>mas[j])
                {
                    int temp=mas[i];
                    mas[i]=mas[j];
                    mas[j]=temp;
                }
            }
        }

        for (int i=0;mas.length>i;i++)
        {
            System.out.println(mas[i]);
        }

        //Напишите тут ваш код
    }
}
