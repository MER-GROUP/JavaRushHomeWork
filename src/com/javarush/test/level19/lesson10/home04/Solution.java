//package com.javarush.test.level19.lesson10.home04;
//
//import java.io.*;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//
///* Ищем нужные строки
//Считать с консоли имя файла.
//Вывести в консоль все строки из файла, которые содержат всего 2 слова из списка words
//Закрыть потоки
//
//Пример: words содержит слова А, Б, В
//Строки:
//В Б А Д  //3 слова из words, не подходит
//Д А Д    //1 слово из words, не подходит
//Д А Б Д  //2 слова - подходит, выводим
//*/
//
//public class Solution {
//    public static List<String> words = new ArrayList<String>();
//
//    static {
////        words.add("файл");
////        words.add("вид");
////        words.add("В");
//        words.add("А");
//        words.add("Б");
//        words.add("В");
//    }
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
//        String fileName=reader.readLine();
//        reader.close();
//
//        BufferedReader fileReader=new BufferedReader(new FileReader(new File(fileName)));
//        String strBuf=null;
//        ArrayList<Integer> arrayListCount=new ArrayList<Integer>();
//        int count=0;
//        while (fileReader.ready()){
//            strBuf=fileReader.readLine();
//            for (int i = 0; i < words.size(); i++) {
//                Pattern pattern=Pattern.compile(words.get(i));
//                Matcher matcher=pattern.matcher(strBuf);
//                while (matcher.find()){
//                    count++;
//                }
//                arrayListCount.add(count);
//                count=0;
//            }
//            if (((1==arrayListCount.get(0) && 1==arrayListCount.get(1)) && 0==arrayListCount.get(2)) ||
//                ((1==arrayListCount.get(1) && 1==arrayListCount.get(2)) && 0==arrayListCount.get(0)) ||
//                ((1==arrayListCount.get(2) && 1==arrayListCount.get(0)) && 0==arrayListCount.get(1))){
//                System.out.println(strBuf);
//            }
//            arrayListCount.clear();
//        }
//        fileReader.close();
//    }
//}

package com.javarush.test.level19.lesson10.home04;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* Ищем нужные строки
Считать с консоли имя файла.
Вывести в консоль все строки из файла, которые содержат всего 2 слова из списка words
Закрыть потоки
Пример: words содержит слова А, Б, В
Строки:
В Б А Д  //3 слова из words, не подходит
Д А Д    //1 слово из words, не подходит
Д А Б Д  //2 слова - подходит, выводим
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = bufferedReader.readLine();
        ArrayList<String> fileList = new ArrayList<String>();
        String input;
        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
        while ((input = fileReader.readLine()) != null)
            fileList.add(input);
        fileReader.close();

        for (String aFileList : fileList)
        {
            String[] stringArray = aFileList.split(" ");
            int match = 0;
            for (String aStringArray : stringArray)
            {
                for (String word : words)
                {
                    if (word.equals(aStringArray))
                        match++;
                }
            }
            if (match == 2)
                System.out.println(aFileList);
        }
    }
}
