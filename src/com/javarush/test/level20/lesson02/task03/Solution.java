//package com.javarush.test.level20.lesson02.task03;
//
//import java.io.*;
//import java.util.Enumeration;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Properties;
//
///* Знакомство с properties
//В методе fillInPropertiesMap считайте имя файла с консоли и заполните карту properties данными из файла.
//Про .properties почитать тут - http://ru.wikipedia.org/wiki/.properties
//Реализуйте логику записи в файл и чтения из файла для карты properties.
//*/
//public class Solution {
//    public static Map<String, String> properties = new HashMap<>();
//
//    public void fillInPropertiesMap() throws Exception {
//        //implement this method - реализуйте этот метод
//        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
//        String fileName=reader.readLine();
//        reader.close();
//        FileInputStream inputStream=new FileInputStream(new File(fileName));
//        load(inputStream);
//        inputStream.close();
//        FileOutputStream outputStream=new FileOutputStream(new File(fileName));
//        save(outputStream);
//        outputStream.close();
//    }
//
//    public void save(OutputStream outputStream) throws Exception {
//        //implement this method - реализуйте этот метод
//        PrintStream printStream=new PrintStream(outputStream);
//        Properties prop=new Properties();
//        for (Map.Entry<String,String> entry:properties.entrySet()){
//            String key=entry.getKey();
//            String value=entry.getValue();
//            prop.setProperty(key,value);
//        }
//        prop.store(printStream,null);
//        printStream.close();
//    }
//
//    public void load(InputStream inputStream) throws Exception {
//        //implement this method - реализуйте этот метод
//        Properties prop=new Properties();
//        prop.load(inputStream);
//        Enumeration<?> e=prop.propertyNames();
//        while (e.hasMoreElements()){
//            String key=(String)e.nextElement();
//            String value=prop.getProperty(key);
//            properties.put(key,value);
//        }
//    }
//}
package com.javarush.test.level20.lesson02.task03;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/* Знакомство с properties
В методе fillInPropertiesMap считайте имя файла с консоли и заполните карту properties данными из файла.
Про .properties почитать тут - http://ru.wikipedia.org/wiki/.properties
Реализуйте логику записи в файл и чтения из файла для карты properties.
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();
    public static Properties props = new Properties();

    public static void main (String[] args) throws Exception
    {
        new Solution().fillInPropertiesMap();
        System.out.println(properties);
        new Solution().save(new FileOutputStream("d:/TEMP/1.txt"));
    }

    public void fillInPropertiesMap() throws Exception
    {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        InputStream fileProperties = new FileInputStream(bufferedReader.readLine());
        bufferedReader.close();
        load(fileProperties);
    }

    public void save(OutputStream outputStream) throws Exception {
        PrintWriter printWriter = new PrintWriter(outputStream);
        if (props.size() > 0)
            props.putAll(properties);
        props.store(outputStream, "");
        printWriter.close();
    }

    public void load(InputStream inputStream) throws Exception {
        //BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        props.load(inputStream);
        Set<String> list = props.stringPropertyNames();
        for (String current : list)
            properties.put(current, props.getProperty(current));
        //bufferedReader.close();
    }
}
