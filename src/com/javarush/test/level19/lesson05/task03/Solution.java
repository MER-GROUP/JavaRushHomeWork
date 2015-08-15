package com.javarush.test.level19.lesson05.task03;

/* Выделяем числа
Считать с консоли 2 имени файла.
Вывести во второй файл все числа, которые есть в первом файле.
Числа выводить через пробел.
Закрыть потоки ввода-вывода.

Пример тела файла:
12 text var2 14 8v 1

Результат:
12 14 1
*/

import java.io.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
        String fileName1=bufferedReader.readLine();
        String fileName2=bufferedReader.readLine();
        bufferedReader.close();

        ArrayList<String> arrayList=new ArrayList<>();
        BufferedReader reader=new BufferedReader(new FileReader(new File(fileName1)));
        while (reader.ready()){
            arrayList.add(reader.readLine());
        }
        reader.close();

        StringBuilder builderSpace=new StringBuilder();
        StringBuilder builderStr=new StringBuilder();
        Pattern pattern=Pattern.compile("(\\s+)(\\d+)(\\s+)");
        for (int i = 0; i < arrayList.size(); i++) {
            builderSpace.append(arrayList.get(i));
            builderSpace.insert(0," ").append(" ");
            Matcher matcher=pattern.matcher(builderSpace.toString());
            while (matcher.find()){
                String str=matcher.group().trim();
                builderStr.append(str).append(" ");
            }
        }

        BufferedWriter writer=new BufferedWriter(new FileWriter(new File(fileName2)));
        writer.write(builderStr.toString());
        writer.close();
    }
}


//import java.io.*;
//        import java.util.ArrayList;
//
//public class Solution {
//    public static void main(String[] args) throws IOException
//    {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        String fileName1 = bufferedReader.readLine();
//        String fileName2 = bufferedReader.readLine();
//        bufferedReader.close();
//
//        BufferedReader fileReader = new BufferedReader(new FileReader(fileName1));
//        ArrayList<String> list = new ArrayList<String>();
//        String nextLine;
//        while ((nextLine = fileReader.readLine()) != null) {
//            list.add(nextLine);
//        }
//        fileReader.close();
//
//        String[] wordArray;
//        ArrayList<Integer> numbers = new ArrayList<Integer>();
//        for (String aString : list) {
//            wordArray = aString.split(" ");
//            for (String aWordArray : wordArray)
//            {
//                try
//                {
//                    numbers.add(Integer.parseInt(aWordArray));
//                }
//                catch (NumberFormatException ignored)
//                {
//                }
//            }
//        }
//
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName2));
//        for (Integer number : numbers)
//            bufferedWriter.write(number + " ");
//        bufferedWriter.close();
//    }
//}
