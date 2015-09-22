package com.javarush.test.level22.lesson18.big01;

/**
 * Created by maxim on 20.09.2015.
 */
public class Field {
    private int width;
    private int height;
    private int[][] matrix;

    public Field(int height, int width) {
        this.height = height;
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public int getWidth() {
        return width;
    }

    public void print(){
        //
    }

    public void removeFullLines(){
        //
    }

    public Integer getValue(int x, int y){
        return null;
    }

    public void setValue(int x, int y, int value){
        //
    }
}
