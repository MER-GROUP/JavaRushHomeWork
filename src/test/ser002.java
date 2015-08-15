package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;

/**
 * Created by maxim on 06.07.2015.
 */
public class ser002 {
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
        try(ObjectInputStream ois=new ObjectInputStream(new FileInputStream(new File("D:/TEMP/111.txt")))){
            //Person p= (Person)ois.readObject();
            Person p=(Person)ois.readObject();
            System.out.println(p.name);
            System.out.println(p.age);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
