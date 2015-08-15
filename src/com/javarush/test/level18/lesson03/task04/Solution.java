package com.javarush.test.level18.lesson03.task04;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;

/* Самые редкие байты
Ввести с консоли имя файла
Найти байты, которые встречаются в файле меньше всего раз.
Вывести их на экран через пробел
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        String fileName=reader.readLine();
        FileInputStream inputStream=new FileInputStream(fileName);

        ArrayList<Integer> list=new ArrayList<Integer>();
        int tempByte;
        while (0<inputStream.available()){
            tempByte=inputStream.read();
            list.add(tempByte);
        }

        ArrayList<Integer> listCount=new ArrayList<Integer>(list.size());
        int min=Integer.MAX_VALUE;
        for (int i = 0; i < list.size(); i++) {
            listCount.add(Collections.frequency(list,list.get(i)));
            if (min>listCount.get(i)){
                min=listCount.get(i);
            }
        }

        HashSet<Integer> set=new HashSet<Integer>();
        for (int i = 0; i < list.size(); i++) {
            if (listCount.get(i)==min){
                set.add(list.get(i));
            }
        }

        Iterator<Integer> iterator=set.iterator();
        while (iterator.hasNext()){
            System.out.print(iterator.next() + " ");
        }

        reader.close();
        inputStream.close();
    }
}
