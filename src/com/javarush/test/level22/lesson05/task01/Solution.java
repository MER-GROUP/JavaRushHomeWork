package com.javarush.test.level22.lesson05.task01;

/* Найти подстроку
Метод getPartOfString должен возвращать подстроку начиная с символа после 1-го пробела и до конца слова,
которое следует после 4-го пробела.
Пример: "JavaRush - лучший сервис обучения Java."
Результат: "- лучший сервис обучения"
На некорректные данные бросить исключение TooShortStringException (сделать исключением).
Сигнатуру метода getPartOfString не менять.
*/
public class Solution {

    public static String getPartOfString(String string) throws TooShortStringException{
        String result;
        try {
            String [] m =string.split(" ");
            int length = m[0].length()+m[1].length()+m[2].length()+m[3].length()+m[4].length()+4;
            result = string.substring(string.indexOf(" ")+1,length);
        }
        catch (Exception e){
            throw new TooShortStringException();
        }
        return result;
    }

    public static class TooShortStringException extends Exception {
    }

    public static void main(String[] args) throws TooShortStringException {
        System.out.println("JavaRush - лучший сервис обучения Java.");
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
    }
}
