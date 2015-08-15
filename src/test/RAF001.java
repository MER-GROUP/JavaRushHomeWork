package test;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Created by maxim on 11.06.2015.
 */
public class RAF001 {
    public static void main(String[] args) throws IOException {
        File file=new File("D://TEMP//111.txt");
        RandomAccessFile r=new RandomAccessFile(file,"rw");
        r.seek(6);
        String str=r.readLine();
        System.out.println(str);
        r.close();
    }
}
