package com.javarush.test.level18.lesson05.task02;

/* Подсчет запятых
С консоли считать имя файла
Посчитать в файле количество символов ',', количество вывести на консоль
Закрыть потоки ввода-вывода

Подсказка: нужно сравнивать с ascii-кодом символа ','
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        String fileName=reader.readLine();
        FileInputStream inputStream=new FileInputStream(fileName);

        int simvolASCI=(int)',';

        ArrayList<Integer> list=new ArrayList<>();
        while (0<inputStream.available()){
            list.add(inputStream.read());
        }

        System.out.println(Collections.frequency(list,simvolASCI));

        reader.close();
        inputStream.close();
    }
}
