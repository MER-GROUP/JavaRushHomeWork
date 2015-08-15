package com.javarush.test.level18.lesson10.home06;

/* Встречаемость символов
Программа запускается с одним параметром - именем файла, который содержит английский текст.
Посчитать частоту встречания каждого символа.
Отсортировать результат по возрастанию кода ASCII (почитать в инете). Пример: ','=44, 's'=115, 't'=116
Вывести на консоль отсортированный результат:
[символ1]  частота1
[символ2]  частота2
Закрыть потоки

Пример вывода:
, 19
- 7
f 361
*/

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        if (1>args.length){
            return;
        }else{
            File file=new File(args[0]);
            FileInputStream fileInputStream=new FileInputStream(file);

            ArrayList<Byte> byteList=new ArrayList<>();
            while (0<fileInputStream.available()){
                byteList.add((byte) fileInputStream.read());
            }
            fileInputStream.close();

            Set<Byte> byteSet=new TreeSet<>();
            for (Byte b:byteList){
                byteSet.add(b);
            }

            Iterator<Byte> iterator=byteSet.iterator();
            int count=0;
            int intByte=0;
            while (iterator.hasNext()){
                intByte=iterator.next();
//                if (intByte>=0 && intByte<=31){
//                    continue;
//                }
                count=Collections.frequency(byteList,(byte)intByte);
                System.out.println((char)intByte+" "+count);
            }
        }
    }
}
//package com.javarush.test.level18.lesson10.home06;
//
///* Встречаемость символов
//Программа запускается с одним параметром - именем файла, который содержит английский текст.
//Посчитать частоту встречания каждого символа.
//Отсортировать результат по возрастанию кода ASCII (почитать в инете). Пример: ','=44, 's'=115, 't'=116
//Вывести на консоль отсортированный результат:
//[символ1]  частота1
//[символ2]  частота2
//Закрыть потоки
//Пример вывода:
//, 19
//- 7
//f 361
//*/
//
//import java.io.*;
//import java.util.Map;
//import java.util.TreeMap;
//
//public class Solution {
//    public static void main(String[] args) throws IOException {
//        if(args.length == 0){
//            throw new IllegalArgumentException();
//        }
//
//        File file1 = new File(args[0]);
//        FileInputStream in = new FileInputStream(file1);
//        TreeMap<Character, Integer> map = new TreeMap<>();
//        byte[] data;
//        char[] c = new char[0];
//
//
//        while(in.available() > 0){
//            data = new byte[in.available()];
//            in.read(data);
//            c = new String(data).toCharArray();
//        }
//
//        for(char b : c){
//            if(map.containsKey(b)){
//                int val = map.get(b) + 1;
//                map.put(b, val);
//            } else {
//                map.put(b, 1);
//            }
//        }
//
//        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
//            System.out.println(entry.getKey() + " " + entry.getValue());
//        }
//
//        in.close();
//    }
//}
