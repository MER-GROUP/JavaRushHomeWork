package com.javarush.test.level19.lesson10.home01;

/* Считаем зарплаты
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Все данные вывести в консоль, предварительно отсортировав в возрастающем порядке по имени
Закрыть потоки

Пример входного файла:
Петров 2
Сидоров 6
Иванов 1.35
Петров 3.1

Пример вывода:
Иванов 1.35
Петров 5.1
Сидоров 6.0
*/

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        if (1>args.length) return;

        String fileName=args[0];
        Map<String,Double> map=new TreeMap<>();
        BufferedReader bufferedReader=new BufferedReader(new FileReader(new File(fileName)));
        String name=new String();
        Double zp=new Double(0);

        while (bufferedReader.ready()){
            String[] str=bufferedReader.readLine().split(" ");
            name=str[0];
            zp=Double.parseDouble(str[1]);
            if (map.containsKey(name)){
                map.put(name,map.get(name)+zp);
            }else{
                map.put(name,zp);
            }
        }
        bufferedReader.close();

        for (Map.Entry<String,Double> entry:map.entrySet()){
            System.out.println(entry.getKey()+" "+entry.getValue());
        }
    }
}
