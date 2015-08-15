package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by support on 04.04.2015.
 */
public class test2
{
    public static void main(String[] args) throws IOException
    {
        ArrayList<String> list=new ArrayList<String>();
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        while (true){
            String s=reader.readLine();
            if (s.isEmpty()){
                break;
            }
            list.add(s);
        }
        for (String s:list) System.out.println(s);
        System.out.println("--------------------------");

        for (int i = 0; i < list.size(); i++)
        {
            String sss=list.get(i);
            for (int j = 0; j < list.size(); j++)
            {
                if (sss.equals(list.get(j))){
                    list.remove(j);
//                    j--;
                }
            }
        }
        for (String s:list) System.out.println(s);

        char cc='k';

    }
}
