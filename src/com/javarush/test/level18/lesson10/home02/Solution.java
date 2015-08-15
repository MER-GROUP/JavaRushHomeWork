package com.javarush.test.level18.lesson10.home02;

/* Пробелы
В метод main первым параметром приходит имя файла.
Вывести на экран частоту встречания пробела. Например, 10.45
1. Посчитать количество всех символов.
2. Посчитать количество пробелов.
3. Вывести на экран п2/п1*100, округлив до 2 знаков после запятой
Закрыть потоки
*/

import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream=new FileInputStream(args[0]);

        byte[] bufSize=new byte[fileInputStream.available()];
        if (0<fileInputStream.available()){
            fileInputStream.read(bufSize);
        }

        int countSimvol=bufSize.length;
        int countSpace=0;
        for (byte b:bufSize){
            if (b==Integer.valueOf(' ')){
                countSpace++;
            }
        }
//        System.out.println("bufSize.length = "+bufSize.length);//
//        System.out.println("countSpace = "+countSpace);//

        double res=(double)countSpace/(double)countSimvol*100;
//        System.out.println("res = "+res);
        System.out.printf("%.2f ",res);
        String str=String.valueOf(res);
//        System.out.println("str = "+str);

        int point=str.indexOf('.');
//        System.out.println("point = "+point);
        str=str.substring(0,point+3);
//        System.out.println("str = "+str);
        System.out.println(str);
        //System.out.printf("%.2d", res);

        fileInputStream.close();
    }
}
