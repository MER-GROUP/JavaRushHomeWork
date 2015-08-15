package test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * Created by maxim on 18.05.2015.
 */
public class file009 {
    public static void main(String[] args) {
        BufferedReader br=null;
        String line;
        try{
            br=new BufferedReader(new InputStreamReader(new FileInputStream("d:/temp/111.txt"),"UTF8"));
            while ((line=br.readLine())!=null){
                System.out.println(line);
            }
        }
        catch (Exception e){
            //
        }
        finally {
            try{
                br.close();
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
