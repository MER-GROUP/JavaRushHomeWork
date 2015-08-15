package com.javarush.test.level20.lesson10.bonus02;

/* Алгоритмы-прямоугольники
1. Дан двумерный массив N*N, который содержит несколько прямоугольников.
2. Различные прямоугольники не соприкасаются и не накладываются.
3. Внутри прямоугольник весь заполнен 1.
4. В массиве:
4.1) a[i, j] = 1, если элемент (i, j) принадлежит какому-либо прямоугольнику
4.2) a[i, j] = 0, в противном случае
5. getRectangleCount должен возвращать количество прямоугольников.
6. Метод main не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        byte[][] a = new byte[][]{
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 1}
        };
        int count = getRectangleCount(a);
        System.out.println("count = " + count + ". Должно быть 2");

        byte[][] a1 = new byte[][]{
                {1, 1, 0},
                {1, 1, 0},
                {1, 1, 0},
                {1, 1, 0}
        };
        int count1 = getRectangleCount(a1);
        System.out.println("count1 = " + count1 + ". Должно быть 1");
    }

    public static int getRectangleCount(byte[][] a) {
        int arrayLenFirst=a.length;
        int count=0;
        for (int i = 0; i < arrayLenFirst; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if (1==a[i][j]){
                    //счетчик квадратов
                    count++;

                    //координаты квадратов
                    int x1=j,y1=i;
                    int x2=0,y2=0;

                    //получаем х2 координату
                    for (int k = x1; k < a[i].length; k++) {
                        if (0==a[i][k]){
                            x2=k-1;
                            break;
                        }else if(k==a[i].length-1){
                            x2=k;
                        }
                    }

                    //получаем y2 координату
                    for (int k = y1; k < a.length; k++) {
                        if (0==a[k][j]){
                            y2=k-1;
                            break;
                        }else if (k==a.length-1){
                            y2=k;
                        }
                    }

                    //стираем квадрат (заполняем нулями)
                    //каждый удаленный квадрат считает count - сумма удаленных квадратов и есть результат
                    for (int k = y1; k <=y2 ; k++) {
                        for (int l = x1; l <= x2; l++) {
                            a[k][l]=0;
                        }
                    }
                }
            }
        }
        return count;
    }
}
