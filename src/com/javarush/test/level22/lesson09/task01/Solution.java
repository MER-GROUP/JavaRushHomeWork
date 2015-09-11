package com.javarush.test.level22.lesson09.task01;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

/* Обращенные слова
В методе main с консоли считать имя файла, который содержит слова, разделенные пробелами.
Найти в тексте все пары слов, которые являются обращением друг друга. Добавить их в result.
Порядок слов first/second не влияет на тестирование.
Использовать StringBuilder.
Пример, "мор"-"ром", "трос"-"сорт"
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args){
        try(
                BufferedReader consoleReader=new BufferedReader(new InputStreamReader(System.in));
                BufferedReader fileReader=new BufferedReader
                        (new InputStreamReader(new FileInputStream(new File(consoleReader.readLine()))));
                ){
            StringBuilder copyFile=new StringBuilder();
            while (fileReader.ready()){
                copyFile.append(fileReader.readLine()).append(" ");
            }

            //убираем пробелы которые идут друг за другом (оставляем один пробел между двумя словами)
            for (int i = copyFile.indexOf(" "); i < copyFile.length(); i=copyFile.indexOf(" ",i)) {
                if (i==-1)break;
                while (true){
                    ++i;
                    if (i>=copyFile.length()) break;
                    else if (copyFile.charAt(i)==' '){
                        copyFile.deleteCharAt(i);
                        --i;
                    }
                    else break;
                }
            }
            copyFile.replace(0,copyFile.length(),copyFile.toString().trim());
            copyFile.insert(0," ").append(" ");

            //нахождение нужных слов
            StringBuilder secondWord=new StringBuilder();
            while (true){
                int indexOfSpaceStart=copyFile.indexOf(" ");
                if (indexOfSpaceStart==-1)break;
                int indexOfSpaceEnd=copyFile.indexOf(" ",indexOfSpaceStart+1);

                Pair pair=null;
                if (copyFile.length()>1){
                    pair=new Pair();
                    pair.first=copyFile.substring(indexOfSpaceStart,indexOfSpaceEnd).trim();
                    copyFile.delete(indexOfSpaceStart,indexOfSpaceEnd);
                }else {
                    break;
                }

                //boolean checkAdd=false;
                if (copyFile.length()>1){
                    for (
                            int start=0, end=copyFile.indexOf(" ",start+1);
                            end<copyFile.length() && end>-1;
                            start=end, end=copyFile.indexOf(" ",end+1)) {

                        secondWord.delete(0,secondWord.length());
                        secondWord.append(copyFile.substring(start,end).trim());

                        if (pair.first.equals(secondWord.reverse().toString().trim())){
                            pair.second=secondWord.reverse().toString();
                            result.add(pair);
                            //checkAdd=true;
                            copyFile.delete(start,end);
                            break;
                        }
                    }
                }

                /*if (!checkAdd){
                    result.add(pair);
                }*/
            }

            //вывод в консоль
            for (Pair itr:result) System.out.println(itr);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static class Pair {
        String first;
        String second;

        @Override
        public String toString() {
            return  first == null && second == null ? "" :
                    first == null && second != null ? second :
                    second == null && first != null ? first :
                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}