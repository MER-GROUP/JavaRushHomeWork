package test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by smu-68 on 27.04.2015.
 */
public class regex001 {
    public static void main(String[] args) {
        Pattern pattern=Pattern.compile("1+");
        String s="302130032111239021130";
        Matcher matcher=pattern.matcher(s);

        while (matcher.find()){
            System.out.println(s);
            System.out.println("matcher.group: "+matcher.group());
            System.out.println(s);
            System.out.println("matcher.start: "+matcher.start());
            System.out.println(s);
            System.out.println("matcher.end: "+matcher.end());
        }
    }
}
