package test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by maxim on 04.07.2015.
 */
public class prop003 {
    public static void main(String[] args) {
        Properties prop=new Properties();
        InputStream input=null;
        try{
            input=new FileInputStream("D:/TEMP/111.txt");
            prop.load(input);
            System.out.println("prop = " + prop.getProperty("dbpassword"));
            System.out.println("prop = " + prop.getProperty("dbuser"));
            System.out.println("prop = " + prop.getProperty("dbpassword"));
        }catch (IOException io){
            io.printStackTrace();
        }finally {
            if (input!=null){
                try{
                    input.close();
                }catch (IOException io){
                    io.printStackTrace();
                }
            }
        }
    }
}
