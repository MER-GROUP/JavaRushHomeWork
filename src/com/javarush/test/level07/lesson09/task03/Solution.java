package com.javarush.test.level07.lesson09.task03;

import java.util.ArrayList;
import java.util.Collections;

/* Слово «именно»
1. Создай список из слов «мама», «мыла», «раму».
2. После каждого слова вставь в список строку, содержащую слово «именно».
3. Используя цикл for вывести результат на экран, каждый элемент списка с новой строки.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //Напишите тут ваш код
        ArrayList<String> list=new ArrayList<String>();
        Collections.addAll(list,"мама","мыла","раму");
        String wrd="именно";
        for (int i = 0; i < list.size();i++)
        {
            if (!list.get(i).equals(wrd))
            {
                list.add(i+1,wrd);
                i++;
            }
        }
        for (String x:list) System.out.println(x);
    }
}
