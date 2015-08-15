package com.javarush.test.level18.lesson05.task04;

/* Реверс файла
Считать с консоли 2 имени файла: файл1, файл2.
Записать в файл2 все байты из файл1, но в обратном порядке
Закрыть потоки ввода-вывода
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        String fileName1=reader.readLine();
        String fileName2=reader.readLine();
        FileInputStream inputStream=new FileInputStream(fileName1);
        FileOutputStream outputStream=new FileOutputStream(fileName2);

        byte[] bufSize=null;
        int Size=0;
        if (0<inputStream.available()){
            bufSize=new byte[inputStream.available()];
            Size=inputStream.read(bufSize);
        }

        byte[] bufSizeNew=new byte[Size];
        for (int i = Size-1,j=0; i >= 0; i--,j++) {
            bufSizeNew[j]=bufSize[i];
        }
        outputStream.write(bufSizeNew);

        reader.close();
        inputStream.close();
        outputStream.close();
    }
}
