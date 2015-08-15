package com.javarush.test.level09.lesson11.home08;

import java.util.ArrayList;

/* Список из массивов чисел
Создать список, элементами которого будут массивы чисел. Добавить в список пять объектов–массивов длиной 5, 2, 4, 7, 0 соответственно. Заполнить массивы любыми данными и вывести их на экран.
*/

public class Solution
{
    public static void main(String[] args)
    {
        ArrayList<int[]> list = createList();
        printList(list);
    }

    public static ArrayList<int[]> createList()
    {
        //Написать тут ваш код
        ArrayList<int[]> list=new ArrayList<int[]>();
        int[] m1={5,5,5,5,5};
        list.add(m1);
        int[] m2={2,2};
        list.add(m2);
        int[] m3={4,4,4,4};
        list.add(m3);
        int[] m4={7,7,7,7,7,7,7};
        list.add(m4);
        int[] m5={};
        list.add(m5);
        return list;
    }

    public static void printList(ArrayList<int[]> list)
    {
        for (int[] array: list )
        {
            for (int x: array)
            {
                System.out.println(x);
            }
        }
    }
}

//Collections.addAll(list,new int[5],new int[2],new int[4],new int[7],new int[0]);


//        list.add(new int[5]);
//        list.add(new int[2]);
//        list.add(new int[4]);
//        list.add(new int[7]);
//        list.add(new int[0]);


//    for (int[] x :list){
//        for (int i = 0; i < x.length; i++)
//        {
//            x[i] = i+1;
//        }
//
//    }