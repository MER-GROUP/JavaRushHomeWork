package com.javarush.test.level23.lesson04.task01;

/* Inner
Реализовать метод getTwoSolutions, который должен возвращать массив из 2-х экземпляров класса Solution.
Для каждого экземпляра класса Solution инициализировать поле innerClasses двумя значениями.
Инициализация всех данных должна происходить только в методе getTwoSolutions.
*/
public class Solution {
    public InnerClass[] innerClasses = new InnerClass[2];

    public class InnerClass {
    }

    public static Solution[] getTwoSolutions() {

        Solution[] solution=new Solution[new Solution().innerClasses.length];
        solution[0]=new Solution();
        solution[0].innerClasses[0]=new Solution().new InnerClass();
        solution[0].innerClasses[1]=new Solution().new InnerClass();
        solution[1]=new Solution();
        solution[1].innerClasses[0]=new Solution().new InnerClass();
        solution[1].innerClasses[1]=new Solution().new InnerClass();

        return solution;
    }
}
