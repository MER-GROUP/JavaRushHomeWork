package com.javarush.test.level06.lesson11.bonus02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* Нужно добавить в программу новую функциональность
Задача: У каждой кошки есть имя и кошка-мама. Создать класс, который бы описывал данную ситуацию. Создать два объекта: кошку-дочь и кошку-маму. Вывести их на экран.
Новая задача: У каждой кошки есть имя, кошка-папа и кошка-мама. Изменить класс Cat так, чтобы он мог описать данную ситуацию.
Создать 6 объектов: маму, папу, сына, дочь, бабушку(мамина мама) и дедушку(папин папа).
Вывести их всех на экран в порядке: дедушка, бабушка, папа, мама, сын, дочь.

Пример ввода:
дедушка Вася
бабушка Мурка
папа Котофей
мама Василиса
сын Мурчик
дочь Пушинка

Пример вывода:
Cat name is дедушка Вася, no mother, no father
Cat name is бабушка Мурка, no mother, no father
Cat name is папа Котофей, no mother, father is дедушка Вася
Cat name is мама Василиса, mother is бабушка Мурка, no father
Cat name is сын Мурчик, mother is мама Василиса, father is папа Котофей
Cat name is дочь Пушинка, mother is мама Василиса, father is папа Котофей
*/

/*public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

//        String motherName = reader.readLine();
//        Cat catMother = new Cat(motherName);
//
//        String daughterName = reader.readLine();
//        Cat catDaughter = new Cat(daughterName, catMother);

        String ded=reader.readLine();
        Cat DED=new Cat(ded);
        DED.setDed(ded);

        String baba=reader.readLine();
        Cat BABA=new Cat(baba);
        BABA.setBaba(baba);

        String papa=reader.readLine();
        Cat PAPA=new Cat(papa);
        PAPA.setPapa(papa);

        String mama=reader.readLine();
        Cat MAMA=new Cat(mama);
        MAMA.setMama(mama);

        String san=reader.readLine();
        Cat SAN=new Cat(san);
        SAN.setSan(san);

        String dote=reader.readLine();
        Cat DOTE=new Cat(dote);
        DOTE.setDote(dote);

//        System.out.println(catMother);
//        System.out.println(catDaughter);

        System.out.println(DED);
        System.out.println(BABA);
        System.out.println(PAPA);
        System.out.println(MAMA);
        System.out.println(SAN);
        System.out.println(DOTE);
    }

    public static class Cat
    {
        private String name="";
        private Cat parent;
        private static String ded="",baba="",papa="",mama="",san="",dote="";

        Cat(String name)
        {
            this.name = name;
        }

        Cat(String name, Cat parent)
        {
            this.name = name;
            this.parent = parent;
        }

        public void setDed(String ded)//ded
        {
        this.ded=ded;
        }

        public void setBaba(String baba)//baba
        {
            this.baba=baba;
        }

        public void setPapa(String papa)//papa
        {
            this.papa=papa;
        }

        public void setMama(String mama)//mama
        {
            this.mama=mama;
        }

        public void setSan(String san)//san
        {
            this.san=san;
        }

        public void setDote(String dote)//dote
        {
            this.dote=dote;
        }

        @Override
        public String toString()
        {
//            if (parent == null)
//                return "Cat name is " + name + ", no mother ";
//            else
//                return "Cat name is " + name + ", mother is " + parent.name;
            if (ded.equals(name))/////////////////////////////////////////////////
//            if (ded==name)//можно и так
            {
                return ("Cat name is " + this.ded + ", no mother, no father");
            }
            if (baba.equals(name))/////////////////////////////////////////////////
            {
                return ("Cat name is " + this.baba + ", no mother, no father");
            }
            if (papa.equals(name))/////////////////////////////////////////////////
            {
                return ("Cat name is " + this.papa + ", no mother, father is "+this.ded);
            }
            if (mama.equals(name))////////////////////////////////////////////////////////
            {
                return ("Cat name is " + this.mama + ", mother is "+this.baba+", no father");
            }
            if (san.equals(name))////////////////////////////////////////////////////////////
            {
                return ("Cat name is " + this.san + ", mother is "+this.mama+", father is "+this.papa);
            }
            if(dote.equals(name))/////////////////////////////////////////////////////////////////////////////////////
            {
                return ("Cat name is " + Cat.dote + ", mother is "+Cat.mama+", father is "+Cat.papa);
            }
            return "ERROR...";
        }
    }

}*/
/*public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String catGrandpaName = reader.readLine();
        Cat catGrandpa = new Cat(catGrandpaName);

        String catGrannyName = reader.readLine();
        Cat catGranny = new Cat(catGrannyName);

        String fatherName = reader.readLine();
        Cat catFather = new Cat(fatherName, null, catGrandpa);

        String matherName = reader.readLine();
        Cat catMather = new Cat(matherName, catGranny, null);


        String sonName = reader.readLine();
        Cat catSon = new Cat(sonName, catMather, catFather);

        String daughterName = reader.readLine();
        Cat catDaughter = new Cat(daughterName, catMather, catFather);

        System.out.println(catGrandpa);
        System.out.println(catGranny);
        System.out.println(catFather);
        System.out.println(catMather);
        System.out.println(catSon);
        System.out.println(catDaughter);
    }

    public static class Cat
    {
        private String name;
        private Cat father;
        private Cat mother;


        Cat(String name)
        {
            this.name = name;
        }

        Cat(String name, Cat mother, Cat father)
        {
            this.name = name;
            this.mother = mother;
            this.father = father;

        }
        public String getMother()
        {
            return this.mother.name;
        }

        public String getFather()
        {
            return this.father.name;
        }

        @Override
        public String toString()
        {
            String str="";
            if ((this.mother == null) && (this.father == null))
                str = "Cat name is " + this.name + ", no mother" + ", no father";
            if ((this.mother == null) && (this.father != null))
                str = "Cat name is " + this.name + ", no mother" + ", father is " + father.name;
            if ((this.mother != null) && (this.father == null))
                str = "Cat name is " + this.name + ", mother is " + mother.name + ", no father";
            if ((this.mother != null) && (this.father != null))
                str = "Cat name is " + this.name + ", mother is " + mother.name + ", father is " + father.name;
            return str;
        }

    }
}*/
public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String dedName = reader.readLine();
        String babName = reader.readLine();
        String fatherName = reader.readLine();
        String motherName = reader.readLine();
        String sonName = reader.readLine();
        String daughterName = reader.readLine();

        Cat catDed = new Cat(dedName, null, null);

        Cat catBab = new Cat(babName, null, null);

        Cat catFather = new Cat(fatherName, catDed, null);

        Cat catMother = new Cat(motherName, null, catBab);

        Cat catSon = new Cat(sonName, catFather, catMother);

        Cat catDaughter = new Cat(daughterName, catFather, catMother);

        System.out.println(catDed);
        System.out.println(catBab);
        System.out.println(catFather);
        System.out.println(catMother);
        System.out.println(catSon);
        System.out.print(catDaughter);
    }

    public static class Cat
    {
        private String name;
        private Cat parentF;
        private Cat parentM;

        Cat(String name)
        {
            this.name=name;
        }

        Cat(String name, Cat parentF, Cat parentM)
        {
            this.name = name;
            this.parentF = parentF;
            this.parentM = parentM;
        }

        @Override
        public String toString()
        {
            return "Cat name is " + name +
                    ((parentM != null) ? ", mother is " + parentM.name : ", no mother") +
                    ((parentF != null) ? ", father is " + parentF.name : ", no father");
        }
    }

}

