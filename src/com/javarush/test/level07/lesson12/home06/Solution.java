package com.javarush.test.level07.lesson12.home06;

/* Семья
Создай класс Human с полями имя(String), пол(boolean),возраст(int), отец(Human), мать(Human). Создай объекты и заполни их так,
чтобы получилось: Два дедушки, две бабушки, отец, мать, трое детей. Вывести объекты на экран.
Примечание:
Если написать свой метод String toString() в классе Human, то именно он будет использоваться при выводе объекта на экран.
Пример вывода:
Имя: Аня, пол: женский, возраст: 21, отец: Павел, мать: Катя
Имя: Катя, пол: женский, возраст: 55
Имя: Игорь, пол: мужской, возраст: 2, отец: Михаил, мать: Аня
…
*/

public class Solution
{
    public static void main(String[] args)
    {
        //Написать тут ваш код
        Human DED1=new Human("DED1",true,70);
        Human DED2=new Human("DED2",true,76);
        Human BABA1=new Human("BABA1",false,60);
        Human BABA2=new Human("BABA2",false,62);
        Human FATHER=new Human("FATHER",true,30,DED1,BABA1);
        Human MOTHER=new Human("MOTHER",false,36,DED2,BABA2);
        Human CHILD1=new Human("CHILD1",true,8,FATHER,MOTHER);
        Human CHILD2=new Human("CHILD2",false,5,FATHER,MOTHER);
        Human CHILD3=new Human("CHILD3",true,2,FATHER,MOTHER);

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
        boolean sex;
        int age;
        Human father,mother;

        public Human(String name,boolean sex,int age)
        {
            this.name=name;
            this.sex=sex;
            this.age=age;
        }

        public Human(String name,boolean sex,int age,Human father,Human mother)
        {
            this.name=name;
            this.sex=sex;
            this.age=age;
            this.father=father;
            this.mother=mother;
        }

        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null)
                text += ", отец: " + this.father.name;

            if (this.mother != null)
                text += ", мать: " + this.mother.name;

            return text;
        }
    }

}
