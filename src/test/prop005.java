package test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Properties;

/**
 * Created by maxim on 04.07.2015.
 */
public class prop005 {
    public static void main(String[] args) {
        prop005 app=new prop005();
        app.printThemAll();
    }
    private void printThemAll(){
        Properties prop=new Properties();
        InputStream input=null;
        try{
            String fileName="111.txt";
            input=getClass().getClassLoader().getResourceAsStream(fileName);
            if (input==null){
                System.out.println("Sorry, unable to find "+fileName);
                return;
            }
            prop.load(input);
            Enumeration<?> e=prop.propertyNames();
            while (e.hasMoreElements()){
                String key=(String)e.nextElement();
                String value=prop.getProperty(key);
                System.out.println("Key : "+key+", Value : "+value);
            }
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
