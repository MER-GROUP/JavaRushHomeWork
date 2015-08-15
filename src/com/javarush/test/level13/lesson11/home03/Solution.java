package com.javarush.test.level13.lesson11.home03;

/* Чтение файла
1. Считать с консоли имя файла.
2. Вывести в консоль(на экран) содержимое файла.
3. Не забыть закрыть файл и поток.
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        //add your code here
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileInputStream=new FileInputStream(reader.readLine());

        int data;
        while (0<fileInputStream.available()){
            System.out.print((char) fileInputStream.read());
        }
        fileInputStream.close();
        reader.close();
    }
}

//        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
//        bufferedWriter.write(fileInputStream.read())
