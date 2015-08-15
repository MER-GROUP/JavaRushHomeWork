package com.javarush.test.level07.lesson09.task01;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Три массива
1. Введи с клавиатуры 20 чисел, сохрани их в список и рассортируй по трём другим спискам:
Число делится на 3 (x%3==0), делится на 2 (x%2==0) и все остальные.
Числа, которые делятся на 3 и на 2 одновременно, например 6, попадают в оба списка.
2. Метод printList должен выводить на экран все элементы списка  с новой строки.
3. Используя метод printList выведи эти три списка на экран. Сначала тот, который для x%3, потом тот, который для x%2, потом последний.
*/

public class Solution
{
    final static int NUMBER = 20;

    public static void main(String[] args) throws Exception
    {
        ArrayList<Integer> listMain = new ArrayList<Integer>();
        ArrayList<Integer> listA    = new ArrayList<Integer>();
        ArrayList<Integer> listB    = new ArrayList<Integer>();
        ArrayList<Integer> listC    = new ArrayList<Integer>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < NUMBER; i++){
            listMain.add(Integer.parseInt(reader.readLine()));
        }

        for (Integer x : listMain){
            if (x % 3 == 0) {
                listA.add(x);
                if (x % 2 == 0)
                    listB.add(x);
            } else {
                if (x % 2 == 0)
                    listB.add(x);
                else
                    listC.add(x);
            }
        }

        printList(listA);
        printList(listB);
        printList(listC);

    }

    public static void printList(List<Integer> list) {
        for (Integer x : list){
            System.out.println(x);
        }
    }
}
