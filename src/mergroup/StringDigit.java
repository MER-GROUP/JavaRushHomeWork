package mergroup;

/**
 * Class Didgit v1.1 rename in StringDigit v1.1
 * Created by Midnight_Filth^MER aka Ramanenka M.E. on 27.04.2015.
 *
 * Class Didgit v1.1
 * Created by Midnight_Filth^MER aka Ramanenka M.E. on 22.04.2014 - 23.04.2015.
 *
 * Class Didgit v1.0
 * Created by Midnight_Filth^MER aka Ramanenka M.E. on 20.04.2015 - 21.04.2015.
 */
public class StringDigit {
    //------------------------------------------------------------//
    private char chr;//число или другая переменная
    private int countNumber=0;//подсчет цифр
    private int countPoint=0;//подсчет точек
    private int countMinusPlus=0;//подсчет плюсов и минусов
    private char point='.';//дробный разделитель по умолчанию
    private boolean isNumber=false;//проверяем встречалось ли число
    private boolean isPoint=false;//проверяем встречалась ли точка
    private boolean isSecondNumber=false;//проверяем повторяется ли число
    private boolean isSpace=false;//проверяем одни ли пробелы в строке
    private boolean isMinusPlus=false;//проверяем встречался ли плюс или минус
    private boolean isMinusPlusEnd=false;//проверяем идет ли плюс или минус после цифры
    //------------------------------------------------------------//

    //------------------------------------------------------------//
    //конструктор по умолчанию ничего не задает
    public StringDigit(){
        //пусто
    }
    //------------------------------------------------------------//

    //------------------------------------------------------------//
    //проверяем : строка это число ?
    public boolean isDigit(String str){

        //если строка пуста
        if (str.isEmpty()){
            return false;
        }

        //смотрим каждый символ в строке
        for (int i = 0; i < str.length(); i++)
        {
            chr=str.toLowerCase().charAt(i);
            //если символ плюс или минус
            if ('-'==chr || '+'==chr){
                countMinusPlus++;
                isMinusPlus=true;
                if (isMinusPlus && 1<countMinusPlus){
                    return false;
                }
                else if (isNumber && 0<countNumber){
                    isMinusPlusEnd=true;
                }
                continue;
            }
            //если символ число
            else if ('0'<=chr && '9'>=chr){
                countNumber++;
                isNumber=true;
                if (isSecondNumber){
                    return false;
                }
                continue;
            }
            //если символ это точка
            else if (point==chr){
                countPoint++;
                isPoint=true;
                if (1<countPoint){
                    return false;
                }
            }
            //если символ это пробел
            else if (' '==chr){
                isSpace=true;
                if (isNumber || (isPoint && 1<countPoint)){
                    isSpace=false;
                    if (' '==chr){
                        isNumber=false;
                        isPoint=false;
                        isSecondNumber=true;
                        continue;
                    }
                }
                continue;
            }
            //другие возможные варианты
            else {
                return false;
            }
        }

        //если в строке одни пробелы
        if (isSpace && !isNumber && !isPoint && !isSecondNumber){
            return false;
        }
        //если только одна точка без ничего
        else if ((isPoint && 1==countPoint) && !isNumber && !isSecondNumber){
            return false;
        }
        //если только одни плюс или минус
        else if ((isMinusPlus && 1==countMinusPlus) && !isNumber && !isPoint && !isSecondNumber){
            return false;
        }
        //если только одни плюс или минус (перед или после числа) и одно число
        else if ((isMinusPlus && isMinusPlusEnd) && isNumber){
            return false;
        }

        return true;
    }
    /**
     * Test
     * пустая строка - false
     * один пробел - false
     * много пробелов - false
     *
     * одно число - true
     * одно большое число - true
     * одно дробное число (1.1) (.1) (1.) - true
     * один дробный разделитель без чисел это не число - false
     * два и более дробных разделителя - false
     *
     * число + пробел - true
     * большое число + пробел - true
     * число + пробелы - true
     * большое число + пробелы - true
     *
     * пробел + число - true
     * пробелы + число - true
     * пробел + дробь (1.1) (.1) (1.) - true
     * пробел + дробный разделитель - false
     * пробелы + дробь (1.1) (.1) (1.) - true
     * пробелы + дробный разделитель - false
     *
     * пробел + большое число - true
     * пробелы + большое число - true
     * пробел + дробные разделители - false
     * пробелы + дробные разделители - false
     *
     * число + пробел + число - false
     * большое число + пробел + большое число - false
     * дробь + пробел + дробь - false
     * дроби + пробелы + дроби - false
     *
     * пробел + число + пробел - true
     * пробелы + большое число + пробелы - true
     * пробел + дробь + пробел - true
     * пробелы + дроби + пробелы - false
     * пробел + дробный разделитель + пробел - false
     * пробелы + дробные разделители + пробелы - false
     *
     * пробел + число + пробел + число - false
     * пробелы + большое число + пробелы + большое число - false
     * пробел + дробный разделитель + пробел + дробный разделитель - false
     * пробелы + дробные разделители + пробелы + дробные разделители - false
     * пробел + дробь + пробел + дробь - false
     * пробелы + дроби + пробелы + дроби - false
     *
     * минус число - true
     * пробел минус число - true
     * пробел минус дробь - true
     * число минус - false
     * пробел число минус - false
     * пробел дровь минус - false
     * минус - false
     * минус минус - false
     * минус точка - false
     */
    //------------------------------------------------------------//

    //------------------------------------------------------------//
    //перегруженный метод
    //проверяем : строка это число ? и задаем разделитель по умолчанию
    public boolean isDigit(String str,char point){

        //задаем дробный разделитель по умолчанию
        this.point=point;
        //если число то true иначе false
        return isDigit(str);
    }
    /**
     * Test
     * смотри boolean isNumber(String str)
     */
    //------------------------------------------------------------//

    //------------------------------------------------------------//
    //проверяем : дробное ли число ?
    public boolean isDouble(String str) {

        //если строка число
        if (new StringDigit().isDigit(str))
        {
            //если дробное число то true иначе false
            return isOnePoint(str);
        }

        //если строка не число
        else {
            return false;
        }
    }
    /**
     * Test
     * дробное число (одна точка) (1.1) (.1) (1.) - true
     * целое число (нет точек или больше одной) (5) (.) - false
     */
    //------------------------------------------------------------//

    //------------------------------------------------------------//
    //перегруженный метод
    //проверяем : дробное ли число ? и задаем разделитель по умолчанию
    public boolean isDouble(String str,char point){

        //если строка число
        if (new StringDigit().isDigit(str,point))
        {
            //задаем дробный разделитель по умолчанию
            this.point=point;
            //если дробное число то true иначе false
            return isOnePoint(str);
        }

        //если строка не число
        else {
            return false;
        }
    }
    /**
     * Test
     * смотри boolean isFraction(String str)
     */
    //------------------------------------------------------------//

    //------------------------------------------------------------//
    //проверяем : есть ли в строке один дробный разделитель (точка или запятая и тд)
    //если да то true
    //если нет или больше одного то false
    private boolean isOnePoint(String str){

        //смотрим каждый символ в строке
        for (int i = 0; i < str.length(); i++)
        {
            chr = str.toLowerCase().charAt(i);
            //если символ это точка
            if (point == chr)
            {
                isPoint = true;
                countPoint++;
                //если точек 2 или более то число не дробное
                if (1 < countPoint)
                {
                    return false;
                }
            }
        }
        //если точек нет
        if (0 == countPoint)
        {
            return false;
        }
        //если точка одна
        else
        {
            return true;
        }
    }
    /**
     * Test
     * (dddd.ddd)(.)(.2)(.1) - true
     * (dddddd) (4444444) (4..2) (...) (555.2.2) - false
     */
    //------------------------------------------------------------//
}
