package com.javarush.test.level05.lesson07.task03;

/* Создать класс Dog
Создать класс Dog (собака) с тремя инициализаторами:
- Имя
- Имя, рост
- Имя, рост, цвет
*/

public class Dog
{
    //Напишите тут ваш код
    String name,colour;
    int rost;

    public void initialize(String name)
    {
        this.name=name;
    }

    public void initialize(String name,int rost)
    {
        this.name=name;
        this.rost=rost;
    }

    public void initialize(String name,int rost,String colour)
    {
        this.name=name;
        this.rost=rost;
        this.colour=colour;
    }

    public static void main(String[] args)
    {
        //
    }

}
