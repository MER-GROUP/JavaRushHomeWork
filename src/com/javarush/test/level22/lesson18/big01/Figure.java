package com.javarush.test.level22.lesson18.big01;

/**
 * Created by maxim on 20.09.2015.
 */
public class Figure {
    private int x;
    private int y;
    private int[][] matrix;

    public Figure(int x, int y, int[][] matrix) {
        this.matrix = matrix;
        this.x = x;
        this.y = y;
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void left(){
        //
    }

    public void right(){
        //
    }

    public void down(){
        //
    }

    public void up(){
        //
    }

    public void downMaximum(){
        //
    }

    public boolean isCurrentPositionAvailable(){
        return false;
    }

    public void landed(){
        //
    }

    public void rotate() {
        //
    }
}
