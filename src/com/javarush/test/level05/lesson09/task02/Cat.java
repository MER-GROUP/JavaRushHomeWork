package com.javarush.test.level05.lesson09.task02;

/* Создать класс Cat
Создать класс Cat (кот) с пятью конструкторами:
- Имя,
- Имя, вес, возраст
- Имя, возраст (вес стандартный)
- вес, цвет, (имя, адрес и возраст – неизвестные. Кот - бездомный)
- вес, цвет, адрес ( чужой домашний кот)
Задача инициализатора – сделать объект валидным. Например, если вес не известен,
то нужно указать какой-нибудь средний вес. Кот не может ничего не весить.
То же касательно возраста. А вот имени может и не быть (null). То же касается адреса: null.
*/

public class Cat
{
    //Напишите тут ваш код
    String name,color,adres;
    int ves,age;

    public Cat(String name)//Имя,
    {
        this.name=name;
    }

    public Cat(String name,int ves, int age)//Имя, вес, возраст
    {
        this.name=name;
        this.ves=ves;
        this.age=age;
    }

    public Cat(String name,int age)//Имя, возраст (вес стандартный)
    {
        this.name=name;
        this.ves=5;
        this.age=age;
    }

    public Cat(int ves,String color)//вес, цвет, (имя, адрес и возраст – неизвестные. Кот - бездомный)
    {
        this.ves=ves;
        this.color=color;
        this.name=null;
        this.adres=null;
        this.age=2;
    }

    public Cat(int ves,String color,String adres)//вес, цвет, адрес ( чужой домашний кот)
    {
        this.ves=ves;
        this.color=color;
        this.adres=adres;
    }

    public static void main(String[] args)
    {
        //
    }

}
