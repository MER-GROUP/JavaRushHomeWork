package test;

import mergroup.RegexConstants;
import mergroup.RegexValidate;

/**
 * Created by smu-68 on 27.04.2015.
 */
public class regex005 {
    public static void main(String[] args) {
        String toValidete1="12:54";
        System.out.println(toValidete1);
        System.out.println(RegexValidate.Validate(RegexConstants.Time,toValidete1));

        String toValidete2="41:01";
        System.out.println(toValidete2);
        System.out.println(RegexValidate.Validate(RegexConstants.Time, toValidete2));

        String toValidete3="2:59";
        System.out.println(toValidete3);
        System.out.println(RegexValidate.Validate(RegexConstants.Time, toValidete3));
    }
}
