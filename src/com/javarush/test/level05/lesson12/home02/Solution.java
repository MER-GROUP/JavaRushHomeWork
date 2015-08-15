package com.javarush.test.level05.lesson12.home02;

/* Man and Woman
1. Внутри класса Solution создай public static классы Man и Woman.
2. У классов должны быть поля: name(String), age(int), address(String).
3. Создай конструкторы, в которые передаются все возможные параметры.
4. Создай по два объекта каждого класса со всеми данными используя конструктор.
5. Объекты выведи на экран в таком формате [name + " " + age + " " + address].
*/

public class Solution
{
    public static void main(String[] args)
    {
        // Создай по два объекта каждого класса тут
        Man man1=new Man("max");
        Man man2=new Man("max",3,"lll");
        Woman woman1=new Woman("lena");
        Woman woman2=new Woman("lena",2,"222");

        // Выведи их на экран тут
        System.out.println(man2.name + " " + man2.age + " " + man2.address);
        System.out.println(woman2.name + " " + woman2.age + " " + woman2.address);
    }

    // Напиши тут свои классы
    public static class Man
    {
        String name,address;
        int age;

        public Man(String name)
        {
            this.name=name;
        }

        public Man(String name,int age)
        {
            this.name=name;
            this.age=age;
        }

        public Man(String name,int age,String address)
        {
            this.name=name;
            this.age=age;
            this.address=address;
        }
    }

    public static class Woman
    {
        String name,address;
        int age;

        public Woman(String name)
        {
            this.name=name;
        }

        public Woman(String name,int age)
        {
            this.name=name;
            this.age=age;
        }

        public Woman(String name,int age,String address)
        {
            this.name=name;
            this.age=age;
            this.address=address;
        }
    }
}
