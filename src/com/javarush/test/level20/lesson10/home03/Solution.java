package com.javarush.test.level20.lesson10.home03;

import java.io.*;

/* Найти ошибки
Почему-то при сериализации/десериализации объекта класса B возникают ошибки.
Найдите проблему и исправьте ее.
Класс A не должен реализовывать интерфейсы Serializable и Externalizable.
Сигнатура класса В не содержит ошибку :)
*/
public class Solution implements Serializable {
    public static class A {

        public A() {
        }

        protected String name = "A";

        public A(String name) {
            this.name += name;
        }
    }

    public class B extends A implements Serializable {
        public B(String name) {
            super(name);
            this.name += name;
        }
        private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
            //s.defaultReadObject();
            name = (String)s.readObject();
        }
        private void writeObject(ObjectOutputStream s) throws IOException {
            //s.defaultWriteObject();
            s.writeObject(name);
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException
    {
        Solution s = new Solution();
        B b = s.new B("B");
        System.out.println(b.name);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("D:/TEMP/111.txt"));
        objectOutputStream.writeObject(b);
        objectOutputStream.close();
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("D:/TEMP/111.txt"));
        B bDes;
        bDes = (B) objectInputStream.readObject();
        System.out.println("b:    " + b.toString() + " " + b.name);
        System.out.println("bDes: " + bDes.toString() + " " + bDes.name);
        objectInputStream.close();
    }
}
