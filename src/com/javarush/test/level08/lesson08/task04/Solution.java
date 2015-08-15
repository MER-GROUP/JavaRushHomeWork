package com.javarush.test.level08.lesson08.task04;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* Удалить всех людей, родившихся летом
Создать словарь (Map<String, Date>) и занести в него десять записей по принципу: «фамилия» - «дата рождения».
Удалить из словаря всех людей, родившихся летом.
*/

public class Solution
{
    public static HashMap<String, Date> createMap()
    {
        HashMap<String, Date> map = new HashMap<String, Date>();
        map.put("Сталлоне", new Date("JUNE 1 1980"));

        //Напишите тут ваш код
        map.put("Сталлоне2", new Date("MAY 12 1980"));
        map.put("Сталлоне3", new Date("JUNE 7 1980"));
        map.put("Сталлоне4", new Date("JUNE 3 1980"));
        map.put("Сталлоне5", new Date("JULY 11 1980"));
        map.put("Сталлоне6", new Date("JUNE 9 1980"));
        map.put("Сталлоне7", new Date("AUGUST 6 1980"));
        map.put("Сталлоне8", new Date("MAY 20 1987"));
        map.put("Сталлоне9", new Date("MAY 15 1989"));
        map.put("Сталлоне10", new Date("MAY 10 2001"));

        return map;

    }

    public static void removeAllSummerPeople(HashMap<String, Date> map)
    {
        //Напишите тут ваш код
        Iterator<Map.Entry<String,Date>> iterator=map.entrySet().iterator();
        while (iterator.hasNext())
        {
            Map.Entry<String,Date> pair=iterator.next();
            if (pair.getValue().getMonth()>4 && pair.getValue().getMonth()<8) iterator.remove();
        }

    }

    public static void main(String[] args)
    {
//        HashMap<String, Date> map = createMap();
//        for (Map.Entry<String,Date> i:map.entrySet())
//        {
//            System.out.println(i.getKey()+" "+i.getValue());
//        }
//        System.out.println("---------------------------------------------------");
//        removeAllSummerPeople(map);
//        for (Map.Entry<String,Date> i:map.entrySet())
//        {
//            System.out.println(i.getKey()+" "+i.getValue());
//        }
    }
}
