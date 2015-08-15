package com.javarush.test.level15.lesson04.task02;

/* ООП - Перегрузка
Перегрузите метод printMatrix 8 различными способами. В итоге должно получиться 10 различных методов printMatrix.
*/

public class Solution {
    public static void main(String[] args) {
        printMatrix(2, 3, "8");
    }

    public static void printMatrix(int m, int n, String value) {
        System.out.println("Заполняем объектами String");
        printMatrix(m, n, (Object) value);
    }

    public static void printMatrix(int m, int n, Object value) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(value);
            }
            System.out.println();
        }
    }

    public static void printMatrix(Integer m, int n, String value) {
        System.out.println("Заполняем объектами Integer m, int n, String value");
    }

    public static void printMatrix(int m, Integer n, String value) {
        System.out.println("Заполняем объектами int m, Integer n, String value");
    }

    public static void printMatrix(Integer m, Integer n, String value) {
        System.out.println("Заполняем объектами Integer m, Integer n, String value");
    }

    public static void printMatrix(short m, short n, String value) {
        System.out.println("Заполняем объектами short m, short n, String value");
    }

    public static void printMatrix(long m, short n, String value) {
        System.out.println("Заполняем объектами long m, short n, String value");
    }

    public static void printMatrix(long m, long n, String value) {
        System.out.println("Заполняем объектами long m, long n, String value");
    }

    public static void printMatrix(long m, int n, String value) {
        System.out.println("Заполняем объектами long m, int n, String value");
    }

    public static void printMatrix(int m, long n, String value) {
        System.out.println("Заполняем объектами int m, long n, String value");
    }
}
