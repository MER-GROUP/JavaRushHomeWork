package com.javarush.test.level22.lesson13.task01;

import java.util.StringTokenizer;

/* StringTokenizer
Используя StringTokenizer разделить query на части по разделителю delimiter.
Пример,
getTokens("level22.lesson13.task01", ".") == {"level22", "lesson13", "task01"}
*/
public class Solution {
    public static String [] getTokens(String query, String delimiter) {
        StringTokenizer stringTokenizer=new StringTokenizer(query,delimiter);
        String[] tokens=new String[stringTokenizer.countTokens()];
        for (int i=0;stringTokenizer.hasMoreTokens();i++){
            tokens[i]=stringTokenizer.nextToken();
        }
        return tokens;
    }

    public static void main(String[] args) {
        String[] array=getTokens("level22.lesson13.task01", ".");
        for (String itr:array) System.out.println(itr);
    }
}
