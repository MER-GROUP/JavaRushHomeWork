//package com.javarush.test.level18.lesson10.home05;
//
///* Округление чисел
//Считать с консоли 2 имени файла
//Первый файл содержит вещественные(дробные) числа, разделенные пробелом. Например, 3.1415
//Округлить числа до целых и записать во второй файл
//Закрыть потоки
//Принцип округления:
//3.49 - 3
//3.50 - 4
//3.51 - 4
//*/
//
//import java.io.*;
//import java.util.ArrayList;
//
//public class Solution {
//    public static void main(String[] args) throws IOException
//    {
//        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
//        String fileName1=reader.readLine();
//        String fileName2=reader.readLine();
////        reader.close();
//
//        File file1=new File(fileName1);
//        File file2=new File(fileName2);
//
//        reader=new BufferedReader(new FileReader(file1));
//        ArrayList<String> list=new ArrayList<>();
//        while (reader.ready()){
//            list.add(reader.readLine());
//        }
//        reader.close();
//
//        BufferedWriter writer=new BufferedWriter(new FileWriter(file2,true));
//
//        for (String str:list){
////            System.out.println("str = " + str);
//            String[] bufStr=str.split(" ");
//            StringBuilder builder=new StringBuilder();
//            double bufDouble=0;
//            int bufInt=0;
//            double tempDouble=0;
//            double resDouble=0;
//            int resInt=0;
//            for (int i = 0; i < bufStr.length; i++) {
//                bufDouble=Double.parseDouble(bufStr[i]);
//                bufInt=(int)bufDouble;
//                tempDouble=bufDouble-(double)bufInt;
//                if (0.5>tempDouble){
//                    resDouble=Math.floor(bufDouble);
//                    resInt=(int)resDouble;
//                }else{
//                    resDouble=Math.ceil(bufDouble);
//                    resInt=(int)resDouble;
//                }
//                builder.append(String.valueOf(resInt)).append(" ");
//            }
//            String resStr=builder.toString().trim()+"\n";
//            writer.write(resStr);
//        }
//
//        writer.close();
//    }
//}
package com.javarush.test.level18.lesson10.home05;

/* Округление чисел
Считать с консоли 2 имени файла
Первый файл содержит вещественные(дробные) числа, разделенные пробелом. Например, 3.1415
Округлить числа до целых и записать во второй файл
Закрыть потоки
Принцип округления:
3.49 - 3
3.50 - 4
3.51 - 4
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        ArrayList<Integer> numbers = new ArrayList<Integer>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        reader.close();

        BufferedReader fileReader = new BufferedReader(new FileReader(fileName1));
        String str;
        String[] strMass;
        double tmp;

        while ((str = fileReader.readLine()) != null) {
            strMass = str.split(" ");
            for (String strMas : strMass)
            {
                tmp = Math.round(Double.parseDouble(strMas));
                numbers.add((int)tmp);
            }
        }
        fileReader.close();

        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(fileName2));
        String num = "";
        for (int a : numbers)
            num = num+a+" ";
        fileWriter.write(num);
        fileWriter.close();
    }
}
