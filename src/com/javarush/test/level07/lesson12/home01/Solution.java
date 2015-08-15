package com.javarush.test.level07.lesson12.home01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Вывести числа в обратном порядке
Ввести с клавиатуры 10 чисел и заполнить ими список.
Вывести их в обратном порядке.
Использовать только цикл for.
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> list_int=new ArrayList<Integer>();
        for (int i = 0; 10 > i; i++)
        {
            list_int.add(Integer.parseInt(reader.readLine()));
        }
        for (int i = list_int.size()-1; 0 <= i; i--)
        {
            System.out.println(list_int.get(i));
        }

        //Напишите тут ваш код
    }
}
