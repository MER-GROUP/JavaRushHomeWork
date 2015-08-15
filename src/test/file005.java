package test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by maxim on 18.05.2015.
 */
public class file005 {
    public static void main(String[] args) {
        String folder="d:/temp";
        List folderNames=new ArrayList();
        List fileNames=new ArrayList();
        for (File file:new File(folder).listFiles()){
            if (file.isDirectory()){
                folderNames.add(file.getName());
            }
            else {
                fileNames.add(file.getName());
            }
        }
        for(Object folderName:folderNames){
            System.out.println("директория: "+folderName);
        }
        for (Object fileName:fileNames){
            System.out.println("файл: "+fileName);
        }
    }
}
