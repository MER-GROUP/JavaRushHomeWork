package com.javarush.test.level18.lesson10.bonus03;

/* Прайсы 2
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается с одним из следующих наборов параметров:
-u id productName price quantity
-d id
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-u  - обновляет данные товара с заданным id
-d  - производит физическое удаление товара с заданным id (все данные, которые относятся к переданному id)

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        if (2>args.length){
            return;
        }else{
            BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
            String fileName=reader.readLine();
            reader.close();

            switch (args[0]){
                /////////////////////////////////////////////////////////////////////
                case "-u":
                    StringBuilder builderQuantity=new StringBuilder(args[args.length-1]);
                    String stringQuantity=new String(Obrabotka(builderQuantity,4));

                    StringBuilder builderPrice=new StringBuilder(args[args.length-2]);
                    String stringPrice=new String(Obrabotka(builderPrice,8));

                    StringBuilder builderId=new StringBuilder(args[1]);
                    String stringId=new String(Obrabotka(builderId,8));

                    StringBuilder builderProductName=new StringBuilder();
                    for (int i = 2; i < args.length-2; i++) {
                        builderProductName.append(args[i]).append(" ");
                    }
                    String stringProductName=new String(Obrabotka(builderProductName,30));

                    String stringResult=new String(stringId+stringProductName+stringPrice+stringQuantity);

                    ArrayList<String> arrayList=new ArrayList<>();
                    BufferedReader bufferedReader=new BufferedReader(new FileReader(new File(fileName)));
                    while (bufferedReader.ready()){
                        String str=bufferedReader.readLine();
                        if (str.isEmpty()){
                            continue;
                        }else{
                            arrayList.add(str);
                        }
                    }
                    bufferedReader.close();

                    for (int i = 0; i < arrayList.size(); i++) {
                        if (arrayList.get(i).startsWith(stringId)){
                            arrayList.set(i,stringResult);
                            break;
                        }
                    }

                    BufferedWriter bufferedWriter=new BufferedWriter(new FileWriter(new File(fileName)));
                    for (int i = 0; i < arrayList.size(); i++) {
                        bufferedWriter.write(arrayList.get(i)+"\n");
                    }
                    bufferedWriter.close();

                    break;
                /////////////////////////////////////////////////////////////////////

                /////////////////////////////////////////////////////////////////////
                case "-d":
                    StringBuilder builderId2=new StringBuilder(args[1]);
                    String stringId2=new String(Obrabotka(builderId2,8));

                    ArrayList<String> arrayList2=new ArrayList<>();
                    BufferedReader bufferedReader2=new BufferedReader(new FileReader(new File(fileName)));
                    while (bufferedReader2.ready()){
                        String str=bufferedReader2.readLine();
                        if (str.isEmpty()){
                            continue;
                        }else{
                            arrayList2.add(str);
                        }
                    }
                    bufferedReader2.close();

                    for (int i = 0; i < arrayList2.size(); i++) {
                        if (arrayList2.get(i).startsWith(stringId2)){
                            arrayList2.remove(i);
                            i--;
                            break;
                        }
                    }

                    BufferedWriter bufferedWriter2=new BufferedWriter(new FileWriter(new File(fileName)));
                    for (int i = 0; i < arrayList2.size(); i++) {
                        bufferedWriter2.write(arrayList2.get(i)+"\n");
                    }
                    bufferedWriter2.close();


                    break;
                /////////////////////////////////////////////////////////////////////
            }
        }
    }

    public static String Obrabotka(StringBuilder builder,int i){
        String stringTemp=new String();
        if (i<builder.length()){
            stringTemp=builder.substring(0,i).toString();
        }else{
            for (int j = builder.length(); j < i; j++) {
                builder.append(" ");
            }
            stringTemp=builder.toString();
        }
        return stringTemp;
    }
}
