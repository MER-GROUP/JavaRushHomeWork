package com.javarush.test.level22.lesson13.task02;

import java.io.*;

/* Смена кодировки
В метод main первым параметром приходит имя файла, тело которого в кодировке Windows-1251.
В метод main вторым параметром приходит имя файла, в который необходимо записать содержимое первого файла в кодировке UTF-8.
*/
public class Solution {
    static String win1251TestString = "РќР°СЂСѓС€РµРЅРёРµ РєРѕРґРёСЂРѕРІРєРё РєРѕРЅСЃРѕР»Рё?"; //only for your testing

    public static void main(String[] args) throws IOException {
        FileInputStream fis1 = new FileInputStream(args[0]);
        FileOutputStream fos = new FileOutputStream(args[1]);
        byte[]buffer = new byte[fis1.available()];
        fis1.read(buffer);
        String s = new String(buffer,"UTF-8");
        buffer = s.getBytes("windows-1251");
        fos.write(buffer);
        fis1.close();
        fos.close();
    }
}
