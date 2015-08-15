package com.javarush.test.level17.lesson10.bonus02;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* CRUD 2
CrUD Batch - multiple Creation, Updates, Deletion
!!!РЕКОМЕНДУЕТСЯ выполнить level17.lesson10.bonus01 перед этой задачей!!!

Программа запускается с одним из следующих наборов параметров:
-c name1 sex1 bd1 name2 sex2 bd2 ...
-u id1 name1 sex1 bd1 id2 name2 sex2 bd2 ...
-d id1 id2 id3 id4 ...
-i id1 id2 id3 id4 ...
Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-с  - добавляет всех людей с заданными параметрами в конец allPeople, выводит id (index) на экран в соответствующем порядке
-u  - обновляет соответствующие данные людей с заданными id
-d  - производит логическое удаление всех людей с заданными id
-i  - выводит на экран информацию о всех людях с заданными id: name sex bd

id соответствует индексу в списке
Формат вывода даты рождения 15-Apr-1990
Все люди должны храниться в allPeople
Порядок вывода данных соответствует вводу данных
Обеспечить корректную работу с данными для множества нитей (чтоб не было затирания данных)
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();
    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        if (args[0].equals("-c")){
            create(args);
        }
        else if (args[0].equals("-u")){
            update(args);
        }

        else if (args[0].equals("-d")){
            delete(args);
        }

        else if (args[0].equals("-i")){
            select(args);
        }
        else {
            //return;
        }
        SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yyyy",Locale.ENGLISH);
        for (Person person:allPeople){
            System.out.println(
                    person.getName() +
                            " " +
                            (person.getSex().equals(Sex.MALE) ? "м" : (person.getSex().equals(Sex.FEMALE) ? "ж" : "")) + " " +
                            ((person.getBirthDay() != null) ? format.format(person.getBirthDay()) : person.getBirthDay()));
        }

    }

    public static synchronized void create (String array[]){

        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        Date date;
        Person person;

        for (int i = 1; i < array.length; i++) {
            if (array[i].equals("м")){
                try {
                    date = format.parse(array[++i]);
                    --i;
                    person = Person.createMale(array[--i], date);
                    ++i;
                    allPeople.add(person);
                    System.out.println(allPeople.indexOf(person));
                }
                catch (ParseException e){
                }
            }
            if (array[i].equals("ж")){
                try {
                    date = format.parse(array[++i]);
                    --i;
                    person = Person.createFemale(array[--i], date);
                    ++i;
                    allPeople.add(person);
                    System.out.println(allPeople.indexOf(person));
                }
                catch (ParseException e){
                }
            }
        }
    }

    public static synchronized void update (String array[]){

        int index, count;
        Date date;
        Person person;
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy",Locale.ENGLISH);

        for (int i = 1; i < array.length; i++) {
            if (array[i].equals("м")){

                count = i - 2;
                index = Integer.parseInt(array[count]);
                if (index < allPeople.size()) {
                    person = allPeople.get(index);
                }
                else return;

                count = i - 1;
                person.setName(array[count]);

                person.setSex(Sex.MALE);

                try
                {
                    count = i + 1;
                    date = format.parse(array[count]);
                    person.setBirthDay(date);
                }
                catch (Exception e){
                }
            }

            if (array[i].equals("ж")){

                count = i - 2;
                index = Integer.parseInt(array[count]);
                if (index < allPeople.size()) {
                    person = allPeople.get(index);
                }
                else return;

                count = i - 1;
                person.setName(array[count]);

                person.setSex(Sex.FEMALE);

                try
                {
                    count = i + 1;
                    date = format.parse(array[count]);
                    person.setBirthDay(date);
                }
                catch (Exception e){
                }
            }
        }

    }

    public static synchronized void delete (String array[]){

        int index;
        Person person;

        for (int i = 1; i < array.length; i++) {
            index = Integer.parseInt(array[i]);
            if (index < allPeople.size()) {
                person = allPeople.get(index);
                person.setName(null);
                person.setSex(null);
                person.setBirthDay(null);
            }
        }
    }

    public static void select (String array[]){

        Person person;
        int index;
        SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yyyy",Locale.ENGLISH);

        for (int i = 1; i < array.length; i++) {
            index = Integer.parseInt(array[i]);
            if (index < allPeople.size()) {
                person = allPeople.get(index);
                System.out.println(
                        person.getName() +
                                " " +
                                    (person.getSex().equals(Sex.MALE) ? "м" : (person.getSex().equals(Sex.FEMALE) ? "ж" : "")) + " " +
                                            ((person.getBirthDay() != null) ? format.format(person.getBirthDay()) : person.getBirthDay()));
            }
        }
    }
}