package test;

import java.io.*;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by maxim on 07.07.2015.
 */
public class ser004 {
    public static class PersistentTime implements Serializable {
        private Date time;

        public PersistentTime() {
            super();
            time = Calendar.getInstance().getTime();
            System.out.println("Constructor default");
        }

        public Date getTime() {
            return time;
        }

//        private void writeObject(ObjectOutputStream out) throws IOException {
//            out.defaultWriteObject();
//        }
//
//        private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
//            in.defaultReadObject();
//            System.out.println("NO Constructor default");
//        }
    }

    public static void main(String[] args) {
//        String filename = "D:/TEMP/111.txt";
//        if(args.length > 0) {
//            filename = args[0];
//        }
//        PersistentTime time = new PersistentTime();
//        FileOutputStream fos = null;
//        ObjectOutputStream out = null;
//        try {
//            fos = new FileOutputStream(filename);
//            out = new ObjectOutputStream(fos);
//            out.writeObject(time);
//            out.close();
//        }catch(IOException ex) {
//            ex.printStackTrace();
//        }
        String filename = "D:/TEMP/111.txt";
        if(args.length > 0) {
            filename = args[0];
        }
        PersistentTime time = null;
        FileInputStream fis = null;
        ObjectInputStream in = null;
        try {
            fis = new FileInputStream(filename);
            in = new ObjectInputStream(fis);
            time = (PersistentTime)in.readObject();
            in.close();
        }
        catch(IOException ex) {
            ex.printStackTrace();
        }
        catch(ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        // распечатать восстановленное время
        System.out.println("Время разложения: " + time.getTime());
        System.out.println();
        // распечатать текущее время
        System.out.println("Текущее время: " + Calendar.getInstance().getTime());
    }
}
