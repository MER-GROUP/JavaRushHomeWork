package com.javarush.test.level04.lesson16.home02;

/* Среднее такое среднее
Ввести с клавиатуры три числа, вывести на экран среднее из них. Т.е. не самое большое и не самое маленькое.
*/

import java.util.Scanner;

public class Solution
{
    public static void main(String[] args)   throws Exception
    {
        //Напишите тут ваш код
        Scanner scanner=new Scanner(System.in);
        int d1=scanner.nextInt();
        int d2=scanner.nextInt();
        int d3=scanner.nextInt();
        int[] mas={d1,d2,d3};

        for (int i=0;i<mas.length;i++)
        {
            for (int j=0;j<mas.length;j++)
            {
                if (mas[i]>mas[j])
                {
                    int buf=mas[i];
                    mas[i]=mas[j];
                    mas[j]=buf;
                }
            }
        }

        System.out.println(mas[1]);
    }
}
