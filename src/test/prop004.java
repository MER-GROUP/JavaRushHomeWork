package test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by maxim on 04.07.2015.
 */
public class prop004 {
    public static void main(String[] args) {
        Properties prop=new Properties();
        InputStream input=null;
        try{
            String fileName="src/test/111.txt";
            input=prop004.class.getClassLoader().getResourceAsStream(fileName);
            if (input==null){
                System.out.println("Sorry, unable to find "+fileName);
                return;
            }
            prop.load(input);
            System.out.println("prop = " + prop.getProperty("dbpassword"));
            System.out.println("prop = " + prop.getProperty("dbuser"));
            System.out.println("prop = " + prop.getProperty("datebase"));
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
