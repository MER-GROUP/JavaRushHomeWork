package com.javarush.test.level18.lesson10.bonus02;

/* Прайсы
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается со следующим набором параметров:
-c productName price quantity
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-c  - добавляет товар с заданными параметрами в конец файла, генерирует id самостоятельно, инкрементируя максимальный id

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
    public static void main(String[] args) throws Exception {
        if (3>args.length){
            return;
        }else{
            switch (args[0]){
                case "-c":
                    BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
                    String fileName=bufferedReader.readLine();
                    bufferedReader.close();

                    StringBuilder builderProductName=new StringBuilder();
                    for (int i = 1; i < args.length-2; i++) {
                        builderProductName.append(args[i]).append(" ");
                    }

                    String stringProductName=new String();
                    if (30<builderProductName.length()){
                        stringProductName=builderProductName.substring(0,30).toString();
                    }else {
                        for (int i = builderProductName.length(); 30 > i; i++) {
                            builderProductName.append(" ");
                        }
                        stringProductName=builderProductName.toString();
                    }

                    StringBuilder builderPrice=new StringBuilder(args[args.length-2]);
                    String stringPrice=new String();
                    if (8<builderPrice.length()){
                        stringPrice=builderPrice.substring(0,8).toString();
                    }else{
                        for (int i = builderPrice.length(); 8 > i; i++) {
                            builderPrice.append(" ");
                        }
                        stringPrice=builderPrice.toString();
                    }

                    StringBuilder builderQuantity=new StringBuilder(args[args.length-1]);
                    String stringQuantity=new String();
                    if (4<builderQuantity.length()){
                        stringQuantity=builderQuantity.substring(0,4).toString();
                    }else{
                        for (int i = builderQuantity.length(); 4 > i; i++) {
                            builderQuantity.append(" ");
                        }
                        stringQuantity=builderQuantity.toString();
                    }

                    File file=new File(fileName);
                    ArrayList<String> arrayList=new ArrayList<>();
                    BufferedReader readerFile=new BufferedReader(new FileReader(file));
                    String stringTemp=new String();
                    while (readerFile.ready()){
                        stringTemp=readerFile.readLine();
                        arrayList.add(stringTemp);
                    }
                    readerFile.close();

                    for (int i = 0; i < arrayList.size(); i++) {
                        if (arrayList.get(i).isEmpty()){
                            arrayList.remove(i);
                            i--;
                        }
                    }

                    StringBuilder builderIdTemp=new StringBuilder();
                    StringBuilder builderId=new StringBuilder();

                    if (1>arrayList.size()){
                        builderId.append("0");
                    }else{
                        builderIdTemp.append(arrayList.get(arrayList.size()-1));
                        char chr;
                        for (int i = 0; i < builderIdTemp.length(); i++) {
                            chr=builderIdTemp.charAt(i);
                            if ('0'<=chr && '9'>=chr){
                                builderId.append(chr);
                            }else{
                                break;
                            }
                        }
                    }

                    int id=Integer.parseInt(builderId.toString());
                    id++;

                    StringBuilder builderIdTemp2=new StringBuilder(String.valueOf(id));
                    String stringId2=new String();
                    if (8<builderIdTemp2.length()){
                        stringId2=builderIdTemp2.substring(0,8).toString();
                    }else{
                        for (int i = builderIdTemp2.length(); 8 > i; i++) {
                            builderIdTemp2.append(" ");
                        }
                        stringId2=builderIdTemp2.toString();
                    }

                    String stringResult=null;
                    if (1==id){
                        stringResult=new String(stringId2+stringProductName+stringPrice+stringQuantity);
                    }else{
                        stringResult=new String("\n"+stringId2+stringProductName+stringPrice+stringQuantity);
                    }
                    BufferedWriter bufferedWriter=new BufferedWriter(new FileWriter(fileName,true));
                    bufferedWriter.write(stringResult);
                    bufferedWriter.close();

                    break;
            }
        }
    }
}

