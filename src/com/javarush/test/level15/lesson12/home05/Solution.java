package com.javarush.test.level15.lesson12.home05;

/* Перегрузка конструкторов
1. В классе Solution создайте по 3 конструктора для каждого модификатора доступа.
2. В отдельном файле унаследуйте класс SubSolution от класса Solution.
3. Внутри класса SubSolution создайте конструкторы командой Alt+Insert -> Constructors.
4. Исправьте модификаторы доступа конструкторов в SubSolution так, чтобы они соответствовали конструкторам класса Solution.
*/

import java.math.BigDecimal;

public class Solution {

    public Solution() {}
    public Solution(int s) {}
    public Solution(short s) {}
    protected Solution (Integer s) {}
    protected Solution (Double s) {}
    protected Solution (double s) {}
    private Solution (byte s) {}
    private Solution (long s) {}
    private Solution (float s) {}
    Solution (BigDecimal s) {}
    Solution (Float s) {}
    Solution (Object s) {}

}

