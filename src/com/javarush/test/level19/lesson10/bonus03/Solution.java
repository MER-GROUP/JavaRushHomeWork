//package com.javarush.test.level19.lesson10.bonus03;
//
///* Знакомство с тегами
//Считайте с консоли имя файла, который имеет HTML-формат
//Пример:
//Info about Leela <span xml:lang="en" lang="en"><b><span>Turanga Leela
//</span></b></span>
//Первым параметром в метод main приходит тег. Например, "span"
//Вывести на консоль все теги, которые соответствуют заданному тегу
//Каждый тег на новой строке, порядок должен соответствовать порядку следования в файле
//Количество пробелов, \n, \r не влияют на результат
//Файл не содержит тег CDATA, для всех открывающих тегов имеется отдельный закрывающий тег, одиночных тегов нету
//Тег может содержать вложенные теги
//Пример вывода:
//<span xml:lang="en" lang="en"><b><span>Turanga Leela</span></b></span>
//<span>Turanga Leela</span>
//
//Шаблон тега:
//<tag>text1</tag>
//<tag text2>text1</tag>
//<tag
//text2>text1</tag>
//
//text1, text2 могут быть пустыми
//*/
//
//import java.io.*;
//import java.util.ArrayList;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//
//public class Solution {
//    private static ArrayList<String> list=new ArrayList<String>();
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
//        String fileName=reader.readLine();
//        reader.close();
//
//        if (1>args.length) return;
//        String param=args[0];
//
//        StringBuilder builder=new StringBuilder();
//        BufferedReader fileReader=new BufferedReader(new FileReader(new File(fileName)));
//        while (fileReader.ready()){
//            builder.append(fileReader.readLine()).append(" ");
//        }
//        fileReader.close();
//
//        Obrabotka(builder.toString().trim(),param);
//
//        for (String str:list){
//            System.out.println(str);
//        }
//    }
//
//    private static void Obrabotka(String str,String args){
//        String strStart="<"+args;
//        String strEnd="</"+args;
//
//        Pattern pattern=Pattern.compile(strStart+"|"+strEnd);
//        Matcher matcher=pattern.matcher(str);
//
//        int countStart=0,countEnd=0;
//        int startA=0,endA=0;
//        int startB=0,endB=0;
//        while (matcher.find()){
//            if (strStart.equals(matcher.group())){
//                countStart++;
//                if (1==countStart){
//                    startA=matcher.start();
//                    endA=matcher.end();
//                }
//            }else if (strEnd.equals(matcher.group())){
//                countEnd++;
//            }
//
//            if (countStart==countEnd){
//                startB=matcher.start();
//                endB=matcher.end();
//                break;
//            }
//        }
//
//        StringBuilder builderEnd=new StringBuilder(str.substring(endB+1,str.length()));
//        StringBuilder builderStart=new StringBuilder(str.substring(startA,endB+1));
//
//        Obrabotka2(builderStart.toString(),args);
//
//        if (!builderEnd.toString().isEmpty()){
//            Obrabotka(builderEnd.toString(),args);
//        }
//    }
//
//    private static void Obrabotka2(String str,String args){
//        Pattern pattern=Pattern.compile(args);
//        Matcher matcher=pattern.matcher(str);
//        int count=0;
//        while (matcher.find()){
//            count++;
//        }
//
//        int startA=0,endA=0;
//        int startB=0,endB=0;
//        int countTmp=0;
//        matcher.reset(str);
//        while (matcher.find()){
//            countTmp++;
//            if (1==countTmp){
//                startA=matcher.start()-1;//включая < (знак из span)
//                endA=matcher.end();
//            }else if (count==countTmp){
//                startB=matcher.start()-2;//включая </ (знак из span)
//                endB=matcher.end()+1;//включая > (знак из span)
//            }
//        }
//
//        String stringThrow=str.substring(endA,startB);
//        if (!str.substring(startA, endB).isEmpty()){
//            list.add(str.substring(startA, endB));
//        }
//
//        if (!stringThrow.isEmpty()) {
//            Obrabotka2(stringThrow,args);
//        }
//    }
//}

package com.javarush.test.level19.lesson10.bonus03;

/* Знакомство с тегами
Считайте с консоли имя файла, который имеет HTML-формат
Пример:
Info about Leela <span xml:lang="en" lang="en"><b><span>Turanga Leela
</span></b></span>
Первым параметром в метод main приходит тег. Например, "span"
Вывести на консоль все теги, которые соответствуют заданному тегу
Каждый тег на новой строке, порядок должен соответствовать порядку следования в файле
Количество пробелов, \n, \r не влияют на результат
Файл не содержит тег CDATA, для всех открывающих тегов имеется отдельный закрывающий тег, одиночных тегов нету
Тег может содержать вложенные теги
Пример вывода:
<span xml:lang="en" lang="en"><b><span>Turanga Leela</span></b></span>
<span>Turanga Leela</span>

Шаблон тега:
<tag>text1</tag>
<tag text2>text1</tag>
<tag
text2>text1</tag>

text1, text2 могут быть пустыми
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader file = new BufferedReader(new FileReader(reader.readLine()));
        StringBuilder stringBuilder = new StringBuilder();
        ArrayList<String> sList = new ArrayList<>();
        while (file.ready()) {
            stringBuilder = stringBuilder.append(file.readLine());
        }

        String t = args[0];
        String s = stringBuilder.toString().replaceAll("\r\n", "");
        ArrayList<Pair> list = new ArrayList<>();
        String open = "<".concat(t);
        String closing = "</".concat(t);
        int len = t.length();
        int index1 = 0;

        while ((index1 != -1) && (index1 < s.length())) {
            index1 = s.indexOf(open, index1);
            int index2 = s.indexOf(closing, index1 + len);
            int k = index1 + len;
            if (index2 != -1) {
                while (s.substring(k, index2).contains(open)) {
                    k = index2 + len;
                    index2 = s.indexOf(closing, k);
                }
            }
            if (index1 != -1 && index2 != -1) {
                list.add(new Pair(index1, index2));
                index1 += len;
            }
        }

        for (Pair pair : list) {
            String str = s.substring(pair.getA(), pair.getB() + len + 3);
            sList.add(str);
        }


        for (String s1 : sList) {
            System.out.println(s1);
        }
    }

    public static class Pair {
        private int a;
        private int b;

        public Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }

        public int getA() {
            return a;
        }

        public int getB() {
            return b;
        }
    }
}
