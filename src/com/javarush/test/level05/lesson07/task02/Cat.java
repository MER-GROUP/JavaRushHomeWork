package com.javarush.test.level05.lesson07.task02;

/* Создать класс Cat
Создать класс Cat (кот) с пятью инициализаторами:
- Имя,
- Имя, вес, возраст
- Имя, возраст (вес стандартный)
- вес, цвет, (имя, адрес и возраст неизвестны, это бездомный кот)
- вес, цвет, адрес ( чужой домашний кот)
Задача инициализатора – сделать объект валидным.
Например, если вес неизвестен, то нужно указать какой-нибудь средний вес.
Кот не может ничего не весить. То же касательно возраста. А вот имени может и не быть (null).
То же касается адреса: null.
*/

public class Cat
{
    //Напишите тут ваш код
    String name;
    int ves;
    int age;
    String colour,adres;

    public void initialize(String name)//Имя,
    {
        this.name=name;
    }

    public void initialize(String name,int ves,int age)//Имя, вес, возраст
    {
        this.name=name;
        this.ves=ves;
        this.age=age;
    }

    public void initialize(String name,int age)//Имя, возраст (вес стандартный)
    {
        this.name=name;
        this.ves=5;
        this.age=age;
    }

    public void initialize(int ves,String colour)//вес, цвет, (имя, адрес и возраст неизвестны, это бездомный кот)
    {
        this.name=null;
        this.ves=ves;
        this.colour=colour;
        this.age=2;
        this.adres=null;
    }

    public void initialize(int ves,String colour,String adres)//вес, цвет, адрес ( чужой домашний кот)
    {
        this.ves=ves;
        this.colour=colour;
        this.adres=adres;
    }

    public static void main(String[] args)
    {
        //
    }

}
