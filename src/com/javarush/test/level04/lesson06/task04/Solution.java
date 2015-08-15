package com.javarush.test.level04.lesson06.task04;

/* Сравнить имена
Ввести с клавиатуры два имени, и если имена одинаковые вывести
сообщение «Имена идентичны». Если имена разные,
но их длины равны – вывести сообщение – «Длины имен равны».
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
        String s1=scanner.nextLine();
        String s2=scanner.nextLine();

        if (s1.equals(s2)) System.out.println("Имена идентичны");
        else
        {
            if(s1.length()==s2.length()) System.out.println("Длины имен равны");
        }
    }
}
