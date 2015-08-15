package com.javarush.test.level08.lesson11.home06;

/* Вся семья в сборе
1. Создай класс Human с полями имя (String), пол (boolean), возраст (int), дети (ArrayList<Human>).
2. Создай объекты и заполни их так, чтобы получилось: два дедушки, две бабушки, отец, мать, трое детей.
3. Вывести все объекты Human на экран.
*/

import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args)
    {
        //Написать тут ваш код
        ArrayList<Human> CHILDREN0 = new ArrayList<Human>();

        Human CHILD1=new Human("CHILD1",false,14,CHILDREN0);
        Human CHILD2=new Human("CHILD2",true,12,CHILDREN0);
        Human CHILD3=new Human("CHILD3",false,8,CHILDREN0);

        ArrayList<Human> CHILDREN = new ArrayList<Human>();
        CHILDREN.add(CHILD1);
        CHILDREN.add(CHILD2);
        CHILDREN.add(CHILD3);

        Human FATHER=new Human("FATHER",true,40,CHILDREN);
        Human MOTHER=new Human("MOTHER",false,35,CHILDREN);

        ArrayList<Human> CHILDREN2 = new ArrayList<Human>();
        CHILDREN2.add(FATHER);
        ArrayList<Human> CHILDREN3 = new ArrayList<Human>();
        CHILDREN3.add(MOTHER);

        Human BABA1=new Human("BABA1",false,73,CHILDREN2);
        Human BABA2=new Human("BABA2",false,68,CHILDREN3);

        Human DED1=new Human("DED1",true,86,CHILDREN2);
        Human DED2=new Human("DED2",true,82,CHILDREN3);

        System.out.println(DED1);
        System.out.println(DED2);
        System.out.println(BABA1);
        System.out.println(BABA2);
        System.out.println(FATHER);
        System.out.println(MOTHER);
        System.out.println(CHILD1);
        System.out.println(CHILD2);
        System.out.println(CHILD3);

    }

    public static class Human
    {
        //Написать тут ваш код
        String name;
        Boolean sex;
        int age;
        ArrayList<Human> children=new ArrayList<Human>();

        public Human(String name,Boolean sex,int age, ArrayList<Human> children)
        {
            this.name=name;
            this.sex=sex;
            this.age=age;
            this.children=children;
        }

        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0)
            {
                text += ", дети: "+this.children.get(0).name;

                for (int i = 1; i < childCount; i++)
                {
                    Human child = this.children.get(i);
                    text += ", "+child.name;
                }
            }

            return text;
        }
    }

}
