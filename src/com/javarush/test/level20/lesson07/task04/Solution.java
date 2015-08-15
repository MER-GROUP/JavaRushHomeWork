package com.javarush.test.level20.lesson07.task04;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/* Externalizable Solution
Сериализуйте класс Solution.
Подумайте, какие поля не нужно сериализовать.
Объект всегда должен содержать актуальные на сегодняшний день данные.
*/
public class Solution implements Externalizable {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        System.out.println(new Solution(4));
        System.out.println("----------------------------");

        Solution solution=new Solution(10);
        System.out.println(solution);
        FileOutputStream fileOutputStream=new FileOutputStream(new File("D:/TEMP/111.txt"));
        ObjectOutputStream objectOutputStream=new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(solution);
        objectOutputStream.flush();
        objectOutputStream.close();
        System.out.println("----------------------------");

        FileInputStream fileInputStream=new FileInputStream(new File("D:/TEMP/111.txt"));
        ObjectInputStream objectInputStream=new ObjectInputStream(fileInputStream);
        Solution solution1=(Solution)objectInputStream.readObject();
        objectInputStream.close();
        System.out.println(solution1);
    }

    private final transient String pattern = "dd MMMM yyyy, EEEE";
    private transient Date currentDate;
    private transient int temperature;
    String string;

    public Solution() {
        super();
        System.out.println("temperature = " + temperature);//test
        currentDate=new Date();
        temperature=20;
        System.out.println("temperature = " + temperature);//test
    }

    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;
        System.out.println("temperature = " + temperature);//test

        string = "Today is %s, and current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    @Override
    public String toString() {
        return this.string;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(string);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        string=(String)in.readObject();
    }
}

//package com.javarush.test.level20.lesson07.task04;
//
//        import java.io.*;
//        import java.text.SimpleDateFormat;
//        import java.util.Date;
//
///* Externalizable Solution
//Сериализуйте класс Solution.
//Подумайте, какие поля не нужно сериализовать.
//Объект всегда должен содержать актуальные на сегодняшний день данные.
//*/
//public class Solution implements Serializable
//{
//    public static void main(String[] args) {
//        System.out.println(new Solution(4));
//    }
//
//    private transient final String pattern = "dd MMMM yyyy, EEEE";
//    private transient Date currentDate;
//    private transient int temperature;
//    String string;
//
//    public Solution() {}
//
//    public Solution(int temperature) {
//        this.currentDate = new Date();
//        this.temperature = temperature;
//        string = "Today is %s, and current temperature is %s C";
//        SimpleDateFormat format = new SimpleDateFormat(pattern);
//        this.string = String.format(string, format.format(currentDate), temperature);
//    }
//
//    @Override
//    public String toString() {
//        return this.string;
//    }
//
//}
