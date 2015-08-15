package com.javarush.test.level10.lesson11.home04;

/* Большая зарплата
Вывести на экран надпись «Я не хочу изучать Java, я хочу большую зарплату» 40 раз по образцу.
Образец:
Я не хочу изучать Java, я хочу большую зарплату
 не хочу изучать Java, я хочу большую зарплату
не хочу изучать Java, я хочу большую зарплату
е хочу изучать Java, я хочу большую зарплату
 хочу изучать Java, я хочу большую зарплату
хочу изучать Java, я хочу большую зарплату
…
*/

public class Solution
{
    public static void main(String[] args)
    {
        String s = "Я не хочу изучать Java, я хочу большую зарплату";

        //Напишите тут ваш код
//        System.out.println(s.length());
        for (int i = 0; i < s.length(); i++)
        {
            if (40==i) break;
            else {
                for (int j = i; j < s.length(); j++)
                {
                    System.out.print(s.charAt(j));
                }
            }
            System.out.println();
        }
    }

}
