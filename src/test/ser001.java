package test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Created by maxim on 06.07.2015.
 */
public class ser001 {
    static class Person implements Serializable{
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
        try(ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(new File("D:/TEMP/111.txt")))){
            Person p=new Person("Jon",33,178,true);
            oos.writeObject(p);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
