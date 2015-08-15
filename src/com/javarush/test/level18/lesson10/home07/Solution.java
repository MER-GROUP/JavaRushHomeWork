package com.javarush.test.level18.lesson10.home07;

/* Поиск данных внутри файла
Считать с консоли имя файла
Найти в файле информацию, которая относится к заданному id, и вывести ее на экран в виде, в котором она записана в файле.
Программа запускается с одним параметром: id (int)
Закрыть потоки

В файле данные разделены пробелом и хранятся в следующей последовательности:
id productName price quantity

где id - int
productName - название товара, может содержать пробелы, String
price - цена, double
quantity - количество, int

Информация по каждому товару хранится в отдельной строке
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
        String file=bufferedReader.readLine();

        bufferedReader=new BufferedReader(new FileReader(new File(file)));
        ArrayList<String> arrayList=new ArrayList<>();
        while (bufferedReader.ready()){
            arrayList.add(bufferedReader.readLine());
        }
        bufferedReader.close();

//        //test///////////////////////
//        for (String str:arrayList){
//            System.out.println(str);
//        }

        if (1>args.length) return;

        int id=Integer.parseInt(args[0]);
        String productName="";
        double price=0;
        int quantity=0;

        for (int i = 0; i < arrayList.size(); i++) {
            String[] strBuf=arrayList.get(i).split(" ");
            if (strBuf[0].equals(String.valueOf(id))){
                quantity=Integer.parseInt(strBuf[strBuf.length-1]);
                price=Double.parseDouble(strBuf[strBuf.length-2]);
                StringBuilder stringBuilder=new StringBuilder();
                for (int j = 1; j < strBuf.length-2; j++) {
                    stringBuilder.append(strBuf[j]).append(" ");
                }
                productName=stringBuilder.toString().trim();
            }
        }
        System.out.println(id+" "+productName+" "+price+" "+quantity);
    }
}

//import java.io.BufferedReader;
//        import java.io.FileReader;
//        import java.io.IOException;
//        import java.io.InputStreamReader;
//
//public class Solution {
//    public static void main(String[] args) throws IOException {
//        if(args.length == 0){
//            throw new IllegalArgumentException();
//        }
//
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        FileReader fileReader = new FileReader(reader.readLine());
//        BufferedReader fileBufReader = new BufferedReader(fileReader);
//
//        String res;
//
//        while((res = fileBufReader.readLine()) != null){
//            if(res.startsWith(args[0] + " ")){
//                System.out.println(res);
//                break;
//            }
//        }
//
//        reader.close();
//        fileBufReader.close();
//        fileBufReader.close();
//
//    }
//}
