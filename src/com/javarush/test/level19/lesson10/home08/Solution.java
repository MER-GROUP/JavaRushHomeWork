package com.javarush.test.level19.lesson10.home08;

/* Перевертыши
1 Считать с консоли имя файла.
2 Для каждой строки в файле:
2.1 переставить все символы в обратном порядке
2.2 вывести на экран
3 Закрыть поток

Пример тела входного файла:
я - программист.
Амиго

Пример результата:
.тсиммаргорп - я
огимА
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
        String fileName=bufferedReader.readLine();
        bufferedReader.close();

        BufferedReader fileReader=new BufferedReader(new FileReader(new File(fileName)));
        StringBuilder stringBuilder=new StringBuilder();
        while (fileReader.ready()){
            stringBuilder.append(fileReader.readLine());
            System.out.println(stringBuilder.reverse().toString());
            stringBuilder.delete(0,stringBuilder.length());
        }
        fileReader.close();
    }
}
