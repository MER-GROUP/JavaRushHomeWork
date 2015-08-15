package com.javarush.test.level09.lesson02.task05;

/* Метод должен возвращать результат – глубину его стек-трейса
Написать метод, который возвращает результат – глубину его стек трейса – количество методов в нем (количество элементов в списке).
Это же число метод должен выводить на экран.
*/

public class Solution
{
    public static int getStackTraceDeep()
    {
        //Напишите тут ваш код
        StackTraceElement[] stackTraceElement=Thread.currentThread().getStackTrace();
//        int i=0;
//        for (StackTraceElement itr:stackTraceElement)
//        {
//            i++;
//        }
//        for (StackTraceElement elements : stackTraceElement)
//        {
//            System.out.println(elements.getMethodName());
//        }

        System.out.println(stackTraceElement.length);
        return stackTraceElement.length;
    }

    public static void main(String[] args)
    {
//        System.out.println(getStackTraceDeep());
        getStackTraceDeep();
    }
}
