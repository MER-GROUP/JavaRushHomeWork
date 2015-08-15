package com.javarush.test.level19.lesson10.bonus01;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* Отслеживаем изменения
Считать в консоли 2 имени файла - file1, file2.
Файлы содержат строки, file2 является обновленной версией file1, часть строк совпадают.
Нужно создать объединенную версию строк, записать их в список lines
Операции ADDED и REMOVED не могут идти подряд, они всегда разделены SAME
Пример:
[Файл 1]
строка1
строка2
строка3

[Файл 2]
строка1
строка3
строка4

[Результат - список lines]
SAME строка1
REMOVED строка2
SAME строка3
ADDED строка4
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        String fileName1=reader.readLine();
        String fileName2=reader.readLine();
        reader.close();

        ArrayList<String> list1=new ArrayList<String>();
        ArrayList<String> list2=new ArrayList<String>();

        BufferedReader bufferedReader=new BufferedReader(new FileReader(new File(fileName1)));
        while (bufferedReader.ready()){
            list1.add(bufferedReader.readLine());
        }
        bufferedReader=new BufferedReader(new FileReader(new File(fileName2)));
        while (bufferedReader.ready()){
            list2.add(bufferedReader.readLine());
        }
        bufferedReader.close();

        //заполняем пустыми строками
        for (int i = 0; i < list1.size(); i++) {
            for (int j = i; j < list2.size(); j++) {
                if (list1.get(i).equals(list2.get(j))){
                    int indexOf1=i;
                    int indexOf2=j;
                    if (indexOf1==indexOf2){
                        break;
                    }else if (indexOf1<indexOf2){
                        for (int k = indexOf1; k < indexOf2; k++) {
                            list1.add(k,"");
                        }
                        i=indexOf2;
                        break;
                    }else if (indexOf1>indexOf2){
                        for (int k = indexOf2; k < indexOf1; k++) {
                            list2.add(k,"");
                        }
                        break;
                    }
                }else if ((!list1.get(i).equals(list2.get(j))) && (j==list2.size()-1)){
                    list2.add(i,"");
                    break;
                }
            }
        }
        //выравниваем массивы
        if (list1.size()<list2.size()){
            for (int i = list1.size(); i < list2.size(); i++) {
                list1.add("");
            }
        }else if (list1.size()>list2.size()){
            for (int i = list2.size(); i < list1.size(); i++) {
                list2.add("");
            }
        }
        //заполняем lines
        for (int i = 0; i < list1.size(); i++) {
            if (!list1.get(i).isEmpty() && !list2.get(i).isEmpty()){
                lines.add(new LineItem(Type.SAME,list1.get(i)));
            }else if (list1.get(i).isEmpty() && !list2.get(i).isEmpty()){
                lines.add(new LineItem(Type.ADDED,list2.get(i)));
            }else if (list2.get(i).isEmpty() && !list1.get(i).isEmpty()) {
                lines.add(new LineItem(Type.REMOVED,list1.get(i)));
            }
        }

//        //test///////////////////////////////////
//        for (String str:list1){//////////////////
//            System.out.println("str = " + str);//
//        }////////////////////////////////////////
//        System.out.println("----------------");//
//        //test///////////////////////////////////
//        for (String str:list2){//////////////////
//            System.out.println("str = " + str);//
//        }////////////////////////////////////////
//        System.out.println("----------------");//
//
//        //test//////////////////////////////////////
//        for (LineItem i:lines){/////////////////////
//            System.out.println(i.type+" "+i.line);//
//        }///////////////////////////////////////////
    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
