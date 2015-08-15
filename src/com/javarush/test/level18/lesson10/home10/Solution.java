//package com.javarush.test.level18.lesson10.home10;
//
///* Собираем файл
//Собираем файл из кусочков
//Считывать с консоли имена файлов
//Каждый файл имеет имя: [someName].partN. Например, Lion.avi.part1, Lion.avi.part2, ..., Lion.avi.part37.
//Имена файлов подаются в произвольном порядке. Ввод заканчивается словом "end"
//В папке, где находятся все прочтенные файлы, создать файл без приставки [.partN]. Например, Lion.avi
//В него переписать все байты из файлов-частей используя буфер.
//Файлы переписывать в строгой последовательности, сначала первую часть, потом вторую, ..., в конце - последнюю.
//Закрыть все потоки ввода-вывода
//Темповые файлы создавать нельзя, т.к. на сервере заблокирована возможность создания каких любо файлов
//*/
//
//import java.io.*;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.Comparator;
//
//public class Solution {
//    public static void main(String[] args) throws IOException {
//        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
//        String fileName=bufferedReader.readLine();
//        ArrayList<String> arrayList=new ArrayList<>();
//        while (!fileName.equals("end")){
//            arrayList.add(fileName);
//            fileName=bufferedReader.readLine();
//        }
//        bufferedReader.close();
//
//        //test/////////////////////
//        //for (String str:arrayList) System.out.println("str = " + str);
//        //System.out.println("---------------------------------");
//
//        Collections.sort(arrayList,new MyComporator());
//
//        //test/////////////////////
//        //for (String str:arrayList) System.out.println("str = " + str);
//        //System.out.println("---------------------------------");
//
//        String[] directionFile=arrayList.get(0).split("\\.");
//        String fileNameNew=directionFile[0]+"."+directionFile[1];
//
//        //test////////////////////////
//        //System.out.println("fileNameNew = "+fileNameNew);
//
//        File file=new File(fileNameNew);
//        file.createNewFile();
//        FileOutputStream fileOutputStream=new FileOutputStream(file,true);
//        FileInputStream fileInputStream=null;
//
//        for (String s:arrayList){
//            fileInputStream=new FileInputStream(new File(s));
//            byte[] bytes=new byte[fileInputStream.available()];
//            if (0<fileInputStream.available()){
//                fileInputStream.read(bytes);
//            }
//            fileOutputStream.write(bytes);
//        }
//
//        fileInputStream.close();
//        fileOutputStream.close();
//    }
//
//    public static class MyComporator implements Comparator{
//        @Override
//        public int compare(Object o1, Object o2) {
//            String str1=o1.toString();
//            String str2=o2.toString();
//
//            String[] bufStr1=str1.split("\\.");
//            String[] bufStr2=str2.split("\\.");
//
//            String buf1="";
//            String buf2="";
//
//            StringBuilder stringBuilder1=new StringBuilder();
//            StringBuilder stringBuilder2=new StringBuilder();
//
//            for (int i = 0; i < bufStr1[2].length(); i++) {
//                if ('0'<=bufStr1[2].charAt(i) && '9'>=bufStr1[2].charAt(i)){
//                    stringBuilder1.append(bufStr1[2].charAt(i));
//                }
//            }
//
//            for (int i = 0; i < bufStr2[2].length(); i++) {
//                if ('0'<=bufStr2[2].charAt(i) && '9'>=bufStr2[2].charAt(i)){
//                    stringBuilder2.append(bufStr2[2].charAt(i));
//                }
//            }
//
//            buf1=stringBuilder1.toString();
//            buf2=stringBuilder2.toString();
//
//            int res1=Integer.parseInt(buf1);
//            int res2=Integer.parseInt(buf2);
//
//            if (res1<res2){
//                return -1;
//            }else if (res1==res2){
//                return 0;
//            }else {
//                return 1;
//            }
//        }
//    }
//}

        /*
D:\TEMP\Lion.txt.part23
D:\TEMP\Lion.txt.part10
D:\TEMP\Lion.txt.part20
D:\TEMP\Lion.txt.part6
D:\TEMP\Lion.txt.part18
D:\TEMP\Lion.txt.part2
D:\TEMP\max.txt.part2
D:\TEMP\max.txt.part4
D:\TEMP\max.txt.part3
D:\TEMP\max.txt.part1
end
end
        */

package com.javarush.test.level18.lesson10.home10;

/* Собираем файл
Собираем файл из кусочков
Считывать с консоли имена файлов
Каждый файл имеет имя: [someName].partN. Например, Lion.avi.part1, Lion.avi.part2, ..., Lion.avi.part37.
Имена файлов подаются в произвольном порядке. Ввод заканчивается словом "end"
В папке, где находятся все прочтенные файлы, создать файл без приставки [.partN]. Например, Lion.avi
В него переписать все байты из файлов-частей используя буфер.
Файлы переписывать в строгой последовательности, сначала первую часть, потом вторую, ..., в конце - последнюю.
Закрыть все потоки ввода-вывода
Темповые файлы создавать нельзя, т.к. на сервере заблокирована возможность создания каких любо файлов
*/

import java.io.*;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name;
        Set<File> fileset = new TreeSet<>();

        while (!(name = reader.readLine()).equals("end")) {
            File file = new File(name);
            fileset.add(file);
        }

        Iterator<File> itr = fileset.iterator();

        //test//////////////////
        for (File file:fileset){
            System.out.println("file = " + file);
        }

        String folder = itr.next().getAbsolutePath();
        //test//////////////////
        System.out.println("folder = " + folder);

        folder = folder.substring(0, folder.length() - 6);
        //test//////////////////
        System.out.println("folder = " + folder);

        FileOutputStream resultFile = new FileOutputStream(folder, true);

        for (File file : fileset) {
            FileInputStream in = new FileInputStream(file);
            byte[] buffer = new byte[in.available()];
            while (in.available() > 0) {
                in.read(buffer);
                resultFile.write(buffer);
            }
            in.close();
        }
        resultFile.close();
    }
}
