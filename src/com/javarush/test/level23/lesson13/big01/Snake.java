package com.javarush.test.level23.lesson13.big01;

import java.util.ArrayList;

/**
 * Created by maxim on 24.09.2015.
 */
public class Snake {
    private ArrayList<SnakeSection> sections;
    private boolean isAlive;
    private SnakeDirection direction;

    public ArrayList<SnakeSection> getSections() {
        return sections;
    }

    public SnakeDirection getDirection() {
        return direction;
    }
    public void setDirection(SnakeDirection direction) {
        this.direction = direction;
    }

    public boolean isAlive() {
        return isAlive;
    }
}
