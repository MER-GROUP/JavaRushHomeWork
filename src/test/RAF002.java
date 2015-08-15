package test;

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.util.Vector;

/**
 * Created by maxim on 11.06.2015.
 */
public class RAF002 {
    public static void main(String[] args) throws FileNotFoundException {
        int i;
        System.out.println("* Random Access File demonstration\n");
        RandomAccessFile data;
        long dataPointer=0;
        Vector idx=new Vector();
        String s;

        try{
            data=new RandomAccessFile("D://TEMP//999.txt","rw");
            for (i = 0; i < 10; i++) {
                dataPointer=data.getFilePointer();
                idx.addElement(new Long(dataPointer));
                data.writeBytes("Record "+ i +"\n");
            }
            for (i = 9; i >= 0; i--) {
                dataPointer=(long)((long)idx.elementAt(i));
                data.seek(dataPointer);
                s=data.readLine();
                System.out.println(s);
            }
        }catch (Exception ex){
            System.out.println(ex.toString());
        }
    }
}
