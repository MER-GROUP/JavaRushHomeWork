package mergroup;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class RegexValidate v1.0
 * Created by Midnight_Filth^MER aka Ramanenka M.E. on 27.04.2015.
 */
public class RegexValidate {
    //------------------------------------------------------------//
    //метод проверяет соответствует ли строка STR регулярному выражению REGEX
    public static boolean Validate(String regex,String str){
        Pattern pattern=Pattern.compile(regex);
        Matcher matcher=pattern.matcher(str);
        return matcher.matches();
    }
    //------------------------------------------------------------//
}
