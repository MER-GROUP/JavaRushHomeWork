package com.javarush.test.level05.lesson12.home05;

/* Вводить с клавиатуры числа и считать их сумму
Вводить с клавиатуры числа и считать их сумму, пока пользователь не введёт слово «сумма». Вывести на экран полученную сумму.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //Напишите тут ваш код
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        String exit;
        int sum=0,i=0;

        for (;true;)
        {
            exit=reader.readLine();
            if (exit.equals("сумма"))
            {
                System.out.println(sum);
                break;
            }
            i=Integer.parseInt(exit);
            sum+=i;
        }
    }
}
