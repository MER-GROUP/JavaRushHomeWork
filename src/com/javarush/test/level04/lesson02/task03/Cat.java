package com.javarush.test.level04.lesson02.task03;

/* Реализовать метод setCatsCount
Реализовать метод setCatsCount так, чтобы с его помощью можно было
устанавливать значение переменной catsCount равное переданному параметру.
*/

public class Cat
{
    private static int catsCount = 0;

    public static void setCatsCount(int catsCount1)
    {
        //add your code here
        catsCount=catsCount1;
    }

    public static void main(String[] args)
    {
        //
    }
}
