package com.javarush.test.level07.lesson06.task02;

/* 5 строчек: «101», «102», «103», «104», «105»
1. Создай список строк.
2. Добавь в него 5 строчек: «101», «102», «103», «104», «105».
3. Удали первую, среднюю и последнюю.
4. Используя цикл выведи на экран его содержимое, каждое значение с новой строки.
5. Выведи его размер. (После удаления одного элемента индексы остальных меняются.
Например, если удалить 0-й элемент, то тот, который был 1-м, станет 0-м. И т.д.)
*/

import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //Напишите тут ваш код
        ArrayList<String> list=new ArrayList<String>();
        for (int i = 0; 5 > i; i++)
        {
            list.add("10"+(i+1));
        }

        for (int i = 0; i < list.size(); i++)
        {
            if (list.get(i).equals("101")) list.remove(i);
            if (list.get(i).equals("103")) list.remove(i);
            if (list.get(i).equals("105")) list.remove(i);
        }

        for (int i = 0; i < list.size(); i++)
        {
            System.out.println(list.get(i));
        }
        System.out.println(list.size());

    }
}
