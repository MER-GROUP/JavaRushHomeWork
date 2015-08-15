package com.javarush.test.level04.lesson06.task02;

/* Максимум четырех чисел
Ввести с клавиатуры четыре числа, и вывести максимальное из них.
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
        int i1=scanner.nextInt();
        int i2=scanner.nextInt();
        int i3=scanner.nextInt();
        int i4=scanner.nextInt();

        if (i1>=i2 && i1>=i3 && i1>=i4) System.out.println(i1);
        else if (i2>=i1 && i2>=i3 && i2>=i4) System.out.println(i2);
        else if (i3>=i1 && i3>=i2 && i3>=i4) System.out.println(i3);
        //else if (i4<=i1 && i4<=i2 && i4<=i3) System.out.println(i4);
        else System.out.println(i4);
    }
}
