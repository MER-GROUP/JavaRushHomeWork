package test;

import java.io.File;

/**
 * Created by maxim on 18.05.2015.
 */
public class file006 {
    public static void main(String[] args) {
//        String filename="newfile.txt";
        String dir=System.getProperty("user.dir");
//        String fullPath=dir+ File.separator+filename;
//        String fullPath=dir+ File.separator;
        String fullPath=dir;
        System.out.println("Полный путь: "+fullPath);
    }
}
