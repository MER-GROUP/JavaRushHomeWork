package com.javarush.test.level19.lesson05.task02;
 
/* Считаем слово
Считать с консоли имя файла.
Вывести в консоль количество слов "world", которые встречаются в файле.
Закрыть поток ввода.
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    static int counter = 0;
    static char currentChar = ' ';
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        FileReader reader = new FileReader(br.readLine());
        //FileWriter writer = new FileWriter(br.readLine());

        String text = "";
        while (reader.ready())
        {
            currentChar = (char)reader.read();
            //readWorld(reader);
            text = text+currentChar;

        }

        String replacedString = text.replaceAll("\\p{P}"," ").toLowerCase();
        replacedString=replacedString.replaceAll("\\s"," ");

        String splitString[] = replacedString.split(" ");
        for (String x : splitString) {
            if (x.equals("world")) {
                counter++;
            }
        }

        System.out.println(counter);
        reader.close();

    }


}