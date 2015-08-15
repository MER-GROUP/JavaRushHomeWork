package test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mergroup.RegexConstants;

/**
 * Created by smu-68 on 27.04.2015.
 */
public class regex003 {
    public static void main(String[] args) {
        Pattern pattern=Pattern.compile(RegexConstants.Didit);
        String s="a: 2.65, b: 3.14, c: 2.71";
        Matcher matcher=pattern.matcher(s);

        System.out.println(s);
        while (matcher.find()){
            System.out.println(matcher.group());
        }
    }
}
