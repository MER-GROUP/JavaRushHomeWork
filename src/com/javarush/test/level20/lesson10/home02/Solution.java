package com.javarush.test.level20.lesson10.home02;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/* Десериализация
На вход подается поток, в который записан сериализованный объект класса A либо класса B.
Десериализуйте объект в методе getOriginalObject предварительно определив, какого именно типа там объект.
Реализуйте интерфейс Serializable где необходимо.
*/
public class Solution implements Serializable{
    public A getOriginalObject(ObjectInputStream objectStream) throws IOException, ClassNotFoundException
    {
//        A a= (A)objectStream.readObject();
//        if (a instanceof A){
//            return (A)a;
//        }else {
//            return (B)a;
//        }

//        Object obj = objectStream.readObject();
//        if(obj instanceof A)
//            return (A)obj;
//        else
//            return null;

        A a = (A) objectStream.readObject();
        if (a instanceof B)
            return (B) a;
        else
            return a;
    }

    public class A implements Serializable {
    }

    public class B extends A {
        public B() {
            System.out.println("inside B");
        }
    }
}
