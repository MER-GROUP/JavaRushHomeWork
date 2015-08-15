package com.javarush.test.level04.lesson02.task01;

/* Реализовать метод setName
Реализовать метод setName, чтобы с его помощью можно было устанавливать значение переменной
private String name равное переданному параметру String name.
*/

public class Cat
{
    private String name;

    /*public void setName(String name1)
    {
        //add your code here
        name=name1;
    }*/

    public void setName(String name)
    {
        //add your code here
        //this.name=name;
        Cat cat=new Cat();
        cat.name=name;
    }

    public static void main(String[] args)
    {
        System.out.println();
    }
}
