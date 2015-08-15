package com.javarush.test.level18.lesson10.home04;

/* Объединение файлов
Считать с консоли 2 имени файла
В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов
Закрыть потоки
Темповые файлы создавать нельзя, т.к. на сервере заблокирована возможность создания каких любо файлов
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        String fileName1=reader.readLine();
        String fileName2=reader.readLine();

        FileInputStream fileInputStream1=new FileInputStream(new File(fileName1));
        FileInputStream fileInputStream2=new FileInputStream(new File(fileName2));

        byte[] fileSize1=new byte[fileInputStream1.available()];
        byte[] fileSize2=new byte[fileInputStream2.available()];

        int size1=0,size2=0;
        if (0<fileInputStream1.available()){
            size1=fileInputStream1.read(fileSize1);
        }
        if (0<fileInputStream2.available()) size2=fileInputStream2.read(fileSize2);
        FileOutputStream fileOutputStream1=new FileOutputStream(new File(fileName1));

        byte[] res=new byte[size1+size2];
        for (int i = 0; i < res.length; i++) {
            if (i<size2) res[i]=fileSize2[i];
            else res[i]=fileSize1[i-size2];
        }
//        System.arraycopy(data2, 0, res, 0, data2.length);
//        System.arraycopy(data1, 0, res, data2.length, data1.length);

        fileOutputStream1.write(res);

        reader.close();
        fileInputStream1.close();
        fileInputStream2.close();
        fileOutputStream1.close();
    }
}
