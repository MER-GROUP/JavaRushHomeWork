package com.javarush.test.level08.lesson03.task04;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* Вывести на экран список ключей
Есть коллекция HashMap<String, String>, туда занесли 10 различных строк. Вывести на экран список ключей, каждый элемент с новой строки.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("Sim", "Sim");
        map.put("Tom", "Tom");
        map.put("Arbus", "Arbus");
        map.put("Baby", "Baby");
        map.put("Cat", "Cat");
        map.put("Dog", "Dog");
        map.put("Eat", "Eat");
        map.put("Food", "Food");
        map.put("Gevey", "Gevey");
        map.put("Hugs", "Hugs");

        printKeys(map);
    }

    public static void printKeys(Map<String, String> map)
    {
        //add your code here - напишите тут ваш код
        Iterator<Map.Entry<String,String>> iterator=map.entrySet().iterator();
        while (iterator.hasNext())
        {
            Map.Entry<String,String> pair=iterator.next();
            System.out.println(pair.getKey());
        }
    }
}
