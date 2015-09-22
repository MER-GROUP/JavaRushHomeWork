package com.javarush.test.level22.lesson18.big01;

/**
 * Created by maxim on 20.09.2015.
 */
public class Field {
    private int width;
    private int height;
    private int[][] matrix;

    public Field(int width, int height) {
        this.height = height;
        this.width = width;
        matrix=new int[getHeight()][getWidth()];
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
        for (int i = 0; i < getHeight(); i++) {
            for (int j = 0; j < getWidth(); j++) {
                if (getMatrix()[i][j]==0){
                    System.out.print(".");
                }else {
                    System.out.print("X");
                }
            }
            System.out.println();
        }
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
