package com.javarush.test.level23.lesson13.big01;

/**
 * Created by maxim on 24.09.2015.
 */
public class Room {
    private int width;
    private int height;
    private Snake snake;
    private Mouse mouse;

    public int getHeight() {
        return height;
    }
    public void setHeight(int height) {
        this.height = height;
    }

    public Mouse getMouse() {
        return mouse;
    }
    public void setMouse(Mouse mouse) {
        this.mouse = mouse;
    }

    public Snake getSnake() {
        return snake;
    }
    public void setSnake(Snake snake) {
        this.snake = snake;
    }

    public int getWidth() {
        return width;
    }
    public void setWidth(int width) {
        this.width = width;
    }

    public Room(int width, int height, Snake snake) {
        this.height = height;
        this.width = width;
        this.snake = snake;
    }

    public static Room game;
    public static void main(String[] args) {
        game=new Room(20,20,new Snake(10,10));
        game.getSnake().setDirection(SnakeDirection.DOWN);
    }

    public void run(){
        //
    }

    public void print(){
        //
    }
}
