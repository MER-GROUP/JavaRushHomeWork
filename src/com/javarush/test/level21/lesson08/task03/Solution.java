package com.javarush.test.level21.lesson08.task03;

/* Запретить клонирование
Разрешите клонировать класс А
Запретите клонировать класс B
Разрешите клонировать класс C
*/
public class Solution {
    public static class A implements Cloneable {
        private int i;
        private int j;

        public A(int i, int j) {
            this.i = i;
            this.j = j;
        }

        public int getI() {
            return i;
        }

        public int getJ() {
            return j;
        }

        @Override
        protected A clone() throws CloneNotSupportedException {
            return (A)super.clone();
        }
    }

    public static class B extends A {
        private String name;

        public B(int i, int j, String name) {
            super(i, j);
            this.name = name;
        }

        public String getName() {
            return name;
        }

        @Override
        protected B clone() throws CloneNotSupportedException {
            throw  new CloneNotSupportedException();
            //return this;
        }
    }

    public static class C extends B {
        public C(int i, int j, String name) {
            super(i, j, name);
        }

        @Override
        protected C clone() throws CloneNotSupportedException {
            C c=null;
            if (this!=null){
                c=new C(this.getI(),this.getJ(),this.getName());
                return c;
            }
            return c;
        }
    }

    /*//test
    public static void main(String[] args) throws CloneNotSupportedException {
        A originA=new A(5,7);
        System.out.println("originA = "+originA);
        A cloneA=originA.clone();
        System.out.println("cloneA = "+cloneA);
        System.out.println("---------------");
        B originB=new B(2,3,"Class B");
        System.out.println("originB = "+originB);
        B cloneB= originB.clone();
        System.out.println("cloneB = "+cloneB);
        System.out.println("---------------");
        C originC=new C(10,20,"Class C");
        System.out.println("originC = "+originC);
        C cloneC=originC.clone();
        System.out.println("cloneC = "+cloneC);
    }*/
}
