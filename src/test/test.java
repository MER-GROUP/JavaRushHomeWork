package test;

import mergroup.StringDigit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by smu-68 on 20.04.2015.
 */
public class test
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        String str;

        while(true){
            str=reader.readLine();
            System.out.println(new StringDigit().isDigit(str));
            System.out.println(new StringDigit().isDouble(str)+" finish");
            System.out.println("==================================");
            System.out.println(new StringDigit().isDigit(str, ','));
            System.out.println(new StringDigit().isDouble(str,',')+ " finish");
//            System.out.println(Double.parseDouble(str));
            if (str.equals("exit")){
                break;
            }
        }
    }
}
