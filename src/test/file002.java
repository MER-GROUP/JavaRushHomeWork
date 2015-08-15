package test;

import java.io.File;

/**
 * Created by maxim on 18.05.2015.
 */
public class file002 {
    public static void main(String[] args) {
        try{
            File file=new File("d:/temp/111.txt");
            if (file.delete()){
                System.out.println("Файл успешно удален");
            }
            else {
                System.out.println("Удалить файл не удалось");
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
