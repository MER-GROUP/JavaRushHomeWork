package com.javarush.test.level18.lesson08.task04;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/* UnsupportedFileName
Измените класс TxtInputStream так, чтобы он работал только с txt-файлами (*.txt)
Например, first.txt или name.1.part3.txt
Если передан не txt-файл, например, file.txt.exe, то конструктор должен выбрасывать исключение UnsupportedFileNameException
*/

public class TxtInputStream extends FileInputStream {

    public TxtInputStream(String fileName) throws FileNotFoundException, UnsupportedFileNameException {
        super(fileName);
        if (fileName.contains(".")){
            int point=fileName.lastIndexOf(".")+1;
            int three=fileName.length()-point;
//            System.out.println("point = "+point);
//            System.out.println("three = "+three);
//            System.out.println("fileName.length() = "+fileName.length());
            if (3==three){
                if (fileName.endsWith("txt")){
                    //
                }else {
                    throw new UnsupportedFileNameException();
                }
            }else{
                throw new UnsupportedFileNameException();
            }
        }else{
            throw new UnsupportedFileNameException();
        }
    }

    public static void main(String[] args) throws FileNotFoundException, UnsupportedFileNameException {
//        String fileName="D:/TEMP/111.txt";
//        String fileName="D:/TEMP/1.jpg";
//        TxtInputStream txtInputStream=new TxtInputStream(fileName);
    }

}

