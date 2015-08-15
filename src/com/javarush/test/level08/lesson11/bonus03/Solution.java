package com.javarush.test.level08.lesson11.bonus03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/* Задача по алгоритмам
Задача: Введи с клавиатуры 20 слов и выведи их в алфавитном порядке.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] array = new String[20];
        for (int i = 0; i < array.length; i++)
        {
            array[i] = reader.readLine();
        }

        sort(array);

        for (String x : array)
        {
            System.out.println(x);
        }

    }

    public static void sort(String[] array)
    {
        //Напишите тут ваш код
//        String temp,a,b;
//        for (int i = 0; i < array.length; i++)
//        {
//            for (int j = i; j < array.length; j++)
//            {
////                a=""+array[i].charAt(0);
////                b=""+array[j].charAt(0);
////                if (isGreaterThen(a,b))
//                if (isGreaterThen(array[i],array[j]))
//                {
//                    temp=array[i];
//                    array[i]=array[j];
//                    array[j]=temp;
//                }
//            }
//        }



//        //сортируем методом пузырька, используя метод сверки
//        //между собой для каждых 2 строк
//        for (int i=0; i<array.length-1;)
//        {
//            int s = i+1;
//            String temp = null;
//            //сначала отправляем первое и второе значение на сверку
//            if(isGreaterThen(array[i], array[s]))
//            {
//                temp = array[s];
//                array[s]=array[i];
//                array[i]=temp;
//                if (i>0) i--;
//            }
//            else i++;
//
//        }


        Arrays.sort(array);
    }

    //Метод для сравнения строк: 'а' больше чем 'b'
    public static boolean isGreaterThen(String a, String b)
    {
        return a.compareTo(b) > 0;
    }
}
