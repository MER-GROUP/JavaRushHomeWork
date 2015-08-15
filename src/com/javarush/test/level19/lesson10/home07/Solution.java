package com.javarush.test.level19.lesson10.home07;

/* Длинные слова
В метод main первым параметром приходит имя файла1, вторым - файла2
Файл1 содержит слова, разделенные пробелом.
Записать через запятую в Файл2 слова, длина которых строго больше 6
Закрыть потоки

Пример выходных данных:
длинное,короткое,аббревиатура
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        if(2>args.length) return;
        String fileName1=args[0],fileName2=args[1];

        BufferedReader bufferedReader=new BufferedReader(new FileReader(new File(fileName1)));
        PrintWriter printWriter=new PrintWriter(new BufferedWriter(new FileWriter(new File(fileName2))));

        StringBuilder builderStr=new StringBuilder();
        while (bufferedReader.ready()){
            String[] strArr=bufferedReader.readLine().split(" ");
            for (String str:strArr){
                if (6<str.length()){
                    builderStr.append(str).append(",");
                }
            }
        }
        printWriter.append(builderStr.toString(),0,builderStr.length()-1);
        bufferedReader.close();
        printWriter.close();
    }
}
