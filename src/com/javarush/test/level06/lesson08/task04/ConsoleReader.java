package com.javarush.test.level06.lesson08.task04;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Класс ConsoleReader
Сделать класс ConsoleReader, у которого будут 4 статических метода:
String readString() – читает с клавиатуры строку
int readInt() – читает с клавиатуры число
double readDouble() – читает с клавиатуры дробное число
void readLn() – ждет нажатия enter [использовать readString()]
*/

public class ConsoleReader
{
    public static String readString() throws Exception//String readString() – читает с клавиатуры строку
    {
        //Напишите тут ваш код
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        String st=reader.readLine();
        return st;

    }

    public static int readInt() throws Exception//читает с клавиатуры число
    {
        //Напишите тут ваш код
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        String st=reader.readLine();
        int n=Integer.parseInt(st);
        return n;

    }

    public static double readDouble() throws Exception//читает с клавиатуры дробное число
    {
        //Напишите тут ваш код
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        String st=reader.readLine();
        double n=Double.parseDouble(st);
        return n;

    }

    public static void readLn() throws Exception//ждет нажатия enter [использовать readString()]
    {
        //Напишите тут ваш код
//        readString();
        ConsoleReader.readString();

    }

    public static void main(String[] args)
    {
        //
    }
}
