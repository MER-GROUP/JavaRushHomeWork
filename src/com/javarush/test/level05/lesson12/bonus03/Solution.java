package com.javarush.test.level05.lesson12.bonus03;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Задача по алгоритмам
Написать программу, которая:
1. вводит с консоли число N > 0
2. потом вводит N чисел с консоли
3. выводит на экран максимальное из введенных N чисел.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int maximum = Integer.parseInt(reader.readLine());
        int temp=-9999999,vvod;

        //напишите здесь ваш код
        if (0<maximum)
        {
            for (int i=0;i<maximum;i++)
            {
                vvod=Integer.parseInt(reader.readLine());
                if (temp<vvod)
                {
                    temp=vvod;
                }
            }
        }
        maximum=temp;




        System.out.println(maximum);
    }
}
