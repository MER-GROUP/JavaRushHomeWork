//package com.javarush.test.level15.lesson12.home09;
//
///* Парсер реквестов
//Считать с консоли URl ссылку.
//Вывести на экран через пробел список всех параметров (Параметры идут после ? и разделяются &, например, lvl=15).
//URL содержит минимум 1 параметр.
//Если присутствует параметр obj, то передать его значение в нужный метод alert.
//alert(double value) - для чисел (дробные числа разделяются точкой)
//alert(String value) - для строк
//
//Пример 1
//Ввод:
//http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo
//Вывод:
//lvl view name
//
//Пример 2
//Ввод:
//http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo
//Вывод:
//obj name
//double 3.14
//*/
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.LinkedHashMap;
//import java.util.Map;
//import java.util.StringTokenizer;
//import mergroup.Digit;
//
//public class Solution {
//    public static void main(String[] args) throws IOException {
//        //add your code here
//        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
//        String str=reader.readLine();
//        String str_obrabotannoe="";
//
//        boolean parametr=false;
//        for (int i = 0; i < str.length(); i++) {
//            if ('?'==str.charAt(i) && !parametr){
//                parametr=true;
//                continue;
//            }
//            else if (parametr){
//                str_obrabotannoe+=str.charAt(i);
//            }
//        }
//
////        //test
////        System.out.println(str_obrabotannoe);
//
//        StringTokenizer st=new StringTokenizer(str_obrabotannoe,"&?");
//        String str_1_param="";
//        String str_2_znach="";
//        LinkedHashMap<String,String> map=new LinkedHashMap<String,String>();
//
////        //test
////        while (st.hasMoreTokens()){
////            System.out.println(st.nextToken());
////        }
//
//        //
//        String temp_str="";
//        while (st.hasMoreTokens()){
//            parametr=false;
//            temp_str=st.nextToken();
//            str_1_param="";
//            str_2_znach="";
//            for (int i = 0; i < temp_str.length(); i++)
//            {
//                if ('='==temp_str.charAt(i) && !parametr){
//                    parametr=true;
//                    continue;
//                }
//                else if (!parametr){
//                    str_1_param+=temp_str.charAt(i);
//                }
//                else if (parametr){
//                    str_2_znach+=temp_str.charAt(i);
//                }
//            }
//            map.put(str_1_param,str_2_znach);
//        }
//
//        for (Map.Entry<String,String> pair:map.entrySet()){
//            System.out.print(pair.getKey()+" ");
//        }
//        System.out.println();
//
//        if (map.containsKey("obj")){
//            if (new Digit().isFraction(map.get("obj"))){
//                alert(Double.parseDouble(map.get("obj")));
//            }
//            else {
//                alert(map.get("obj"));
//            }
//        }
//    }
//
//    public static void alert(double value) {
//        System.out.println("double " + value);
//    }
//
//    public static void alert(String value) {
//        System.out.println("String " + value);
//    }
//}

package com.javarush.test.level15.lesson12.home09;

/* Парсер реквестов
Считать с консоли URl ссылку.
Вывести на экран через пробел список всех параметров (Параметры идут после ? и разделяются &, например, lvl=15).
URL содержит минимум 1 параметр.
Если присутствует параметр obj, то передать его значение в нужный метод alert.
alert(double value) - для чисел (дробные числа разделяются точкой)
alert(String value) - для строк

Пример 1
Ввод:
http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo
Вывод:
lvl view name

Пример 2
Ввод:
http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo
Вывод:
obj name
double 3.14
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String [] args) throws IOException
    {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String url = reader.readLine();
        String afterQuestionMark = url.substring(url.indexOf("?")+1);
        String [] tokens = afterQuestionMark.split("(\\&+)|(\\?+)");

        ArrayList<String> objList = new ArrayList<String>();
        Pattern objMutch = Pattern.compile("^obj=.*");
        for(String a:tokens){
            if(!a.equals("")){
                Matcher matcher = objMutch.matcher(a);
                if(matcher.find()){ objList.add(a.substring(a.indexOf("=")+1)); }
                if(a.contains("=")){ System.out.print(a.substring(0,(a.indexOf("="))) +" "); }
                else {System.out.print(a+" ");}
            }
        }

        Pattern doublePattern = Pattern.compile("[0-9.]");
        Pattern stringPattern = Pattern.compile("[A-Za-z]");

        System.out.println();
        for(String a:objList){
            Matcher matcher = stringPattern.matcher(a);
            Matcher matcher1 = doublePattern.matcher(a);
            if(matcher.find()){alert(a);}
            else  if(matcher1.find()){alert(Double.parseDouble(a));}
        }
    }

    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}