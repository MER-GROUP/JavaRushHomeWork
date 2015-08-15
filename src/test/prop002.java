package test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

/**
 * Created by maxim on 04.07.2015.
 */
public class prop002 {
    public static void main(String[] args) {
        Properties prop=new Properties();
        OutputStream output=null;
        try{
            output=new FileOutputStream("D:/TEMP/111.txt");
            prop.setProperty("datebase","localhost");
            prop.setProperty("dbuser","mkyong");
            prop.setProperty("dbpassword","password");

            prop.store(output,null);
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if (output!=null){
                try{
                    output.close();
                }catch (IOException io){
                    io.printStackTrace();
                }
            }
        }
    }
}
