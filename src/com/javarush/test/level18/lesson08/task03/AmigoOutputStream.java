package com.javarush.test.level18.lesson08.task03;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* AmigoOutputStream
1 Измените класс AmigoOutputStream так, чтобы он стал Wrapper-ом для класса FileOutputStream
2 При вызове метода close() должны выполняться следующая последовательность действий:
2.1 вызвать метод flush()
2.2 дописать следующий текст [JavaRush © 2012-2013 All rights reserved.], используйте метод getBytes()
2.3 закрыть поток методом close()
*/

public class AmigoOutputStream extends OutputStream
{
    public static String fileName = "C:/tmp/result.txt";
//    public static String fileName = "D:/TEMP/111.txt";

    private FileOutputStream fileOutputStream;

    public AmigoOutputStream(FileOutputStream fileOutputStream) {
        this.fileOutputStream = fileOutputStream;
    }

    @Override
    public void write(int b) throws IOException {
        fileOutputStream.write(b);
    }

    @Override
    public void close() throws IOException {
        fileOutputStream.flush();
        byte[] buff="JavaRush © 2012-2013 All rights reserved.".getBytes();
        fileOutputStream.write(buff);
        fileOutputStream.close();
    }

    public static void main(String[] args) throws IOException {
        new AmigoOutputStream(new FileOutputStream(fileName));
    }

}
