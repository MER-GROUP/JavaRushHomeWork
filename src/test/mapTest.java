package test;

import java.util.*;

/**
 * Created by maxim on 25.06.2015.
 */
public class mapTest {
    public static void main(String[] args) {
        Map<Character, Integer> m = new LinkedHashMap<Character, Integer>() {
            {
                put('b', 2);
                put('a', 3);
                put('c', 1);
            }
        };

        System.out.println(m);
        m = new TreeMap<Character, Integer>(m);
        System.out.println(m);
        Map<Character, Integer> n = new TreeMap<Character, Integer>(new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                int a=o1;
                int b=o2;
                if (a>b){
                    return 1;
                }else if (a<b){
                    return -1;
                }else{
                    return 0;
                }
            }
        });
        n.putAll(m);
        System.out.println(n);

    }
}
