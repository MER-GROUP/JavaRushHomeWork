package test;

import mergroup.RegexConstants;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by smu-68 on 27.04.2015.
 */
public class regex004 {
    private static Pattern pattern=Pattern.compile(RegexConstants.Time);

    public static boolean Validete(String s){
        Matcher mather=pattern.matcher(s);
        return mather.matches();
    }

    public static void main(String[] args) {
        String toValidete1="12:54";
        System.out.println(toValidete1);
        System.out.println(Validete(toValidete1));

        String toValidete2="41:01";
        System.out.println(toValidete2);
        System.out.println(Validete(toValidete2));

        String toValidete3="2:59";
        System.out.println(toValidete3);
        System.out.println(Validete(toValidete3));
    }
}
