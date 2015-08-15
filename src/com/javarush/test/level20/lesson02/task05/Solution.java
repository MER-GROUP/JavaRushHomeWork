package com.javarush.test.level20.lesson02.task05;

import java.io.*;

/* И еще раз о синхронизации
Реализуйте логику записи в файл и чтения из файла для класса Object
Метод load должен инициализировать объект данными из файла
Метод main реализован только для вас и не участвует в тестировании
*/
public class Solution {
    public static void main(java.lang.String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            //File your_file_name = File.createTempFile("your_file_name", null);
            File your_file_name = File.createTempFile("your_file_name", null,new File("D:/TEMP"));
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            Object object = new Object();
            object.string1 = new String();   //string #1
            object.string2 = new String();   //string #2
            object.save(outputStream);
            outputStream.flush();

            Object loadedObject = new Object();
            loadedObject.string1 = new String(); //string #3
            loadedObject.string2 = new String(); //string #4

            //test////////////////////////////////////////////////////////////////////////
            System.out.println("loadedObject.string1 = " + loadedObject.string1.number);//
            System.out.println("loadedObject.string2 = " + loadedObject.string2.number);//
            System.out.println("-----------------------------------------------------");//


            loadedObject.load(inputStream);
            //check here that the object variable equals to loadedObject - проверьте тут, что object и loadedObject равны
            System.out.println("loadedObject.string1 = " + loadedObject.string1.number);
            System.out.println("loadedObject.string2 = " + loadedObject.string2.number);

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }


    public static class Object {
        public String string1;
        public String string2;

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            PrintWriter printWriter=new PrintWriter(outputStream);

            java.lang.String isObject1=(this.string1!=null?"yes":"no");
            printWriter.println(isObject1);
            if ("yes".equals(isObject1)){
                printWriter.println(string1.number);
            }

            java.lang.String isObject2=(this.string2!=null?"yes":"no");
            printWriter.println(isObject2);
            if ("yes".equals(isObject2)){
                printWriter.println(string2.number);
            }

            printWriter.close();
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader reader=new BufferedReader(new InputStreamReader(inputStream));

            int countStringsTMP=countStrings;

            java.lang.String isObject1=reader.readLine();
            if ("yes".equals(isObject1)){
                countStrings=Integer.parseInt(reader.readLine())-1;
                string1=new String();
            }

            java.lang.String isObject2=reader.readLine();
            if ("yes".equals(isObject2)){
                countStrings=Integer.parseInt(reader.readLine())-1;
                string2=new String();
            }

            countStrings=countStringsTMP;

            reader.close();
        }
    }

    public static int countStrings;

    public static class String {
        private final int number;

        public String() {
            number = ++countStrings;
        }

        public void print() {
            System.out.println("string #" + number);
        }
    }
}

//public static class Object {
//    public String string1;
//    public String string2;
//
//    public void save(OutputStream outputStream) throws Exception {
//        PrintWriter printWriter = new PrintWriter(outputStream);
//        java.lang.String hasString1 = (string1 != null) ? "yes" : "no";
//        printWriter.println(hasString1);
//        currentValue = countStrings - 1;
//        java.lang.String hasString2 = (string2 != null) ? "yes" : "no";
//        printWriter.println(hasString2);
//        currentValue = currentValue--;
//        printWriter.close();
//    }
//
//    public void load(InputStream inputStream) throws Exception {
//        int tmp = countStrings;
//        countStrings = currentValue;
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
//        java.lang.String hasString1 = bufferedReader.readLine();
//        if ("yes".equals(hasString1))
//            this.string1 = new String();
//        java.lang.String hasString2= bufferedReader.readLine();
//        if ("yes".equals(hasString2))
//            this.string2 = new String();
//        bufferedReader.close();
//        countStrings = tmp;
//    }
//}
