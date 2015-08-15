package com.javarush.test.level14.lesson08.bonus02;

/* НОД
Наибольший общий делитель (НОД).
Ввести с клавиатуры 2 целых положительных числа.
Вывести в консоль наибольший общий делитель.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        Integer a=Integer.parseInt(reader.readLine());
        Integer b=Integer.parseInt(reader.readLine());
        reader.close();

        ArrayList<Integer> list_A=new ArrayList<Integer>();
        ArrayList<Integer> list_B=new ArrayList<Integer>();

        for (int i = 2; true ; i++)
        {
            if (0==a%i){
                list_A.add(i);
                a/=i;
                i--;
            }
            else if (1==a) break;
        }

        for (int i = 2; true ; i++)
        {
            if (0==b%i){
                list_B.add(i);
                b/=i;
                i--;
            }
            else if (1==b) break;
        }

//        System.out.println("-----------------");
//        for (Integer i:list_A) System.out.print(i + " ");
//        System.out.println();
//        System.out.println("-----------------");
//        for (Integer i:list_B) System.out.print(i + " ");
//        System.out.println();
//        System.out.println("-----------------");

        ArrayList<Integer> list_R=new ArrayList<Integer>();

        for (int i = 0; i < list_A.size(); i++)
        {
            for (int j = 0; j < list_B.size(); j++)
            {
                if (list_A.get(i)==list_B.get(j)){
                    list_R.add(list_A.get(i));
                    list_A.remove(i);
                    list_B.remove(j);
                }
            }
        }

//        for (Integer i:list_R) System.out.print(i);

        int temp=list_R.get(0);
        for (int i = 1; i < list_R.size(); i++)
        {
            temp*=list_R.get(i);
        }

        System.out.println(temp);
    }
}

//    public static void nod(int a, int b)
//    {
//        if (a > b) a = a - b; else b = b - a;
//        if (b == 0)
//        {
//            System.out.println(a);
//            return;
//        }
//        nod(a, b); //рИкурсивно вызываю функцию с Валерой и его Машей, где она весит 160кг, а он трогает её матку.
//    }
