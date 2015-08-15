package com.javarush.test.level04.lesson06.task03;

/* Сортировка трех чисел
Ввести с клавиатуры три числа, и вывести их в порядке убывания.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //Напишите тут ваш код
        Scanner scanner=new Scanner(System.in);
        int iD1=scanner.nextInt();
        int iD2=scanner.nextInt();
        int iD3=scanner.nextInt();

//        if (iD1<=iD2 && iD2<=iD3) System.out.println(iD1+iD2+iD3);
//        else if (iD2<=iD3 && iD3<=iD1) System.out.println(iD2+iD3+iD1);
//        else if (iD3<=iD1 && iD1<=iD2) System.out.println(iD3+iD1+iD2);

        int[] iMas={iD1,iD2,iD3};

        for (int i=0;i<iMas.length;i++)
        {
            int iTemp=0;
            for (int j=0;j<iMas.length;j++)
            {
                if (iMas[i]>iMas[j])
                {
                    iTemp=iMas[i];
                    iMas[i]=iMas[j];
                    iMas[j]=iTemp;
                }
            }
        }

        for (int i=0;i<iMas.length;i++) System.out.println(iMas[i]);

    }
}
