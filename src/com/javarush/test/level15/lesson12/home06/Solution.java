package com.javarush.test.level15.lesson12.home06;

/* Порядок загрузки переменных
Разобраться, что в какой последовательности инициализируется.
Исправить порядок инициализации данных так, чтобы результат был следующим:
static void init()
Static block
public static void main
non-static block
static void printAllFields
0
null
Solution constructor
static void printAllFields
6
First name
*/

public class Solution {
    static {//++++++++++++++1
        init();
//        System.out.println("Static block");
    }

    {
        System.out.println("non-static block");//+++++++++++++4
        printAllFields(this);//5,6,7
    }

    public int i = 6;

    public String name = "First name";
    static {//++++++++++++++++++++++++++++++++2
//        init();
        System.out.println("Static block");
    }

    public Solution() {
        System.out.println("Solution constructor");//8
        printAllFields(this);//9,10,11
    }

    public static void init() {
        System.out.println("static void init()");
    }

    public static void main(String[] args) {
        System.out.println("public static void main");//+++++++++++++++++++3
        Solution s = new Solution();
    }

    public static void printAllFields(Solution obj) {
        System.out.println("static void printAllFields");//+++++++++++++++5    //9
//        System.out.println(obj.name);
        System.out.println(obj.i);//6     //10
        System.out.println(obj.name);//7       //11
    }
}
