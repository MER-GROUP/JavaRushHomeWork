package com.javarush.test.level08.lesson11.home09;

import java.util.Date;

/* Работа с датой
1. Реализовать метод isDateOdd(String date) так, чтобы он возвращал true,
если количество дней с начала года - нечетное число, иначе false
2. String date передается в формате MAY 1 2013
Пример:
JANUARY 1 2000 = true
JANUARY 2 2020 = false
*/

public class Solution
{
    public static void main(String[] args)
    {
//        isDateOdd("JANUARY 2 1970");
    }

    public static boolean isDateOdd(String date)
    {
        Date End=new Date(date);
        Date Beg=new Date(date);

        Beg.setMonth(0);
        Beg.setDate(0);
        Beg.setHours(0);
        Beg.setMinutes(0);
        Beg.setSeconds(0);

        long Days=End.getTime()-Beg.getTime();
        int Day=(int)(Days/(24*60*60*1000));
//        System.out.println(Day);

        return (0==Day%2)?false:true;
    }
}
