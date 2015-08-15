package com.javarush.test.level18.lesson10.home03;

/* Два в одном
Считать с консоли 3 имени файла
Записать в первый файл содержимого второго файла, а потом дописать содержимое третьего файла
Закрыть потоки
Темповые файлы создавать нельзя, т.к. на сервере заблокирована возможность создания каких любо файлов
*/

import java.io.*;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) throws IOException
    {
//        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
//        String fileName1=reader.readLine();
//        String fileName2=reader.readLine();
//        String fileName3=reader.readLine();
//
//        FileInputStream fileInputStream2=new FileInputStream(fileName2);
//        FileInputStream fileInputStream3=new FileInputStream(fileName3);
//
//        byte[] fileSize2=new byte[fileInputStream2.available()];
//        byte[] fileSize3=new byte[fileInputStream3.available()];
//
//        if (0<fileInputStream2.available()) fileInputStream2.read(fileSize2);
//        if (0<fileInputStream3.available()) fileInputStream3.read(fileSize3);
//
//        FileOutputStream fileOutputStream1=new FileOutputStream(fileName1);
//
//        byte[] fileSize1=new byte[fileSize2.length+fileSize3.length];
//        for (int i = 0; i < (fileSize2.length+fileSize3.length); i++) {
//            if (i<fileSize2.length) fileSize1[i]=fileSize2[i];
//            else fileSize1[i]=fileSize3[i-fileSize2.length];
//        }
//
//        fileOutputStream1.write(fileSize1);
//
//        reader.close();
//        fileInputStream2.close();
//        fileInputStream3.close();
//        fileOutputStream1.close();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileOutputStream out1 = new FileOutputStream(new File(reader.readLine()), true);
        FileInputStream in2 = new FileInputStream(new File(reader.readLine()));
        FileInputStream in3 = new FileInputStream(new File(reader.readLine()));

        while(in2.available() > 0){
            byte[] res = new byte[in2.available()];
            int count = in2.read(res);

            out1.write(res, 0, count);
        }

        while(in3.available() > 0){
            byte[] res = new byte[in3.available()];
            int count = in3.read(res);

            out1.write(res, 0, count);
        }


        reader.close();
        out1.close();
        in2.close();
        in3.close();
    }
}
