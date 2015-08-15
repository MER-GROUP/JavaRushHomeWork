package test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by smu-68 on 27.04.2015.
 */
public class regex007 {
    public static void myMatches(String regex,String input){
        Pattern pattern=Pattern.compile(regex);
        Matcher matcher=pattern.matcher(input);
        if (matcher.matches()){
            System.out.println("First group: "+matcher.group(1));
            System.out.println("Second group: "+matcher.group(2));
        }
        else {
            System.out.println("nothing");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        String input = "abdcxyz";
        myMatches("([a-z]*)([a-z]+)",input);
        myMatches("([a-z]?)([a-z]+)",input);
        myMatches("([a-z]+)([a-z]*)",input);
        myMatches("([a-z]?)([a-z]?)",input);
    }
}
