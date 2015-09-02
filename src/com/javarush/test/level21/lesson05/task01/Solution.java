package com.javarush.test.level21.lesson05.task01;

import java.util.HashSet;
import java.util.Set;

/* Equals and HashCode
В классе Solution исправить пару методов equals/hashCode в соответствии с правилами реализации этих методов.
Метод main не участвует в тестировании.
*/
public class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }

    public boolean equals(Object n) {
        if (this==n) return true;
        else if (null==n) return false;
        else if (this.getClass()!=n.getClass()) return false;
        else if (null==((Solution)n).first && ((Solution)n).last!=null)
            return first==null && ((Solution)n).last.equals(last);
        else if (null==((Solution)n).last && ((Solution)n).first!=null)
            return last==null && ((Solution)n).first.equals(first);
        else if (null==((Solution)n).first && null==((Solution)n).last )
            return first==null && last==null;
        return ((Solution)n).first.equals(first) && ((Solution)n).last.equals(last);
    }

    public int hashCode() {
        return 31 *
                (first == null ? 0 : first.hashCode()) +
                (last == null ? 0 : last.hashCode());
    }

    public static void main(String[] args) {
        Set<Solution> s = new HashSet<>();
        s.add(new Solution("Donald", "Duck"));

        System.out.println((new Solution("Donald", "Duck")).equals(new Solution("Donald", "Duck")));
        System.out.println((new Solution(null, null)).equals( new Solution(null, null)));
        System.out.println((new Solution("first", null)).equals(new Solution("first", null)));
        System.out.println((new Solution(null, "last")).equals(new Solution(null, "last")));
        System.out.println();

        System.out.println(s.contains(new Solution("Donald", "Duck")));
    }
}
