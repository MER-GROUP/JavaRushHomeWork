package com.javarush.test.level17.lesson10.bonus01;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* CRUD
CrUD - Create, Update, Delete
Программа запускается с одним из следующих наборов параметров:
-c name sex bd
-u id name sex bd
-d id
-i id
Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-с  - добавляет человека с заданными параметрами в конец allPeople, выводит id (index) на экран
-u  - обновляет данные человека с данным id
-d  - производит логическое удаление человека с id
-i  - выводит на экран информацию о человеке с id: name sex (м/ж) bd (формат 15-Apr-1990)

id соответствует индексу в списке
Все люди должны храниться в allPeople
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat

Пример параметров: -c Миронов м 15/04/1990
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();
    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException
    {
        //start here - начни тут
        if (args.length < 2) return;

        if (args[0].equals("-c") && args.length>=4)
        {
            Person person = null;
            int findIndex = 0;
            String name = "";
            for (int i = 1; i < args.length; i++)
            {
                if(args[i].equals("м") | args[i].equals("ж"))
                {
                    findIndex = i;
                    name = name.substring(0, name.length() - 1);
                    break;
                }
                else
                {
                    name = name + args[i] + " ";
                }
            }
            String sex = args[findIndex];
            Date bd = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(args[findIndex+1]);

            if (sex.equals("м")) person = Person.createMale(name, bd);
            if (sex.equals("ж")) person = Person.createFemale(name, bd);

            allPeople.add(person);

            System.out.println(allPeople.indexOf(person));
        }

        if (args[0].equals("-u") && args.length>=5)
        {
            Person person = null;
            int id = Integer.parseInt(args[1]);
            int findIndex = 0;
            String name = "";
            for (int i = 2; i < args.length; i++)
            {
                if(args[i].equals("м") | args[i].equals("ж"))
                {
                    findIndex = i;
                    name = name.substring(0, name.length() - 1);
                    break;
                }
                else
                {
                    name = name + args[i] + " ";
                }
            }

            String sex = args[findIndex];
            Date bd = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(args[findIndex + 1]);

            if (sex.equals("м")) person = Person.createMale(name, bd);
            if (sex.equals("ж")) person = Person.createFemale(name, bd);

            allPeople.set(id, person);
        }

        if (args[0].equals("-d") && args.length==2)
        {
            int id = Integer.parseInt(args[1]);

//            allPeople.remove(id);
            allPeople.set(id,null);
        }

        if (args[0].equals("-i") && args.length==2)
        {
            int id = Integer.parseInt(args[1]);
            Person p = allPeople.get(id);
            String sex = null;
            String bd = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH).format(p.getBirthDay());

            if (p.getSex().equals(Sex.MALE))  sex = "м";
            if (p.getSex().equals(Sex.FEMALE))  sex = "ж";

            System.out.println(p.getName() + " " + sex + " " + bd);
        }
    }
}