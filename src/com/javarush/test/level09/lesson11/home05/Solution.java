//package com.javarush.test.level09.lesson11.home05;
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//
///* Гласные и согласные буквы
//Написать программу, которая вводит с клавиатуры строку текста.
//Программа должна вывести на экран две строки:
//1. первая строка содержит только гласные буквы
//2. вторая - только согласные буквы и знаки препинания из введённой строки.
//Буквы соединять пробелом.
//
//Пример ввода:
//Мама мыла раму.
//Пример вывода:
//а а ы а а у
//М м м л р м .
//*/
//
//public class Solution
//{
//    public static void main(String[] args) throws Exception
//    {
//        //Написать тут ваш код
//        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
//        String text=reader.readLine();
//
//        ArrayList<String> list_vowels=new ArrayList<String>();
//        ArrayList<String> list=new ArrayList<String>();
//
//        char c,p=' ';
//        for (int i = 0; i < text.length(); i++)
//        {
//            c=text.charAt(i);
//            if (p==c){}
//            else if (isVowel(c)) list_vowels.add(c+" ");
//            else list.add(c+" ");
//        }
//
//        for (String i:list_vowels) System.out.print(i);
//        System.out.println();
//        for (String i:list) System.out.print(i);
//
////        BufferedReader reader = new BufferedReader( new InputStreamReader( System.in ) );
////        String s = reader.readLine();
////        String vowelStr = "";
////        String consonantStr = "";
////        char[] letters = s.toCharArray();
////
////        for ( int i = 0; i < letters.length; i++ )
////        {
////            if ( letters[i] == ' ' )
////            {
////                continue;
////            }
////            if ( isVowel( letters[i] ) )
////            {
////                vowelStr += letters[i] + " ";
////            }
////            else
////            {
////                consonantStr += letters[i] + " ";
////            }
////        }
////
////        vowelStr = vowelStr.trim();
////        consonantStr = consonantStr.trim();
////
////        System.out.println( vowelStr );
////        System.out.println( consonantStr );
//    }
//
//
//    public static char[] vowels = new char[]{'а', 'я', 'у', 'ю', 'и', 'ы', 'э', 'е', 'о', 'ё'};
//
//    //метод проверяет, гласная ли буква
//    public static boolean isVowel(char c)
//    {
//        c = Character.toLowerCase(c);  //приводим символ в нижний регистр - от заглавных к строчным буквам
//
//        for (char d : vowels)   //ищем среди массива гласных
//        {
//            if (c == d)
//                return true;
//        }
//        return false;
//    }
//}
