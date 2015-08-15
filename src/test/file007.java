package test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

/**
 * Created by maxim on 18.05.2015.
 */
public class file007 {
    public static void main(String[] args) {
        FileWriter fw=null;
        BufferedWriter bw=null;
        try{
            String toWrite="asdasdsad//n";
            File file=new File("D:/TEMP/111.txt");
            fw=new FileWriter(file,true);
            bw=new BufferedWriter(fw);
            bw.write(toWrite);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally {
            try{
                bw.close();
            }
            catch (Exception e){
                e.printStackTrace();
            }
            try{
                fw.close();
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
