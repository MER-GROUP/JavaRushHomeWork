package com.javarush.test.level08.lesson08.task05;

import java.util.HashMap;
import java.util.Map;

/* Удалить людей, имеющих одинаковые имена
Создать словарь (Map<String, String>) занести в него десять записей по принципу «фамилия» - «имя».
Удалить людей, имеющих одинаковые имена.
*/

public class Solution
{
    public static HashMap<String, String> createMap()
    {
        //Напишите тут ваш код
        Map<String,String> map=new HashMap<String, String>();
        map.put("1","max");
        map.put("2","mina");
        map.put("3","max");
        map.put("4","olesa");
        map.put("5","max");
        map.put("6","mina");
        map.put("7","roma");
        map.put("8","max");
        map.put("9","tana");
        map.put("10","max");

        return (HashMap)map;

    }

    public static void removeTheFirstNameDuplicates(HashMap<String, String> map)
    {
        //Напишите тут ваш код
        HashMap<String,String> map1=new HashMap<String, String>(map);
        HashMap<String,String> map2=new HashMap<String, String>(map);

        for (Map.Entry<String,String> itr_map1:map1.entrySet())
        {
            map2.remove(itr_map1.getKey());
            if (map2.containsValue(itr_map1.getValue())) removeItemFromMapByValue(map,itr_map1.getValue());
        }

    }

    public static void removeItemFromMapByValue(HashMap<String, String> map, String value)
    {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair: copy.entrySet())
        {
            if (pair.getValue().equals(value))
                map.remove(pair.getKey());
        }

    }

    public static void main(String[] args)
    {
        HashMap<String, String> map=createMap();
        for (Map.Entry<String,String> itr:map.entrySet()) System.out.println(itr);
        System.out.println("================================================================");
        removeTheFirstNameDuplicates(map);
        for (Map.Entry<String,String> itr:map.entrySet()) System.out.println(itr);
    }
}
