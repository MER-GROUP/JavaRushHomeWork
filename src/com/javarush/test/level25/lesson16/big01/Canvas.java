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
}
