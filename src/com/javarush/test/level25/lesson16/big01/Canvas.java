package com.javarush.test.level25.lesson16.big01;

/**
 * Created by M.E.R.lin on 18.12.2015.
 */
public class Canvas {
    private int width;
    private int height;
    private char[][] matrix;

    public int getWidth() {
        return width;
    }
    public int getHeight() {
        return height;
    }
    public char[][] getMatrix() {
        return matrix;
    }

    public Canvas(int width, int height) {
        this.width = width;
        this.height = height;
        this.matrix = new char[getWidth()][getHeight()];
    }

    public void setPoint(double x, double y, char c){
        if (!(x<0 || y<0 || y>matrix.length || x>matrix[0].length)){
            int x1= (int) Math.round(x);
            int y1= (int) Math.round(y);
            this.matrix[y1][x1]=c;
        }
    }

    public void drawMatrix(double x, double y, int[][] matrix, char c){
        int height = matrix.length;
        int width = matrix[0].length;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (matrix[i][j] != 0)
                    setPoint(x + j, y + i, c);
            }
        }
    }
}
