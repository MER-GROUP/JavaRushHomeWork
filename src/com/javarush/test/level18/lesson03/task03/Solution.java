package com.javarush.test.level18.lesson03.task03;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* Самые частые байты
Ввести с консоли имя файла
Найти байты, которые чаше всех встречаются в файле
Вывести их на экран через пробел.
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        String fileName=reader.readLine();

        FileInputStream inputStream=new FileInputStream(fileName);

        ArrayList<Integer> list=new ArrayList<Integer>();
        int temp;
        while (0<inputStream.available()){
            temp=inputStream.read();
            list.add(temp);
        }

        ArrayList<Integer> listMax=new ArrayList<Integer>(list.size());
        int max=Integer.MIN_VALUE;
        for (int i = 0; i < list.size(); i++) {
            listMax.add(Collections.frequency(list, list.get(i)));
            if (max<listMax.get(i)){
                max=listMax.get(i);
            }
        }

        LinkedHashSet<Integer> set=new LinkedHashSet<Integer>();
        for (int i = 0; i < list.size(); i++) {
            if (listMax.get(i)==max){
                set.add(list.get(i));
            }
        }

        Iterator<Integer> iterator=set.iterator();
        while (iterator.hasNext()){
            System.out.print(iterator.next()+" ");
        }


        reader.close();
        inputStream.close();
    }
}