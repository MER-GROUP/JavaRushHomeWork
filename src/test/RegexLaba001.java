package test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by smu-68 on 27.04.2015.
 */
public class RegexLaba001 {
    public static void main(String[] args) {
        String regex="abcdefghijklmnopqrstuv18340";
        Pattern pattern=Pattern.compile(regex);

        String s1="sdsdsdsdsdsd4s5d4s5d4s5d45s4d45sd    dsdsd";
        String s2="abcdefghijklmnopqrstuv18340";

        System.out.println(s1);
        Matcher matcher=pattern.matcher(s1);
        System.out.println(matcher.matches());

        System.out.println(s2);
        matcher=pattern.matcher(s2);
        System.out.println(matcher.matches());
    }
}
