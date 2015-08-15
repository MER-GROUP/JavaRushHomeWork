package com.javarush.test.level04.lesson16.home04;

/* Меня зовут 'Вася'...
Ввести с клавиатуры строку name.
Ввести с клавиатуры дату рождения (три числа): y, m, d.
Вывести на экран текст:
«Меня зовут name
Я родился d.m.y»
Пример:
Меня зовут Вася
Я родился 15.2.1988
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution
{
    public static void main(String[] args)   throws Exception
    {
        //Напишите тут ваш код
//        Scanner scanner=new Scanner(System.in);
//        String name=scanner.nextLine();
//        int d=scanner.nextInt();
//        int m=scanner.nextInt();
//        int y=scanner.nextInt();
//
//        System.out.println("Меня зовут "+name);
//        System.out.print("Я родился "+d+"."+m+"."+y);

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String name = in.readLine();
        int y = Integer.parseInt(in.readLine());
        int m = Integer.parseInt(in.readLine());
        int d = Integer.parseInt(in.readLine());
        System.out.print("Меня зовут " + name +"\nЯ родился "+ d + "." + m + "."+y);
    }
}
