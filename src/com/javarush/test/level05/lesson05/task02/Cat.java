package com.javarush.test.level05.lesson05.task02;

/* Реализовать метод fight
Реализовать метод boolean fight(Cat anotherCat):
реализовать механизм драки котов в зависимости от их веса, возраста и силы.
Зависимость придумать самому. Метод должен определять, выиграли ли мы (this) бой или нет,
т.е. возвращать true, если выиграли и false - если нет.
Должно выполняться условие:
если cat1.fight(cat2) = true , то cat2.fight(cat1) = false
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Cat
{
    public String name;
    public int age;
    public int weight;
    public int strength;

    public Cat()
    {
    }

    public boolean fight (Cat anotherCat)
    {
        //Напишите тут ваш код
        if (this.age>anotherCat.age) return true;
        else return false;

    }

    public static void main(String[] args) throws IOException
    {
        Cat cat1=new Cat(), cat2=new Cat();
//        Cat cat1=new Cat();
//        Cat cat2=new Cat();
//        cat1.age=Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)));
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        cat1.age=Integer.parseInt(reader.readLine());
        cat2.age=Integer.parseInt(reader.readLine());
        cat1.fight(cat2);
    }
}
