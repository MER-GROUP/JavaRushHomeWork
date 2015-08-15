package test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by maxim on 04.07.2015.
 */
public class prop001 {
    public static void main(String[] args) {
        FileInputStream fis;
        Properties properties=new Properties();
        try{
            fis=new FileInputStream("D:/TEMP/111.txt");
            properties.load(fis);
            String host=properties.getProperty("db.host");
            String login=properties.getProperty("db.login");
            String password=properties.getProperty("db.password");
            System.out.println("HOST: "+host+", LOGIN: "+login+", PASSWORD: "+password);
        }catch (IOException e){
            System.err.println("error...");
        }
    }
}
