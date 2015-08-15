package test;

import java.io.PrintWriter;

/**
 * Created by maxim on 20.06.2015.
 */
public class printWriter {
    public static void main(String[] args) {
        PrintWriter pw=new PrintWriter(System.out,true);

        pw.println("* PrintWriter demonstration\n");

        pw.print("Boolean: ");
        pw.println(true);

        pw.print("Double: ");
        pw.println((double)1/3);

        pw.print("Float: ");
        pw.println((float)1/3);

        pw.print("int: ");
        pw.println(512);

        pw.print("long: ");
        pw.println((long)512*512*512);

        pw.println();
    }
}
