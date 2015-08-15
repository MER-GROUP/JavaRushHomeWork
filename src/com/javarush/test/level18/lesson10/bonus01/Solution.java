package com.javarush.test.level18.lesson10.bonus01;

/* Шифровка
Придумать механизм шифровки/дешифровки

Программа запускается с одним из следующих наборов параметров:
-e fileName fileOutputName
-d fileName fileOutputName
где
fileName - имя файла, который необходимо зашифровать/расшифровать
fileOutputName - имя файла, куда необходимо записать результат шифрования/дешифрования
-e - ключ указывает, что необходимо зашифровать данные
-d - ключ указывает, что необходимо расшифровать данные
*/

import java.io.*;

public class Solution {
    private static int count=5;

    public static void main(String[] args) throws IOException {
        if (2>args.length){
            return;
        }else{
            String key=args[0];
            String fileName=args[1];
            String fileOutputName=args[2];

            FileInputStream fileInputStream=new FileInputStream(new File(fileName));
            FileOutputStream fileOutputStream=new FileOutputStream(new File(fileOutputName));

            byte[] bytes=new byte[fileInputStream.available()];
            if (0<fileInputStream.available()){
                fileInputStream.read(bytes);
            }
            fileInputStream.close();

            switch (key){
                case "-e":
                    encript(bytes);
                    break;
                case "-d":
                    dencript(bytes);
                    break;
            }

            fileOutputStream.write(bytes);
            fileOutputStream.close();
        }
    }

    public static void encript(byte[] bytes){
        for (int i = 0; i < bytes.length; i++) {
            for (int j = 0; j < count; j++) {
                if (-128<=bytes[i]){
                    if (128==bytes[i]){
                        bytes[i]=-128;
                    }
                    bytes[i]++;
                }
            }
        }
    }

    public static void dencript(byte[] bytes){
        for (int i = 0; i < bytes.length; i++) {
            for (int j = 0; j < count; j++) {
                if (128>bytes[i]){
                    if (-129==bytes[i]){
                        bytes[i]=127;
                    }
                    bytes[i]--;
                }
            }
        }
    }

}
