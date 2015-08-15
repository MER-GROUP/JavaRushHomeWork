//package com.javarush.test.level10.lesson11.home05;
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.LinkedHashMap;
//import java.util.Map;
//
///* Количество букв
//Ввести с клавиатуры 10 строчек и подсчитать в них количество различных букв (для 33 букв алфавита).  Вывести результат на экран.
//Пример вывода:
//а 5
//б 8
//в 3
//г 7
//…
//я 9
//*/
//
//public class Solution
//{
//    public static void main(String[] args)  throws Exception
//    {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//
//        //алфавит
//        ArrayList<Character> alphabet = new ArrayList<Character>();
//        for(int i=0;i<32;i++)
//        {
//            alphabet.add( (char) ('а'+i));
//        }
//        alphabet.add(6,'ё');
//
//        //ввод строк
//        ArrayList<String> list = new ArrayList<String>();
//        for(int i=0;i<10;i++)
//        {
//            String s = reader.readLine();
//            list.add( s.toLowerCase());
//        }
//
//
//        //Напишите тут ваш код
//        Map<Character,Integer> map=new LinkedHashMap<Character, Integer>();
//        for (int i = 0; i < alphabet.size(); i++)
//        {
//            map.put(alphabet.get(i),0);
//        }
//
//        for (int i = 0; i < list.size(); i++)
//        {
//            for (int j = 0; j < list.get(i).length(); j++)
//            {
//                if (map.containsKey(list.get(i).charAt(j))){
//                    for (Map.Entry<Character,Integer> pair:map.entrySet()){
//                        if (pair.getKey().equals(list.get(i).charAt(j))){
//                            pair.setValue(pair.getValue()+1);
//                        }
//                    }
//                }
//            }
//        }
//        for (Map.Entry<Character,Integer> pair:map.entrySet()) System.out.println(pair.getKey()+" "+pair.getValue());
//
////        //склеить все строки в одну
////        String s ="";
////        for (int i=0;i<list.size();i++)
////            s += list.get(i).toString();
////
////        //бежим по массиву букв
////        for (Character c1 : alphabet)
////        {
////            int count = 0;
////            for (Character c2 : s.toCharArray()) //бежим по массиву строки
////            {
////                if (c2.equals(c1)) count++; //если символы совпадают, то счетчик +1
////            }
////            System.out.println(c1 + " " + count); // по окончании проверки печатаем и переходим к следующей букве
////        }
//
//    }
//
//}
