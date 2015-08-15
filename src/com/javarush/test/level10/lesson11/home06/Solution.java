package com.javarush.test.level10.lesson11.home06;

/* Конструкторы класса Human
Напиши класс Human с 6 полями. Придумай и реализуй 10 различных конструкторов для него. Каждый конструктор должен иметь смысл.
*/

public class Solution
{
    public static void main(String[] args)
    {
        //
    }

    public static class Human
    {
        //напишите тут ваши переменные и конструкторы
        String name;
        int a;
        int b;
        int c;
        int d;
        int e;

        public Human(){
            //
        }
        public Human(String name){
            this.name=name;
        }
        public Human(String name,int a){
            this.name=name;
            this.a=a;
        }
        public Human(String name,int a,int b){
            this.name=name;
            this.a=a;
            this.b=b;
        }
        public Human(String name,int a,int b,int c){
            this.name=name;
            this.a=a;
            this.b=b;
            this.c=c;
        }
        public Human(String name,int a,int b,int c,int d){
            this.name=name;
            this.a=a;
            this.b=b;
            this.c=c;
            this.d=d;
        }
        public Human(String name,int a,int b,int c,int d,int e){
            this.name=name;
            this.a=a;
            this.b=b;
            this.c=c;
            this.d=d;
            this.e=e;
        }
        public Human(Human human){
            human.toString();
        }
        public Human(Human human,String name){
            human.toString();
            this.name=name;
        }
        public Human(Human human,String name,int a){
            human.toString();
            this.name=name;
            this.a=a;
        }
    }
}
