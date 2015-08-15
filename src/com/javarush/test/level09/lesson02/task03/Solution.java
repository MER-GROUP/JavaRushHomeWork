package com.javarush.test.level09.lesson02.task03;

/* Метод должен вернуть номер строки кода, из которого вызвали этот метод
Написать пять методов, которые вызывают друг друга. Метод должен вернуть номер строки кода, из которого вызвали этот метод. Воспользуйся функцией: element.getLineNumber().
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        method1();
    }

    public static int method1()
    {
        method2();
        StackTraceElement[] stackTraceElements=Thread.currentThread().getStackTrace();
        System.out.println(stackTraceElements[2].getLineNumber());
        return  /*add your code here*/ stackTraceElements[2].getLineNumber();
    }

    public static int method2()
    {
        method3();
        StackTraceElement[] stackTraceElements=Thread.currentThread().getStackTrace();
        System.out.println(stackTraceElements[2].getLineNumber());
        return  /*add your code here*/ stackTraceElements[2].getLineNumber();
    }

    public static int method3()
    {
        method4();
        StackTraceElement[] stackTraceElements=Thread.currentThread().getStackTrace();
        System.out.println(stackTraceElements[2].getLineNumber());
        return  /*add your code here*/ stackTraceElements[2].getLineNumber();
    }

    public static int method4()
    {
        method5();
        StackTraceElement[] stackTraceElements=Thread.currentThread().getStackTrace();
        System.out.println(stackTraceElements[2].getLineNumber());
        return  /*add your code here*/ stackTraceElements[2].getLineNumber();
    }

    public static int method5()
    {
        StackTraceElement[] stackTraceElements=Thread.currentThread().getStackTrace();
        System.out.println(stackTraceElements[2].getLineNumber());
        return  /*add your code here*/ stackTraceElements[2].getLineNumber();
    }
}

//Thread.currentThread().getStackTrace()[2].getLineNumber();
