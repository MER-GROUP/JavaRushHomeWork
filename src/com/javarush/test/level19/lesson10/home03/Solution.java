//package com.javarush.test.level19.lesson10.home03;
//
//import java.io.*;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
///* Хуан Хуанович
//В метод main первым параметром приходит имя файла.
//В этом файле каждая строка имеет следующий вид:
//имя день месяц год
//где [имя] - может состоять из нескольких слов, разделенных пробелами, и имеет тип String
//[день] - int, [месяц] - int, [год] - int
//данные разделены пробелами
//
//Заполнить список PEOPLE импользуя данные из файла
//Закрыть потоки
//
//Пример входного файла:
//Иванов Иван Иванович 31 12 1987
//Вася 15 5 2013
//*/
//
//public class Solution {
//    public static final List<Person> PEOPLE = new ArrayList<Person>();
//
//    public static void main(String[] args) throws IOException {
//        if(1>args.length) return;
//
//        String fileName=args[0];
//        BufferedReader reader=new BufferedReader(new FileReader(new File(fileName)));
//        String[] strBuf=null;
//        StringBuilder builderName=new StringBuilder();
//        int day=0;
//        int month=0;
//        int year=0;
//        while (reader.ready()){
//            strBuf=reader.readLine().split(" ");
//            for (int i = 0; i < strBuf.length-3; i++) {
//                builderName.append(strBuf[i]).append(" ");
//            }
//            year=Integer.parseInt(strBuf[strBuf.length-1]);
//            month=Integer.parseInt(strBuf[strBuf.length-2]);
//            day=Integer.parseInt(strBuf[strBuf.length-3]);
//            PEOPLE.add(new Person(builderName.toString().trim(),new Date(year,month,day)));
//
//            builderName.delete(0,builderName.length());
//        }
//        reader.close();
//
//        //test//
//        for (Person person:PEOPLE){
//            System.out.println(person.getName()+" "+person.getBirthday());
//        }
//    }
//
//}

package com.javarush.test.level19.lesson10.home03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/* Хуан Хуанович
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя день месяц год
где [имя] - может состоять из нескольких слов, разделенных пробелами, и имеет тип String
[день] - int, [месяц] - int, [год] - int
данные разделены пробелами
Заполнить список PEOPLE импользуя данные из файла
Закрыть потоки
Пример входного файла:
Иванов Иван Иванович 31 12 1987
Вася 15 5 2013
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException
    {
        String fileName = args[0];
        String input;
        ArrayList<String> fileList = new ArrayList<String>();
        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
        while ((input = fileReader.readLine()) != null)
            fileList.add(input);
        fileReader.close();

        for (String aFileList : fileList)
        {
            String[] stringArray = aFileList.split(" ");
            String name = "";
            for (int i = 0; i < stringArray.length-3; i++) {
                if (i == stringArray.length-4)
                    name = name+stringArray[i];
                else
                    name = name+stringArray[i]+" ";
            }
            int year = Integer.parseInt(stringArray[stringArray.length-1]);
            int month = Integer.parseInt(stringArray[stringArray.length-2])-1;
            int day = Integer.parseInt(stringArray[stringArray.length-3]);
            Date birthDay = new GregorianCalendar(year, month, day).getTime();
            PEOPLE.add(new Person(name, birthDay));
        }
    }
}
