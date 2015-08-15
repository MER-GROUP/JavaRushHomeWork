package com.javarush.test.level19.lesson05.task05;

/* Пунктуация
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Удалить все знаки пунктуации, вывести во второй файл.
http://ru.wikipedia.org/wiki/%D0%9F%D1%83%D0%BD%D0%BA%D1%82%D1%83%D0%B0%D1%86%D0%B8%D1%8F
Закрыть потоки ввода-вывода.
Темповые файлы создавать нельзя, т.к. на сервере заблокирована возможность создания каких любо файлов.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        String fileName1=reader.readLine();
        String fileName2=reader.readLine();
        reader.close();

        BufferedReader bufferedReader=new BufferedReader(new FileReader(new File(fileName1)));
        PrintWriter printWriter=new PrintWriter(new BufferedWriter(new FileWriter(new File(fileName2))));
        while (bufferedReader.ready()){
            printWriter.println(bufferedReader.readLine().replaceAll("\\p{Punct}",""));
        }
        bufferedReader.close();
        printWriter.close();
    }
}

//import java.io.*;
//        import java.util.regex.Pattern;
//
//public class Solution {
//    public static void main(String[] args) throws IOException {
//
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        FileReader reader = new FileReader(br.readLine());
//        FileWriter writer = new FileWriter(br.readLine());
//
//        while (reader.ready()) {
//            char c = (char) reader.read();
//            if (!Pattern.matches("\\p{P}",String.valueOf(c))) {
//                writer.write(c);
//            }
//        }
//        reader.close();
//        writer.close();
//
//    }
//}
