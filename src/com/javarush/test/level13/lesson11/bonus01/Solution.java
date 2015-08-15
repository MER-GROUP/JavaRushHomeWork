package com.javarush.test.level13.lesson11.bonus01;

/* Сортировка четных чисел из файла
1. Ввести имя файла с консоли.
2. Прочитать из него набор чисел.
3. Вывести на консоль только четные, отсортированные по возрастанию.
Пример ввода:
5
8
11
3
2
10
Пример вывода:
2
8
10
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        // напишите тут ваш код
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        String fileName=reader.readLine();
        reader.close();

        BufferedReader fileReader= new BufferedReader(new FileReader(fileName));

        ArrayList<Integer> list=new ArrayList<Integer>();
        int d;
        while (fileReader.ready()){
            d=Integer.parseInt(fileReader.readLine());
//            System.out.println(d);
            if (0==d%2){
                list.add(d);
            }
        }

        Collections.sort(list);

        for (int i:list) System.out.println(i);
        fileReader.close();
    }
}

//          Scanner si = new Scanner(new File(fileName));
//          while(si.hasNextLine()) {
//          int i =  Integer.parseInt(si.nextLine());
//           if(i%2 == 0) arr.add(i);
//           }
