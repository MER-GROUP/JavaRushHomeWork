package com.javarush.test.level22.lesson05.task02;

/* Между табуляциями
Метод getPartOfString должен возвращать подстроку между первой и второй табуляцией.
На некорректные данные бросить исключение TooShortStringException.
Класс TooShortStringException не менять.
*/
public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException {

        try{
            String result = string.substring(string.indexOf("\t")+1,string.indexOf("\t",string.indexOf("\t")+1));
            return result;
        }
        catch (Exception e) {

            throw new TooShortStringException();

        }
    }

    public static class TooShortStringException extends Exception {
    }
}
