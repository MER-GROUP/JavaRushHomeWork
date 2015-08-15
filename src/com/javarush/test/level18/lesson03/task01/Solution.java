package com.javarush.test.level18.lesson03.task01;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* Максимальный байт
Ввести с консоли имя файла
Найти максимальный байт в файле, вывести его на экран.
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        String fileName=reader.readLine();

        FileInputStream inputStream=new FileInputStream(fileName);

        int res=Integer.MIN_VALUE;
        int temp=0;
        while (0<inputStream.available()){
            temp=inputStream.read();
            if (temp>res) res=temp;
        }
        System.out.println(res);

        reader.close();
        inputStream.close();
    }
}
