package com.javarush.test.level12.lesson09.task01;
 
/* Интерфейс Fly
Напиши свой public интерфейс Fly(летать). Добавь в него два метода.
*/

public class Solution
{
    public static void main(String[] args)
    {

    }

    interface Fly
    {
        void takeOff (int newHeight); //взлет - число новаяВысота

        void landing (String airport); //посадка - Аэропорт
    }
}