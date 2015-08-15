package com.javarush.test.level05.lesson07.task05;

/* Создать класс прямоугольник (Rectangle)
Создать класс прямоугольник (Rectangle). Его данными будут top, left, width, height
(левая координата, верхняя, ширина и высота). Создать для него как можно больше методов initialize(…)
Примеры:
-	заданы 4 параметра: left, top, width, height
-	ширина/высота не задана (оба равны 0)
-	высота не задана (равно ширине) создаём квадрат
-	создаём копию другого прямоугольника (он и передаётся в параметрах)
*/

public class Rectangle
{
    //Напишите тут ваш код
    int left, top, width, height;

    public void initialize(int left,int top,int width,int height)//заданы 4 параметра: left, top, width, height
    {
        this.left=left;
        this.top=top;
        this.width=width;
        this.height=height;
    }

    public void initialize(int left,int top)//ширина/высота не задана (оба равны 0)
    {
        this.left=left;
        this.top=top;
        this.width=0;
        this.height=0;
    }

    public void initialize(int left,int top,int width)//высота не задана (равно ширине) создаём квадрат
    {
        this.left=left;
        this.top=top;
        this.height=width;
        this.width=width;
    }

    public void initialize(Rectangle rectangle)//создаём копию другого прямоугольника (он и передаётся в параметрах)
    {
        Rectangle rect=rectangle;
    }

    public static void main(String[] args)
    {
        //
    }

}
