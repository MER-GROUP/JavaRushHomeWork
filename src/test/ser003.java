package test;

import com.javarush.test.level20.lesson02.task05.Solution;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by maxim on 06.07.2015.
 */
public class ser003 {
    static class Person implements Serializable {
        public String name;
        public int age;
        public double height;
        public boolean married;

        public Person(String name, int age, double height, boolean married) {
            this.name = name;
            this.age = age;
            this.height = height;
            this.married = married;
        }
    }

    public static void main(String[] args) {
        String fileName="D:/TEMP/111.txt";
        ArrayList<Person> people=new ArrayList<Person>();
        people.add(new Person("Tom", 30, 175, false));
        people.add(new Person("Jon", 33, 178, true));
        try(ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(new File(fileName)))){
            oos.writeObject(people);
            System.out.println("Запись произведена");
        }catch (Exception e){
            e.printStackTrace();
        }
        ArrayList<Person> newPeople=null;
        try(ObjectInputStream ois=new ObjectInputStream(new FileInputStream(new File(fileName)))){
            newPeople=(ArrayList<Person>)ois.readObject();
        }catch (Exception e){
            e.printStackTrace();
        }
        for (Person p:newPeople){
            System.out.println(p.name);
            System.out.println(p.age);
        }
    }
}
