package test;

/**
 * Created by smu-68 on 27.04.2015.
 */
public class regex002 {
    public static void main(String[] args) {
        String regex="([+-]?\\d+\\.?\\d*)";//описание любого числа (целого или дробного, с плюсом или минусом)
        String s="a: 2.65, b: 3.14, c: 2.71";

        System.out.println(s);
        String result=s.replaceAll(regex,"[confidential]");
        System.out.println(result);
    }
}
