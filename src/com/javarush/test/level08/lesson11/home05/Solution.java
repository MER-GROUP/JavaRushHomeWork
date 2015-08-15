package com.javarush.test.level08.lesson11.home05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/* Мама Мыла Раму. Теперь с большой буквы
Написать программу, которая вводит с клавиатуры строку текста.
Программа заменяет в тексте первые буквы всех слов на заглавные.
Вывести результат на экран.

Пример ввода:
  мама     мыла раму.

Пример вывода:
  Мама     Мыла Раму.
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();

        //Напишите тут ваш код
        StringTokenizer st=new StringTokenizer(s," ",true);

        ArrayList<String> list_string=new ArrayList<String>();
        while (st.hasMoreElements()) list_string.add(st.nextToken());
//        for (String i:list_string) System.out.println(i);

        for (int i = 0; i < list_string.size(); i++)
        {
            String temp_string="";
            for (int j = 0; j < list_string.get(i).length(); j++)
            {
                if (0==j) temp_string+=list_string.get(i).toUpperCase().charAt(j);
//                if (0==j) System.out.println(list_string.get(i).charAt(j));
                else temp_string+=list_string.get(i).charAt(j);
            }
            list_string.set(i,temp_string);
        }

        for (String i:list_string) System.out.print(i);
    }
}

/*
public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();

        //создадим таблицу, в которой будем хранить разобранные слова из строки
        ArrayList<String> array = new ArrayList<String>();

        //создадим объект StringTokenizer, класса StringTokenizer
        //который отвечает в Java за разбор строк
        //подробнее есть, например,  тут http://articles.org.ru/docum/java/gl5/gl5.php#23
        //в разбор обязательно включаем учёт пробелов к словам
        StringTokenizer st = new StringTokenizer(s," ", true);
        while (st.hasMoreTokens()){
            array.add(st.nextToken());
        }


        //вызовем цикл, который каждое слово превратит в отдельные символы
        for (int i=0; i<array.size();i++){
            //берём слово и все буквы делаем символами
            //создаём цикл по количеству букв
            //для начала создадим временный лист символов
            ArrayList<Character> temp = new ArrayList<Character>();

            for(int i2=0; i2<(array.get(i).length());i2++){
                //бежим по циклу и заносим символы во временный лист символов
                char c = array.get(i).charAt(i2);
                //при этом, если это первый смивол, то делаем его большим
                if (i2 == 0) {
                    char c1 = Character.toTitleCase(c);
                    //и переопределяем
                    c = c1;
                }
                //затем символ вносим в лист
                temp.add(c);

            }

            //когда разбор символов закончен, вносим эти символы в лист слов
            //для этого удаляем текущую позицию и создаём на её месте новую
            array.remove(i);

            //Создаём слово из букв (конкатенация)
            //Первым символов сразу инициализируем переменную
            String con=temp.get(0).toString();


            //Временную переменную инициализировать не надо
            String con1;
            for (int i3 = 1; i3<temp.size();i3++){
                con1 = con.concat(temp.get(i3).toString());
                con=con1;
            }
            //вносим на нужную позицию в лист готовое слово
            array.add(i,con);
        }

        //печатаем готовый лист строк
        for (String s2 : array){
            System.out.print(s2);
        }


    }


}*/
