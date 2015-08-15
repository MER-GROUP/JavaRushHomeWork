//package com.javarush.test.level19.lesson10.home02;
//
///* Самый богатый
//В метод main первым параметром приходит имя файла.
//В этом файле каждая строка имеет следующий вид:
//имя значение
//где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом
//
//Для каждого имени посчитать сумму всех его значений
//Вывести в консоль имена, у которых максимальная сумма
//Имена разделять пробелом либо выводить с новой строки
//Закрыть потоки
//
//Пример входного файла:
//Петров 0.501
//Иванов 1.35
//Петров 0.85
//
//Пример вывода:
//Петров
//*/
//
//import java.io.*;
//import java.util.Comparator;
//import java.util.Map;
//import java.util.TreeMap;
//
//public class Solution {
//    public static void main(String[] args) throws IOException {
//        if (1>args.length) return;
//
//        String fileName=args[0];
//        TreeMap<String,Double> map=new TreeMap<String,Double>(new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return o2.compareTo(o1);
//            }
//        });
//
//        BufferedReader bufferedReader=new BufferedReader(new FileReader(new File(fileName)));
//        while (bufferedReader.ready()){
//            String[] str=bufferedReader.readLine().split(" ");
//            String name=str[0];
//            Double zp=Double.parseDouble(str[1]);
//            if (map.containsKey(name)){
//                map.put(name,map.get(name)+zp);
//            }else{
//                map.put(name,zp);
//            }
//        }
//        bufferedReader.close();
//
//        Map.Entry<String,Double> entryMax=map.firstEntry();
//        Double max=entryMax.getValue();
//
//        for (Map.Entry<String,Double> entry:map.entrySet()){
//            if (entry.getValue().equals(max)){
//                System.out.println(entry.getKey());
//            }
//        }
//    }
//}

package com.javarush.test.level19.lesson10.home02;

/* Самый богатый
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом
Для каждого имени посчитать сумму всех его значений
Вывести в консоль имена, у которых максимальная сумма. Имена разделять пробелом
Закрыть потоки
Пример входного файла:
Петров 0.501
Иванов 1.35
Петров 0.85
Пример вывода:
Петров
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        String fileName = args[0];
        ArrayList<String> fileList = new ArrayList<String>();
        String input;
        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
        while ((input = fileReader.readLine()) != null)
            fileList.add(input);
        fileReader.close();
        ArrayList<String> names = new ArrayList<String>();
        ArrayList<Double> values = new ArrayList<Double>();
        String[] stringArray;
        for (String aFileList : fileList)
        {
            stringArray = aFileList.split(" ");
            names.add(stringArray[0]);
            values.add(Double.parseDouble(stringArray[1]));
        }

        Map<String, Double> map = new HashMap<String, Double>();
        for (int i = 0; i < names.size(); i++)
            map.put(names.get(i), values.get(i));

        ArrayList<String> ignoredNames = new ArrayList<String>();
        for (int i = 0; i<names.size()-1; i++) {
            for (int j = i+1; j < names.size(); j++) {
                if (names.get(i).equals(names.get(j)) && !ignoredNames.contains(names.get(i)))
                {
                    double tmp = values.get(i) + values.get(j);
                    map.put(names.get(i), tmp);
                    ignoredNames.add(names.get(i));
                }
            }
        }

        double max = map.get(names.get(0));
        for (Map.Entry<String, Double> entry : map.entrySet()){
            if(entry.getValue() > max)
                max = entry.getValue();
        }

        ArrayList<String> theRichest = new ArrayList<String>();
        for (Map.Entry<String, Double> entry : map.entrySet()){
            if(entry.getValue() == max)
                theRichest.add(entry.getKey());
        }

        for (String aString : theRichest)
            System.out.print(aString+" ");
    }
}
