package test;

import java.io.File;

/**
 * Created by maxim on 18.05.2015.
 */
public class file001 {
    public static void main(String[] args) {
        File folder=new File("D:/TEMP/111");
        boolean result=delete(folder);

        if (result){
            System.out.println("Директория удалена");
        }
        else{
            System.out.println("При удалении директории возникли проблемы");
        }
    }

    private static boolean delete(File file){
        if (file.isDirectory()){
            for (File inFile:file.listFiles()){
                delete(inFile);
            }
        }
        return file.delete();
    }
}
