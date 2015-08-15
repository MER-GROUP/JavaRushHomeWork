package com.javarush.test.level19.lesson08.task04;

/* Решаем пример
В методе main подмените объект System.out написанной вами ридер-оберткой по аналогии с лекцией
Ваша ридер-обертка должна выводить на консоль решенный пример
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток

Возможные операции: + - *
Шаблон входных данных и вывода: a [знак] b = c
Отрицательных и дробных чисел, унарных операторов - нет.

Пример вывода:
3 + 6 = 9
*/

//import java.io.ByteArrayOutputStream;
//import java.io.PrintStream;
//
//public class Solution {
//    public static TestString testString = new TestString();
//
//    public static void main(String[] args) {
//        PrintStream consoleStream=System.out;
//        ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream();
//        PrintStream printStream=new PrintStream(byteArrayOutputStream);
//        System.setOut(printStream);
//
//        testString.printSomething();
//        System.setOut(consoleStream);
//        printStream.close();
//
//        String str=byteArrayOutputStream.toString();
//        Object A=new Object();
//        Object B=new Object();
//        Object ZNAK=new Object();
//        boolean check=false;
//        for (int i = 0; i < str.length(); i++) {
//            if ('+'==str.charAt(i)||'-'==str.charAt(i)||'*'==str.charAt(i)){
//                ZNAK=str.charAt(i);
//            }else if ('0'<=str.charAt(i)&&'9'>=str.charAt(i)){
//                if (check){
//                    B=str.charAt(i);
//                    continue;
//                }
//                check=true;
//                A=str.charAt(i);
//            }
//        }
//
//        int AA=Integer.parseInt(A.toString());
//        int BB=Integer.parseInt(B.toString());
//        int RES=0;
//        switch (ZNAK.toString()){
//            case "+":
//                RES=AA+BB;
//                break;
//            case "-":
//                RES=AA-BB;
//                break;
//            case "*":
//                RES=AA*BB;
//                break;
//        }
//        StringBuilder builderStr=new StringBuilder();
//        builderStr.append(AA).append(" ").append(ZNAK).append(" ").append(BB).append(" ").append("=").append(" ").append(RES);
//        System.out.println(builderStr.toString());
//
//        consoleStream.close();
//    }
//
//    public static class TestString {
//        public void printSomething() {
//            System.out.println("3 + 6 = ");
//        }
//    }
//}

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream defaultPrintStream = System.out;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteArrayOutputStream));
        testString.printSomething();
        System.setOut(defaultPrintStream);

        String result = byteArrayOutputStream.toString();
        String[] resultArray = result.split(" ");
        int firstNum = Integer.parseInt(resultArray[0]);
        int secondNum = Integer.parseInt(resultArray[2]);
        int arithmeticResult;

        if (resultArray[1].equals("+"))
            arithmeticResult = firstNum + secondNum;
        else if (resultArray[1].equals("-"))
            arithmeticResult = firstNum - secondNum;
        else
            arithmeticResult = firstNum * secondNum;

        System.out.println(firstNum+" "+resultArray[1]+" "+secondNum+" = "+arithmeticResult);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

