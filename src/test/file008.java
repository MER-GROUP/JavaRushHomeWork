package test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

/**
 * Created by maxim on 18.05.2015.
 */
public class file008 {
    public static void main(String[] args) {
        BufferedWriter bw=null;
        try{
            String toWrite="11111111111111111111111111";
            File file=new File("D:/TEMP/111.txt");
            bw=new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file),"UTF8"));
            bw.write(toWrite);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            try{
                bw.close();
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
