package com.javarush.test.level08.lesson08.task03;

import java.util.HashMap;
import java.util.Map;

/* Одинаковые имя и фамилия
Создать словарь (Map<String, String>) занести в него десять записей по принципу «Фамилия» - «Имя».
Проверить сколько людей имеют совпадающие с заданным имя или фамилию.
*/

public class Solution
{

    public static void main(String[] args){


        //

    }

    public static HashMap<String, String> createMap()
    {
        Map<String,String> map = new HashMap<String, String>();
        map.put("Ivanov", "Artem");
        map.put("Glazov", "Vitya");
        map.put("Belkina", "Pol");
        map.put("Rolov", "Misha");
        map.put("Barakov", "Ilya");
        map.put("Kolof", "Pol");
        map.put("Polotov", "Pol");
        map.put("Kilova", "Liza");
        map.put("Kpolo", "Liza");
        map.put("Kpoloz", "Pol");


        return (HashMap) map;

    }

    public static int getCountTheSameFirstName(HashMap<String, String> map, String name)
    {
        int k = 0;
        for (Map.Entry<String,String> pair: map.entrySet()){

            if (pair.getValue().equals(name)) {
                k++;
            }
        }
        return k;
    }

    public static int getCountTheSameLastName(HashMap<String, String> map, String familiya)
    {
        int k = 0;
        for (Map.Entry<String,String> pair: map.entrySet()){

            if (pair.getKey().equals(familiya)) {
                k++;
            }

        }
        return k;

    }
}