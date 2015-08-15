package test;

import java.io.*;

/**
 * Created by maxim on 18.05.2015.
 */
public class file004 {
    public static void main(String[] args) {
        InputStream inStream=null;
        OutputStream outStream=null;

        try{
            File fromFile=new File("D:/TEMP/111.txt");
            File toFile=new File("d:/temp/222.txt");
            inStream=new FileInputStream(fromFile);
            outStream=new FileOutputStream(toFile);
            byte[] buffer=new byte[1024];
            int lenght;

            while ((lenght=inStream.read(buffer))>0){
                outStream.write(buffer,0,lenght);
            }
            System.out.println("Копирование файла завершено");
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally {
            try{
                inStream.close();
            }
            catch (Exception e){
                e.printStackTrace();
            }
            try{
                outStream.close();
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
