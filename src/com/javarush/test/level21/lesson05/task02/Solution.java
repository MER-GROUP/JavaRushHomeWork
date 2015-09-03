package com.javarush.test.level21.lesson05.task02;

import java.util.HashSet;
import java.util.Set;

/* Исправить ошибку
Сравнение объектов Solution не работает должным образом. Найти ошибку и исправить.
Метод main не участвует в тестировании.
*/
public class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (!(o instanceof Solution)) return false;

        Solution solution = (Solution) o;

        if (first != null ? !first.equals(solution.first) : solution.first != null) return false;
        return !(last != null ? !last.equals(solution.last) : solution.last != null);

    }

    @Override
    public int hashCode() {
        int result1 = (first==null ? 0 : first.hashCode());
        int result2 = (last==null ? 0 : last.hashCode());
        return 31*result1+result2;
    }

    public static void main(String[] args) {
        Set<Solution> s = new HashSet<>();
        s.add(new Solution("Mickey", "Mouse"));
        System.out.println(s.contains(new Solution("Mickey", "Mouse")));
        System.out.println(s.contains(new Solution("Mickey", null)));
        System.out.println(s.contains(new Solution(null, null)));
        System.out.println(s.contains(new Solution(null, "Mouse")));
    }
}
