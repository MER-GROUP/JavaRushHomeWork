package com.javarush.test.level24.lesson14.big01;

/**
 * Created by M.E.R.lin on 28.11.2015.
 */
public class Canvas {
    private int width;
    private int height;
    private char[][] matrix;
    public Canvas(int width, int height) {
        this.width = width;
        this.height = height;
        matrix=new char[height][width];
    }
    public int getWidth() {
        return width;
    }
    public void setWidth(int width) {
        this.width = width;
    }
    public int getHeight() {
        return height;
    }
    public void setHeight(int height) {
        this.height = height;
    }
    public char[][] getMatrix() {
        return matrix;
    }
    public void setMatrix(char[][] matrix) {
        this.matrix = matrix;
    }

    public void setPoint(double x, double y, char c){
        int xi=(int) x;
        int yi=(int) y;
        if (!(xi<0 || yi<0 || yi>matrix.length || xi>matrix[0].length)){
            matrix[xi][yi]=c;
        }
    }

    public void drawMatrix(double x, double y, int[][] matrix, char c){
        for (int i = (int) y; i < matrix.length; i++) {
            for (int j = (int) x; j < matrix[0].length; j++) {
                if (matrix[i][j]!=0) setPoint(i,j,c);
            }
        }
    }
}
