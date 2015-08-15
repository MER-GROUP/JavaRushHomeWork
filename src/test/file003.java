package test;

import java.io.File;

/**
 * Created by maxim on 18.05.2015.
 */
public class file003 {
    public static void main(String[] args) {
        File file=new File("D:/TEMP/111.txt");
        File fileWithNewName=new File("D:/TEMP/222.txt");
        if (file.renameTo(fileWithNewName)){
            System.out.println("Переименование прошло успешно");
        }
        else{
            System.out.println("Переименовать файл не удалось");
        }
    }
}
