package com.javarush.test.level22.lesson09.task03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* Составить цепочку слов
В методе main считайте с консоли имя файла, который содержит слова, разделенные пробелом.
В методе getLine используя StringBuilder расставить все слова в таком порядке,
чтобы последняя буква данного слова совпадала с первой буквой следующего не учитывая регистр.
Каждое слово должно участвовать 1 раз.
Метод getLine должен возвращать любой вариант.
Слова разделять пробелом.
В файле не обязательно будет много слов.

Пример тела входного файла:
Киев Нью-Йорк Амстердам Вена Мельбурн

Результат:
Амстердам Мельбурн Нью-Йорк Киев Вена
*/
public class Solution {
    public static void main(String[] args) throws IOException
    {
        //...
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Scanner scanner = new Scanner(new FileReader(reader.readLine()));
        String www = "";
        while (scanner.hasNextLine())
        {
            www = scanner.nextLine();
        }
        StringBuilder result = getLine(www.split(" "));
        System.out.println(result.toString());
    }
    public static StringBuilder getLine(String... words) {
        /*
        if (words == null || words.length == 0) return new StringBuilder();
        if ("".equals(words[0]) || words.length == 1) return new StringBuilder(words[0]);

        ArrayList<StringBuilder> result = new ArrayList<StringBuilder>();
        for (int i = 0; i < words.length; i++)
        {
            ArrayList<String> list = new ArrayList<>(Arrays.asList(words));
            list.remove(words[i]);
            result.add(i, new StringBuilder(words[i]));
            int j = 0;
            String firstWord = words[i];
            while (j < list.size())
            {
                String secondWord = list.get(j);
                if (firstWord.toLowerCase().charAt(firstWord.length() - 1) == secondWord.toLowerCase().charAt(0))
                {
                    result.set(i, result.get(i).append(" ").append(secondWord));
                    firstWord = secondWord;
                    list.remove(j);
                    j = -1;
                }
                j++;
            }
        }

        int[] count = new int[result.size()];
        for (int i = 0; i < count.length; i++)
        {
            count[i] = result.get(i).toString().trim().split("\\p{Space}+").length;
        }

        int maxWords = count[0];
        int index = 0;
        for (int i = 1; i < count.length; i++)
        {
            if (maxWords < count[i])
            {
                maxWords = count[i];
                index = i;
            }
        }

        return result.get(index);
        */

        if (words == null || words.length == 0)
        { return new StringBuilder(); }
        if ("".equals(words[0]) || words.length == 1)
        {return new StringBuilder(words[0]); }

        StringBuilder result = new StringBuilder();

        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < words.length; i ++)
            if (!words[i].equals(""))
                list.add(words[i]);
        while (!isOK(list)) {
            Collections.shuffle(list);
        }
        for (String s : list)
            result.append(s+ " ");
        result.deleteCharAt(result.length()-1);
        return result;
    }
    public static boolean isOK(ArrayList<String> list) {
        for (int i = 0; i < list.size()-1; i++) {
            String first = list.get(i);
            String second = list.get(i+1);
            first = first.toLowerCase();
            second =second.toLowerCase();
            if (first.charAt(first.length()-1)!=second.charAt(0))
                return false;
        }
        return true;
    }
}